package siakreborn.observer.industri;

import vmj.routing.route.exceptions.NotFoundException;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.Route;
import vmj.auth.annotations.Restricted;
import vmj.auth.model.core.*;
import vmj.auth.model.utils.*;

import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverResourceDecorator;
import siakreborn.observer.core.ObserverResourceComponent;
import siakreborn.observer.core.ObserverService;
import siakreborn.observer.core.ObserverServiceComponent;

import siakreborn.subscription.core.*;

import java.util.*;
import java.util.logging.Logger;

public class ObserverResourceImpl extends ObserverResourceDecorator {
  private ObserverService observerService;
  private UserResource  userResource = new UserResourceImpl();
  private RoleResource  roleResource = new RoleResourceImpl();
  private SubscriptionService subscriptionService = new SubscriptionServiceImpl();
  private static final Logger LOGGER = Logger.getLogger(ObserverResourceImpl.class.getName());

  public ObserverResourceImpl(ObserverResourceComponent recordController, ObserverServiceComponent recordService) {
    super(recordController);
    this.observerService = new ObserverServiceImpl(recordService);
  }

  @Restricted(permissionName = "SaveIndustri")
  @Route(url = "call/industri/save")
  public List<HashMap<String, Object>> saveObserver(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<Observer> observerList = observerService.saveObserver((HashMap<String, Object>) vmjExchange.getPayload());
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Restricted(permissionName = "UpdateIndustri")
  @Route(url = "call/industri/update")
  public HashMap<String, Object> updateObserver(VMJExchange vmjExchange) {
    Observer observer = observerService.updateObserver((HashMap<String, Object>) vmjExchange.getPayload());
    return observer.toHashMap();
  }

  @Restricted(permissionName = "ReadIndustri")
  @Route(url = "call/industri/detail")
  public HashMap<String, Object> getObserver(VMJExchange vmjExchange) {
    String idStr = null;
    String email = null;
    HashMap<String, Object> error = new HashMap<>();
		
		try {
			idStr = vmjExchange.getGETParam("id");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID id = UUID.fromString(idStr);
      Observer observer = observerService.getObserver(id);
      return observer.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      error.put("error", e);
		}
		
		try {
			email = vmjExchange.getAuthPayload().getEmail();
      Observer observer = ((ObserverServiceImpl) observerService).getObserverByEmail(email);
      return observer.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      error.put("error", e);
		}

    error.put("message", "Data dengan id: "+idStr+" atau token dengan email: " + email + " tidak ditemukan");
    return error;
  }

  @Restricted(permissionName = "ReadIndustri")
  @Route(url = "call/industri/list")
  public List<HashMap<String, Object>> getAllObserver(VMJExchange vmjExchange) {
    List<Observer> observerList = observerService.getAllObserver();
    return observerService.transformObserverListToHashMap(observerList);
  }
  
  @Restricted(permissionName = "ReadIndustri")
  @Route(url = "call/industri/listrequested")
  public List<HashMap<String, Object>> getAllObserverRequested(VMJExchange vmjExchange) {
    List<Observer> observerList = ((ObserverServiceImpl) observerService).getAllObserverRequested();
    return observerService.transformObserverListToHashMap(observerList);
  }
  
  @Restricted(permissionName = "ReadIndustri")
  @Route(url = "call/industri/listapproved")
  public List<HashMap<String, Object>> getAllObserverApproved(VMJExchange vmjExchange) {
    List<Observer> observerList = ((ObserverServiceImpl) observerService).getAllObserverApproved();
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Restricted(permissionName = "DeleteIndustri")
  @Route(url = "call/industri/delete")
  public List<HashMap<String, Object>> deleteObserver(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Observer> observerList = observerService.deleteObserver(id);
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Route(url = "call/industri/domain")
  public List<HashMap<String, Object>> getAllDomain(VMJExchange vmjExchange) {
    return ((ObserverServiceImpl) observerService).getAllDomain();
  }

  @Restricted(permissionName = "SubscriptionRequestIndustri")
  @Route(url = "call/industri/subscriptionrequest")
  public HashMap<String, Object> subscriptionRequest(VMJExchange vmjExchange) {
    try {
			String email = vmjExchange.getAuthPayload().getEmail();
      Observer observer = ((ObserverServiceImpl) observerService).subscriptionRequest((HashMap<String, Object>) vmjExchange.getPayload(), email);
      return observer.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      HashMap<String, Object> error = new HashMap<>();
      error.put("error", e);
      return error;
		}
  }

  @Restricted(permissionName = "SubscriptionApproveIndustri")
  @Route(url = "call/industri/subscriptionapprove")
  public HashMap<String, Object> subscriptionApprove(VMJExchange vmjExchange) {
    try {
      Observer observer = observerService.getObserver(UUID.fromString((String) vmjExchange.getRequestBodyForm("id")));
      String subscriptionType = ((ObserverImpl) observer).getSubscription().getSubscriptionPlan().getName();
      
      User updatedUser = ((ObserverServiceImpl) observerService).changeRole(observer.getEmail(), "Industri" + subscriptionType);

      LOGGER.info("User email: " + observer.getEmail());
      LOGGER.info("Role name: " + "Industri" + subscriptionType);
      LOGGER.info("Updated User: " + updatedUser.toString());

      Subscription approvedSubscription = subscriptionService.approveSubscription(((ObserverImpl) observer).getSubscription().getId());
      return approvedSubscription.toHashMap();
    } catch (Exception e) {
      LOGGER.severe("Error: " + e);
      HashMap<String, Object> error = new HashMap<>();
      error.put("error", e);
      return error;
    }
  }

  @Route(url = "call/alumni/optionpublic")
  public HashMap<String, Object> getOptionPublic(VMJExchange vmjExchange) {
    HashMap<String, Object> optionPublic = new HashMap<>();
    optionPublic.put("id", "true");
    optionPublic.put("name", "isPublic");
    return optionPublic;
  }
}
