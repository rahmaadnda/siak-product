package siakreborn.subscription.core;

import java.util.*;

public interface SubscriptionService {
  List<Subscription> saveSubscription(HashMap<String, Object> body);

  Subscription createSubscription(HashMap<String, Object> body);

  Subscription updateSubscription(HashMap<String, Object> body);

  Subscription updateSubscription(Subscription subscription);

  Subscription getSubscription(UUID id);

  List<Subscription> getAllSubscription();

  List<Subscription> deleteSubscription(UUID id);

  List<HashMap<String, Object>> transformSubscriptionListToHashMap(List<Subscription> subscriptionList);

  Subscription approveSubscription(UUID id); 
}
