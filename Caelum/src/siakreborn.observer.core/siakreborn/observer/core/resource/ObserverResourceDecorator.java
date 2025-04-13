package siakreborn.observer.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ObserverResourceDecorator extends ObserverResourceComponent {
  protected ObserverResourceComponent record;

  public ObserverResourceDecorator(ObserverResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveObserver(VMJExchange vmjExchange) {
    return record.saveObserver(vmjExchange);
  }

  public HashMap<String, Object> updateObserver(VMJExchange vmjExchange) {
    return record.updateObserver(vmjExchange);
  }

  public HashMap<String, Object> getObserver(VMJExchange vmjExchange) {
    return record.getObserver(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllObserver(VMJExchange vmjExchange) {
    return record.getAllObserver(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteObserver(VMJExchange vmjExchange) {
    return record.deleteObserver(vmjExchange);
  }

}
