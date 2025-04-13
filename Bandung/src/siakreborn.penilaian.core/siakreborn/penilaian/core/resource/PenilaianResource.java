package siakreborn.penilaian.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PenilaianResource {
    List<HashMap<String,Object>> savePenilaian(VMJExchange vmjExchange);
    HashMap<String, Object> updatePenilaian(VMJExchange vmjExchange);
    HashMap<String, Object> getPenilaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPenilaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePenilaian(VMJExchange vmjExchange);
}
