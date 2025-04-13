package siakreborn.subscriptionplan.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.subscriptionplan.SubscriptionPlanFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class SubscriptionPlanResourceImpl extends SubscriptionPlanResourceComponent {
  SubscriptionPlanService subscriptionPlanService = new SubscriptionPlanServiceImpl();

  @Restricted(permissionName = "CreateSubscriptionPlan")
  @Route(url = "call/subscriptionplan/save")
  public List<HashMap<String, Object>> saveSubscriptionPlan(VMJExchange vmjExchange) {
    List<SubscriptionPlan> listSubscriptionPlan = subscriptionPlanService.saveSubscriptionPlan((HashMap<String, Object>) vmjExchange.getPayload());
    return subscriptionPlanService.transformSubscriptionPlanListToHashMap(listSubscriptionPlan);
  }

  @Restricted(permissionName = "UpdateSubscriptionPlan")
  @Route(url = "call/subscriptionplan/update")
  public HashMap<String, Object> updateSubscriptionPlan(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    SubscriptionPlan subscriptionplan = subscriptionPlanService.updateSubscriptionPlan((HashMap<String, Object>) vmjExchange.getPayload());
    return subscriptionplan.toHashMap();
  }

  @Restricted(permissionName = "ReadSubscriptionPlan")
  @Route(url = "call/subscriptionplan/detail")
  public HashMap<String, Object> getSubscriptionPlan(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    SubscriptionPlan subscriptionplan = subscriptionPlanService.getSubscriptionPlan(id);
    return subscriptionplan.toHashMap();
  }

  @Restricted(permissionName = "ReadSubscriptionPlan")
  @Route(url = "call/subscriptionplan/list")
  public List<HashMap<String, Object>> getAllSubscriptionPlan(VMJExchange vmjExchange) {
    List<SubscriptionPlan> subscriptionplanList = subscriptionPlanService.getAllSubscriptionPlan();
    return subscriptionPlanService.transformSubscriptionPlanListToHashMap(subscriptionplanList);
  }

  @Restricted(permissionName = "DeleteSubscriptionPlan")
  @Route(url = "call/subscriptionplan/delete")
  public List<HashMap<String, Object>> deleteSubscriptionPlan(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<SubscriptionPlan> subscriptionplanList = subscriptionPlanService.deleteSubscriptionPlan(id);
    return subscriptionPlanService.transformSubscriptionPlanListToHashMap(subscriptionplanList);
  }

}
