package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class BobotKomponenPenilaianServiceComponent implements BobotKomponenPenilaianService {
  protected RepositoryUtil<BobotKomponenPenilaian> bobotKomponenPenilaianRepository;

  public BobotKomponenPenilaianServiceComponent() {
    this.bobotKomponenPenilaianRepository = new RepositoryUtil<BobotKomponenPenilaian>(
        siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianComponent.class);
  }

  public abstract List<BobotKomponenPenilaian> saveBobotKomponenPenilaian(HashMap<String, Object> body);

  public abstract BobotKomponenPenilaian updateBobotKomponenPenilaian(HashMap<String, Object> body);

  public abstract BobotKomponenPenilaian getBobotKomponenPenilaian(UUID id);

  public abstract List<BobotKomponenPenilaian> getAllBobotKomponenPenilaian();

  public abstract List<BobotKomponenPenilaian> deleteBobotKomponenPenilaian(UUID id);

  public abstract HashMap<String, Object> getKomponenPenilaianKelasMapping(UUID kelasId);

  public abstract List<HashMap<String, Object>> transformBobotKomponenPenilaianListToHashMap(
      List<BobotKomponenPenilaian> bobotKomponenPenilaianList);
}
