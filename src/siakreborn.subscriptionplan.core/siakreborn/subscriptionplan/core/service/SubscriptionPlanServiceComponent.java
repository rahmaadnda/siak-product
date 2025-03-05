package siakreborn.subscriptionplan.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class SubscriptionPlanServiceComponent implements SubscriptionPlanService {
  protected RepositoryUtil<SubscriptionPlan> subscriptionPlanRepository;

  public SubscriptionPlanServiceComponent() {
    this.subscriptionPlanRepository = new RepositoryUtil<SubscriptionPlan>(siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class);
  }

  public abstract List<SubscriptionPlan> saveSubscriptionPlan(HashMap<String, Object> body);

  public abstract SubscriptionPlan updateSubscriptionPlan(HashMap<String, Object> body);

  public abstract SubscriptionPlan getSubscriptionPlan(UUID id);

  public abstract List<SubscriptionPlan> getAllSubscriptionPlan();

  public abstract List<SubscriptionPlan> deleteSubscriptionPlan(UUID id);

  public abstract List<HashMap<String, Object>> transformSubscriptionPlanListToHashMap(List<SubscriptionPlan> subscriptionplanList);
}
