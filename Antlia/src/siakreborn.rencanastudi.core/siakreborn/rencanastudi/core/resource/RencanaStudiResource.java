package siakreborn.rencanastudi.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface RencanaStudiResource {
  HashMap<String, Object> saveRencanaStudi(VMJExchange vmjExchange);

  HashMap<String, Object> getRencanaStudi(VMJExchange vmjExchange);

  List<HashMap<String, Object>> getAllRencanaStudi(VMJExchange vmjExchange);

  List<HashMap<String, Object>> deleteRencanaStudi(VMJExchange vmjExchange);
}
