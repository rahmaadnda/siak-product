package siakreborn.matakuliah.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.matakuliah.MataKuliahFactory;
import vmj.auth.annotations.Restricted;
import siakreborn.kurikulum.core.Kurikulum;

public class MataKuliahResourceImpl extends MataKuliahResourceComponent {
  private MataKuliahFactory mataKuliahFactory = new MataKuliahFactory();
  private MataKuliahService mataKuliahService = new MataKuliahServiceImpl();

  @Restricted(permissionName = "CreateMataKuliah")
  @Route(url = "call/matakuliah/save")
  public List<HashMap<String, Object>> saveMataKuliah(VMJExchange vmjExchange) {
    List<MataKuliah> mataKuliahList = mataKuliahService
        .saveMataKuliah((HashMap<String, Object>) vmjExchange.getPayload());
    return mataKuliahService.transformMataKuliahListToHashMap(mataKuliahList);
  }

  @Restricted(permissionName = "UpdateMataKuliah")
  @Route(url = "call/matakuliah/update")
  public HashMap<String, Object> updateMataKuliah(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    MataKuliah mataKuliah = mataKuliahService.updateMataKuliah((HashMap<String, Object>) vmjExchange.getPayload());
    return mataKuliah.toHashMap();
  }

  @Restricted(permissionName = "ReadMataKuliah")
  @Route(url = "call/matakuliah/detail")
  public HashMap<String, Object> getMataKuliah(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    MataKuliah mataKuliah = mataKuliahService.getMataKuliah(id);
    return mataKuliah.toHashMap();
  }

  @Restricted(permissionName = "ReadMataKuliah")
  @Route(url = "call/matakuliah/list")
  public List<HashMap<String, Object>> getAllMataKuliah(VMJExchange vmjExchange) {
    List<MataKuliah> mataKuliahList = mataKuliahService.getAllMataKuliah();
    return mataKuliahService.transformMataKuliahListToHashMap(mataKuliahList);
  }

  @Restricted(permissionName = "DeleteMataKuliah")
  @Route(url = "call/matakuliah/delete")
  public List<HashMap<String, Object>> deleteMataKuliah(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<MataKuliah> mataKuliahList = mataKuliahService.deleteMataKuliah(id);
    return mataKuliahService.transformMataKuliahListToHashMap(mataKuliahList);
  }
}
