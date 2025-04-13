package siakreborn.adminakademik.core;

import java.util.*;
import java.util.logging.Logger;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.adminakademik.AdminAkademikFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class AdminAkademikResourceImpl extends AdminAkademikResourceComponent {
  AdminAkademikService adminAkademikService = new AdminAkademikServiceImpl();
  private static final Logger LOGGER = Logger.getLogger(AdminAkademikResourceImpl.class.getName());

  @Restricted(permissionName = "CreateAdminAkademik")
  @Route(url = "call/adminakademik/save")
  public List<HashMap<String, Object>> saveAdminAkademik(VMJExchange vmjExchange) {
    List<AdminAkademik> listAdminAkademik = adminAkademikService.saveAdminAkademik((HashMap<String, Object>) vmjExchange.getPayload());
    return adminAkademikService.transformAdminAkademikListToHashMap(listAdminAkademik);
  }

  @Restricted(permissionName = "UpdateAdminAkademik")
  @Route(url = "call/adminakademik/update")
  public HashMap<String, Object> updateAdminAkademik(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    AdminAkademik adminAkademik = adminAkademikService.updateAdminAkademik((HashMap<String, Object>) vmjExchange.getPayload());
    return adminAkademik.toHashMap();
  }

  @Restricted(permissionName = "ReadAdminAkademik")
  @Route(url = "call/adminakademik/detail")
  public HashMap<String, Object> getAdminAkademik(VMJExchange vmjExchange) {
    String idStr = null;
    String email = null;
    HashMap<String, Object> error = new HashMap<>();
		
		try {
			idStr = vmjExchange.getGETParam("id");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      
      UUID id = UUID.fromString(idStr);
      AdminAkademik adminAkademik = adminAkademikService.getAdminAkademik(id);
      return adminAkademik.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      error.put("error", e);
		}
		
		try {
			email = vmjExchange.getAuthPayload().getEmail();
      AdminAkademik adminAkademik = adminAkademikService.getAdminAkademikByEmail(email);
      return adminAkademik.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      error.put("error", e);
		}

    error.put("message", "Data dengan id: "+idStr+" atau token dengan email: " + email + " tidak ditemukan");
    return error;
  }

  @Restricted(permissionName = "ReadAdminAkademik")
  @Route(url = "call/adminakademik/list")
  public List<HashMap<String, Object>> getAllAdminAkademik(VMJExchange vmjExchange) {
    List<AdminAkademik> adminAkademikList = adminAkademikService.getAllAdminAkademik();
    return adminAkademikService.transformAdminAkademikListToHashMap(adminAkademikList);
  }

  @Restricted(permissionName = "DeleteAdminAkademik")
  @Route(url = "call/adminakademik/delete")
  public List<HashMap<String, Object>> deleteAdminAkademik(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<AdminAkademik> adminAkademikList = adminAkademikService.deleteAdminAkademik(id);
    return adminAkademikService.transformAdminAkademikListToHashMap(adminAkademikList);
  }

}
