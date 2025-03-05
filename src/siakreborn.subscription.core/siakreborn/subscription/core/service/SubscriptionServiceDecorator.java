package siakreborn.subscription.core;

import java.util.*;

public abstract class SubscriptionServiceDecorator extends SubscriptionServiceComponent {
  protected SubscriptionServiceComponent record;

  public SubscriptionServiceDecorator(SubscriptionServiceComponent record) {
    this.record = record;
  }

  public List<Subscription> saveSubscription(HashMap<String, Object> body) {
    return record.saveSubscription(body);
  }
  
  public Subscription createSubscription(HashMap<String, Object> body) {
    return record.createSubscription(body);
  }

  public Subscription updateSubscription(HashMap<String, Object> body) {
    return record.updateSubscription(body);
  }

  public Subscription updateSubscription(Subscription subscription) {
    return record.updateSubscription(subscription);
  }

  public Subscription getSubscription(UUID id) {
    return record.getSubscription(id);
  }

  public List<Subscription> getAllSubscription() {
    return record.getAllSubscription();
  }

  public List<Subscription> deleteSubscription(UUID id) {
    return record.deleteSubscription(id);
  }

  public List<HashMap<String, Object>> transformSubscriptionListToHashMap(List<Subscription> subscriptionList) {
    return record.transformSubscriptionListToHashMap(subscriptionList);
  }

  public Subscription approveSubscription(UUID id) {
    return record.approveSubscription(id);
  }
}
