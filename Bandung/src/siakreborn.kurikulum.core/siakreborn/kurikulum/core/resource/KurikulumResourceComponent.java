package siakreborn.kurikulum.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.Route;

import siakreborn.kurikulum.KurikulumFactory;

import siakreborn.programstudi.core.ProgramStudi;

import vmj.auth.annotations.Restricted;

public abstract class KurikulumResourceComponent implements KurikulumResource {
  protected RepositoryUtil<Kurikulum> kurikulumRepository;

  public KurikulumResourceComponent() {
    this.kurikulumRepository = new RepositoryUtil<Kurikulum>(siakreborn.kurikulum.core.KurikulumComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveKurikulum(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateKurikulum(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getKurikulum(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllKurikulum(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteKurikulum(VMJExchange vmjExchange);

}
