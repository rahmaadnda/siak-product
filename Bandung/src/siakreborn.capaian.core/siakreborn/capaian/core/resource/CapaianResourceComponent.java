package siakreborn.capaian.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CapaianResourceComponent implements CapaianResource {
  protected RepositoryUtil<Capaian> capaianRepository;

  public CapaianResourceComponent() {
    this.capaianRepository = new RepositoryUtil<Capaian>(siakreborn.capaian.core.CapaianComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveCapaian(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateCapaian(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getCapaian(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllCapaian(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> transformCapaianListToHashMap(List<Capaian> CapaianList);

  public abstract List<HashMap<String, Object>> deleteCapaian(VMJExchange vmjExchange);

}
