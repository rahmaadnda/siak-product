package siakreborn.penilaian.core;

import java.util.*;

import siakreborn.penilaian.PenilaianFactory;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;
import siakreborn.kelas.core.Kelas;
import siakreborn.kelas.core.KelasService;
import siakreborn.kelas.core.KelasServiceImpl;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.komponenpenilaian.core.KomponenPenilaian;

public class PenilaianServiceImpl extends PenilaianServiceComponent {
  private PenilaianFactory penilaianFactory = new PenilaianFactory();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();
  private KelasService kelasService = new KelasServiceImpl();

  public List<Penilaian> savePenilaian(HashMap<String, Object> body) {
    String nilaiStr = (String) body.get("nilai");
    int nilai = Integer.parseInt(nilaiStr);
    String komponenPenilaianIdStr = (String) body.get("komponenPenilaianId");
    String mahasiswaIdStr = (String) body.get("mahasiswaId");

    KomponenPenilaian komponenPenilaian = null;
    if (komponenPenilaianIdStr != null) {
      UUID komponenPenilaianId = UUID.fromString(komponenPenilaianIdStr);
      komponenPenilaian = penilaianRepository.getProxyObject(
          siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class, komponenPenilaianId);
    }

    Mahasiswa mahasiswa = null;
    if (mahasiswaIdStr != null) {
      UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);
      mahasiswa = penilaianRepository.getProxyObject(siakreborn.mahasiswa.core.MahasiswaComponent.class, mahasiswaId);
    }

    if (komponenPenilaian != null && mahasiswa != null) {
      Penilaian existingPenilaian = getPenilaianByKomponenAndMahasiswa(komponenPenilaian.getId(), mahasiswa.getId());
      if (existingPenilaian != null) {
        body.put("id", existingPenilaian.getId().toString());
        updatePenilaian(body);
        return getAllPenilaian();
      }
    }

    Penilaian penilaian = penilaianFactory.createPenilaian("siakreborn.penilaian.core.PenilaianImpl", mahasiswa, nilai,
        komponenPenilaian);

