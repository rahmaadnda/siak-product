package siakreborn.observer.core;

import java.util.*;

public interface ObserverService {
  List<Observer> saveObserver(HashMap<String, Object> body);

  Observer updateObserver(HashMap<String, Object> body);

  Observer getObserver(UUID id);

  List<Observer> getAllObserver();

  List<Observer> deleteObserver(UUID id);

  List<HashMap<String, Object>> transformObserverListToHashMap(List<Observer> observerList);
}
