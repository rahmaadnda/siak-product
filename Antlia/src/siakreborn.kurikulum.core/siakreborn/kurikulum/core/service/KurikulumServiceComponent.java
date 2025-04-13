package siakreborn.kurikulum.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class KurikulumServiceComponent implements KurikulumService {
  protected RepositoryUtil<Kurikulum> kurikulumRepository;

  public KurikulumServiceComponent() {
    this.kurikulumRepository = new RepositoryUtil<Kurikulum>(siakreborn.kurikulum.core.KurikulumComponent.class);
  }

  public abstract List<Kurikulum> saveKurikulum(HashMap<String, Object> body);

  public abstract Kurikulum updateKurikulum(HashMap<String, Object> body);

  public abstract Kurikulum getKurikulum(UUID id);

  public abstract List<Kurikulum> getAllKurikulum();

  public abstract List<Kurikulum> filterKurikulumByProgramStudi(UUID programStudiId);

  public abstract List<Kurikulum> deleteKurikulum(UUID id);

  public abstract List<HashMap<String, Object>> transformKurikulumListToHashMap(List<Kurikulum> kurikulumList);
}
