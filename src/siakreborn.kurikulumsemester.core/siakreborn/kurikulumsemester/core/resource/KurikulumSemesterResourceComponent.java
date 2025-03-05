package siakreborn.kurikulumsemester.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KurikulumSemesterResourceComponent implements KurikulumSemesterResource {
  protected RepositoryUtil<KurikulumSemester> kurikulumSemesterRepository;

  public KurikulumSemesterResourceComponent() {
    this.kurikulumSemesterRepository = new RepositoryUtil<KurikulumSemester>(
        siakreborn.kurikulumsemester.core.KurikulumSemesterComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveKurikulumSemester(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> saveSemester(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateKurikulumSemester(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getKurikulumSemester(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllKurikulumSemester(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteKurikulumSemester(VMJExchange vmjExchange);

}
