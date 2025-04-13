package siakreborn.observer.industri;

import java.util.*;

import siakreborn.observer.ObserverFactory;
import siakreborn.observer.core.ObserverServiceDecorator;
import siakreborn.observer.core.ObserverServiceComponent;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverComponent;
import siakreborn.observer.core.ObserverDecorator;

import siakreborn.subscription.SubscriptionFactory;
import siakreborn.subscription.core.*;
import siakreborn.subscriptionplan.core.*;

import vmj.routing.route.exceptions.NotFoundException;
import vmj.auth.model.core.*;
import vmj.auth.model.utils.*;

public class ObserverServiceImpl extends ObserverServiceDecorator {
  private ObserverFactory observerFactory = new ObserverFactory();
  private SubscriptionService subscriptionService = new SubscriptionServiceImpl();

  public ObserverServiceImpl(ObserverServiceComponent record) {
    super(record);
  }

  public List<Observer> saveObserver(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String email = (String) body.get("email");
    String websiteUrl = (String) body.get("websiteUrl");
    String domain = (String) body.get("domain");
    String alamat = (String) body.get("alamat");
    int tahunBerdiri = Integer.parseInt((String) body.get("tahunBerdiri"));
    int jumlahKaryawan = Integer.parseInt((String) body.get("jumlahKaryawan"));

    Observer observer = observerFactory.createObserver("siakreborn.observer.core.ObserverImpl", nama, email);
    Observer observerIndustri = observerFactory.createObserver("siakreborn.observer.industri.ObserverImpl", observer, null, websiteUrl, domain, alamat, tahunBerdiri, jumlahKaryawan);

    observerRepository.saveObject(observer);
    observerRepository.saveObject(observerIndustri);

    return getAllObserver();
  }

  public Observer updateObserver(HashMap<String, Object> body) {
      String idStr = (String) body.get("id");
      UUID id = UUID.fromString(idStr);

      String nama = (String) body.get("nama");
      String email = (String) body.get("email");
      String websiteUrl = (String) body.get("websiteUrl");
      String domain = (String) body.get("domain");
      String alamat = (String) body.get("alamat");
      int tahunBerdiri = Integer.parseInt((String) body.get("tahunBerdiri"));
      int jumlahKaryawan = Integer.parseInt((String) body.get("jumlahKaryawan"));

      Observer savedObserver = getObserver(id);
      UUID recordObserverId = (((ObserverDecorator) savedObserver).getRecord()).getId();

      Observer observer = observerFactory.createObserver(
          "siakreborn.observer.core.ObserverImpl", recordObserverId, nama, email);
      Observer observerIndustri = observerFactory.createObserver(
          "siakreborn.observer.industri.ObserverImpl", id, observer, ((ObserverImpl) savedObserver).getSubscription(), websiteUrl, domain, alamat, tahunBerdiri, jumlahKaryawan);

      observerRepository.updateObject(observer);
      observerRepository.updateObject(observerIndustri);

      return observerRepository.getObject(id);
  }

  public Observer getObserver(UUID id) {
    return record.getObserver(id);
  }

  public Observer getObserverByEmail(String email) {
    List<Observer> observerList = getAllObserver();
    for (Observer observer : observerList) {
      if (observer.getEmail().equals(email)) {
        return observer;
      }
    }
    throw new NotFoundException("industri tidak ditemukan");
  }

  public List<Observer> getAllObserver() {
    List<Observer> observerList = observerRepository.getAllObject("observer_industri");
    return observerList;
  }
  
  public List<Observer> getAllObserverRequested() {
    List<Observer> observerList = observerRepository.getAllObject("observer_industri");
    List<Observer> requestedSubscriptionList = new ArrayList<Observer>();

    for (int i = 0; i < observerList.size(); i++) {
      if (((ObserverImpl) observerList.get(i)).getSubscription() != null && ((Subscription) ((ObserverImpl) observerList.get(i)).getSubscription()).getStatus().equals("REQUESTED")) {
        requestedSubscriptionList.add(observerList.get(i));
      }
    }
    return requestedSubscriptionList;
  }
  
  public List<Observer> getAllObserverApproved() {
    List<Observer> observerList = observerRepository.getAllObject("observer_industri");
    List<Observer> approvedSubscriptionList = new ArrayList<Observer>();

    for (int i = 0; i < observerList.size(); i++) {
      if (((ObserverImpl) observerList.get(i)).getSubscription() != null && ((Subscription) ((ObserverImpl) observerList.get(i)).getSubscription()).getStatus().equals("APPROVED")) {
        approvedSubscriptionList.add(observerList.get(i));
      }
    }
    return approvedSubscriptionList;
  }

  public List<Observer> deleteObserver(UUID id) {
    observerRepository.deleteObject(id);
    return getAllObserver();
  }

  public List<HashMap<String, Object>> getAllDomain() {
    return transformDomainListToHashMap(ObserverImpl.domainList);
  }

  private List<HashMap<String, Object>> transformDomainListToHashMap(List<String> domainList) {
      List<HashMap<String, Object>> domainHashMapList = new ArrayList<>();
      
      for (String domain : domainList) {
          HashMap<String, Object> map = new HashMap<>();
          map.put("name", domain);
          domainHashMapList.add(map);
      }

      return domainHashMapList;
  }

  public Observer subscriptionRequest(HashMap<String, Object> body, String email) {
    UUID idSubscriptionPlan = UUID.fromString((String) body.get("idSubscriptionPlan"));

    SubscriptionPlan subscriptionPlan = observerRepository.getProxyObject(siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class, idSubscriptionPlan);
    
    Observer observer = getObserverByEmail(email);
    Subscription subscription = ((ObserverImpl) observer).getSubscription();

    if (subscription == null) {
      HashMap<String, Object> bodySubs = new HashMap<>();
      bodySubs.put("startDate", new Date());
      bodySubs.put("endDate", new Date());
      bodySubs.put("requestDate", new Date());
      bodySubs.put("status", "REQUESTED");
      bodySubs.put("subscriptionPlanId", idSubscriptionPlan);
      subscription = subscriptionService.createSubscription(bodySubs);
    } else {
      subscription.setRequestDate(new Date());
      subscription.setStatus("REQUESTED");
      subscription.setSubscriptionPlan(subscriptionPlan);
      subscription.setStartDate(new Date());
      subscription.setEndDate(new Date());
      subscriptionService.updateSubscription(subscription);
    }

    ((ObserverImpl) observer).setSubscription(subscription);
    observerRepository.updateObject(observer);
    return getObserverByEmail(email);
  }

  public User changeRole(String email, String roleName) {
    UUID roleId = getAuthRoleByName(roleName);
    UUID userId = AccountUtils.getUserByEmail(email).getId();

    observerRepository.executeQuery(session -> {
      String sql = String.format("UPDATE auth_user_role_impl SET authrole = '%s' WHERE authuser = '%s'", roleId, userId);
      session.createNativeQuery(sql).executeUpdate();
    });

    return AccountUtils.getUserById(userId);
  }
  
  private UUID getAuthRoleByName(String name) {
    final String[] idHolder = new String[1];
    observerRepository.executeQuery(session -> {
      String sql = "SELECT CAST(ari.id AS VARCHAR) FROM auth_role_impl ari WHERE ari.name = :name";
      Object result = session.createNativeQuery(sql)
                        .setParameter("name", name)
                        .getSingleResult();
      idHolder[0] = (String) result;
    });

    return UUID.fromString(idHolder[0]);
  }

}
