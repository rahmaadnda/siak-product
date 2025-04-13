package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;
//add other required packages
import siakreborn.komponenpenilaian.core.KomponenPenilaian;

public class BobotKomponenPenilaianResourceImpl extends BobotKomponenPenilaianResourceComponent {
  private BobotKomponenPenilaianService bobotKomponenPenilaianService = new BobotKomponenPenilaianServiceImpl();

  @Restricted(permissionName = "CreateBobotKomponenPenilaian")
  @Route(url = "call/bobotkomponenpenilaian/save")
  public List<HashMap<String, Object>> saveBobotKomponenPenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    List<BobotKomponenPenilaian> bobotKomponenPenilaianList = bobotKomponenPenilaianService
        .saveBobotKomponenPenilaian((HashMap<String, Object>) vmjExchange.getPayload());

    return bobotKomponenPenilaianService.transformBobotKomponenPenilaianListToHashMap(bobotKomponenPenilaianList);
  }

  @Restricted(permissionName = "UpdateBobotKomponenPenilaian")
  @Route(url = "call/bobotkomponenpenilaian/update")
  public HashMap<String, Object> updateBobotKomponenPenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    BobotKomponenPenilaian bobotKomponenPenilaian = bobotKomponenPenilaianService
        .updateBobotKomponenPenilaian((HashMap<String, Object>) vmjExchange.getPayload());

    return bobotKomponenPenilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadBobotKomponenPenilaian")
  @Route(url = "call/bobotkomponenpenilaian/detail")
  public HashMap<String, Object> getBobotKomponenPenilaian(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    BobotKomponenPenilaian bobotKomponenPenilaian = bobotKomponenPenilaianService.getBobotKomponenPenilaian(id);
    return bobotKomponenPenilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadBobotKomponenPenilaian")
  @Route(url = "call/bobotkomponenpenilaian/list")
  public List<HashMap<String, Object>> getAllBobotKomponenPenilaian(VMJExchange vmjExchange) {
    List<BobotKomponenPenilaian> bobotKomponenPenilaianList = bobotKomponenPenilaianService
        .getAllBobotKomponenPenilaian();
    return bobotKomponenPenilaianService.transformBobotKomponenPenilaianListToHashMap(bobotKomponenPenilaianList);
  }

  @Restricted(permissionName = "DeleteBobotKomponenPenilaian")
  @Route(url = "call/bobotkomponenpenilaian/delete")
  public List<HashMap<String, Object>> deleteBobotKomponenPenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<BobotKomponenPenilaian> bobotKomponenPenilaianList = bobotKomponenPenilaianService
        .deleteBobotKomponenPenilaian(id);
    return bobotKomponenPenilaianService.transformBobotKomponenPenilaianListToHashMap(bobotKomponenPenilaianList);
  }

  @Restricted(permissionName = "ReadBobotKomponenPenilaian")
  @Route(url = "call/bobotkomponenpenilaian/mapping")
  public HashMap<String, Object> getBobotKomponenPenilaianKelasMapping(VMJExchange vmjExchange) {
    String kelasIdStr = vmjExchange.getGETParam("kelasId");
    if(kelasIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kelasId = UUID.fromString(kelasIdStr);

    HashMap<String, Object> result = bobotKomponenPenilaianService.getKomponenPenilaianKelasMapping(kelasId);

    return result;
  }

}
