package siakreborn.kelasdosen.core;

import java.util.*;

import siakreborn.dosen.core.Dosen;

public abstract class KelasDosenServiceDecorator extends KelasDosenServiceComponent {
  protected KelasDosenServiceComponent record;

  public KelasDosenServiceDecorator(KelasDosenServiceComponent record) {
    this.record = record;
  }

  public List<KelasDosen> saveKelasDosen(HashMap<String, Object> body) {
    return record.saveKelasDosen(body);
  }

  public KelasDosen updateKelasDosen(HashMap<String, Object> body) {
    return record.updateKelasDosen(body);
  }

  public KelasDosen getKelasDosen(UUID id) {
    return record.getKelasDosen(id);
  }

  public List<KelasDosen> getAllKelasDosen() {
    return record.getAllKelasDosen();
  }

  public HashMap<String, Object> getKelasWithDosen(UUID kelasId) {
    return record.getKelasWithDosen(kelasId);
  }

  public List<HashMap<String, Object>> getRiwayatKelasDosen(UUID mahasiswaId) {
    return record.getRiwayatKelasDosen(mahasiswaId);
  }

  public List<Dosen> filterDosenByKelas(UUID kelasId) {
    return record.filterDosenByKelas(kelasId);
  }

  public List<KelasDosen> deleteKelasDosen(UUID id) {
    return record.deleteKelasDosen(id);
  }

  public List<HashMap<String, Object>> transformKelasDosenListToHashMap(List<KelasDosen> kelasDosenList) {
    return record.transformKelasDosenListToHashMap(kelasDosenList);
  }

  public List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList) {
    return record.transformDosenListToHashMap(dosenList);
  }
}
