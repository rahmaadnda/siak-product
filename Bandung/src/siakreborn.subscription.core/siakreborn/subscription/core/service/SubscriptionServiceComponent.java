package siakreborn.subscription.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class SubscriptionServiceComponent implements SubscriptionService {
  protected RepositoryUtil<Subscription> subscriptionRepository;

  public SubscriptionServiceComponent() {
    this.subscriptionRepository = new RepositoryUtil<Subscription>(siakreborn.subscription.core.SubscriptionComponent.class);
  }

  public abstract List<Subscription> saveSubscription(HashMap<String, Object> body);

  public abstract Subscription createSubscription(HashMap<String, Object> body);

  public abstract Subscription updateSubscription(HashMap<String, Object> body);

  public abstract Subscription updateSubscription(Subscription subscription);

  public abstract Subscription getSubscription(UUID id);

  public abstract List<Subscription> getAllSubscription();

  public abstract List<Subscription> deleteSubscription(UUID id);

  public abstract List<HashMap<String, Object>> transformSubscriptionListToHashMap(List<Subscription> subscriptionList);

  public abstract Subscription approveSubscription(UUID id);
}
