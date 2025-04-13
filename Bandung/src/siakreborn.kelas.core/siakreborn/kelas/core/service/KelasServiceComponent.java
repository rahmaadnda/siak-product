package siakreborn.kelas.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class KelasServiceComponent implements KelasService {
  protected RepositoryUtil<Kelas> kelasRepository;

  public KelasServiceComponent() {
    this.kelasRepository = new RepositoryUtil<Kelas>(siakreborn.kelas.core.KelasComponent.class);
  }

  public abstract List<Kelas> saveKelas(HashMap<String, Object> body);

  public abstract Kelas updateKelas(HashMap<String, Object> body);

  public abstract Kelas getKelas(UUID id);

  public abstract List<Kelas> getAllKelas();

  public abstract List<Kelas> deleteKelas(UUID id);

  public abstract List<Kelas> filterKelasByMataKuliah(UUID mataKuliahId);

  public abstract List<Kelas> filterKelasBySemester(UUID semesterId);

  public abstract List<HashMap<String, Object>> groupKelasByMataKuliah();

  public abstract List<HashMap<String, Object>> mataKuliahGrouper(List<Kelas> kelasList);

  public abstract List<HashMap<String, Object>> transformKelasListToHashMap(List<Kelas> kelasList);
}
