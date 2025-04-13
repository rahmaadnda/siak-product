package siakreborn.capaian.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CapaianResource {
    List<HashMap<String,Object>> saveCapaian(VMJExchange vmjExchange);
    HashMap<String, Object> updateCapaian(VMJExchange vmjExchange);
    HashMap<String, Object> getCapaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCapaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCapaian(VMJExchange vmjExchange);
}
