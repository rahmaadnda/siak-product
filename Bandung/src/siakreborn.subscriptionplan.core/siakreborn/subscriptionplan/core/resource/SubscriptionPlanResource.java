package siakreborn.subscriptionplan.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SubscriptionPlanResource {
    List<HashMap<String,Object>> saveSubscriptionPlan(VMJExchange vmjExchange);
    HashMap<String, Object> updateSubscriptionPlan(VMJExchange vmjExchange);
    HashMap<String, Object> getSubscriptionPlan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSubscriptionPlan(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSubscriptionPlan(VMJExchange vmjExchange);
}
