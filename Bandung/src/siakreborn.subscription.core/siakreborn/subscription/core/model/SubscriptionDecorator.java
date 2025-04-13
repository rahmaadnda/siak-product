package siakreborn.subscription.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.subscriptionplan.core.*;

@MappedSuperclass
public abstract class SubscriptionDecorator extends SubscriptionComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected SubscriptionComponent record;

  public SubscriptionDecorator(SubscriptionComponent record) {
    this.id = UUID.randomUUID();
    this.record = record;
  }

  public SubscriptionDecorator(UUID id, SubscriptionComponent record) {
    this.id = id;
    this.record = record;
  }

  public SubscriptionDecorator() {
    super();
    this.id = UUID.randomUUID();
    this.record = new SubscriptionImpl();
  }

  public SubscriptionComponent getRecord() {
    return this.record;
  }

  public void setRecord(SubscriptionComponent record) {
    this.record = record;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
  
  public Date getStartDate() {
    return record.getStartDate();
  }

  public void setStartDate(Date startDate) {
    record.setStartDate(startDate);
  }
  
  public Date getEndDate() {
    return record.getEndDate();
  }

  public void setEndDate(Date endDate) {
    record.setEndDate(endDate);
  }
  
  public Date getRequestDate() {
    return record.getRequestDate();
  }

  public void setRequestDate(Date requestDate) {
    record.setRequestDate(requestDate);
  }
  
  public String getStatus() {
    return record.getStatus();
  }

  public void setStatus(String status) {
    record.setStatus(status);
  }
  
  public SubscriptionPlan getSubscriptionPlan() {
    return record.getSubscriptionPlan();
  }

  public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
    record.setSubscriptionPlan(subscriptionPlan);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
