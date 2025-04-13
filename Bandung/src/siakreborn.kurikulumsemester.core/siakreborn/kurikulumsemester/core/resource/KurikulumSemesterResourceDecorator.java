package siakreborn.kurikulumsemester.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KurikulumSemesterResourceDecorator extends KurikulumSemesterResourceComponent {
  protected KurikulumSemesterResourceComponent record;

  public KurikulumSemesterResourceDecorator(KurikulumSemesterResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveKurikulumSemester(VMJExchange vmjExchange) {
    return record.saveKurikulumSemester(vmjExchange);
  }

  public List<HashMap<String, Object>> saveSemester(VMJExchange vmjExchange) {
    return record.saveSemester(vmjExchange);
  }

  public HashMap<String, Object> updateKurikulumSemester(VMJExchange vmjExchange) {
    return record.updateKurikulumSemester(vmjExchange);
  }

  public HashMap<String, Object> getKurikulumSemester(VMJExchange vmjExchange) {
    return record.getKurikulumSemester(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllKurikulumSemester(VMJExchange vmjExchange) {
    return record.getAllKurikulumSemester(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteKurikulumSemester(VMJExchange vmjExchange) {
    return record.deleteKurikulumSemester(vmjExchange);
  }

}
