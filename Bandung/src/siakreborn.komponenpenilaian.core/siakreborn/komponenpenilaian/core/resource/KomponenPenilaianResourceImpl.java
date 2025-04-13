package siakreborn.komponenpenilaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.komponenpenilaian.KomponenPenilaianFactory;
import vmj.auth.annotations.Restricted;
//add other required packages
import siakreborn.kelas.core.Kelas;

public class KomponenPenilaianResourceImpl extends KomponenPenilaianResourceComponent {
  private KomponenPenilaianFactory komponenPenilaianFactory = new KomponenPenilaianFactory();
  private KomponenPenilaianService komponenPenilaianService = new KomponenPenilaianServiceImpl();

  @Restricted(permissionName = "CreateKomponenPenilaian")
  @Route(url = "call/komponenpenilaian/save")
  public List<HashMap<String, Object>> saveKomponenPenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<KomponenPenilaian> komponenPenilaianList = komponenPenilaianService
        .saveKomponenPenilaian((HashMap<String, Object>) vmjExchange.getPayload());
    return komponenPenilaianService.transformKomponenPenilaianListToHashMap(komponenPenilaianList);
  }

  @Restricted(permissionName = "UpdateKomponenPenilaian")
  @Route(url = "call/komponenpenilaian/update")
  public HashMap<String, Object> updateKomponenPenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    KomponenPenilaian komponenPenilaian = komponenPenilaianService
        .updateKomponenPenilaian((HashMap<String, Object>) vmjExchange.getPayload());
    return komponenPenilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadKomponenPenilaian")
  @Route(url = "call/komponenpenilaian/detail")
  public HashMap<String, Object> getKomponenPenilaian(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    KomponenPenilaian komponenPenilaian = komponenPenilaianService.getKomponenPenilaian(id);
    return komponenPenilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadKomponenPenilaian")
  @Route(url = "call/komponenpenilaian/list")
  public List<HashMap<String, Object>> getAllKomponenPenilaian(VMJExchange vmjExchange) {
    List<KomponenPenilaian> komponenPenilaianList = komponenPenilaianService.getAllKomponenPenilaian();
    return komponenPenilaianService.transformKomponenPenilaianListToHashMap(komponenPenilaianList);
  }

  @Restricted(permissionName = "ReadKomponenPenilaian")
  @Route(url = "call/komponenpenilaian/filter")
  public List<HashMap<String, Object>> filterKomponenPenilaian(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    if (by.equals("kelas")) {
      String kelasIdStr = (String) vmjExchange.getGETParam("kelasId");
      if(kelasIdStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID kelasId = UUID.fromString(kelasIdStr);

      List<KomponenPenilaian> komponenPenilaianList = komponenPenilaianService.filterKomponenPenilaianByKelas(kelasId);
      List<HashMap<String, Object>> result = komponenPenilaianService
          .transformKomponenPenilaianListToHashMap(komponenPenilaianList);
      for (HashMap<String, Object> komponen : result) {
        komponen.put("komponenPenilaianId", komponen.get("id"));
      }

      return result;
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "DeleteKomponenPenilaian")
  @Route(url = "call/komponenpenilaian/delete")
  public List<HashMap<String, Object>> deleteKomponenPenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<KomponenPenilaian> komponenPenilaianList = komponenPenilaianService.deleteKomponenPenilaian(id);
    return komponenPenilaianService.transformKomponenPenilaianListToHashMap(komponenPenilaianList);
  }

}
