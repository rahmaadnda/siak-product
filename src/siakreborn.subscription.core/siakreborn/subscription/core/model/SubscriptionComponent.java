package siakreborn.subscription.core;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.subscription.core.*;
import siakreborn.util.core.*;

import siakreborn.subscriptionplan.core.*;
import siakreborn.util.core.*;

@Entity(name = "subscription_comp")
@Table(name = "subscription_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SubscriptionComponent implements Subscription {
  @Id
  protected UUID id;
  protected Date startDate;
  protected Date endDate;
  protected Date requestDate;
  protected String status;

  @ManyToOne(targetEntity = siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class)
  public SubscriptionPlan subscriptionPlan;

  protected String objectName = SubscriptionComponent.class.getName();

  public SubscriptionComponent() {
  }

  @Override
  public UUID getId() {
    return this.id;
  }

  @Override
  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public Date getStartDate() {
    return this.startDate;
  }

  @Override
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  @Override
  public Date getEndDate() {
    return this.endDate;
  }

  @Override
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public Date getRequestDate() {
    return this.requestDate;
  }

  @Override
  public void setRequestDate(Date requestDate) {
    this.requestDate = requestDate;
  }

  @Override
  public String getStatus() {
    return this.status;
  }

  @Override
  public void setStatus(String status) {
    this.status = status;
  }
  
  @Override
  public SubscriptionPlan getSubscriptionPlan() {
    return this.subscriptionPlan;
  }

  @Override
  public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
    this.subscriptionPlan = subscriptionPlan;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", startDate='" + getStartDate() + "'" +
        ", endDate='" + getEndDate() + "'" +
        ", requestDate='" + getRequestDate() + "'" +
        ", status='" + getStatus() + "'" +
        ", subsriptionPlan='" + getSubscriptionPlan() + "'" +
        "}";
  }

  @Override
  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> subscriptionMap = new HashMap<>();
    subscriptionMap.put("id", getId());
    subscriptionMap.put("startDate", getStartDate());
    subscriptionMap.put("endDate", getEndDate());
    subscriptionMap.put("requestDate", getRequestDate());
    subscriptionMap.put("status", getStatus());
    if (getSubscriptionPlan() != null)
      subscriptionMap = Util.combine(subscriptionMap, ((SubscriptionPlanComponent) this.getSubscriptionPlan()).toHashMap(), "subscriptionplan");

    return subscriptionMap;
  }

}
