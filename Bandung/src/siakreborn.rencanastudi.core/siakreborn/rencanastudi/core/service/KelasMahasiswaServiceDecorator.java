package siakreborn.rencanastudi.core;

import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;

public abstract class KelasMahasiswaServiceDecorator extends KelasMahasiswaServiceComponent {
  protected KelasMahasiswaServiceComponent record;

  public KelasMahasiswaServiceDecorator(KelasMahasiswaServiceComponent record) {
    this.record = record;
  }

  public List<KelasMahasiswa> saveKelasMahasiswa(HashMap<String, Object> body) {
    return record.saveKelasMahasiswa(body);
  }

  public KelasMahasiswa updateKelasMahasiswa(HashMap<String, Object> body) {
    return record.updateKelasMahasiswa(body);
  }

  public KelasMahasiswa getKelasMahasiswa(UUID id) {
    return record.getKelasMahasiswa(id);
  }

  public List<KelasMahasiswa> getAllKelasMahasiswa() {
    return record.getAllKelasMahasiswa();
  }

  public List<KelasMahasiswa> filterKelasMahasiswa(String columnName, UUID id) {
    return record.filterKelasMahasiswa(columnName, id);
  }

  public List<Mahasiswa> filterMahasiswaByKelas(UUID kelasId) {
    return record.filterMahasiswaByKelas(kelasId);
  }

  public List<HashMap<String, Object>> getRiwayatKelasMahasiswa(UUID mahasiswaId, String by) {
    return record.getRiwayatKelasMahasiswa(mahasiswaId, by);
  }

  public List<KelasMahasiswa> deleteKelasMahasiswa(UUID id) {
    return record.deleteKelasMahasiswa(id);
  }

  public List<HashMap<String, Object>> transformKelasMahasiswaListToHashMap(List<KelasMahasiswa> kelasMahasiswaList) {
    return record.transformKelasMahasiswaListToHashMap(kelasMahasiswaList);
  }

  public List<HashMap<String, Object>> transformMahasiswaListToHashMap(
      List<Mahasiswa> mahasiswaList) {
    return record.transformMahasiswaListToHashMap(mahasiswaList);
  }
}
