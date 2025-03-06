package siakreborn.kurikulum.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KurikulumResourceDecorator extends KurikulumResourceComponent {
  protected KurikulumResourceComponent record;

  public KurikulumResourceDecorator(KurikulumResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveKurikulum(VMJExchange vmjExchange) {
    return record.saveKurikulum(vmjExchange);
  }

  public HashMap<String, Object> updateKurikulum(VMJExchange vmjExchange) {
    return record.updateKurikulum(vmjExchange);
  }

  public HashMap<String, Object> getKurikulum(VMJExchange vmjExchange) {
    return record.getKurikulum(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllKurikulum(VMJExchange vmjExchange) {
    return record.getAllKurikulum(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteKurikulum(VMJExchange vmjExchange) {
    return record.deleteKurikulum(vmjExchange);
  }

}
