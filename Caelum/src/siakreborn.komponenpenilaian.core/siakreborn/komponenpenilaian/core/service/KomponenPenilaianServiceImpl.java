package siakreborn.komponenpenilaian.core;

import java.util.*;

import siakreborn.komponenpenilaian.KomponenPenilaianFactory;
import siakreborn.kelas.core.Kelas;

public class KomponenPenilaianServiceImpl extends KomponenPenilaianServiceComponent {
  private KomponenPenilaianFactory komponenPenilaianFactory = new KomponenPenilaianFactory();

  public List<KomponenPenilaian> saveKomponenPenilaian(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String bobotStr = (String) body.get("bobot");
    double bobot = Double.parseDouble(bobotStr);
    String kelasIdStr = (String) body.get("kelasId");

    Kelas kelas = null;
    if (kelasIdStr != null) {
      UUID kelasId = UUID.fromString(kelasIdStr);
      kelas = komponenPenilaianRepository.getProxyObject(siakreborn.kelas.core.KelasComponent.class, kelasId);
    }

    KomponenPenilaian komponenPenilaian = komponenPenilaianFactory
        .createKomponenPenilaian("siakreborn.komponenpenilaian.core.KomponenPenilaianImpl", nama, kelas, bobot);

    komponenPenilaianRepository.saveObject(komponenPenilaian);
    return getAllKomponenPenilaian();
  }

  public KomponenPenilaian updateKomponenPenilaian(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nama = (String) body.get("nama");
    String bobotStr = (String) body.get("bobot");
    double bobot = Double.parseDouble(bobotStr);
    String kelasIdStr = (String) body.get("kelasId");

    KomponenPenilaian komponenPenilaian = komponenPenilaianRepository.getObject(id);

    Kelas kelas = komponenPenilaian.getKelas();
    if (kelasIdStr != null) {
      UUID kelasId = UUID.fromString(kelasIdStr);
      kelas = komponenPenilaianRepository.getProxyObject(siakreborn.kelas.core.KelasComponent.class, kelasId);
    }

    komponenPenilaian.setNama(nama);
    komponenPenilaian.setBobot(bobot);
    komponenPenilaian.setKelas(kelas);

    komponenPenilaianRepository.updateObject(komponenPenilaian);
    komponenPenilaian = komponenPenilaianRepository.getObject(id);

    return komponenPenilaian;
  }

  public KomponenPenilaian getKomponenPenilaian(UUID id) {
    KomponenPenilaian komponenPenilaian = komponenPenilaianRepository.getObject(id);
    return komponenPenilaian;
  }

  public List<KomponenPenilaian> getAllKomponenPenilaian() {
    List<KomponenPenilaian> komponenPenilaianList = komponenPenilaianRepository.getAllObject("komponen_penilaian_impl",
        KomponenPenilaianImpl.class.getName());
    return komponenPenilaianList;
  }

  public List<KomponenPenilaian> filterKomponenPenilaianByKelas(UUID kelasId) {
    List<KomponenPenilaian> komponenPenilaianList = komponenPenilaianRepository.getListObject("komponen_penilaian_comp",
        "kelas_id", kelasId);
    return komponenPenilaianList;
  }

  public List<KomponenPenilaian> deleteKomponenPenilaian(UUID id) {
    komponenPenilaianRepository.deleteObject(id);
    return getAllKomponenPenilaian();
  }

  public List<HashMap<String, Object>> transformKomponenPenilaianListToHashMap(
      List<KomponenPenilaian> komponenPenilaianList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < komponenPenilaianList.size(); i++) {
      resultList.add(komponenPenilaianList.get(i).toHashMap());
    }

    return resultList;
  }
}
