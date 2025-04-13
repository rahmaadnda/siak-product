package siakreborn.subscription.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SubscriptionResourceComponent implements SubscriptionResource {
  protected RepositoryUtil<Subscription> subscriptionRepository;

  public SubscriptionResourceComponent() {
    this.subscriptionRepository = new RepositoryUtil<Subscription>(siakreborn.subscription.core.SubscriptionComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveSubscription(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateSubscription(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getSubscription(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllSubscription(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteSubscription(VMJExchange vmjExchange);

}
