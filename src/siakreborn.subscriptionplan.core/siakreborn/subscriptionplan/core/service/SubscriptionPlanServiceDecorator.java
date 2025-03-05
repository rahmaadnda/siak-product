package siakreborn.subscriptionplan.core;

import java.util.*;

public abstract class SubscriptionPlanServiceDecorator extends SubscriptionPlanServiceComponent {
  protected SubscriptionPlanServiceComponent record;

  public SubscriptionPlanServiceDecorator(SubscriptionPlanServiceComponent record) {
    this.record = record;
  }

  public List<SubscriptionPlan> saveSubscriptionPlan(HashMap<String, Object> body) {
    return record.saveSubscriptionPlan(body);
  }

  public SubscriptionPlan updateSubscriptionPlan(HashMap<String, Object> body) {
    return record.updateSubscriptionPlan(body);
  }

  public SubscriptionPlan getSubscriptionPlan(UUID id) {
    return record.getSubscriptionPlan(id);
  }

  public List<SubscriptionPlan> getAllSubscriptionPlan() {
    return record.getAllSubscriptionPlan();
  }

  public List<SubscriptionPlan> deleteSubscriptionPlan(UUID id) {
    return record.deleteSubscriptionPlan(id);
  }

  public List<HashMap<String, Object>> transformSubscriptionPlanListToHashMap(List<SubscriptionPlan> subscriptionplanList) {
    return record.transformSubscriptionPlanListToHashMap(subscriptionplanList);
  }
}
