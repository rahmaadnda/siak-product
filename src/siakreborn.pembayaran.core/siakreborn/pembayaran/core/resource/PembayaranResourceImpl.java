package siakreborn.pembayaran.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.pembayaran.PembayaranFactory;
import vmj.auth.annotations.Restricted;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;
import siakreborn.semester.core.Semester;

public class PembayaranResourceImpl extends PembayaranResourceComponent {
  PembayaranService pembayaranService = new PembayaranServiceImpl();
  MahasiswaService mahasiswaService = new MahasiswaServiceImpl();

  @Restricted(permissionName = "CreatePembayaran")
  @Route(url = "call/pembayaran/save")
  public HashMap<String, Object> savePembayaran(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    Pembayaran pembayaran = pembayaranService
        .savePembayaran((HashMap<String, Object>) vmjExchange.getPayload());
    return pembayaran.toHashMap();
  }

  @Restricted(permissionName = "CreatePembayaranMe")
  @Route(url = "call/pembayaran/me/save")
  public HashMap<String, Object> savePembayaranMe(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    Pembayaran pembayaran = pembayaranService
        .savePembayaranMe(mahasiswa.getId(), (HashMap<String, Object>) vmjExchange.getPayload());
    return pembayaran.toHashMap();
  }

  @Restricted(permissionName = "ReadPembayaranMe")
  @Route(url = "call/pembayaran/me/detail")
  public HashMap<String, Object> getPembayaranMe(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    Pembayaran pembayaran = pembayaranService
        .getPembayaranMe(mahasiswa.getId());
    return pembayaran.toHashMap();
  }

  @Restricted(permissionName = "UpdatePembayaran")
  @Route(url = "call/pembayaran/update")
  public HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Pembayaran pembayaran = pembayaranService.updatePembayaran((HashMap<String, Object>) vmjExchange.getPayload());
    return pembayaran.toHashMap();
  }

  @Restricted(permissionName = "ReadPembayaran")
  @Route(url = "call/pembayaran/detail")
  public HashMap<String, Object> getPembayaran(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Pembayaran pembayaran = pembayaranService.getPembayaran(id);
    return pembayaran.toHashMap();
  }

  @Restricted(permissionName = "ReadPembayaran")
  @Route(url = "call/pembayaran/list")
  public List<HashMap<String, Object>> getAllPembayaran(VMJExchange vmjExchange) {
    List<Pembayaran> pembayaranList = pembayaranService.getAllPembayaran();
    return pembayaranService.transformPembayaranListToHashMap(pembayaranList);
  }

  @Restricted(permissionName = "DeletePembayaran")
  @Route(url = "call/pembayaran/delete")
  public List<HashMap<String, Object>> deletePembayaran(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    List<Pembayaran> pembayaranList = pembayaranService.deletePembayaran(id);
    return pembayaranService.transformPembayaranListToHashMap(pembayaranList);
  }

}
