package siakreborn.rencanastudi.core;

import java.time.Instant;
import java.util.*;

import siakreborn.rencanastudi.KelasMahasiswaFactory;
import siakreborn.kelas.core.Kelas;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;
import siakreborn.penilaian.core.PenilaianService;
import siakreborn.penilaian.core.PenilaianServiceImpl;

public class KelasMahasiswaServiceImpl extends KelasMahasiswaServiceComponent {
  private KelasMahasiswaFactory kelasMahasiswaFactory = new KelasMahasiswaFactory();
  private PenilaianService penilaianService = new PenilaianServiceImpl();

  public List<KelasMahasiswa> saveKelasMahasiswa(HashMap<String, Object> body) {
    String rencanaStudiIdStr = (String) body.get("rencanaStudiId");
    String kelasIdStr = (String) body.get("kelasId");

    RencanaStudi rencanaStudi = null;
    if (rencanaStudiIdStr != null) {
      UUID rencanaStudiId = UUID.fromString(rencanaStudiIdStr);
      rencanaStudi = kelasMahasiswaRepository.getProxyObject(siakreborn.rencanastudi.core.RencanaStudiComponent.class,
          rencanaStudiId);
    }

    Kelas kelas = null;
    if (kelasIdStr != null) {
      UUID kelasId = UUID.fromString(kelasIdStr);
      kelas = kelasMahasiswaRepository.getProxyObject(siakreborn.kelas.core.KelasComponent.class, kelasId);
    }

    KelasMahasiswa kelasMahasiswa = kelasMahasiswaFactory.createKelasMahasiswa(
        "siakreborn.rencanastudi.core.KelasMahasiswaImpl", rencanaStudi, kelas, Date.from(Instant.now()));
    kelasMahasiswaRepository.saveObject(kelasMahasiswa);

    return getAllKelasMahasiswa();
  }

  public KelasMahasiswa updateKelasMahasiswa(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String rencanaStudiStr = (String) body.get("rencanaStudiId");
    String kelasIdStr = (String) body.get("kelasId");

    KelasMahasiswa kelasMahasiswa = kelasMahasiswaRepository.getObject(id);

    RencanaStudi rencanaStudi = kelasMahasiswa.getRencanaStudi();
    if (rencanaStudiStr != null) {
      UUID rencanaStudiId = UUID.fromString(rencanaStudiStr);
      rencanaStudi = kelasMahasiswaRepository.getProxyObject(siakreborn.rencanastudi.core.RencanaStudiComponent.class,
          rencanaStudiId);
    }

    Kelas kelas = kelasMahasiswa.getKelas();
    if (kelasIdStr != null) {
      UUID kelasId = UUID.fromString(kelasIdStr);
      kelas = kelasMahasiswaRepository.getProxyObject(siakreborn.kelas.core.KelasComponent.class, kelasId);
    }

    kelasMahasiswa.setRencanaStudi(rencanaStudi);
    kelasMahasiswa.setKelas(kelas);

    kelasMahasiswaRepository.updateObject(kelasMahasiswa);
    kelasMahasiswa = kelasMahasiswaRepository.getObject(id);

    return kelasMahasiswa;
  }

  public KelasMahasiswa getKelasMahasiswa(UUID id) {
    KelasMahasiswa kelasMahasiswa = kelasMahasiswaRepository.getObject(id);
    return kelasMahasiswa;
  }

  public List<KelasMahasiswa> getAllKelasMahasiswa() {
    List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaRepository.getAllObject("kelas_mahasiswa_impl",
        KelasMahasiswaImpl.class.getName());
    return kelasMahasiswaList;
  }

  public List<KelasMahasiswa> filterKelasMahasiswa(String columnName, UUID id) {
    List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaRepository.getListObject("kelas_mahasiswa_comp", columnName,
        id);

    return kelasMahasiswaList;
  }

  public List<Mahasiswa> filterMahasiswaByKelas(UUID kelasId) {
    List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaRepository.getListObject("kelas_mahasiswa_comp", "kelas_id",
        kelasId);
    List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();
    for (int i = 0; i < kelasMahasiswaList.size(); i++) {
      mahasiswaList.add(kelasMahasiswaList.get(i).getRencanaStudi().getMahasiswa());
    }

    return mahasiswaList;
  }

  public List<Kelas> filterKelasByMahasiswa(UUID mahasiswaId) {
    List<KelasMahasiswa> kelasMahasiswaList = getAllKelasMahasiswa();
    List<Kelas> kelasList = new ArrayList<Kelas>();
    for (KelasMahasiswa kelasMahasiswa : kelasMahasiswaList) {
      Mahasiswa mahasiswa = kelasMahasiswa.getRencanaStudi().getMahasiswa();
      if (mahasiswa.getId().toString().equals(mahasiswaId.toString())) {
        kelasList.add(kelasMahasiswa.getKelas());
      }
    }

    return kelasList;
  }

