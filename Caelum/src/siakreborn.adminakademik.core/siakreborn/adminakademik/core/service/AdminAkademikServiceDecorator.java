package siakreborn.adminakademik.core;

import java.util.*;

public abstract class AdminAkademikServiceDecorator extends AdminAkademikServiceComponent {
  protected AdminAkademikServiceComponent record;

  public AdminAkademikServiceDecorator(AdminAkademikServiceComponent record) {
    this.record = record;
  }

  public List<AdminAkademik> saveAdminAkademik(HashMap<String, Object> body) {
    return record.saveAdminAkademik(body);
  }

  public AdminAkademik updateAdminAkademik(HashMap<String, Object> body) {
    return record.updateAdminAkademik(body);
  }

  public AdminAkademik getAdminAkademik(UUID id) {
    return record.getAdminAkademik(id);
  }

  public AdminAkademik getAdminAkademikByEmail(String email) {
    return record.getAdminAkademikByEmail(email);
  }

  public List<AdminAkademik> getAllAdminAkademik() {
    return record.getAllAdminAkademik();
  }

  public List<AdminAkademik> deleteAdminAkademik(UUID id) {
    return record.deleteAdminAkademik(id);
  }

  public List<HashMap<String, Object>> transformAdminAkademikListToHashMap(List<AdminAkademik> adminAkademikList) {
    return record.transformAdminAkademikListToHashMap(adminAkademikList);
  }
}
