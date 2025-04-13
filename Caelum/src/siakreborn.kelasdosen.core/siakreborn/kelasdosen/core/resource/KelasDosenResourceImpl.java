package siakreborn.kelasdosen.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kelasdosen.KelasDosenFactory;
import vmj.auth.annotations.Restricted;
//add other required packages
import siakreborn.dosen.core.Dosen;
import siakreborn.dosen.core.DosenService;
import siakreborn.dosen.core.DosenServiceImpl;
import siakreborn.kelas.core.Kelas;

public class KelasDosenResourceImpl extends KelasDosenResourceComponent {
  private KelasDosenFactory kelasDosenFactory = new KelasDosenFactory();
  private KelasDosenService kelasDosenService = new KelasDosenServiceImpl();
  private DosenService dosenService = new DosenServiceImpl();

  @Restricted(permissionName = "CreateKelasDosen")
  @Route(url = "call/kelasdosen/save")
  public List<HashMap<String, Object>> saveKelasDosen(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<KelasDosen> kelasDosenList = kelasDosenService
        .saveKelasDosen((HashMap<String, Object>) vmjExchange.getPayload());
    return kelasDosenService.transformKelasDosenListToHashMap(kelasDosenList);
  }

  @Restricted(permissionName = "UpdateKelasDosen")
  @Route(url = "call/kelasdosen/update")
  public HashMap<String, Object> updateKelasDosen(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    KelasDosen kelasDosen = kelasDosenService.updateKelasDosen((HashMap<String, Object>) vmjExchange.getPayload());
    return kelasDosen.toHashMap();
  }

  @Restricted(permissionName = "ReadKelasDosen")
  @Route(url = "call/kelasdosen/detail")
  public HashMap<String, Object> getKelasDosen(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    KelasDosen kelasDosen = kelasDosenService.getKelasDosen(id);
    return kelasDosen.toHashMap();
  }

  @Restricted(permissionName = "ReadKelasDosen")
  @Route(url = "call/kelasdosen/kelas/detail")
  public HashMap<String, Object> getKelasDetail(VMJExchange vmjExchange) {
    String kelasIdStr = vmjExchange.getGETParam("kelasId");
    UUID kelasId = UUID.fromString(kelasIdStr);

    HashMap<String, Object> result = kelasDosenService.getKelasWithDosen(kelasId);
    return result;
  }

  @Restricted(permissionName = "ReadKelasDosenMe")
  @Route(url = "call/kelasdosen/me/riwayat")
  public List<HashMap<String, Object>> getRiwayatDosen(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Dosen dosen = dosenService.getDosenByEmail(email);
    UUID mahasiswaId = dosen.getId();

    return kelasDosenService.getRiwayatKelasDosen(mahasiswaId);
  }

  @Restricted(permissionName = "ReadKelasDosen")
  @Route(url = "call/kelasdosen/list")
  public List<HashMap<String, Object>> getAllKelasDosen(VMJExchange vmjExchange) {
    List<KelasDosen> kelasDosenList = kelasDosenService.getAllKelasDosen();
    return kelasDosenService.transformKelasDosenListToHashMap(kelasDosenList);
  }

  @Restricted(permissionName = "ReadKelasDosen")
  @Route(url = "call/kelasdosen/filter")
  public List<HashMap<String, Object>> filterKelasDosen(VMJExchange vmjExchange) {
    String target = (String) vmjExchange.getGETParam("target");
    String by = (String) vmjExchange.getGETParam("by");

    if (target.equals("dosen") && by.equals("kelas")) {
      String kelasIdStr = (String) vmjExchange.getGETParam("kelasId");
      if(kelasIdStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID kelasId = UUID.fromString(kelasIdStr);

      List<Dosen> dosenList = kelasDosenService.filterDosenByKelas(kelasId);
      return kelasDosenService.transformDosenListToHashMap(dosenList);
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "DeleteKelasDosen")
  @Route(url = "call/kelasdosen/delete")
  public List<HashMap<String, Object>> deleteKelasDosen(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<KelasDosen> kelasDosenList = kelasDosenService.deleteKelasDosen(id);
    return kelasDosenService.transformKelasDosenListToHashMap(kelasDosenList);
  }

}
