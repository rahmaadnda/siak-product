package siakreborn.penilaian.core;

import java.util.*;

public abstract class PenilaianServiceDecorator extends PenilaianServiceComponent {
  protected PenilaianServiceComponent record;

  public PenilaianServiceDecorator(PenilaianServiceComponent record) {
    this.record = record;
  }

  public List<Penilaian> savePenilaian(HashMap<String, Object> body) {
    return record.savePenilaian(body);
  }

  public Penilaian updatePenilaian(HashMap<String, Object> body) {
    return record.updatePenilaian(body);
  }

  public Penilaian getPenilaian(UUID id) {
    return record.getPenilaian(id);
  }

  public List<Penilaian> getAllPenilaian() {
    return record.getAllPenilaian();
  }

  public List<Penilaian> filterPenilaian(String columnName, UUID id) {
    return record.filterPenilaian(columnName, id);
  }

  public List<Penilaian> deletePenilaian(UUID id) {
    return record.deletePenilaian(id);
  }

  public List<Penilaian> filterPenilaianByMahasiswaAndKelas(UUID mahasiswaId, UUID kelasId) {
    return record.filterPenilaianByMahasiswaAndKelas(mahasiswaId, kelasId);
  }

  public HashMap<String, Object> getPenilaianAkhir(UUID mahasiswaId, UUID kelasId) {
    return record.getPenilaianAkhir(mahasiswaId, kelasId);
  }

  public HashMap<String, Object> getPenilaianAkhirBulk(UUID mahasiswaId, List<UUID> kelasIdList) {
    return record.getPenilaianAkhirBulk(mahasiswaId, kelasIdList);
  }

  public List<HashMap<String, Object>> transformPenilaianListToHashMap(List<Penilaian> penilaianList) {
    return record.transformPenilaianListToHashMap(penilaianList);
  }
}
