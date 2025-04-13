package siakreborn.adminakademik.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AdminAkademikResourceComponent implements AdminAkademikResource {
  protected RepositoryUtil<AdminAkademik> adminAkademikRepository;

  public AdminAkademikResourceComponent() {
    this.adminAkademikRepository = new RepositoryUtil<AdminAkademik>(siakreborn.adminakademik.core.AdminAkademikComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveAdminAkademik(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateAdminAkademik(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getAdminAkademik(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllAdminAkademik(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteAdminAkademik(VMJExchange vmjExchange);

}
