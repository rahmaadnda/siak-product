package siakreborn.kelas.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KelasResource {
    List<HashMap<String,Object>> saveKelas(VMJExchange vmjExchange);
    HashMap<String, Object> updateKelas(VMJExchange vmjExchange);
    HashMap<String, Object> getKelas(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKelas(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKelas(VMJExchange vmjExchange);
}
