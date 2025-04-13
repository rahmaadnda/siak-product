package siakreborn.pembayaran.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PembayaranResourceDecorator extends PembayaranResourceComponent {
  protected PembayaranResourceComponent record;

  public PembayaranResourceDecorator(PembayaranResourceComponent record) {
    this.record = record;
  }

  public HashMap<String, Object> savePembayaran(VMJExchange vmjExchange) {
    return record.savePembayaran(vmjExchange);
  }

  public HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange) {
    return record.updatePembayaran(vmjExchange);
  }

  public HashMap<String, Object> getPembayaran(VMJExchange vmjExchange) {
    return record.getPembayaran(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllPembayaran(VMJExchange vmjExchange) {
    return record.getAllPembayaran(vmjExchange);
  }

  public List<HashMap<String, Object>> deletePembayaran(VMJExchange vmjExchange) {
    return record.deletePembayaran(vmjExchange);
  }

}
