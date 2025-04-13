package siakreborn.observer.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.observer.ObserverFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class ObserverResourceImpl extends ObserverResourceComponent {
  ObserverService observerService = new ObserverServiceImpl();

  @Restricted(permissionName = "CreateObserver")
  @Route(url = "call/observer/save")
  public List<HashMap<String, Object>> saveObserver(VMJExchange vmjExchange) {
    List<Observer> listObserver = observerService.saveObserver((HashMap<String, Object>) vmjExchange.getPayload());
    return observerService.transformObserverListToHashMap(listObserver);
  }

  @Restricted(permissionName = "UpdateObserver")
  @Route(url = "call/observer/update")
  public HashMap<String, Object> updateObserver(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Observer observer = observerService.updateObserver((HashMap<String, Object>) vmjExchange.getPayload());
    return observer.toHashMap();
  }

  @Restricted(permissionName = "ReadObserver")
  @Route(url = "call/observer/detail")
  public HashMap<String, Object> getObserver(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Observer observer = observerService.getObserver(id);
    return observer.toHashMap();
  }

  @Restricted(permissionName = "ReadObserver")
  @Route(url = "call/observer/list")
  public List<HashMap<String, Object>> getAllObserver(VMJExchange vmjExchange) {
    List<Observer> observerList = observerService.getAllObserver();
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Restricted(permissionName = "DeleteObserver")
  @Route(url = "call/observer/delete")
  public List<HashMap<String, Object>> deleteObserver(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Observer> observerList = observerService.deleteObserver(id);
    return observerService.transformObserverListToHashMap(observerList);
  }

}
