package siakreborn.kelasdosen.core;

import java.util.*;

import siakreborn.dosen.core.Dosen;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class KelasDosenServiceComponent implements KelasDosenService {
  protected RepositoryUtil<KelasDosen> kelasDosenRepository;

  public KelasDosenServiceComponent() {
    this.kelasDosenRepository = new RepositoryUtil<KelasDosen>(siakreborn.kelasdosen.core.KelasDosenComponent.class);
  }

  public abstract List<KelasDosen> saveKelasDosen(HashMap<String, Object> body);

  public abstract KelasDosen updateKelasDosen(HashMap<String, Object> body);

  public abstract KelasDosen getKelasDosen(UUID id);

  public abstract List<KelasDosen> getAllKelasDosen();

  public abstract HashMap<String, Object> getKelasWithDosen(UUID kelasId);

  public abstract List<HashMap<String, Object>> getRiwayatKelasDosen(UUID mahasiswaId);

  public abstract List<Dosen> filterDosenByKelas(UUID kelasId);

  public abstract List<KelasDosen> deleteKelasDosen(UUID id);

  public abstract List<HashMap<String, Object>> transformKelasDosenListToHashMap(List<KelasDosen> kelasDosenList);

  public abstract List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList);
}
