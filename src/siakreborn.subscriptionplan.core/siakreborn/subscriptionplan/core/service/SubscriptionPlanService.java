package siakreborn.subscriptionplan.core;

import java.util.*;

public interface SubscriptionPlanService {
  List<SubscriptionPlan> saveSubscriptionPlan(HashMap<String, Object> body);

  SubscriptionPlan updateSubscriptionPlan(HashMap<String, Object> body);

  SubscriptionPlan getSubscriptionPlan(UUID id);

  List<SubscriptionPlan> getAllSubscriptionPlan();

  List<SubscriptionPlan> deleteSubscriptionPlan(UUID id);

  List<HashMap<String, Object>> transformSubscriptionPlanListToHashMap(List<SubscriptionPlan> subscriptionplanList);
}
