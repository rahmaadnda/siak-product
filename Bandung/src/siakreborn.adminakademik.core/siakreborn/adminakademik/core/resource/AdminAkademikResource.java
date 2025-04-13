package siakreborn.adminakademik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AdminAkademikResource {
    List<HashMap<String,Object>> saveAdminAkademik(VMJExchange vmjExchange);
    HashMap<String, Object> updateAdminAkademik(VMJExchange vmjExchange);
    HashMap<String, Object> getAdminAkademik(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAdminAkademik(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAdminAkademik(VMJExchange vmjExchange);
}
