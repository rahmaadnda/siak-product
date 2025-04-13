package siakreborn.observer.core;

import java.util.*;

import siakreborn.observer.ObserverFactory;

import vmj.routing.route.exceptions.NotFoundException;

public class ObserverServiceImpl extends ObserverServiceComponent {
  private ObserverFactory observerFactory = new ObserverFactory();

  public List<Observer> saveObserver(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String email = (String) body.get("email");

    Observer observer = ObserverFactory.createObserver("siakreborn.observer.core.ObserverImpl", nama, email);

    return getAllObserver();
  }

  public Observer updateObserver(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nama = (String) body.get("nama");
    String email = (String) body.get("email");

    Observer observer = observerRepository.getObject(id);
    observer.setNama(nama);
    observer.setEmail(email);

    observerRepository.updateObject(observer);
    observer = observerRepository.getObject(id);

    return observer;
  }

  public Observer getObserver(UUID id) {
    Observer observer = observerRepository.getObject(id);
    return observer;
  }

  public Observer getObserverByEmail(String email) {
    try {
      Observer observer = observerRepository.getListObject("observer_comp", "email", email).get(0);
      return observer;
    } catch (Exception e) {
      throw new NotFoundException("observer tidak ditemukan");
    }
  }

  public List<Observer> getAllObserver() {
    List<Observer> observerList = observerRepository.getAllObject("observer_impl", ObserverImpl.class.getName());
    return observerList;
  }

  public List<Observer> deleteObserver(UUID id) {
    observerRepository.deleteObject(id);
    return getAllObserver();
  }

  public List<HashMap<String, Object>> transformObserverListToHashMap(List<Observer> observerList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < observerList.size(); i++) {
      resultList.add(observerList.get(i).toHashMap());
    }

    return resultList;
  }
}
