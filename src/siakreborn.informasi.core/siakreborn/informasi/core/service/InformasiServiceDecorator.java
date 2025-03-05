package siakreborn.informasi.core;

import java.util.*;

public abstract class InformasiServiceDecorator extends InformasiServiceComponent {
  protected InformasiServiceComponent record;

  public InformasiServiceDecorator(InformasiServiceComponent record) {
    this.record = record;
  }

  public List<Informasi> saveInformasi(HashMap<String, Object> body) {
    return record.saveInformasi(body);
  }

  public Informasi updateInformasi(HashMap<String, Object> body) {
    return record.updateInformasi(body);
  }

  public Informasi getInformasi(UUID id) {
    return record.getInformasi(id);
  }

  public List<Informasi> getAllInformasi() {
    return record.getAllInformasi();
  }

  public List<Informasi> deleteInformasi(UUID id) {
    return record.deleteInformasi(id);
  }

  public List<HashMap<String, Object>> transformInformasiListToHashMap(List<Informasi> informasiList) {
    return record.transformInformasiListToHashMap(informasiList);
  }
}
