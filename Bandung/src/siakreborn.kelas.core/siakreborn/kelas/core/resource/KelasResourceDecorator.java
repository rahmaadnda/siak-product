package siakreborn.kelas.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KelasResourceDecorator extends KelasResourceComponent {
  protected KelasResourceComponent record;

  public KelasResourceDecorator(KelasResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveKelas(VMJExchange vmjExchange) {
    return record.saveKelas(vmjExchange);
  }

  public HashMap<String, Object> updateKelas(VMJExchange vmjExchange) {
    return record.updateKelas(vmjExchange);
  }

  public HashMap<String, Object> getKelas(VMJExchange vmjExchange) {
    return record.getKelas(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllKelas(VMJExchange vmjExchange) {
    return record.getAllKelas(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteKelas(VMJExchange vmjExchange) {
    return record.deleteKelas(vmjExchange);
  }

}