    penilaianRepository.saveObject(penilaian);
    return getAllPenilaian();
  }

  public Penilaian updatePenilaian(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nilaiStr = (String) body.get("nilai");
    int nilai = Integer.parseInt(nilaiStr);
    String komponenPenilaianIdStr = (String) body.get("komponenPenilaianId");
    String mahasiswaIdStr = (String) body.get("mahasiswaId");

    Penilaian penilaian = penilaianRepository.getObject(id);

    KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
    if (komponenPenilaianIdStr != null) {
      UUID komponenPenilaianId = UUID.fromString(komponenPenilaianIdStr);
      komponenPenilaian = penilaianRepository.getProxyObject(
          siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class, komponenPenilaianId);
    }

    Mahasiswa mahasiswa = penilaian.getMahasiswa();
    if (mahasiswaIdStr != null) {
      UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);
      mahasiswa = penilaianRepository.getProxyObject(siakreborn.mahasiswa.core.MahasiswaComponent.class, mahasiswaId);
    }

    penilaian.setNilai(nilai);
    penilaian.setKomponenPenilaian(komponenPenilaian);
    penilaian.setMahasiswa(mahasiswa);

    penilaianRepository.updateObject(penilaian);
    penilaian = penilaianRepository.getObject(id);

    return penilaian;
  }

  public Penilaian getPenilaian(UUID id) {
    Penilaian penilaian = penilaianRepository.getObject(id);
    return penilaian;
  }

  public Penilaian getPenilaianByKomponenAndMahasiswa(UUID komponenPenilaianId, UUID mahasiswaId) {
    List<Penilaian> penilaianList = filterPenilaian("mahasiswa_id", mahasiswaId);
    for (Penilaian penilaian : penilaianList) {
      KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
      if (komponenPenilaian.getId().equals(komponenPenilaianId)) {
        return penilaian;
      }
    }

    return null;
  }

  public List<Penilaian> getAllPenilaian() {
    List<Penilaian> penilaianList = penilaianRepository.getAllObject("penilaian_impl", PenilaianImpl.class.getName());
    return penilaianList;
  }

  public List<Penilaian> filterPenilaian(String columnName, UUID id) {
    List<Penilaian> penilaianList = penilaianRepository.getListObject("penilaian_comp", columnName, id);
    return penilaianList;
  }

  public List<Penilaian> filterPenilaianByMahasiswaAndKelas(UUID mahasiswaId, UUID kelasId) {
    List<Penilaian> penilaianList = penilaianRepository.getListObject("penilaian_comp",
        "mahasiswa_id", mahasiswaId);

    List<Penilaian> resultList = new ArrayList<>();
    for (Penilaian penilaian : penilaianList) {
      KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
      Kelas kelas = komponenPenilaian.getKelas();
      if (kelas.getId().toString().equals(kelasId.toString())) {
        resultList.add(penilaian);
      }
    }

    return resultList;
  }

  public HashMap<String, Object> getPenilaianAkhir(UUID mahasiswaId, UUID kelasId) {
    List<Penilaian> penilaianList = penilaianRepository.getListObject("penilaian_comp",
        "mahasiswa_id", mahasiswaId);

    List<Penilaian> penilaianKelas = new ArrayList<>();
    for (Penilaian penilaian : penilaianList) {
      KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
      Kelas kelas = komponenPenilaian.getKelas();
      if (kelas.getId().toString().equals(kelasId.toString())) {
        penilaianKelas.add(penilaian);
      }
    }

    double nilaiAkhir = computePenilaianAkhir(penilaianKelas);
    String nilaiAkhirHuruf = computeNilaiHuruf(nilaiAkhir);

    HashMap<String, Object> nilaiAkhirMap = new HashMap<>();
    nilaiAkhirMap.put("nilaiAkhir", nilaiAkhir);
    nilaiAkhirMap.put("nilaiAkhirHuruf", nilaiAkhirHuruf);

    Mahasiswa mahasiswa = mahasiswaService.getMahasiswa(mahasiswaId);
    nilaiAkhirMap.put("mahasiswaNama", mahasiswa.getNama());
    nilaiAkhirMap.put("mahasiswaNpm", mahasiswa.getNpm());

    Kelas kelas = kelasService.getKelas(kelasId);
    nilaiAkhirMap.put("kelasNama", kelas.getNama());

    MataKuliah mataKuliah = kelas.getMataKuliah();
    nilaiAkhirMap.put("mataKuliahNama", mataKuliah.getNama());
    nilaiAkhirMap.put("mataKuliahKode", mataKuliah.getKode());

    return nilaiAkhirMap;
  }

  public HashMap<String, Object> getPenilaianAkhirBulk(UUID mahasiswaId, List<UUID> kelasIdList) {
    List<Penilaian> penilaianList = penilaianRepository.getListObject("penilaian_comp",
        "mahasiswa_id", mahasiswaId);

    HashMap<String, Object> resultMap = new HashMap<>();
    for (UUID kelasId : kelasIdList) {
      List<Penilaian> penilaianKelas = new ArrayList<>();
      for (Penilaian penilaian : penilaianList) {
        KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
        Kelas kelas = komponenPenilaian.getKelas();
        if (kelas.getId().toString().equals(kelasId.toString())) {
          penilaianKelas.add(penilaian);
        }
      }

      double nilaiAkhir = computePenilaianAkhir(penilaianKelas);
      String nilaiAkhirHuruf = computeNilaiHuruf(nilaiAkhir);

      HashMap<String, Object> nilaiAkhirMap = new HashMap<>();
      nilaiAkhirMap.put("nilaiAkhir", nilaiAkhir);
      nilaiAkhirMap.put("nilaiAkhirHuruf", nilaiAkhirHuruf);

      resultMap.put(kelasId.toString(), nilaiAkhirMap);
    }

    return resultMap;
  }

  private double computePenilaianAkhir(List<Penilaian> penilaianList) {
    double totalBobot = 0;
    for (Penilaian penilaian : penilaianList) {
      KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
      totalBobot += komponenPenilaian.getBobot();
    }

    double nilaiAkhir = 0;
    for (Penilaian penilaian : penilaianList) {
      KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
      int nilaiKomponen = penilaian.getNilai();
      double bobotKomponen = komponenPenilaian.getBobot();
      nilaiAkhir += nilaiKomponen * bobotKomponen / totalBobot;
    }

    return Math.round(nilaiAkhir * 100) / 100;
  }

  private String computeNilaiHuruf(double nilaiAkhir) {
    if (nilaiAkhir >= 85) {
      return "A";
    }
    if (nilaiAkhir >= 80) {
      return "A-";
    }
    if (nilaiAkhir >= 75) {
      return "B+";
    }
    if (nilaiAkhir >= 70) {
      return "B";
    }
    if (nilaiAkhir >= 65) {
      return "B-";
    }
    if (nilaiAkhir >= 60) {
      return "C+";
    }
    if (nilaiAkhir >= 55) {
      return "C";
    }
    if (nilaiAkhir >= 40) {
      return "D";
    }
    return "E";
  }

  public List<Penilaian> deletePenilaian(UUID id) {
    penilaianRepository.deleteObject(id);
    return getAllPenilaian();
  }

  public List<HashMap<String, Object>> transformPenilaianListToHashMap(List<Penilaian> penilaianList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < penilaianList.size(); i++) {
      resultList.add(penilaianList.get(i).toHashMap());
    }

    return resultList;
  }
}
