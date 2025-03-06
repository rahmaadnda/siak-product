package siakreborn.kurikulum.core;

import java.util.*;

public abstract class KurikulumServiceDecorator extends KurikulumServiceComponent {
  protected KurikulumServiceComponent record;

  public KurikulumServiceDecorator(KurikulumServiceComponent record) {
    this.record = record;
  }

  public List<Kurikulum> saveKurikulum(HashMap<String, Object> body) {
    return record.saveKurikulum(body);
  }

  public Kurikulum updateKurikulum(HashMap<String, Object> body) {
    return record.updateKurikulum(body);
  }

  public Kurikulum getKurikulum(UUID id) {
    return record.getKurikulum(id);
  }

  public List<Kurikulum> getAllKurikulum() {
    return record.getAllKurikulum();
  }

  public List<Kurikulum> filterKurikulumByProgramStudi(UUID programStudiId) {
    return record.filterKurikulumByProgramStudi(programStudiId);
  }

  public List<Kurikulum> deleteKurikulum(UUID id) {
    return record.deleteKurikulum(id);
  }

  public List<HashMap<String, Object>> transformKurikulumListToHashMap(List<Kurikulum> kurikulumList) {
    return record.transformKurikulumListToHashMap(kurikulumList);
  }
}
