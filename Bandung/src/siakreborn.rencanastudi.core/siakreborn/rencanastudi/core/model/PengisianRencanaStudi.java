package siakreborn.rencanastudi.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.semester.core.Semester;

public interface PengisianRencanaStudi {
  public UUID getId();

  public void setId(UUID id);

  public Date getMulai();

  public void setMulai(Date mulai);

  public Date getAkhir();

  public void setAkhir(Date akhir);

  public Semester getSemester();

  public void setSemester(Semester semester);

  HashMap<String, Object> toHashMap();
}
