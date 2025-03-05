package siakreborn.semester.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class SemesterResourceDecorator extends SemesterResourceComponent {
  protected SemesterResourceComponent record;

  public SemesterResourceDecorator(SemesterResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveSemester(VMJExchange vmjExchange) {
    return record.saveSemester(vmjExchange);
  }

  public HashMap<String, Object> updateSemester(VMJExchange vmjExchange) {
    return record.updateSemester(vmjExchange);
  }

  public HashMap<String, Object> getSemester(VMJExchange vmjExchange) {
    return record.getSemester(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllSemester(VMJExchange vmjExchange) {
    return record.getAllSemester(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteSemester(VMJExchange vmjExchange) {
    return record.deleteSemester(vmjExchange);
  }

}
