package siakreborn.kelas.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KelasResourceComponent implements KelasResource {
  protected RepositoryUtil<Kelas> kelasRepository;

  public KelasResourceComponent() {
    this.kelasRepository = new RepositoryUtil<Kelas>(siakreborn.kelas.core.KelasComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveKelas(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateKelas(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getKelas(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllKelas(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteKelas(VMJExchange vmjExchange);

}
