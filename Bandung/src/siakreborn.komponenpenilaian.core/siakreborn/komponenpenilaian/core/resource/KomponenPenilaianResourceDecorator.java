package siakreborn.komponenpenilaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KomponenPenilaianResourceDecorator extends KomponenPenilaianResourceComponent {
  protected KomponenPenilaianResourceComponent record;

  public KomponenPenilaianResourceDecorator(KomponenPenilaianResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveKomponenPenilaian(VMJExchange vmjExchange) {
    return record.saveKomponenPenilaian(vmjExchange);
  }

  public HashMap<String, Object> updateKomponenPenilaian(VMJExchange vmjExchange) {
    return record.updateKomponenPenilaian(vmjExchange);
  }

  public HashMap<String, Object> getKomponenPenilaian(VMJExchange vmjExchange) {
    return record.getKomponenPenilaian(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllKomponenPenilaian(VMJExchange vmjExchange) {
    return record.getAllKomponenPenilaian(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteKomponenPenilaian(VMJExchange vmjExchange) {
    return record.deleteKomponenPenilaian(vmjExchange);
  }

}
