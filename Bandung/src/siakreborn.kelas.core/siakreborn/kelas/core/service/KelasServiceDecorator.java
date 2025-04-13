package siakreborn.kelas.core;

import java.util.*;

public abstract class KelasServiceDecorator extends KelasServiceComponent {
  protected KelasServiceComponent record;

  public KelasServiceDecorator(KelasServiceComponent record) {
    this.record = record;
  }

  public List<Kelas> saveKelas(HashMap<String, Object> body) {
    return record.saveKelas(body);
  }

  public Kelas updateKelas(HashMap<String, Object> body) {
    return record.updateKelas(body);
  }

  public Kelas getKelas(UUID id) {
    return record.getKelas(id);
  }

  public List<Kelas> getAllKelas() {
    return record.getAllKelas();
  }

  public List<Kelas> filterKelasByMataKuliah(UUID mataKuliahId) {
    return record.filterKelasByMataKuliah(mataKuliahId);
  }

  public List<Kelas> filterKelasBySemester(UUID semesterId) {
    return record.filterKelasBySemester(semesterId);
  }

  public List<HashMap<String, Object>> groupKelasByMataKuliah() {
    return record.groupKelasByMataKuliah();
  }

  public List<HashMap<String, Object>> mataKuliahGrouper(List<Kelas> kelasList) {
    return record.mataKuliahGrouper(kelasList);
  }

  public List<Kelas> deleteKelas(UUID id) {
    return record.deleteKelas(id);
  }

  public List<HashMap<String, Object>> transformKelasListToHashMap(List<Kelas> kelasList) {
    return record.transformKelasListToHashMap(kelasList);
  }
}
