package siakreborn.capaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.capaian.CapaianFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class CapaianResourceImpl extends CapaianResourceComponent {
  CapaianService capaianService = new CapaianServiceImpl();

  @Restricted(permissionName = "CreateCapaian")
  @Route(url = "call/capaian/save")
  public List<HashMap<String, Object>> saveCapaian(VMJExchange vmjExchange) {
    List<Capaian> listCapaian = capaianService.saveCapaian((HashMap<String, Object>) vmjExchange.getPayload());
    return capaianService.transformCapaianListToHashMap(listCapaian);
  }

  @Restricted(permissionName = "UpdateCapaian")
  @Route(url = "call/capaian/update")
  public HashMap<String, Object> updateCapaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Capaian capaian = capaianService.updateCapaian((HashMap<String, Object>) vmjExchange.getPayload());
    return capaian.toHashMap();
  }

  @Restricted(permissionName = "ReadCapaian")
  @Route(url = "call/capaian/detail")
  public HashMap<String, Object> getCapaian(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Capaian capaian = capaianService.getCapaian(id);
    return capaian.toHashMap();
  }

  @Restricted(permissionName = "ReadCapaian")
  @Route(url = "call/capaian/list")
  public List<HashMap<String, Object>> getAllCapaian(VMJExchange vmjExchange) {
    List<Capaian> capaianList = capaianService.getAllCapaian();
    return capaianService.transformCapaianListToHashMap(capaianList);
  }

  public List<HashMap<String, Object>> transformCapaianListToHashMap(List<Capaian> capaianList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < capaianList.size(); i++) {
      resultList.add(capaianList.get(i).toHashMap());
    }

    return resultList;
  }

  @Restricted(permissionName = "DeleteCapaian")
  @Route(url = "call/capaian/delete")
  public List<HashMap<String, Object>> deleteCapaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Capaian> capaianList = capaianService.deleteCapaian(id);
    return capaianService.transformCapaianListToHashMap(capaianList);
  }

  @Restricted(permissionName = "ReadCapaian")
  @Route(url = "call/capaian/kelas")
  public List<HashMap<String, Object>> getCapaianKelas(VMJExchange vmjExchange) {
    String kelasIdStr = (String) vmjExchange.getGETParam("kelasId");
    if(kelasIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kelasId = UUID.fromString(kelasIdStr);

    List<HashMap<String, Object>> capaianList = capaianService.getCapaianKelas(kelasId);
    return capaianList;
  }

}
