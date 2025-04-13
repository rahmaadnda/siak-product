package siakreborn.observer.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ObserverResource {
    List<HashMap<String,Object>> saveObserver(VMJExchange vmjExchange);
    HashMap<String, Object> updateObserver(VMJExchange vmjExchange);
    HashMap<String, Object> getObserver(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllObserver(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteObserver(VMJExchange vmjExchange);
}
