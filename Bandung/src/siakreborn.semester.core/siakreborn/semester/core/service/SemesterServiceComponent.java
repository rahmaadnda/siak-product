package siakreborn.semester.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class SemesterServiceComponent implements SemesterService {
  protected RepositoryUtil<Semester> semesterRepository;

  public SemesterServiceComponent() {
    this.semesterRepository = new RepositoryUtil<Semester>(siakreborn.semester.core.SemesterComponent.class);
  }

  public abstract List<Semester> saveSemester(HashMap<String, Object> body);

  public abstract Semester updateSemester(HashMap<String, Object> body);

  public abstract Semester getSemester(UUID id);

  public abstract Semester getActiveSemester();

  public abstract List<Semester> getAllSemester();

  public abstract List<Semester> deleteSemester(UUID id);

  public abstract List<HashMap<String, Object>> transformSemesterListToHashMap(List<Semester> semesterList);
}
