package siakreborn.kurikulum.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kurikulum.KurikulumFactory;
import vmj.auth.annotations.Restricted;
import siakreborn.programstudi.core.ProgramStudi;

public class KurikulumResourceImpl extends KurikulumResourceComponent {
  private KurikulumFactory kurikulumFactory = new KurikulumFactory();
  private KurikulumService kurikulumService = new KurikulumServiceImpl();

  @Restricted(permissionName = "CreateKurikulum")
  @Route(url = "call/kurikulum/save")
  public List<HashMap<String, Object>> saveKurikulum(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<Kurikulum> kurikulumList = kurikulumService.saveKurikulum((HashMap<String, Object>) vmjExchange.getPayload());
    return kurikulumService.transformKurikulumListToHashMap(kurikulumList);
  }

  @Restricted(permissionName = "UpdateKurikulum")
  @Route(url = "call/kurikulum/update")
  public HashMap<String, Object> updateKurikulum(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Kurikulum kurikulum = kurikulumService.updateKurikulum((HashMap<String, Object>) vmjExchange.getPayload());
    return kurikulum.toHashMap();
  }

  @Restricted(permissionName = "ReadKurikulum")
  @Route(url = "call/kurikulum/detail")
  public HashMap<String, Object> getKurikulum(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Kurikulum kurikulum = kurikulumService.getKurikulum(id);
    return kurikulum.toHashMap();
  }

  @Restricted(permissionName = "ReadKurikulum")
  @Route(url = "call/kurikulum/list")
  public List<HashMap<String, Object>> getAllKurikulum(VMJExchange vmjExchange) {
    List<Kurikulum> kurikulumList = kurikulumService.getAllKurikulum();
    return kurikulumService.transformKurikulumListToHashMap(kurikulumList);
  }

  @Restricted(permissionName = "ReadKurikulum")
  @Route(url = "call/kurikulum/filter")
  public List<HashMap<String, Object>> filterKurikulum(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    if (by.equals("programStudi")) {
      String programStudiIdStr = (String) vmjExchange.getGETParam("programStudiId");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }

      UUID programStudiId = UUID.fromString(programStudiIdStr);

      List<Kurikulum> kurikulumList = kurikulumService.filterKurikulumByProgramStudi(programStudiId);
      return kurikulumService.transformKurikulumListToHashMap(kurikulumList);
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "DeleteKurikulum")
  @Route(url = "call/kurikulum/delete")
  public List<HashMap<String, Object>> deleteKurikulum(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Kurikulum> kurikulumList = kurikulumService.deleteKurikulum(id);
    return kurikulumService.transformKurikulumListToHashMap(kurikulumList);
  }

}
