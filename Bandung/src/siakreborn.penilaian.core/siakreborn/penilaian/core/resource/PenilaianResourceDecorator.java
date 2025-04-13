package siakreborn.penilaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PenilaianResourceDecorator extends PenilaianResourceComponent {
  protected PenilaianResourceComponent record;

  public PenilaianResourceDecorator(PenilaianResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> savePenilaian(VMJExchange vmjExchange) {
    return record.savePenilaian(vmjExchange);
  }

  public HashMap<String, Object> updatePenilaian(VMJExchange vmjExchange) {
    return record.updatePenilaian(vmjExchange);
  }

  public HashMap<String, Object> getPenilaian(VMJExchange vmjExchange) {
    return record.getPenilaian(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllPenilaian(VMJExchange vmjExchange) {
    return record.getAllPenilaian(vmjExchange);
  }

  public List<HashMap<String, Object>> deletePenilaian(VMJExchange vmjExchange) {
    return record.deletePenilaian(vmjExchange);
  }

}
