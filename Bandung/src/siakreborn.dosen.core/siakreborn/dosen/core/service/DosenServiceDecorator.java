package siakreborn.dosen.core;

import java.util.*;

public abstract class DosenServiceDecorator extends DosenServiceComponent {
  protected DosenServiceComponent record;

  public DosenServiceDecorator(DosenServiceComponent record) {
    this.record = record;
  }

  public List<Dosen> saveDosen(HashMap<String, Object> body) {
    return record.saveDosen(body);
  }

  public Dosen updateDosen(HashMap<String, Object> body) {
    return record.updateDosen(body);
  }

  public Dosen getDosen(UUID id) {
    return record.getDosen(id);
  }

  public Dosen getDosenByEmail(String email) {
    return record.getDosenByEmail(email);
  }

  public List<Dosen> getAllDosen() {
    return record.getAllDosen();
  }

  public List<Dosen> deleteDosen(UUID id) {
    return record.deleteDosen(id);
  }

  public List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList) {
    return record.transformDosenListToHashMap(dosenList);
  }
}
