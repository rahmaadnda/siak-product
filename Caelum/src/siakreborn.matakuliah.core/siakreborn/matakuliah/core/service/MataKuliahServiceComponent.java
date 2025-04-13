package siakreborn.matakuliah.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class MataKuliahServiceComponent implements MataKuliahService {
  protected RepositoryUtil<MataKuliah> mataKuliahRepository;

  public MataKuliahServiceComponent() {
    this.mataKuliahRepository = new RepositoryUtil<MataKuliah>(siakreborn.matakuliah.core.MataKuliahComponent.class);
  }

  public abstract List<MataKuliah> saveMataKuliah(HashMap<String, Object> body);

  public abstract MataKuliah updateMataKuliah(HashMap<String, Object> body);

  public abstract MataKuliah getMataKuliah(UUID id);

  public abstract List<MataKuliah> getAllMataKuliah();

  public abstract List<MataKuliah> filterMataKuliahByProgramStudi(UUID programStudiId);

  public abstract List<MataKuliah> filterMataKuliahByParentMataKuliah(UUID parentMataKuliahId);

  public abstract List<MataKuliah> filterMataKuliahByKurikulum(UUID kurikulumId);

  public abstract List<MataKuliah> deleteMataKuliah(UUID id);

  public abstract List<HashMap<String, Object>> transformMataKuliahListToHashMap(List<MataKuliah> mataKuliahList);
}
