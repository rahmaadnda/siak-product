package siakreborn.semester.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

@MappedSuperclass
public abstract class SemesterDecorator extends SemesterComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected SemesterComponent record;

  public SemesterDecorator(SemesterComponent record, String objectName) {
    this.record = record;
    this.id = UUID.randomUUID();
    this.record.objectName = objectName;
  }

  public SemesterDecorator(UUID id, SemesterComponent record) {
    this.id = id;
    this.record = record;
  }

  public SemesterDecorator() {
    super();
    this.record = new SemesterImpl();
    this.id = UUID.randomUUID();
  }

  public SemesterComponent getRecord() {
    return this.record;
  }

  public void setRecord(SemesterComponent record) {
    this.record = record;
  }

  public String getKode() {
    return record.getKode();
  }

  public void setKode(String kode) {
    record.setKode(kode);
  }

  public String getStatus() {
    return record.getStatus();
  }

  public void setStatus(String status) {
    record.setStatus(status);
  }

  public String getTanggalMulai() {
    return record.getTanggalMulai();
  }

  public void setTanggalMulai(String tanggalMulai) {
    record.setTanggalMulai(tanggalMulai);
  }

  public String getTanggalSelesai() {
    return record.getTanggalSelesai();
  }

  public void setTanggalSelesai(String tanggalSelesai) {
    record.setTanggalSelesai(tanggalSelesai);
  }

  public String getDeskripsi() {
    return record.getDeskripsi();
  }

  public void setDeskripsi(String deskripsi) {
    record.setDeskripsi(deskripsi);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
