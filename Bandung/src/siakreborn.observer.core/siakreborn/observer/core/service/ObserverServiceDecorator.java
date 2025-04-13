package siakreborn.observer.core;

import java.util.*;

public abstract class ObserverServiceDecorator extends ObserverServiceComponent {
  protected ObserverServiceComponent record;

  public ObserverServiceDecorator(ObserverServiceComponent record) {
    this.record = record;
  }

  public List<Observer> saveObserver(HashMap<String, Object> body) {
    return record.saveObserver(body);
  }

  public Observer updateObserver(HashMap<String, Object> body) {
    return record.updateObserver(body);
  }

  public Observer getObserver(UUID id) {
    return record.getObserver(id);
  }

  public List<Observer> getAllObserver() {
    return record.getAllObserver();
  }

  public List<Observer> deleteObserver(UUID id) {
    return record.deleteObserver(id);
  }

  public List<HashMap<String, Object>> transformObserverListToHashMap(List<Observer> observerList) {
    return record.transformObserverListToHashMap(observerList);
  }
}
