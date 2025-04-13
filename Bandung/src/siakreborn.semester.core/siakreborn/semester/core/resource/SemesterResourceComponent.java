package siakreborn.semester.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SemesterResourceComponent implements SemesterResource {
  protected RepositoryUtil<Semester> semesterRepository;

  public SemesterResourceComponent() {
    this.semesterRepository = new RepositoryUtil<Semester>(siakreborn.semester.core.SemesterComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveSemester(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateSemester(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getSemester(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllSemester(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteSemester(VMJExchange vmjExchange);

}
