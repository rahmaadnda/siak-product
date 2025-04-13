package siakreborn.subscriptionplan.core;

import java.util.*;

import siakreborn.subscriptionplan.SubscriptionPlanFactory;

import vmj.routing.route.exceptions.NotFoundException;

public class SubscriptionPlanServiceImpl extends SubscriptionPlanServiceComponent {

  public List<SubscriptionPlan> saveSubscriptionPlan(HashMap<String, Object> body) {
    String name = (String) body.get("name");
    String deskripsi = (String) body.get("deskripsi");
    int harga = Integer.parseInt((String) body.get("harga"));

    SubscriptionPlan subscriptionplan = SubscriptionPlanFactory.createSubscriptionPlan("siakreborn.subscriptionplan.core.SubscriptionPlanImpl", name, deskripsi, harga);
    subscriptionPlanRepository.saveObject(subscriptionplan);

    return getAllSubscriptionPlan();
  }

  public SubscriptionPlan updateSubscriptionPlan(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String name = (String) body.get("name");
    String deskripsi = (String) body.get("deskripsi");
    int harga = Integer.parseInt((String) body.get("harga"));

    SubscriptionPlan subscriptionplan = subscriptionPlanRepository.getObject(id);
    subscriptionplan.setName(name);
    subscriptionplan.setDeskripsi(deskripsi);
    subscriptionplan.setHarga(harga);

    subscriptionPlanRepository.updateObject(subscriptionplan);
    subscriptionplan = subscriptionPlanRepository.getObject(id);

    return subscriptionplan;
  }

  public SubscriptionPlan getSubscriptionPlan(UUID id) {
    SubscriptionPlan subscriptionplan = subscriptionPlanRepository.getObject(id);
    return subscriptionplan;
  }

  public List<SubscriptionPlan> getAllSubscriptionPlan() {
    List<SubscriptionPlan> subscriptionplanList = subscriptionPlanRepository.getAllObject("subscriptionplan_impl", SubscriptionPlanImpl.class.getName());
    return subscriptionplanList;
  }

  public List<SubscriptionPlan> deleteSubscriptionPlan(UUID id) {
    subscriptionPlanRepository.deleteObject(id);
    return getAllSubscriptionPlan();
  }

  public List<HashMap<String, Object>> transformSubscriptionPlanListToHashMap(List<SubscriptionPlan> subscriptionplanList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < subscriptionplanList.size(); i++) {
      resultList.add(subscriptionplanList.get(i).toHashMap());
    }

    return resultList;
  }
}
