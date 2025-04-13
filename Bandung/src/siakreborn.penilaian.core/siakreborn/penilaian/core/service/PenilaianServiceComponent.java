package siakreborn.penilaian.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class PenilaianServiceComponent implements PenilaianService {
  protected RepositoryUtil<Penilaian> penilaianRepository;

  public PenilaianServiceComponent() {
    this.penilaianRepository = new RepositoryUtil<Penilaian>(siakreborn.penilaian.core.PenilaianComponent.class);
  }

  public abstract List<Penilaian> savePenilaian(HashMap<String, Object> body);

  public abstract Penilaian updatePenilaian(HashMap<String, Object> body);

  public abstract Penilaian getPenilaian(UUID id);

  public abstract List<Penilaian> getAllPenilaian();

  public abstract List<Penilaian> filterPenilaian(String columnName, UUID id);

  public abstract List<Penilaian> filterPenilaianByMahasiswaAndKelas(UUID mahasiswaId, UUID kelasId);

  public abstract HashMap<String, Object> getPenilaianAkhir(UUID mahasiswaId, UUID kelasId);

  public abstract HashMap<String, Object> getPenilaianAkhirBulk(UUID mahasiswaId, List<UUID> kelasIdList);

  public abstract List<Penilaian> deletePenilaian(UUID id);

  public abstract List<HashMap<String, Object>> transformPenilaianListToHashMap(List<Penilaian> penilaianList);
}
