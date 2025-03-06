package siakreborn.capaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class CapaianResourceDecorator extends CapaianResourceComponent {
  protected CapaianResourceComponent record;

  public CapaianResourceDecorator(CapaianResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveCapaian(VMJExchange vmjExchange) {
    return record.saveCapaian(vmjExchange);
  }

  public HashMap<String, Object> updateCapaian(VMJExchange vmjExchange) {
    return record.updateCapaian(vmjExchange);
  }

  public HashMap<String, Object> getCapaian(VMJExchange vmjExchange) {
    return record.getCapaian(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllCapaian(VMJExchange vmjExchange) {
    return record.getAllCapaian(vmjExchange);
  }

  public List<HashMap<String, Object>> transformCapaianListToHashMap(List<Capaian> capaianList) {
    return record.transformCapaianListToHashMap(capaianList);
  }

  public List<HashMap<String, Object>> deleteCapaian(VMJExchange vmjExchange) {
    return record.deleteCapaian(vmjExchange);
  }

}
