package siakreborn.mahasiswa.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class MahasiswaResourceDecorator extends MahasiswaResourceComponent {
  protected MahasiswaResourceComponent record;

  public MahasiswaResourceDecorator(MahasiswaResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveMahasiswa(VMJExchange vmjExchange) {
    return record.saveMahasiswa(vmjExchange);
  }

  public HashMap<String, Object> updateMahasiswa(VMJExchange vmjExchange) {
    return record.updateMahasiswa(vmjExchange);
  }

  public HashMap<String, Object> getMahasiswa(VMJExchange vmjExchange) {
    return record.getMahasiswa(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllMahasiswa(VMJExchange vmjExchange) {
    return record.getAllMahasiswa(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteMahasiswa(VMJExchange vmjExchange) {
    return record.deleteMahasiswa(vmjExchange);
  }
}
