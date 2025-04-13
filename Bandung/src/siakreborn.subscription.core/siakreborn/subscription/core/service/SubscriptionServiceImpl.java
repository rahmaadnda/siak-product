package siakreborn.subscription.core;

import java.util.*;
import java.time.Instant;

import siakreborn.subscription.SubscriptionFactory;

import vmj.routing.route.exceptions.NotFoundException;

import siakreborn.subscriptionplan.core.*;

public class SubscriptionServiceImpl extends SubscriptionServiceComponent {
  private SubscriptionFactory subscriptionFactory = new SubscriptionFactory();

  public List<Subscription> saveSubscription(HashMap<String, Object> body) {
    String startDateStr = (String) body.get("startDate");
    Date startDate = Date.from(Instant.parse(startDateStr));

    String endDateStr = (String) body.get("endDate");
    Date endDate = Date.from(Instant.parse(endDateStr));

    String requestDateStr = (String) body.get("requestDate");
    Date requestDate = Date.from(Instant.parse(requestDateStr));

    String status = ((String) body.get("status")).toUpperCase();

    String subscriptionPlanIdStr = (String) body.get("subscriptionPlanId");

    SubscriptionPlan subscriptionPlan = null;
    if (subscriptionPlanIdStr != null) {
      UUID subscriptionPlanId = UUID.fromString(subscriptionPlanIdStr);
      subscriptionPlan = subscriptionRepository.getProxyObject(siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class, subscriptionPlanId);
    }

    Subscription subscription = SubscriptionFactory.createSubscription(
        "siakreborn.subscription.core.SubscriptionImpl", startDate, endDate, requestDate, status, subscriptionPlan);

    subscriptionRepository.saveObject(subscription);

    return getAllSubscription();
  } 

  public Subscription createSubscription(HashMap<String, Object> body) {
    Date startDate = (Date) body.get("startDate");
    Date endDate = (Date) body.get("endDate");
    Date requestDate = (Date) body.get("requestDate");
    String status = ((String) body.get("status")).toUpperCase();
    UUID subscriptionPlanId = (UUID) body.get("subscriptionPlanId");
    SubscriptionPlan subscriptionPlan = subscriptionRepository.getProxyObject(siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class, subscriptionPlanId);

    Subscription subscription = SubscriptionFactory.createSubscription(
        "siakreborn.subscription.core.SubscriptionImpl", startDate, endDate, requestDate, status, subscriptionPlan);

    subscriptionRepository.saveObject(subscription);

    return subscription;
  }

  public Subscription updateSubscription(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String startDateStr = (String) body.get("startDate");
    Date startDate = Date.from(Instant.parse(startDateStr));

    String endDateStr = (String) body.get("endDate");
    Date endDate = Date.from(Instant.parse(endDateStr));

    String requestDateStr = (String) body.get("requestDate");
    Date requestDate = Date.from(Instant.parse(requestDateStr));

    String status = ((String) body.get("status")).toUpperCase();

    String subscriptionPlanIdStr = (String) body.get("subscriptionPlanId");

    SubscriptionPlan subscriptionPlan = null;
    if (subscriptionPlanIdStr != null) {
      UUID subscriptionPlanId = UUID.fromString(subscriptionPlanIdStr);
      subscriptionPlan = subscriptionRepository.getProxyObject(siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class, subscriptionPlanId);
    }

    Subscription subscription = subscriptionRepository.getObject(id);
    subscription.setStartDate(startDate);
    subscription.setEndDate(endDate);
    subscription.setRequestDate(requestDate);
    subscription.setStatus(status);
    subscription.setSubscriptionPlan(subscriptionPlan);

    subscriptionRepository.updateObject(subscription);
    subscription = subscriptionRepository.getObject(id);

    return subscription;
  }

  public Subscription updateSubscription(Subscription subscription) {
    subscriptionRepository.updateObject(subscription);
    return subscription;
  }

  public Subscription getSubscription(UUID id) {
    Subscription subscription = subscriptionRepository.getObject(id);
    if (subscription == null) {
      throw new NotFoundException("Subscription not found");
    }
    return subscription;
  }

  public List<Subscription> getAllSubscription() {
    List<Subscription> subscriptionList = subscriptionRepository.getAllObject("subscription_impl", SubscriptionImpl.class.getName());
    return subscriptionList;
  }

  public List<Subscription> deleteSubscription(UUID id) {
    subscriptionRepository.deleteObject(id);
    return getAllSubscription();
  }

  public List<HashMap<String, Object>> transformSubscriptionListToHashMap(List<Subscription> subscriptionList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < subscriptionList.size(); i++) {
      resultList.add(subscriptionList.get(i).toHashMap());
    }

    return resultList;
  }

  public Subscription approveSubscription(UUID id) {
    Subscription subscription = getSubscription(id);
    subscription.setStatus("APPROVED");
    subscriptionRepository.updateObject(subscription);
    return getSubscription(id);
  }
}