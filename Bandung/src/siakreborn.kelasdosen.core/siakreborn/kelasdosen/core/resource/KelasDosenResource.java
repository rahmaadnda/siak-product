package siakreborn.kelasdosen.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KelasDosenResource {
    List<HashMap<String,Object>> saveKelasDosen(VMJExchange vmjExchange);
    HashMap<String, Object> updateKelasDosen(VMJExchange vmjExchange);
    HashMap<String, Object> getKelasDosen(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKelasDosen(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKelasDosen(VMJExchange vmjExchange);
}
