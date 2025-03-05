package siakreborn.kelas.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kelas.KelasFactory;
import vmj.auth.annotations.Restricted;

import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.semester.core.Semester;

public class KelasResourceImpl extends KelasResourceComponent {
  private KelasFactory kelasFactory = new KelasFactory();
  private KelasService kelasService = new KelasServiceImpl();

  @Restricted(permissionName = "CreateKelas")
  @Route(url = "call/kelas/save")
  public List<HashMap<String, Object>> saveKelas(VMJExchange vmjExchange) {
    List<Kelas> kelasList = kelasService.saveKelas((HashMap<String, Object>) vmjExchange.getPayload());
    return kelasService.transformKelasListToHashMap(kelasList);
  }

  @Restricted(permissionName = "UpdateKelas")
  @Route(url = "call/kelas/update")
  public HashMap<String, Object> updateKelas(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Kelas kelas = kelasService.updateKelas((HashMap<String, Object>) vmjExchange.getPayload());
    return kelas.toHashMap();
  }

  @Restricted(permissionName = "ReadKelas")
  @Route(url = "call/kelas/detail")
  public HashMap<String, Object> getKelas(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Kelas kelas = kelasService.getKelas(id);
    return kelas.toHashMap();
  }

  @Restricted(permissionName = "ReadKelas")
  @Route(url = "call/kelas/list")
  public List<HashMap<String, Object>> getAllKelas(VMJExchange vmjExchange) {
    List<Kelas> kelasList = kelasService.getAllKelas();
    return kelasService.transformKelasListToHashMap(kelasList);
  }

  @Restricted(permissionName = "ReadKelas")
  @Route(url = "call/kelas/filter")
  public List<HashMap<String, Object>> filterKelas(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    if (by.equals("mataKuliah")) {
      String mataKuliahIdStr = (String) vmjExchange.getGETParam("mataKuliahId");
      if(mataKuliahIdStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);

      List<Kelas> kelasList = kelasService.filterKelasByMataKuliah(mataKuliahId);
      return kelasService.transformKelasListToHashMap(kelasList);
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "ReadKelas")
  @Route(url = "call/kelas/group")
  public List<HashMap<String, Object>> groupKelas(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    if (by.equals("mataKuliah")) {
      return kelasService.groupKelasByMataKuliah();
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "DeleteKelas")
  @Route(url = "call/kelas/delete")
  public List<HashMap<String, Object>> deleteKelas(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Kelas> kelasList = kelasService.deleteKelas(id);
    return kelasService.transformKelasListToHashMap(kelasList);
  }

}
