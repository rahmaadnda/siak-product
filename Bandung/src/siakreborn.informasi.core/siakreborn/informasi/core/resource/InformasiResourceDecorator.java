package siakreborn.informasi.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class InformasiResourceDecorator extends InformasiResourceComponent {
  protected InformasiResourceComponent record;

  public InformasiResourceDecorator(InformasiResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveInformasi(VMJExchange vmjExchange) {
    return record.saveInformasi(vmjExchange);
  }

  public HashMap<String, Object> updateInformasi(VMJExchange vmjExchange) {
    return record.updateInformasi(vmjExchange);
  }

  public HashMap<String, Object> getInformasi(VMJExchange vmjExchange) {
    return record.getInformasi(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllInformasi(VMJExchange vmjExchange) {
    return record.getAllInformasi(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteInformasi(VMJExchange vmjExchange) {
    return record.deleteInformasi(vmjExchange);
  }

}
