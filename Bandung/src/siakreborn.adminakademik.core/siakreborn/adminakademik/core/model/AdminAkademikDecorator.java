package siakreborn.adminakademik.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AdminAkademikDecorator extends AdminAkademikComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected AdminAkademikComponent record;

  public AdminAkademikDecorator(AdminAkademikComponent record) {
    this.id = UUID.randomUUID();
    this.record = record;
  }

  public AdminAkademikDecorator(UUID id, AdminAkademikComponent record) {
    this.id = id;
    this.record = record;
  }

  public AdminAkademikDecorator() {
    super();
    this.id = UUID.randomUUID();
    this.record = new AdminAkademikImpl();
  }

  public AdminAkademikComponent getRecord() {
    return this.record;
  }

  public void setRecord(AdminAkademikComponent record) {
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
