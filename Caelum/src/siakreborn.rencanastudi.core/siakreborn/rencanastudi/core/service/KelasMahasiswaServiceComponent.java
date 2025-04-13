package siakreborn.rencanastudi.core;

import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class KelasMahasiswaServiceComponent implements KelasMahasiswaService {
  protected RepositoryUtil<KelasMahasiswa> kelasMahasiswaRepository;

  public KelasMahasiswaServiceComponent() {
    this.kelasMahasiswaRepository = new RepositoryUtil<KelasMahasiswa>(
        siakreborn.rencanastudi.core.KelasMahasiswaComponent.class);
  }

  public abstract List<KelasMahasiswa> saveKelasMahasiswa(HashMap<String, Object> body);

  public abstract KelasMahasiswa updateKelasMahasiswa(HashMap<String, Object> body);

  public abstract KelasMahasiswa getKelasMahasiswa(UUID id);

  public abstract List<KelasMahasiswa> getAllKelasMahasiswa();

  public abstract List<KelasMahasiswa> filterKelasMahasiswa(String columnName, UUID id);

  public abstract List<Mahasiswa> filterMahasiswaByKelas(UUID kelasId);

  public abstract List<HashMap<String, Object>> getRiwayatKelasMahasiswa(UUID mahasiswaId, String by);

  public abstract List<KelasMahasiswa> deleteKelasMahasiswa(UUID id);

  public abstract List<HashMap<String, Object>> transformKelasMahasiswaListToHashMap(
      List<KelasMahasiswa> kelasMahasiswaList);

  public abstract List<HashMap<String, Object>> transformMahasiswaListToHashMap(
      List<Mahasiswa> mahasiswaList);
}
