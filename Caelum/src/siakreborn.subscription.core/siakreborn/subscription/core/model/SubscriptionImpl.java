package siakreborn.subscription.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;

import siakreborn.subscriptionplan.core.*;

@Entity(name = "subscription_impl")
@Table(name = "subscription_impl")
public class SubscriptionImpl extends SubscriptionComponent {

  public SubscriptionImpl(UUID id, Date startDate, Date endDate, Date requestDate, String status, SubscriptionPlan subscriptionPlan) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.requestDate = requestDate;
    this.status = status;
    this.subscriptionPlan = subscriptionPlan;
    this.objectName = SubscriptionImpl.class.getName();
  }

  public SubscriptionImpl(Date startDate, Date endDate, Date requestDate, String status, SubscriptionPlan subscriptionPlan) {
    this.id = UUID.randomUUID();
    this.startDate = startDate;
    this.endDate = endDate;
    this.requestDate = requestDate;
    this.status = status;
    this.subscriptionPlan = subscriptionPlan;
    this.objectName = SubscriptionImpl.class.getName();
  }

  public SubscriptionImpl() {
    this.id = UUID.randomUUID();
    this.objectName = SubscriptionImpl.class.getName();
  }

}
