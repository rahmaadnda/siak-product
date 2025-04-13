package siakreborn.dosen.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.dosen.DosenFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class DosenResourceImpl extends DosenResourceComponent {
  private DosenFactory dosenFactory = new DosenFactory();
  private DosenService dosenService = new DosenServiceImpl();

  @Restricted(permissionName = "CreateDosen")
  @Route(url = "call/dosen/save")
  public List<HashMap<String, Object>> saveDosen(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<Dosen> dosenList = dosenService.saveDosen((HashMap<String, Object>) vmjExchange.getPayload());
    return dosenService.transformDosenListToHashMap(dosenList);
  }

  @Restricted(permissionName = "UpdateDosen")
  @Route(url = "call/dosen/update")
  public HashMap<String, Object> updateDosen(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Dosen dosen = dosenService.updateDosen((HashMap<String, Object>) vmjExchange.getPayload());
    return dosen.toHashMap();
  }

  @Restricted(permissionName = "ReadDosen")
  @Route(url = "call/dosen/detail")
  public HashMap<String, Object> getDosen(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Dosen dosen = dosenService.getDosen(id);
    return dosen.toHashMap();
  }

  @Restricted(permissionName = "ReadDosen")
  @Route(url = "call/dosen/list")
  public List<HashMap<String, Object>> getAllDosen(VMJExchange vmjExchange) {
    List<Dosen> dosenList = dosenService.getAllDosen();
    return dosenService.transformDosenListToHashMap(dosenList);
  }

  @Restricted(permissionName = "DeleteDosen")
  @Route(url = "call/dosen/delete")
  public List<HashMap<String, Object>> deleteDosen(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Dosen> dosenList = dosenService.deleteDosen(id);
    return dosenService.transformDosenListToHashMap(dosenList);
  }

}
