package siakreborn.kurikulumsemester.core;

import java.util.*;

import siakreborn.semester.core.Semester;

public abstract class KurikulumSemesterServiceDecorator extends KurikulumSemesterServiceComponent {
  protected KurikulumSemesterServiceComponent record;

  public KurikulumSemesterServiceDecorator(KurikulumSemesterServiceComponent record) {
    this.record = record;
  }

  public List<KurikulumSemester> saveKurikulumSemester(HashMap<String, Object> body) {
    return record.saveKurikulumSemester(body);
  }

  public KurikulumSemester updateKurikulumSemester(HashMap<String, Object> body) {
    return record.updateKurikulumSemester(body);
  }

  public KurikulumSemester getKurikulumSemester(UUID id) {
    return record.getKurikulumSemester(id);
  }

  public List<KurikulumSemester> getAllKurikulumSemester() {
    return record.getAllKurikulumSemester();
  }

  public List<KurikulumSemester> deleteKurikulumSemester(UUID id) {
    return record.deleteKurikulumSemester(id);
  }

  public List<KurikulumSemester> saveSemester(HashMap<String, Object> body) {
    return record.saveSemester(body);
  }

  public Semester updateSemester(HashMap<String, Object> body) {
    return record.updateSemester(body);
  }

  public HashMap<String, Object> getSemester(UUID semesterId) {
    return record.getSemester(semesterId);
  }

  public List<HashMap<String, Object>> transformKurikulumSemesterListToHashMap(
      List<KurikulumSemester> kurikulumSemesterList) {
    return record.transformKurikulumSemesterListToHashMap(kurikulumSemesterList);
  }
}
