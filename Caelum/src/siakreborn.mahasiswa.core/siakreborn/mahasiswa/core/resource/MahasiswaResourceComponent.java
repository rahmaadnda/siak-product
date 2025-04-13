package siakreborn.mahasiswa.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class MahasiswaResourceComponent implements MahasiswaResource {
  protected RepositoryUtil<Mahasiswa> mahasiswaRepository;

  public MahasiswaResourceComponent() {
    this.mahasiswaRepository = new RepositoryUtil<Mahasiswa>(siakreborn.mahasiswa.core.MahasiswaComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveMahasiswa(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateMahasiswa(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getMahasiswa(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllMahasiswa(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteMahasiswa(VMJExchange vmjExchange);
}
