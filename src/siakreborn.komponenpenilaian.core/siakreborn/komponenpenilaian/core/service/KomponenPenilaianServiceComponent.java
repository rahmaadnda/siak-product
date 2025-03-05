package siakreborn.komponenpenilaian.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class KomponenPenilaianServiceComponent implements KomponenPenilaianService {
  protected RepositoryUtil<KomponenPenilaian> komponenPenilaianRepository;

  public KomponenPenilaianServiceComponent() {
    this.komponenPenilaianRepository = new RepositoryUtil<KomponenPenilaian>(
        siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class);
  }

  public abstract List<KomponenPenilaian> saveKomponenPenilaian(HashMap<String, Object> body);

  public abstract KomponenPenilaian updateKomponenPenilaian(HashMap<String, Object> body);

  public abstract KomponenPenilaian getKomponenPenilaian(UUID id);

  public abstract List<KomponenPenilaian> getAllKomponenPenilaian();

  public abstract List<KomponenPenilaian> filterKomponenPenilaianByKelas(UUID kelasId);

  public abstract List<KomponenPenilaian> deleteKomponenPenilaian(UUID id);

  public abstract List<HashMap<String, Object>> transformKomponenPenilaianListToHashMap(
      List<KomponenPenilaian> komponenPenilaianList);
}
