package siakreborn.kelas.core;

import java.util.*;

import siakreborn.kelas.KelasFactory;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.semester.core.Semester;
import siakreborn.semester.core.SemesterService;
import siakreborn.semester.core.SemesterServiceImpl;

public class KelasServiceImpl extends KelasServiceComponent {
  private KelasFactory kelasFactory = new KelasFactory();
  private SemesterService semesterService = new SemesterServiceImpl();

  public List<Kelas> saveKelas(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String kapasitasStr = (String) body.get("kapasitas");
    int kapasitas = Integer.parseInt(kapasitasStr);
    String ruangan = (String) body.get("ruangan");
    String jadwal = (String) body.get("jadwal");
    String mataKuliahIdStr = (String) body.get("mataKuliahId");
    String semesterIdStr = (String) body.get("semesterId");

    MataKuliah mataKuliah = null;
    if (mataKuliahIdStr != null) {
      UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
      mataKuliah = kelasRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, mataKuliahId);
    }

    Semester semester = null;
    if (semesterIdStr != null) {
      UUID semesterId = UUID.fromString(semesterIdStr);
      semester = kelasRepository.getProxyObject(siakreborn.semester.core.SemesterComponent.class, semesterId);
    }

    Kelas kelas = kelasFactory.createKelas("siakreborn.kelas.core.KelasImpl", nama, kapasitas, ruangan, jadwal,
        mataKuliah, semester);
    kelasRepository.saveObject(kelas);

    return getAllKelas();
  }

  public Kelas updateKelas(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nama = (String) body.get("nama");
    String kapasitasStr = (String) body.get("kapasitas");
    int kapasitas = Integer.parseInt(kapasitasStr);
    String ruangan = (String) body.get("ruangan");
    String jadwal = (String) body.get("jadwal");
    String mataKuliahIdStr = (String) body.get("mataKuliahId");
    String semesterIdStr = (String) body.get("semesterId");

    Kelas kelas = kelasRepository.getObject(id);

    MataKuliah mataKuliah = kelas.getMataKuliah();
    if (mataKuliahIdStr != null) {
      UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
      mataKuliah = kelasRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, mataKuliahId);
    }

    Semester semester = kelas.getSemester();
    if (semesterIdStr != null) {
      UUID semesterId = UUID.fromString(semesterIdStr);
      semester = kelasRepository.getProxyObject(siakreborn.semester.core.SemesterComponent.class, semesterId);
    }

    kelas.setNama(nama);
    kelas.setKapasitas(kapasitas);
    kelas.setRuangan(ruangan);
    kelas.setJadwal(jadwal);
    kelas.setMataKuliah(mataKuliah);
    kelas.setSemester(semester);

    kelasRepository.updateObject(kelas);
    kelas = kelasRepository.getObject(id);

    return kelas;
  }

  public Kelas getKelas(UUID id) {
    Kelas kelas = kelasRepository.getObject(id);
    return kelas;
  }

  public List<Kelas> getAllKelas() {
    List<Kelas> kelasList = kelasRepository.getAllObject("kelas_impl", KelasImpl.class.getName());
    return kelasList;
  }

  public List<Kelas> filterKelasByMataKuliah(UUID mataKuliahId) {
    List<Kelas> kelasList = kelasRepository.getListObject("kelas_comp", "matakuliah_id", mataKuliahId);
    return kelasList;
  }

  public List<Kelas> filterKelasBySemester(UUID semesterId) {
    List<Kelas> kelasList = kelasRepository.getListObject("kelas_comp", "semester_id", semesterId);
    return kelasList;
  }

  public List<HashMap<String, Object>> groupKelasByMataKuliah() {
    List<Kelas> kelasList = kelasRepository.getAllObject("kelas_impl", KelasImpl.class.getName());

    return mataKuliahGrouper(kelasList);
  }

  public List<Kelas> deleteKelas(UUID id) {
    kelasRepository.deleteObject(id);
    return getAllKelas();
  }

  public List<HashMap<String, Object>> transformKelasListToHashMap(List<Kelas> kelasList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kelasList.size(); i++) {
      resultList.add(kelasList.get(i).toHashMap());
    }

    return resultList;
  }

  public List<HashMap<String, Object>> mataKuliahGrouper(List<Kelas> kelasList) {
    HashMap<String, MataKuliah> mapMataKuliah = new HashMap<>();
    HashMap<String, List<Kelas>> groups = new HashMap<>();

    for (Kelas kelas : kelasList) {
      MataKuliah mataKuliah = kelas.getMataKuliah();

      if (!mapMataKuliah.containsKey(mataKuliah.getId().toString())) {
        mapMataKuliah.put(mataKuliah.getId().toString(), mataKuliah);
      }

      List<Kelas> group = new ArrayList<>();
      if (groups.containsKey(mataKuliah.getId().toString())) {
        group = groups.get(mataKuliah.getId().toString());
      } else {
        groups.put(mataKuliah.getId().toString(), group);
      }

      group.add(kelas);
    }

    List<HashMap<String, Object>> result = new ArrayList<>();
    for (Map.Entry<String, List<Kelas>> entry : groups.entrySet()) {
      String id = entry.getKey();
      List<Kelas> group = entry.getValue();

      MataKuliah mataKuliah = mapMataKuliah.get(id);
      String title = String.format("[%s] %s (%d SKS, Term %d); Kurikulum %s", mataKuliah.getKode(),
          mataKuliah.getNama(), mataKuliah.getSks(), mataKuliah.getTerm(),
          mataKuliah.getKurikulum().getKode() + " " + mataKuliah.getKurikulum().getNoSK());

      HashMap<String, Object> groupInfo = mataKuliah.toHashMap();

      List<HashMap<String, Object>> transformedGroup = transformKelasListToHashMap(group);
      groupInfo.put("kelas", transformedGroup);
      groupInfo.put("title", title);

      result.add(groupInfo);
    }

    return result;
  }
}