  public List<HashMap<String, Object>> getRiwayatKelasMahasiswa(UUID mahasiswaId, String by) {
    List<Kelas> kelasList = filterKelasByMahasiswa(mahasiswaId);
    List<UUID> kelasIdList = new ArrayList<>();
    for (Kelas kelas : kelasList) {
      kelasIdList.add(kelas.getId());
    }

    HashMap<String, Object> nilaiAkhirMap = penilaianService.getPenilaianAkhirBulk(mahasiswaId, kelasIdList);

    if (by.equals("semester")) {
      return groupRiwayatBySemester(kelasList, nilaiAkhirMap);
    } else if (by.equals("mataKuliah")) {
      return sortRiwayatByMataKuliah(kelasList, nilaiAkhirMap);
    } else {
      return combineKelasListAndNilaiAkhir(kelasList, nilaiAkhirMap);
    }
  }

  private List<HashMap<String, Object>> groupRiwayatBySemester(List<Kelas> kelasList,
      HashMap<String, Object> nilaiAkhirMap) {

    HashMap<String, Semester> mapSemester = new HashMap<>();
    HashMap<String, List<Kelas>> groups = new HashMap<>();

    for (Kelas kelas : kelasList) {
      Semester semester = kelas.getSemester();

      if (!mapSemester.containsKey(semester.getId().toString())) {
        mapSemester.put(semester.getId().toString(), semester);
      }

      List<Kelas> group = new ArrayList<>();
      if (groups.containsKey(semester.getId().toString())) {
        group = groups.get(semester.getId().toString());
      } else {
        groups.put(semester.getId().toString(), group);
      }

      group.add(kelas);
    }

    List<HashMap<String, Object>> result = new ArrayList<>();
    for (Map.Entry<String, List<Kelas>> entry : groups.entrySet()) {
      String id = entry.getKey();
      List<Kelas> group = entry.getValue();

      Semester semester = mapSemester.get(id);

      HashMap<String, Object> groupInfo = semester.toHashMap();

      List<HashMap<String, Object>> transformedGroup = combineKelasListAndNilaiAkhir(group, nilaiAkhirMap);

      groupInfo.put("kelas", transformedGroup);

      result.add(groupInfo);
    }

    return result;
  }

  private List<HashMap<String, Object>> sortRiwayatByMataKuliah(List<Kelas> kelasList,
      HashMap<String, Object> nilaiAkhirMap) {
    List<HashMap<String, Object>> riwayatKelas = combineKelasListAndNilaiAkhir(kelasList, nilaiAkhirMap);

    riwayatKelas.sort((map1, map2) -> {
      String mataKuliahNama1 = (String) map1.get("mataKuliahNama");
      String mataKuliahNama2 = (String) map2.get("mataKuliahNama");

      return mataKuliahNama1.compareToIgnoreCase(mataKuliahNama2);
    });

    return riwayatKelas;
  }

  private List<HashMap<String, Object>> combineKelasListAndNilaiAkhir(List<Kelas> kelasList,
      HashMap<String, Object> nilaiAkhirMap) {
    List<HashMap<String, Object>> result = new ArrayList<>();
    for (Kelas kelas : kelasList) {
      String id = kelas.getId().toString();
      HashMap<String, Object> map = (HashMap<String, Object>) nilaiAkhirMap.get(id);
      double nilaiAkhir = (double) map.get("nilaiAkhir");
      String nilaiHuruf = (String) map.get("nilaiAkhirHuruf");

      HashMap<String, Object> kelasMap = kelas.toHashMap();
      kelasMap.put("nilaiAkhir", nilaiAkhir);
      kelasMap.put("nilaiHuruf", nilaiHuruf);

      result.add(kelasMap);
    }

    return result;
  }

  public List<KelasMahasiswa> deleteKelasMahasiswa(UUID id) {
    kelasMahasiswaRepository.deleteObject(id);
    return getAllKelasMahasiswa();
  }

  public List<HashMap<String, Object>> transformKelasMahasiswaListToHashMap(List<KelasMahasiswa> kelasMahasiswaList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kelasMahasiswaList.size(); i++) {
      resultList.add(kelasMahasiswaList.get(i).toHashMap());
    }

    return resultList;
  }

  public List<HashMap<String, Object>> transformMahasiswaListToHashMap(List<Mahasiswa> mahasiswaList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < mahasiswaList.size(); i++) {
      resultList.add(mahasiswaList.get(i).toHashMap());
    }

    return resultList;
  }

  public List<HashMap<String, Object>> transformKelasListToHashMap(List<Kelas> kelasList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kelasList.size(); i++) {
      resultList.add(kelasList.get(i).toHashMap());
    }

    return resultList;
  }
}
