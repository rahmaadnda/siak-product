package siakreborn.capaian.core;

import java.util.*;

public abstract class CapaianServiceDecorator extends CapaianServiceComponent {
  protected CapaianServiceComponent record;

  public CapaianServiceDecorator(CapaianServiceComponent record) {
    this.record = record;
  }

  public List<Capaian> saveCapaian(HashMap<String, Object> body) {
    return record.saveCapaian(body);
  }

  public Capaian updateCapaian(HashMap<String, Object> body) {
    return record.updateCapaian(body);
  }

  public Capaian getCapaian(UUID id) {
    return record.getCapaian(id);
  }

  public List<Capaian> getAllCapaian() {
    return record.getAllCapaian();
  }

  public List<Capaian> deleteCapaian(UUID id) {
    return record.deleteCapaian(id);
  }

  public List<HashMap<String, Object>> getCapaianKelas(UUID kelasId) {
    return record.getCapaianKelas(kelasId);
  }

  public List<HashMap<String, Object>> transformCapaianListToHashMap(List<Capaian> capaianList) {
    return record.transformCapaianListToHashMap(capaianList);
  }
}
