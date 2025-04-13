package siakreborn.matakuliahprasyarat.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

import siakreborn.matakuliah.core.MataKuliah;

public abstract class MataKuliahPrasyaratServiceComponent implements MataKuliahPrasyaratService {
  protected RepositoryUtil<MataKuliahPrasyarat> mataKuliahPrasyaratRepository;

  public MataKuliahPrasyaratServiceComponent() {
    this.mataKuliahPrasyaratRepository = new RepositoryUtil<MataKuliahPrasyarat>(
        siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratComponent.class);
  }

  public abstract List<MataKuliahPrasyarat> saveMataKuliahPrasyarat(HashMap<String, Object> body);

  public abstract MataKuliahPrasyarat updateMataKuliahPrasyarat(HashMap<String, Object> body);

  public abstract MataKuliahPrasyarat getMataKuliahPrasyarat(UUID id);

  public abstract List<MataKuliahPrasyarat> getAllMataKuliahPrasyarat();

  public abstract List<MataKuliahPrasyarat> getAllMataKuliahPrasyaratFromParent(UUID id);
  
  public abstract List<MataKuliahPrasyarat> deleteMataKuliahPrasyarat(UUID id);

  public abstract List<HashMap<String, Object>> transformMataKuliahPrasyaratListToHashMap(List<MataKuliahPrasyarat> mataKuliahPrasyaratList);

  public abstract List<HashMap<String, String>> listSyarat();

}
