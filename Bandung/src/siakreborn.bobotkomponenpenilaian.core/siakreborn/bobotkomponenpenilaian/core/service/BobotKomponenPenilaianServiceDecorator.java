package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;

public abstract class BobotKomponenPenilaianServiceDecorator extends BobotKomponenPenilaianServiceComponent {
  protected BobotKomponenPenilaianServiceComponent record;

  public BobotKomponenPenilaianServiceDecorator(BobotKomponenPenilaianServiceComponent record) {
    this.record = record;
  }

  public List<BobotKomponenPenilaian> saveBobotKomponenPenilaian(HashMap<String, Object> body) {
    return record.saveBobotKomponenPenilaian(body);
  }

  public BobotKomponenPenilaian updateBobotKomponenPenilaian(HashMap<String, Object> body) {
    return record.updateBobotKomponenPenilaian(body);
  }

  public BobotKomponenPenilaian getBobotKomponenPenilaian(UUID id) {
    return record.getBobotKomponenPenilaian(id);
  }

  public List<BobotKomponenPenilaian> getAllBobotKomponenPenilaian() {
    return record.getAllBobotKomponenPenilaian();
  }

  public List<BobotKomponenPenilaian> deleteBobotKomponenPenilaian(UUID id) {
    return record.deleteBobotKomponenPenilaian(id);
  }

  public HashMap<String, Object> getKomponenPenilaianKelasMapping(UUID kelasId) {
    return record.getKomponenPenilaianKelasMapping(kelasId);
  }

  public List<HashMap<String, Object>> transformBobotKomponenPenilaianListToHashMap(
      List<BobotKomponenPenilaian> bobotKomponenPenilaianList) {
    return record.transformBobotKomponenPenilaianListToHashMap(bobotKomponenPenilaianList);
  }
}
