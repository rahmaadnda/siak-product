package siakreborn.dosen.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface DosenResource {
    List<HashMap<String,Object>> saveDosen(VMJExchange vmjExchange);
    HashMap<String, Object> updateDosen(VMJExchange vmjExchange);
    HashMap<String, Object> getDosen(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllDosen(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteDosen(VMJExchange vmjExchange);
}
