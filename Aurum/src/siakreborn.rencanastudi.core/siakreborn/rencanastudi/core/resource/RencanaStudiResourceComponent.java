package siakreborn.rencanastudi.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class RencanaStudiResourceComponent implements RencanaStudiResource {

  public RencanaStudiResourceComponent() {
  }

  public abstract HashMap<String, Object> saveRencanaStudi(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getRencanaStudi(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllRencanaStudi(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deleteRencanaStudi(VMJExchange vmjExchange);

}
