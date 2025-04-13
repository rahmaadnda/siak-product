package siakreborn.capaian.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class CapaianServiceComponent implements CapaianService {
  protected RepositoryUtil<Capaian> capaianRepository;

  public CapaianServiceComponent() {
    this.capaianRepository = new RepositoryUtil<Capaian>(siakreborn.capaian.core.CapaianComponent.class);
  }

  public abstract List<Capaian> saveCapaian(HashMap<String, Object> body);

  public abstract Capaian updateCapaian(HashMap<String, Object> body);

  public abstract Capaian getCapaian(UUID id);

  public abstract List<Capaian> getAllCapaian();

  public abstract List<Capaian> deleteCapaian(UUID id);

  public abstract List<HashMap<String, Object>> getCapaianKelas(UUID kelasId);

  public abstract List<HashMap<String, Object>> transformCapaianListToHashMap(List<Capaian> capaianList);
}
