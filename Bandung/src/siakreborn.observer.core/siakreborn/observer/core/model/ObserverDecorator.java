package siakreborn.observer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ObserverDecorator extends ObserverComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected ObserverComponent record;

  public ObserverDecorator(ObserverComponent record) {
    this.id = UUID.randomUUID();
    this.record = record;
  }

  public ObserverDecorator(UUID id, ObserverComponent record) {
    this.id = id;
    this.record = record;
  }

  public ObserverDecorator() {
    super();
    this.id = UUID.randomUUID();
    this.record = new ObserverImpl();
  }

  public ObserverComponent getRecord() {
    return this.record;
  }

  public void setRecord(ObserverComponent record) {
    this.record = record;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNama() {
    return record.getNama();
  }

  public void setNama(String nama) {
    record.setNama(nama);
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
