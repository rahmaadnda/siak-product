package siakreborn.informasi.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class InformasiServiceComponent implements InformasiService {
  protected RepositoryUtil<Informasi> informasiRepository;

  public InformasiServiceComponent() {
    this.informasiRepository = new RepositoryUtil<Informasi>(siakreborn.informasi.core.InformasiComponent.class);
  }

  public abstract List<Informasi> saveInformasi(HashMap<String, Object> body);

  public abstract Informasi updateInformasi(HashMap<String, Object> body);

  public abstract Informasi getInformasi(UUID id);

  public abstract List<Informasi> getAllInformasi();

  public abstract List<Informasi> deleteInformasi(UUID id);

  public abstract List<HashMap<String, Object>> transformInformasiListToHashMap(List<Informasi> informasiList);
}
