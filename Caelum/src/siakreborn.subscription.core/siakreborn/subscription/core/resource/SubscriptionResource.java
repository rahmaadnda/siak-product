package siakreborn.subscription.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SubscriptionResource {
    List<HashMap<String,Object>> saveSubscription(VMJExchange vmjExchange);
    HashMap<String, Object> updateSubscription(VMJExchange vmjExchange);
    HashMap<String, Object> getSubscription(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSubscription(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSubscription(VMJExchange vmjExchange);
}
