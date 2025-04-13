package siakreborn.dosen.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class DosenResourceComponent implements DosenResource {
  protected RepositoryUtil<Dosen> dosenRepository;

  public DosenResourceComponent() {
    this.dosenRepository = new RepositoryUtil<Dosen>(siakreborn.dosen.core.DosenComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveDosen(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateDosen(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getDosen(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllDosen(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteDosen(VMJExchange vmjExchange);

}
