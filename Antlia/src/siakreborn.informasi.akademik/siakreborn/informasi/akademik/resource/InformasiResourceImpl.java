package siakreborn.informasi.akademik;

import vmj.routing.route.VMJExchange;
import vmj.routing.route.Route;
import vmj.auth.annotations.Restricted;

import java.util.*;
import java.util.logging.Logger;

import siakreborn.informasi.core.*;

public class InformasiResourceImpl extends InformasiResourceDecorator {
  private InformasiService informasiService;
  private static final Logger LOGGER = Logger.getLogger(InformasiResourceImpl.class.getName());

  public InformasiResourceImpl(InformasiResourceComponent recordController, InformasiServiceComponent recordService) {
    super(recordController);
    this.informasiService = new InformasiServiceImpl(recordService);
  }

  @Restricted(permissionName = "SaveInformasiAkademik")
  @Route(url = "call/informasiakademik/save")
  public List<HashMap<String, Object>> saveInformasi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String email = vmjExchange.getAuthPayload().getEmail();
    List<Informasi> informasiList = ((InformasiServiceImpl) informasiService).saveInformasi((HashMap<String, Object>) vmjExchange.getPayload(), email);
    return informasiService.transformInformasiListToHashMap(informasiList);
  }

  @Restricted(permissionName = "UpdateInformasiAkademik")
  @Route(url = "call/informasiakademik/update")
  public HashMap<String, Object> updateInformasi(VMJExchange vmjExchange) {
    Informasi informasi = informasiService.updateInformasi((HashMap<String, Object>) vmjExchange.getPayload());
    return informasi.toHashMap();
  }

  @Restricted(permissionName = "ReadInformasiAkademik")
  @Route(url = "call/informasiakademik/detail")
  public HashMap<String, Object> getInformasi(VMJExchange vmjExchange) {
		try {
      String idStr = null;
			idStr = vmjExchange.getGETParam("id");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID id = UUID.fromString(idStr);
      Informasi informasi = informasiService.getInformasi(id);
      return informasi.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      HashMap<String, Object> error = new HashMap<>();
      error.put("error", e);
      return error;
		}
  }

  @Restricted(permissionName = "ReadInformasiAkademik")
  @Route(url = "call/informasiakademik/list")
  public List<HashMap<String, Object>> getAllInformasi(VMJExchange vmjExchange) {
    List<Informasi> informasiList = informasiService.getAllInformasi();
    return informasiService.transformInformasiListToHashMap(informasiList);
  }

  @Restricted(permissionName = "DeleteInformasiAkademik")
  @Route(url = "call/informasiakademik/delete")
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
