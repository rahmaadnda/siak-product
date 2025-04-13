package siakreborn.penilaian.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;
//add other required packages
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;

public class PenilaianResourceImpl extends PenilaianResourceComponent {
  private PenilaianService penilaianService = new PenilaianServiceImpl();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();

  @Restricted(permissionName = "CreatePenilaian")
  @Route(url = "call/penilaian/save")
  public List<HashMap<String, Object>> savePenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<Penilaian> penilaianList = penilaianService.savePenilaian((HashMap<String, Object>) vmjExchange.getPayload());
    return penilaianService.transformPenilaianListToHashMap(penilaianList);
  }

  @Restricted(permissionName = "UpdatePenilaian")
  @Route(url = "call/penilaian/update")
  public HashMap<String, Object> updatePenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Penilaian penilaian = penilaianService.updatePenilaian((HashMap<String, Object>) vmjExchange.getPayload());
    return penilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadPenilaian")
  @Route(url = "call/penilaian/detail")
  public HashMap<String, Object> getPenilaian(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Penilaian penilaian = penilaianService.getPenilaian(id);
    return penilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadPenilaian")
  @Route(url = "call/penilaian/list")
  public List<HashMap<String, Object>> getAllPenilaian(VMJExchange vmjExchange) {
    List<Penilaian> penilaianList = penilaianService.getAllPenilaian();
    return penilaianService.transformPenilaianListToHashMap(penilaianList);
  }

  @Restricted(permissionName = "DeletePenilaian")
  @Route(url = "call/penilaian/delete")
  public List<HashMap<String, Object>> deletePenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Penilaian> penilaianList = penilaianService.deletePenilaian(id);
    return penilaianService.transformPenilaianListToHashMap(penilaianList);
  }

  @Restricted(permissionName = "ReadPenilaian")
  @Route(url = "call/penilaian/filter")
  public List<HashMap<String, Object>> filterPenilaian(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    if (by.equals("mahasiswa") || by.equals("komponenPenilaian")) {
      String idStr = (String) vmjExchange.getGETParam(by + "Id");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID id = UUID.fromString(idStr);

      String columnName = by.toLowerCase() + "_id";

      List<Penilaian> penilaianList = penilaianService.filterPenilaian(columnName, id);
      return penilaianService.transformPenilaianListToHashMap(penilaianList);
    } else if (by.equals("mahasiswa,kelas")) {
      String mahasiswaIdStr = (String) vmjExchange.getGETParam("mahasiswaId");
      if(mahasiswaIdStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);

      String idStr = (String) vmjExchange.getGETParam("kelasId");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID kelasId = UUID.fromString(idStr);

      List<Penilaian> penilaianList = penilaianService.filterPenilaianByMahasiswaAndKelas(mahasiswaId, kelasId);
      return penilaianService.transformPenilaianListToHashMap(penilaianList);
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "ReadPenilaianMe")
  @Route(url = "call/penilaian/me/filter")
  public List<HashMap<String, Object>> filterPenilaianMe(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    if (by.equals("kelas")) {
      UUID mahasiswaId = mahasiswa.getId();

      String idStr = (String) vmjExchange.getGETParam("kelasId");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID kelasId = UUID.fromString(idStr);

      List<Penilaian> penilaianList = penilaianService.filterPenilaianByMahasiswaAndKelas(mahasiswaId, kelasId);
      return penilaianService.transformPenilaianListToHashMap(penilaianList);
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "ReadPenilaian")
  @Route(url = "call/penilaian/nilai-akhir")
  public HashMap<String, Object> getPenilaianAkhir(VMJExchange vmjExchange) {
    String mahasiswaIdStr = (String) vmjExchange.getGETParam("mahasiswaId");
    if(mahasiswaIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);

    String idStr = (String) vmjExchange.getGETParam("kelasId");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kelasId = UUID.fromString(idStr);

    HashMap<String, Object> nilaiAkhirMap = penilaianService.getPenilaianAkhir(mahasiswaId, kelasId);

    return nilaiAkhirMap;
  }

  @Restricted(permissionName = "ReadPenilaianMe")
  @Route(url = "call/penilaian/me/nilai-akhir")
  public HashMap<String, Object> getPenilaianAkhirMe(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    String idStr = (String) vmjExchange.getGETParam("kelasId");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kelasId = UUID.fromString(idStr);

    HashMap<String, Object> nilaiAkhirMap = penilaianService.getPenilaianAkhir(mahasiswa.getId(), kelasId);

    return nilaiAkhirMap;
  }
}
