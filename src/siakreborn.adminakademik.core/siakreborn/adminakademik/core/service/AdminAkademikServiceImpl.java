package siakreborn.adminakademik.core;

import java.util.*;

import siakreborn.adminakademik.AdminAkademikFactory;

import vmj.routing.route.exceptions.NotFoundException;

public class AdminAkademikServiceImpl extends AdminAkademikServiceComponent {
  private AdminAkademikFactory adminAkademikFactory = new AdminAkademikFactory();

  public List<AdminAkademik> saveAdminAkademik(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String email = (String) body.get("email");

    AdminAkademik adminAkademik = AdminAkademikFactory.createAdminAkademik("siakreborn.adminakademik.core.AdminAkademikImpl", nama, email);
    adminAkademikRepository.saveObject(adminAkademik);

    return getAllAdminAkademik();
  }

  public AdminAkademik updateAdminAkademik(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nama = (String) body.get("nama");
    String email = (String) body.get("email");

    AdminAkademik adminAkademik = adminAkademikRepository.getObject(id);
    adminAkademik.setNama(nama);
    adminAkademik.setEmail(email);

    adminAkademikRepository.updateObject(adminAkademik);
    adminAkademik = adminAkademikRepository.getObject(id);

    return adminAkademik;
  }

  public AdminAkademik getAdminAkademik(UUID id) {
    AdminAkademik adminAkademik = adminAkademikRepository.getObject(id);
    return adminAkademik;
  }

  public AdminAkademik getAdminAkademikByEmail(String email) {
    List<AdminAkademik> adminAkademikList = getAllAdminAkademik();
    for (AdminAkademik adminAkademik : adminAkademikList) {
      if (adminAkademik.getEmail().equals(email)) {
        return adminAkademik;
      }
    }
    throw new NotFoundException("admin akademik tidak ditemukan");
  }

  public List<AdminAkademik> getAllAdminAkademik() {
    List<AdminAkademik> adminAkademikList = adminAkademikRepository.getAllObject("adminakademik_impl", AdminAkademikImpl.class.getName());
    return adminAkademikList;
  }

  public List<AdminAkademik> deleteAdminAkademik(UUID id) {
    adminAkademikRepository.deleteObject(id);
    return getAllAdminAkademik();
  }

  public List<HashMap<String, Object>> transformAdminAkademikListToHashMap(List<AdminAkademik> adminAkademikList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < adminAkademikList.size(); i++) {
      resultList.add(adminAkademikList.get(i).toHashMap());
    }

    return resultList;
  }
}
