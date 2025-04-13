package siakreborn.adminakademik.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class AdminAkademikServiceComponent implements AdminAkademikService {
  protected RepositoryUtil<AdminAkademik> adminAkademikRepository;

  public AdminAkademikServiceComponent() {
    this.adminAkademikRepository = new RepositoryUtil<AdminAkademik>(siakreborn.adminakademik.core.AdminAkademikComponent.class);
  }

  public abstract List<AdminAkademik> saveAdminAkademik(HashMap<String, Object> body);

  public abstract AdminAkademik updateAdminAkademik(HashMap<String, Object> body);

  public abstract AdminAkademik getAdminAkademik(UUID id);

  public abstract AdminAkademik getAdminAkademikByEmail(String email);

  public abstract List<AdminAkademik> getAllAdminAkademik();

  public abstract List<AdminAkademik> deleteAdminAkademik(UUID id);

  public abstract List<HashMap<String, Object>> transformAdminAkademikListToHashMap(List<AdminAkademik> adminAkademikList);
}
