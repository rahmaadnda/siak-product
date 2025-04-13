package siakreborn.informasi.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.informasi.InformasiFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class InformasiResourceImpl extends InformasiResourceComponent {
  InformasiService informasiService = new InformasiServiceImpl();

  @Restricted(permissionName = "CreateInformasi")
  @Route(url = "call/informasi/save")
  public List<HashMap<String, Object>> saveInformasi(VMJExchange vmjExchange) {
    List<Informasi> listInformasi = informasiService.saveInformasi((HashMap<String, Object>) vmjExchange.getPayload());
    return informasiService.transformInformasiListToHashMap(listInformasi);
  }

  @Restricted(permissionName = "UpdateInformasi")
  @Route(url = "call/informasi/update")
  public HashMap<String, Object> updateInformasi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Informasi informasi = informasiService.updateInformasi((HashMap<String, Object>) vmjExchange.getPayload());
    return informasi.toHashMap();
  }

  @Restricted(permissionName = "ReadInformasi")
  @Route(url = "call/informasi/detail")
  public HashMap<String, Object> getInformasi(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Informasi informasi = informasiService.getInformasi(id);
    return informasi.toHashMap();
  }

  @Restricted(permissionName = "ReadInformasi")
  @Route(url = "call/informasi/list")
  public List<HashMap<String, Object>> getAllInformasi(VMJExchange vmjExchange) {
    List<Informasi> informasiList = informasiService.getAllInformasi();
    return informasiService.transformInformasiListToHashMap(informasiList);
  }

  @Restricted(permissionName = "DeleteInformasi")
  @Route(url = "call/informasi/delete")
  public List<HashMap<String, Object>> deleteInformasi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Informasi> informasiList = informasiService.deleteInformasi(id);
    return informasiService.transformInformasiListToHashMap(informasiList);
  }

}
