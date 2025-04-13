package siakreborn.kelasdosen.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KelasDosenResourceComponent implements KelasDosenResource {
  protected RepositoryUtil<KelasDosen> kelasDosenRepository;

  public KelasDosenResourceComponent() {
    this.kelasDosenRepository = new RepositoryUtil<KelasDosen>(siakreborn.kelasdosen.core.KelasDosenComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveKelasDosen(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateKelasDosen(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getKelasDosen(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllKelasDosen(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteKelasDosen(VMJExchange vmjExchange);

}
