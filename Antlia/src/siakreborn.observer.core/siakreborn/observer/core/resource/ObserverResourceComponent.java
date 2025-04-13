package siakreborn.observer.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ObserverResourceComponent implements ObserverResource {
  protected RepositoryUtil<Observer> observerRepository;

  public ObserverResourceComponent() {
    this.observerRepository = new RepositoryUtil<Observer>(siakreborn.observer.core.ObserverComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveObserver(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updateObserver(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getObserver(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllObserver(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteObserver(VMJExchange vmjExchange);

}
