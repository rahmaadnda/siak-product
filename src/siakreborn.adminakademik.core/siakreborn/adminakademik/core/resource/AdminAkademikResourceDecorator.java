package siakreborn.adminakademik.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class AdminAkademikResourceDecorator extends AdminAkademikResourceComponent {
  protected AdminAkademikResourceComponent record;

  public AdminAkademikResourceDecorator(AdminAkademikResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveAdminAkademik(VMJExchange vmjExchange) {
    return record.saveAdminAkademik(vmjExchange);
  }

  public HashMap<String, Object> updateAdminAkademik(VMJExchange vmjExchange) {
    return record.updateAdminAkademik(vmjExchange);
  }

  public HashMap<String, Object> getAdminAkademik(VMJExchange vmjExchange) {
    return record.getAdminAkademik(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllAdminAkademik(VMJExchange vmjExchange) {
    return record.getAllAdminAkademik(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteAdminAkademik(VMJExchange vmjExchange) {
    return record.deleteAdminAkademik(vmjExchange);
  }

}
