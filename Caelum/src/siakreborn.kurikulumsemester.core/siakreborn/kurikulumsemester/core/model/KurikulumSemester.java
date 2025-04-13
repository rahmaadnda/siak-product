package siakreborn.kurikulumsemester.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.kurikulum.core.Kurikulum;
import siakreborn.semester.core.Semester;

public interface KurikulumSemester {
  UUID getId();

  void setId(UUID id);

  Kurikulum getKurikulum();

  void setKurikulum(Kurikulum kurikulum);

  Semester getSemester();

  void setSemester(Semester semester);

  HashMap<String, Object> toHashMap();
}
