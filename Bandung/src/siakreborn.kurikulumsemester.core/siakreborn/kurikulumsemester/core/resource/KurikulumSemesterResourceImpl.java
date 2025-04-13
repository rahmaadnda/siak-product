package siakreborn.kurikulumsemester.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kurikulumsemester.KurikulumSemesterFactory;
import vmj.auth.annotations.Restricted;

import siakreborn.kurikulum.core.Kurikulum;
import siakreborn.semester.core.Semester;

public class KurikulumSemesterResourceImpl extends KurikulumSemesterResourceComponent {
  private KurikulumSemesterService kurikulumSemesterService = new KurikulumSemesterServiceImpl();

  @Restricted(permissionName = "CreateKurikulumSemester")
  @Route(url = "call/kurikulumsemester/save")
  public List<HashMap<String, Object>> saveKurikulumSemester(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    List<KurikulumSemester> kurikulumSemesterList = kurikulumSemesterService
        .saveKurikulumSemester((HashMap<String, Object>) vmjExchange.getPayload());
    return kurikulumSemesterService.transformKurikulumSemesterListToHashMap(kurikulumSemesterList);
  }

  @Restricted(permissionName = "UpdateKurikulumSemester")
  @Route(url = "call/kurikulumsemester/update")
  public HashMap<String, Object> updateKurikulumSemester(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    KurikulumSemester kurikulumSemester = kurikulumSemesterService
        .updateKurikulumSemester((HashMap<String, Object>) vmjExchange.getPayload());
    return kurikulumSemester.toHashMap();
  }

  @Restricted(permissionName = "ReadKurikulumSemester")
  @Route(url = "call/kurikulumsemester/detail")
  public HashMap<String, Object> getKurikulumSemester(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    KurikulumSemester kurikulumSemester = kurikulumSemesterService.getKurikulumSemester(id);
    return kurikulumSemester.toHashMap();
  }

  @Restricted(permissionName = "ReadKurikulumSemester")
  @Route(url = "call/kurikulumsemester/list")
  public List<HashMap<String, Object>> getAllKurikulumSemester(VMJExchange vmjExchange) {
    List<KurikulumSemester> kurikulumSemesterList = kurikulumSemesterService.getAllKurikulumSemester();
    return kurikulumSemesterService.transformKurikulumSemesterListToHashMap(kurikulumSemesterList);
  }

  @Restricted(permissionName = "DeleteKurikulumSemester")
  @Route(url = "call/kurikulumsemester/delete")
  public List<HashMap<String, Object>> deleteKurikulumSemester(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<KurikulumSemester> kurikulumSemesterList = kurikulumSemesterService.deleteKurikulumSemester(id);
    return kurikulumSemesterService.transformKurikulumSemesterListToHashMap(kurikulumSemesterList);
  }

  @Restricted(permissionName = "CreateSemester")
  @Route(url = "call/kurikulumsemester/semester/save")
  public List<HashMap<String, Object>> saveSemester(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    List<KurikulumSemester> kurikulumSemesterList = kurikulumSemesterService
        .saveSemester((HashMap<String, Object>) vmjExchange.getPayload());
    return kurikulumSemesterService.transformKurikulumSemesterListToHashMap(kurikulumSemesterList);
  }

  @Restricted(permissionName = "UpdateSemester")
  @Route(url = "call/kurikulumsemester/semester/update")
  public HashMap<String, Object> updateSemester(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    Semester semester = kurikulumSemesterService
        .updateSemester((HashMap<String, Object>) vmjExchange.getPayload());
    return semester.toHashMap();
  }

  @Restricted(permissionName = "ReadSemester")
  @Route(url = "call/kurikulumsemester/semester/detail")
  public HashMap<String, Object> getSemester(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    HashMap<String, Object> semester = kurikulumSemesterService.getSemester(id);
    return semester;
  }
}
