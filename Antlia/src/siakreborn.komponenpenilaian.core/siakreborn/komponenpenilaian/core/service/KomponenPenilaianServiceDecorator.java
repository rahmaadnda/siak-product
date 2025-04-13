package siakreborn.komponenpenilaian.core;

import java.util.*;

public abstract class KomponenPenilaianServiceDecorator extends KomponenPenilaianServiceComponent {
  protected KomponenPenilaianServiceComponent record;

  public KomponenPenilaianServiceDecorator(KomponenPenilaianServiceComponent record) {
    this.record = record;
  }

  public List<KomponenPenilaian> saveKomponenPenilaian(HashMap<String, Object> body) {
    return record.saveKomponenPenilaian(body);
  }

  public KomponenPenilaian updateKomponenPenilaian(HashMap<String, Object> body) {
    return record.updateKomponenPenilaian(body);
  }

  public KomponenPenilaian getKomponenPenilaian(UUID id) {
    return record.getKomponenPenilaian(id);
  }

  public List<KomponenPenilaian> getAllKomponenPenilaian() {
    return record.getAllKomponenPenilaian();
  }

  public List<KomponenPenilaian> filterKomponenPenilaianByKelas(UUID kelasId) {
    return record.filterKomponenPenilaianByKelas(kelasId);
  }

  public List<KomponenPenilaian> deleteKomponenPenilaian(UUID id) {
    return record.deleteKomponenPenilaian(id);
  }

  public List<HashMap<String, Object>> transformKomponenPenilaianListToHashMap(
      List<KomponenPenilaian> komponenPenilaianList) {
    return record.transformKomponenPenilaianListToHashMap(komponenPenilaianList);
  }
}
