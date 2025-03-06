package siakreborn.matakuliah.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.Route;

import siakreborn.matakuliah.MataKuliahFactory;

import siakreborn.kurikulum.core.Kurikulum;

import vmj.auth.annotations.Restricted;

public abstract class MataKuliahResourceComponent implements MataKuliahResource {
  protected RepositoryUtil<MataKuliah> mataKuliahRepository;

  public MataKuliahResourceComponent() {
    this.mataKuliahRepository = new RepositoryUtil<MataKuliah>(siakreborn.matakuliah.core.MataKuliahComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveMataKuliah(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateMataKuliah(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getMataKuliah(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllMataKuliah(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteMataKuliah(VMJExchange vmjExchange);

}
