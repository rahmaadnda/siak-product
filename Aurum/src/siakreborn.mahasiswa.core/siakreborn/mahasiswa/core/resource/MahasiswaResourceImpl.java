package siakreborn.mahasiswa.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.mahasiswa.MahasiswaFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class MahasiswaResourceImpl extends MahasiswaResourceComponent {
  private MahasiswaFactory mahasiswaFactory = new MahasiswaFactory();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();

  @Restricted(permissionName = "CreateMahasiswa")
  @Route(url = "call/mahasiswa/save")
  public List<HashMap<String, Object>> saveMahasiswa(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<Mahasiswa> mahasiswaList = mahasiswaService.saveMahasiswa((HashMap<String, Object>) vmjExchange.getPayload());
    return mahasiswaService.transformMahasiswaListToHashMap(mahasiswaList);
  }

  @Restricted(permissionName = "UpdateMahasiswa")
  @Route(url = "call/mahasiswa/update")
  public HashMap<String, Object> updateMahasiswa(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Mahasiswa mahasiswa = mahasiswaService.updateMahasiswa((HashMap<String, Object>) vmjExchange.getPayload());
    return mahasiswa.toHashMap();
  }

  @Restricted(permissionName = "ReadMahasiswaMe")
  @Route(url = "call/mahasiswa/me/detail")
  public HashMap<String, Object> getMahasiswaMe(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    return mahasiswa.toHashMap();
  }

  @Restricted(permissionName = "ReadMahasiswa")
  @Route(url = "call/mahasiswa/detail")
  public HashMap<String, Object> getMahasiswa(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    UUID id = UUID.fromString(idStr);

    Mahasiswa mahasiswa = mahasiswaService.getMahasiswa(id);
    return mahasiswa.toHashMap();
  }

  @Restricted(permissionName = "ReadMahasiswa")
  @Route(url = "call/mahasiswa/list")
  public List<HashMap<String, Object>> getAllMahasiswa(VMJExchange vmjExchange) {
    List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswa();
    return mahasiswaService.transformMahasiswaListToHashMap(mahasiswaList);
  }

  @Restricted(permissionName = "DeleteMahasiswa")
  @Route(url = "call/mahasiswa/delete")
  public List<HashMap<String, Object>> deleteMahasiswa(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Mahasiswa> mahasiswaList = mahasiswaService.deleteMahasiswa(id);
    return mahasiswaService.transformMahasiswaListToHashMap(mahasiswaList);
  }

}
