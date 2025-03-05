package siakreborn.semester.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.semester.SemesterFactory;
import vmj.auth.annotations.Restricted;

public class SemesterResourceImpl extends SemesterResourceComponent {
  private SemesterFactory semesterFactory = new SemesterFactory();
  private SemesterService semesterService = new SemesterServiceImpl();

  @Restricted(permissionName = "CreateSemester")
  @Route(url = "call/semester/save")
  public List<HashMap<String, Object>> saveSemester(VMJExchange vmjExchange) {
    List<Semester> semesterList = semesterService.saveSemester((HashMap<String, Object>) vmjExchange.getPayload());
    return semesterService.transformSemesterListToHashMap(semesterList);
  }

  @Restricted(permissionName = "UpdateSemester")
  @Route(url = "call/semester/update")
  public HashMap<String, Object> updateSemester(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Semester semester = semesterService.updateSemester((HashMap<String, Object>) vmjExchange.getPayload());
    return semester.toHashMap();
  }

  @Restricted(permissionName = "ReadSemester")
  @Route(url = "call/semester/detail")
  public HashMap<String, Object> getSemester(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Semester semester = semesterService.getSemester(id);
    return semester.toHashMap();
  }

  @Restricted(permissionName = "ReadSemester")
  @Route(url = "call/semester/active")
  public HashMap<String, Object> getActiveSemester(VMJExchange vmjExchange) {
    Semester semester = semesterService.getActiveSemester();
    return semester.toHashMap();
  }

  @Restricted(permissionName = "ReadSemester")
  @Route(url = "call/semester/list")
  public List<HashMap<String, Object>> getAllSemester(VMJExchange vmjExchange) {
    List<Semester> semesterList = semesterService.getAllSemester();
    return semesterService.transformSemesterListToHashMap(semesterList);
  }

  @Restricted(permissionName = "DeleteSemester")
  @Route(url = "call/semester/delete")
  public List<HashMap<String, Object>> deleteSemester(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Semester> semesterList = semesterService.deleteSemester(id);
    return semesterService.transformSemesterListToHashMap(semesterList);
  }

}
