package siakreborn.dosen.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class DosenResourceDecorator extends DosenResourceComponent {
  protected DosenResourceComponent record;

  public DosenResourceDecorator(DosenResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveDosen(VMJExchange vmjExchange) {
    return record.saveDosen(vmjExchange);
  }

  public HashMap<String, Object> updateDosen(VMJExchange vmjExchange) {
    return record.updateDosen(vmjExchange);
  }

  public HashMap<String, Object> getDosen(VMJExchange vmjExchange) {
    return record.getDosen(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllDosen(VMJExchange vmjExchange) {
    return record.getAllDosen(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteDosen(VMJExchange vmjExchange) {
    return record.deleteDosen(vmjExchange);
  }

}
