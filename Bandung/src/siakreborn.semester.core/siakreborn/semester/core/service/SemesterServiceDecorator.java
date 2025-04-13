package siakreborn.semester.core;

import java.util.*;

public abstract class SemesterServiceDecorator extends SemesterServiceComponent {
  protected SemesterServiceComponent record;

  public SemesterServiceDecorator(SemesterServiceComponent record) {
    this.record = record;
  }

  public List<Semester> saveSemester(HashMap<String, Object> body) {
    return record.saveSemester(body);
  }

  public Semester updateSemester(HashMap<String, Object> body) {
    return record.updateSemester(body);
  }

  public Semester getSemester(UUID id) {
    return record.getSemester(id);
  }

  public Semester getActiveSemester() {
    return record.getActiveSemester();
  }

  public List<Semester> getAllSemester() {
    return record.getAllSemester();
  }

  public List<Semester> deleteSemester(UUID id) {
    return record.deleteSemester(id);
  }

  public List<HashMap<String, Object>> transformSemesterListToHashMap(List<Semester> semesterList) {
    return record.transformSemesterListToHashMap(semesterList);
  }
}
