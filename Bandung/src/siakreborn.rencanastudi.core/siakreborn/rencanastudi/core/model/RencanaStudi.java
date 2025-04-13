package siakreborn.rencanastudi.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;

public interface RencanaStudi {
  public UUID getId();

  public void setId(UUID id);

  public Mahasiswa getMahasiswa();

  public void setMahasiswa(Mahasiswa mahasiswa);

  public Semester getSemester();

  public void setSemester(Semester semester);

  public int getTotalSKS();

  public void setTotalSKS(int totalSKS);

  public String getStatus();

  public void setStatus(String status);

  HashMap<String, Object> toHashMap();
}
