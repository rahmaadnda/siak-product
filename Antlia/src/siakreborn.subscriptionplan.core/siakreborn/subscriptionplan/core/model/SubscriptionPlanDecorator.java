package siakreborn.subscriptionplan.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class SubscriptionPlanDecorator extends SubscriptionPlanComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected SubscriptionPlanComponent record;

  public SubscriptionPlanDecorator(SubscriptionPlanComponent record) {
    this.id = UUID.randomUUID();
    this.record = record;
  }

  public SubscriptionPlanDecorator(UUID id, SubscriptionPlanComponent record) {
    this.id = id;
    this.record = record;
  }

  public SubscriptionPlanDecorator() {
    super();
    this.id = UUID.randomUUID();
    this.record = new SubscriptionPlanImpl();
  }

  public SubscriptionPlanComponent getRecord() {
    return this.record;
  }

  public void setRecord(SubscriptionPlanComponent record) {
    this.record = record;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return record.getName();
  }

  public void setName(String name) {
    record.setName(name);
  }

  public String getDeskripsi() {
    return record.getDeskripsi();
  }

  public void setDeskripsi(String deskripsi) {
    record.setDeskripsi(deskripsi);
  }
  
  public int getHarga() {
    return record.getHarga();
  }

  public void setHarga(int harga) {
    record.setHarga(harga);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
