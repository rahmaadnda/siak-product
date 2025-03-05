package siakreborn.mahasiswa.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class MahasiswaServiceComponent implements MahasiswaService {
  protected RepositoryUtil<Mahasiswa> mahasiswaRepository;

  public MahasiswaServiceComponent() {
    this.mahasiswaRepository = new RepositoryUtil<Mahasiswa>(siakreborn.mahasiswa.core.MahasiswaComponent.class);
  }

  public abstract List<Mahasiswa> saveMahasiswa(HashMap<String, Object> body);

  public abstract Mahasiswa updateMahasiswa(HashMap<String, Object> body);

  public abstract Mahasiswa getMahasiswa(UUID id);

  public abstract Mahasiswa getMahasiswaByEmail(String email);

  public abstract List<Mahasiswa> getAllMahasiswa();

  public abstract List<Mahasiswa> getNotGraduated();

  public abstract List<Mahasiswa> getAllMahasiswaPublic();

  public abstract List<Mahasiswa> deleteMahasiswa(UUID id);

  public abstract List<HashMap<String, Object>> transformMahasiswaListToHashMap(List<Mahasiswa> mahasiswaList);

  public abstract Mahasiswa verify(HashMap<String, Object> body);

  public abstract Mahasiswa graduate(UUID id);

  public abstract List<HashMap<String, Object>> getAllAngkatan();
}
