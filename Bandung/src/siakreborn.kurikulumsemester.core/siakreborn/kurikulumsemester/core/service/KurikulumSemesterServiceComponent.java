package siakreborn.kurikulumsemester.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

import siakreborn.semester.core.Semester;

public abstract class KurikulumSemesterServiceComponent implements KurikulumSemesterService {
  protected RepositoryUtil<KurikulumSemester> kurikulumSemesterRepository;

  public KurikulumSemesterServiceComponent() {
    this.kurikulumSemesterRepository = new RepositoryUtil<KurikulumSemester>(
        siakreborn.kurikulumsemester.core.KurikulumSemesterComponent.class);
  }

  public abstract List<KurikulumSemester> saveKurikulumSemester(HashMap<String, Object> body);

  public abstract KurikulumSemester updateKurikulumSemester(HashMap<String, Object> body);

  public abstract KurikulumSemester getKurikulumSemester(UUID id);

  public abstract List<KurikulumSemester> getAllKurikulumSemester();

  public abstract List<KurikulumSemester> deleteKurikulumSemester(UUID id);

  public abstract List<KurikulumSemester> saveSemester(HashMap<String, Object> body);

  public abstract Semester updateSemester(HashMap<String, Object> body);

  public abstract HashMap<String, Object> getSemester(UUID semesterId);

  public abstract List<HashMap<String, Object>> transformKurikulumSemesterListToHashMap(
      List<KurikulumSemester> kurikulumSemesterList);
}
