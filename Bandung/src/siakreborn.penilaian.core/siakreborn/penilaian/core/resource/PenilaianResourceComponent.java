package siakreborn.penilaian.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

import siakreborn.komponenpenilaian.core.KomponenPenilaian;

public abstract class PenilaianResourceComponent implements PenilaianResource {
  protected RepositoryUtil<Penilaian> penilaianRepository;

  public PenilaianResourceComponent() {
    this.penilaianRepository = new RepositoryUtil<Penilaian>(siakreborn.penilaian.core.PenilaianComponent.class);
  }

  public abstract List<HashMap<String, Object>> savePenilaian(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updatePenilaian(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getPenilaian(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllPenilaian(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deletePenilaian(VMJExchange vmjExchange);

}
