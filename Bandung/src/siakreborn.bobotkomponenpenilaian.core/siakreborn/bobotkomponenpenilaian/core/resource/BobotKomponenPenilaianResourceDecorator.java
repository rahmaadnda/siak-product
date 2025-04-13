package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class BobotKomponenPenilaianResourceDecorator extends BobotKomponenPenilaianResourceComponent {
  protected BobotKomponenPenilaianResourceComponent record;

  public BobotKomponenPenilaianResourceDecorator(BobotKomponenPenilaianResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveBobotKomponenPenilaian(VMJExchange vmjExchange) {
    return record.saveBobotKomponenPenilaian(vmjExchange);
  }

  public HashMap<String, Object> updateBobotKomponenPenilaian(VMJExchange vmjExchange) {
    return record.updateBobotKomponenPenilaian(vmjExchange);
  }

  public HashMap<String, Object> getBobotKomponenPenilaian(VMJExchange vmjExchange) {
    return record.getBobotKomponenPenilaian(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllBobotKomponenPenilaian(VMJExchange vmjExchange) {
    return record.getAllBobotKomponenPenilaian(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteBobotKomponenPenilaian(VMJExchange vmjExchange) {
    return record.deleteBobotKomponenPenilaian(vmjExchange);
  }

}
