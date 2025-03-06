package siakreborn.matakuliah.core;

import java.util.*;

public abstract class MataKuliahServiceDecorator extends MataKuliahServiceComponent {
  protected MataKuliahServiceComponent record;

  public MataKuliahServiceDecorator(MataKuliahServiceComponent record) {
    this.record = record;
  }

  public List<MataKuliah> saveMataKuliah(HashMap<String, Object> body) {
    return record.saveMataKuliah(body);
  }

  public MataKuliah updateMataKuliah(HashMap<String, Object> body) {
    return record.updateMataKuliah(body);
  }

  public MataKuliah getMataKuliah(UUID id) {
    return record.getMataKuliah(id);
  }

  public List<MataKuliah> getAllMataKuliah() {
    return record.getAllMataKuliah();
  }

  public List<MataKuliah> deleteMataKuliah(UUID id) {
    return record.deleteMataKuliah(id);
  }

  public List<HashMap<String, Object>> transformMataKuliahListToHashMap(List<MataKuliah> mataKuliahList) {
    return record.transformMataKuliahListToHashMap(mataKuliahList);
  }
}
