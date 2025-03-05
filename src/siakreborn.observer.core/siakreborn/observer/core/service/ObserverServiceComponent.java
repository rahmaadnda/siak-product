package siakreborn.observer.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class ObserverServiceComponent implements ObserverService {
  protected RepositoryUtil<Observer> observerRepository;

  public ObserverServiceComponent() {
    this.observerRepository = new RepositoryUtil<Observer>(siakreborn.observer.core.ObserverComponent.class);
  }

  public abstract List<Observer> saveObserver(HashMap<String, Object> body);

  public abstract Observer updateObserver(HashMap<String, Object> body);

  public abstract Observer getObserver(UUID id);

  public abstract List<Observer> getAllObserver();

  public abstract List<Observer> deleteObserver(UUID id);

  public abstract List<HashMap<String, Object>> transformObserverListToHashMap(List<Observer> observerList);
}
