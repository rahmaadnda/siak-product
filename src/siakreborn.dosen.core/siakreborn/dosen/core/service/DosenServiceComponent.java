package siakreborn.dosen.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class DosenServiceComponent implements DosenService {
  protected RepositoryUtil<Dosen> dosenRepository;

  public DosenServiceComponent() {
    this.dosenRepository = new RepositoryUtil<Dosen>(siakreborn.dosen.core.DosenComponent.class);
  }

  public abstract List<Dosen> saveDosen(HashMap<String, Object> body);

  public abstract Dosen updateDosen(HashMap<String, Object> body);

  public abstract Dosen getDosen(UUID id);

  public abstract Dosen getDosenByEmail(String email);

  public abstract List<Dosen> getAllDosen();

  public abstract List<Dosen> deleteDosen(UUID id);

  public abstract List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList);
}
