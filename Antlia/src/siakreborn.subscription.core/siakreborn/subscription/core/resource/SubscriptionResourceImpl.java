package siakreborn.subscription.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.subscription.SubscriptionFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class SubscriptionResourceImpl extends SubscriptionResourceComponent {
  SubscriptionService subscriptionService = new SubscriptionServiceImpl();

  @Restricted(permissionName = "CreateSubscription")
  @Route(url = "call/subscription/save")
  public List<HashMap<String, Object>> saveSubscription(VMJExchange vmjExchange) {
    List<Subscription> listSubscription = subscriptionService.saveSubscription((HashMap<String, Object>) vmjExchange.getPayload());
    return subscriptionService.transformSubscriptionListToHashMap(listSubscription);
  }

  @Restricted(permissionName = "UpdateSubscription")
  @Route(url = "call/subscription/update")
  public HashMap<String, Object> updateSubscription(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Subscription subscription = subscriptionService.updateSubscription((HashMap<String, Object>) vmjExchange.getPayload());
    return subscription.toHashMap();
  }

  @Restricted(permissionName = "ReadSubscription")
  @Route(url = "call/subscription/detail")
  public HashMap<String, Object> getSubscription(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("subscriptionId");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Subscription subscription = subscriptionService.getSubscription(id);
    return subscription.toHashMap();
  }

  @Restricted(permissionName = "ReadSubscription")
  @Route(url = "call/subscription/list")
  public List<HashMap<String, Object>> getAllSubscription(VMJExchange vmjExchange) {
    List<Subscription> subscriptionList = subscriptionService.getAllSubscription();
    return subscriptionService.transformSubscriptionListToHashMap(subscriptionList);
  }

  @Restricted(permissionName = "DeleteSubscription")
  @Route(url = "call/subscription/delete")
  public List<HashMap<String, Object>> deleteSubscription(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Subscription> subscriptionList = subscriptionService.deleteSubscription(id);
    return subscriptionService.transformSubscriptionListToHashMap(subscriptionList);
  }

}
