package siakreborn.capaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CapaianDecorator extends CapaianComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected CapaianComponent record;

  public CapaianDecorator(CapaianComponent record) {
    this.id = UUID.randomUUID();
    this.record = record;
  }

  public CapaianDecorator(UUID id, CapaianComponent record) {
    this.id = id;
    this.record = record;
  }

  public CapaianDecorator() {
    super();
    this.id = UUID.randomUUID();
    this.record = new CapaianImpl();
  }

  public CapaianComponent getRecord() {
    return this.record;
  }

  public void setRecord(CapaianComponent record) {
    this.record = record;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getKode() {
    return record.getKode();
  }

  public void setKode(String kode) {
    record.setKode(kode);
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
