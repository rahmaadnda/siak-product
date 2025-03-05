package siakreborn.observer.alumni;

import vmj.routing.route.VMJExchange;
import vmj.routing.route.Route;
import vmj.auth.annotations.Restricted;

import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverResourceDecorator;
import siakreborn.observer.core.ObserverResourceComponent;
import siakreborn.observer.core.ObserverService;
import siakreborn.observer.core.ObserverServiceComponent;

import java.util.*;
import java.util.logging.Logger;

public class ObserverResourceImpl extends ObserverResourceDecorator {
  private ObserverService observerService;
  private static final Logger LOGGER = Logger.getLogger(ObserverResourceImpl.class.getName());

  public ObserverResourceImpl(ObserverResourceComponent recordController, ObserverServiceComponent recordService) {
    super(recordController);
    this.observerService = new ObserverServiceImpl(recordService);
  }

  @Restricted(permissionName = "SaveAlumni")
  @Route(url = "call/alumni/save")
  public List<HashMap<String, Object>> saveObserver(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<Observer> observerList = observerService.saveObserver((HashMap<String, Object>) vmjExchange.getPayload());
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Restricted(permissionName = "UpdateAlumni")
  @Route(url = "call/alumni/update")
  public HashMap<String, Object> updateObserver(VMJExchange vmjExchange) {
    Observer observer = observerService.updateObserver((HashMap<String, Object>) vmjExchange.getPayload());
    return observer.toHashMap();
  }

  @Restricted(permissionName = "ReadDetailAlumni")
  @Route(url = "call/alumni/detail")
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

  @Restricted(permissionName = "ReadAlumni")
  @Route(url = "call/alumni/list")
  public List<HashMap<String, Object>> getAllObserver(VMJExchange vmjExchange) {
    List<Observer> observerList = observerService.getAllObserver();
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Restricted(permissionName = "DeleteAlumni")
  @Route(url = "call/alumni/delete")
  public List<HashMap<String, Object>> deleteObserver(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Observer> observerList = observerService.deleteObserver(id);
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Restricted(permissionName = "VerifyAlumni")
  @Route(url = "call/alumni/verify")
	public HashMap<String, Object> verify(VMJExchange vmjExchange) {
		Observer verified = ((ObserverServiceImpl) observerService).verify((HashMap<String, Object>) vmjExchange.getPayload());

		if (verified != null) {
			return verified.toHashMap();
		} else {
			HashMap<String, Object> notFoundMap = new HashMap<>();
			notFoundMap.put("message", "Data tidak ditemukan");
			return notFoundMap;
		}
	}

	@Route(url = "call/alumni/tahunlulus")
  public List<HashMap<String, Object>> getAllTahunLulus(VMJExchange vmjExchange) {
      return ((ObserverServiceImpl) observerService).getAllTahunLulus();
  }

  @Restricted(permissionName = "ReadAlumniPublic")
  @Route(url = "call/alumni/listpublic")
  public List<HashMap<String, Object>> getAllObserverPublic(VMJExchange vmjExchange) {
    List<Observer> observerList = ((ObserverServiceImpl) observerService).getAllObserverPublic();
    return observerService.transformObserverListToHashMap(observerList);
  }

  @Restricted(permissionName = "CreateAkunAlumni")
  @Route(url = "call/alumni/akun")
  public HashMap<String, Object> createAkunAlumni(VMJExchange vmjExchange) {
    HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
    String emailMahasiswa = vmjExchange.getAuthPayload().getEmail();
    String emailAlumni = (String) body.get("email");
    return ((ObserverServiceImpl) observerService).createAkunAlumni(emailAlumni, emailMahasiswa);
  }

  @Restricted(permissionName = "CreateAkunAlumni")
  @Route(url = "call/alumni/akuncreated")
  public HashMap<String, Object> getAkunAlumniCreated(VMJExchange vmjExchange) {
    String email = vmjExchange.getGETParam("email"); 
    return ((ObserverServiceImpl) observerService).getAkunAlumniCreated(email);
  }

}
