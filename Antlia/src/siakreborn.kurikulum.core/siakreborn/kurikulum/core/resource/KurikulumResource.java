package siakreborn.kurikulum.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KurikulumResource {
    List<HashMap<String,Object>> saveKurikulum(VMJExchange vmjExchange);
    HashMap<String, Object> updateKurikulum(VMJExchange vmjExchange);
    HashMap<String, Object> getKurikulum(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKurikulum(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKurikulum(VMJExchange vmjExchange);
}
