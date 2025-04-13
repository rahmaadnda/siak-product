package siakreborn.rencanastudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class RencanaStudiDecorator extends RencanaStudiComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected RencanaStudiComponent record;

  public RencanaStudiDecorator(RencanaStudiComponent record) {
    this.record = record;
    this.id = UUID.randomUUID();
  }

  public RencanaStudiDecorator(UUID id, RencanaStudiComponent record) {
    this.id = id;
    this.record = record;
  }

  public RencanaStudiDecorator() {
    super();
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return record.getId();
  }

  public void setId(UUID id) {
    record.setId(id);
  }

  public int getTotalSKS() {
    return record.getTotalSKS();
  }

  public void setTotalSKS(int totalSKS) {
    record.setTotalSKS(totalSKS);
  }

  public String getStatus() {
    return record.getStatus();
  }

  public void setStatus(String status) {
    record.setStatus(status);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
