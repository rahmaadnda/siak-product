package siakreborn.subscriptionplan.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SubscriptionPlanResourceComponent implements SubscriptionPlanResource {
  protected RepositoryUtil<SubscriptionPlan> subscriptionPlanRepository;

  public SubscriptionPlanResourceComponent() {
    this.subscriptionPlanRepository = new RepositoryUtil<SubscriptionPlan>(siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveSubscriptionPlan(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateSubscriptionPlan(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getSubscriptionPlan(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllSubscriptionPlan(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteSubscriptionPlan(VMJExchange vmjExchange);

}
