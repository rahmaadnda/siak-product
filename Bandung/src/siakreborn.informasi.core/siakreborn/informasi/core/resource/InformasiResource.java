package siakreborn.informasi.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InformasiResource {
    List<HashMap<String,Object>> saveInformasi(VMJExchange vmjExchange);
    HashMap<String, Object> updateInformasi(VMJExchange vmjExchange);
    HashMap<String, Object> getInformasi(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllInformasi(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteInformasi(VMJExchange vmjExchange);
}
