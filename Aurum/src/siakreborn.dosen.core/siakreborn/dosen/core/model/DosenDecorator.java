package siakreborn.dosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class DosenDecorator extends DosenComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected DosenComponent record;

  public DosenDecorator(DosenComponent record, String objectName) {
    this.record = record;
    this.id = UUID.randomUUID();
    this.record.objectName = objectName;
  }

  public DosenDecorator(UUID id, DosenComponent record) {
    this.id = id;
    this.record = record;
  }

  public DosenDecorator() {
    super();
    this.record = new DosenImpl();
    this.id = UUID.randomUUID();
  }

  public DosenComponent getRecord() {
    return this.record;
  }

  public void setRecord(DosenComponent record) {
    this.record = record;
  }

  public String getNama() {
    return record.getNama();
  }

  public void setNama(String nama) {
    record.setNama(nama);
  }

  public String getNip() {
    return record.getNip();
  }

  public void setNip(String nip) {
    record.setNip(nip);
  }

  public String getEmail() {
    return record.getEmail();
  }

  public void setEmail(String email) {
    record.setEmail(email);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
