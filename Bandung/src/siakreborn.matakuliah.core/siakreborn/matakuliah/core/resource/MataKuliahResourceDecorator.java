package siakreborn.matakuliah.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class MataKuliahResourceDecorator extends MataKuliahResourceComponent {
  protected MataKuliahResourceComponent record;

  public MataKuliahResourceDecorator(MataKuliahResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveMataKuliah(VMJExchange vmjExchange) {
    return record.saveMataKuliah(vmjExchange);
  }

  public HashMap<String, Object> updateMataKuliah(VMJExchange vmjExchange) {
    return record.updateMataKuliah(vmjExchange);
  }

  public HashMap<String, Object> getMataKuliah(VMJExchange vmjExchange) {
    return record.getMataKuliah(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllMataKuliah(VMJExchange vmjExchange) {
    return record.getAllMataKuliah(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteMataKuliah(VMJExchange vmjExchange) {
    return record.deleteMataKuliah(vmjExchange);
  }

}
