package siakreborn.rencanastudi.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.rencanastudi.RencanaStudiFactory;
import vmj.auth.annotations.Restricted;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;

public class RencanaStudiResourceImpl extends RencanaStudiResourceComponent {
  private RencanaStudiService rencanaStudiService = new RencanaStudiServiceImpl();
  private KelasMahasiswaService kelasMahasiswaService = new KelasMahasiswaServiceImpl();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();

  @Restricted(permissionName = "CreateRencanaStudiMe")
  @Route(url = "call/rencanastudi/me/save")
  public HashMap<String, Object> saveRencanaStudi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    RencanaStudi rencanaStudiList = rencanaStudiService
        .saveRencanaStudi((HashMap<String, Object>) vmjExchange.getPayload(), mahasiswa);
    return rencanaStudiList.toHashMap();
  }

  @Restricted(permissionName = "ReadRencanaStudiMe")
  @Route(url = "call/rencanastudi/me/active")
  public HashMap<String, Object> getActiveRencanaStudi(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    return rencanaStudiService.getActiveRencanaStudi(mahasiswa.getId());
  }

  @Restricted(permissionName = "ReadRencanaStudiMe")
  @Route(url = "call/rencanastudi/me/list")
  public List<HashMap<String, Object>> getRencanaStudiMahasiswa(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    List<RencanaStudi> rencanaStudiList = rencanaStudiService.getRencanaStudiMahasiswa(mahasiswa.getId());
    return rencanaStudiService.transformRencanaStudiListToHashMap(rencanaStudiList);
  }

  @Restricted(permissionName = "ReadRencanaStudiMe")
  @Route(url = "call/rencanastudi/me/ringkasan")
  public HashMap<String, Object> getRingkasanMahasiswa(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    HashMap<String, Object> result = mahasiswa.toHashMap();

    int totalSKS = rencanaStudiService.getTotalSKS(mahasiswa.getId());
    result.put("totalSKS", totalSKS);

    return result;
  }

  @Restricted(permissionName = "ReadRencanaStudiMe")
  @Route(url = "call/rencanastudi/kelas")
  public HashMap<String, Object> getRencanaStudiClass(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    return rencanaStudiService.getRencanaStudiClass(mahasiswa.getId());
  }

  @Restricted(permissionName = "ReadRencanaStudi")
  @Route(url = "call/rencanastudi/detail")
  public HashMap<String, Object> getRencanaStudi(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    RencanaStudi rencanaStudi = rencanaStudiService.getRencanaStudi(id);
    return rencanaStudi.toHashMap();
  }

  @Restricted(permissionName = "ReadRencanaStudi")
  @Route(url = "call/rencanastudi/list")
  public List<HashMap<String, Object>> getAllRencanaStudi(VMJExchange vmjExchange) {
    List<RencanaStudi> rencanaStudiList = rencanaStudiService.getAllRencanaStudi();
    return rencanaStudiService.transformRencanaStudiListToHashMap(rencanaStudiList);
  }

  @Restricted(permissionName = "DeleteRencanaStudi")
  @Route(url = "call/rencanastudi/delete")
  public List<HashMap<String, Object>> deleteRencanaStudi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<RencanaStudi> rencanaStudiList = rencanaStudiService.deleteRencanaStudi(id);
    return rencanaStudiService.transformRencanaStudiListToHashMap(rencanaStudiList);
  }

  @Restricted(permissionName = "ReadPengisianRencanaStudi")
  @Route(url = "call/rencanastudi/pengisian-aktif/detail")
  public HashMap<String, Object> getActivePengisianRencanaStudi(VMJExchange vmjExchange) {
    PengisianRencanaStudi pengisianRencanaStudi = rencanaStudiService.getActivePengisianRencanaStudi();
    return pengisianRencanaStudi.toHashMap();
  }

  @Restricted(permissionName = "UpdatePengisianRencanaStudi")
  @Route(url = "call/rencanastudi/pengisian-aktif/update")
  public HashMap<String, Object> updateActivePengisianRencanaStudi(VMJExchange vmjExchange) {
    PengisianRencanaStudi pengisianRencanaStudi = rencanaStudiService
        .updateActivePengisianRencanaStudi((HashMap<String, Object>) vmjExchange.getPayload());
    return pengisianRencanaStudi.toHashMap();
  }

  @Restricted(permissionName = "CreateKelasMahasiswa")
  @Route(url = "call/kelasmahasiswa/save")
  public List<HashMap<String, Object>> saveKelasMahasiswa(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaService
        .saveKelasMahasiswa((HashMap<String, Object>) vmjExchange.getPayload());
    return kelasMahasiswaService.transformKelasMahasiswaListToHashMap(kelasMahasiswaList);
  }

  @Restricted(permissionName = "UpdateKelasMahasiswa")
  @Route(url = "call/kelasmahasiswa/update")
  public HashMap<String, Object> updateKelasMahasiswa(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    KelasMahasiswa kelasMahasiswa = kelasMahasiswaService
        .updateKelasMahasiswa((HashMap<String, Object>) vmjExchange.getPayload());
    return kelasMahasiswa.toHashMap();
  }

  @Restricted(permissionName = "ReadKelasMahasiswa")
  @Route(url = "call/kelasmahasiswa/detail")
  public HashMap<String, Object> getKelasMahasiswa(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    KelasMahasiswa kelasMahasiswa = kelasMahasiswaService.getKelasMahasiswa(id);
    return kelasMahasiswa.toHashMap();
  }

  @Restricted(permissionName = "ReadKelasMahasiswa")
  @Route(url = "call/kelasmahasiswa/list")
  public List<HashMap<String, Object>> getAllKelasMahasiswa(VMJExchange vmjExchange) {
    List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaService.getAllKelasMahasiswa();
    return kelasMahasiswaService.transformKelasMahasiswaListToHashMap(kelasMahasiswaList);
  }

  @Restricted(permissionName = "ReadKelasMahasiswa")
  @Route(url = "call/kelasmahasiswa/filter")
  public List<HashMap<String, Object>> filterKelasMahasiswa(VMJExchange vmjExchange) {
    String target = (String) vmjExchange.getGETParam("target");
    String by = (String) vmjExchange.getGETParam("by");

    if (target.equals("mahasiswa") && by.equals("kelas")) {
      String kelasIdStr = (String) vmjExchange.getGETParam("kelasId");
      if(kelasIdStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID kelasId = UUID.fromString(kelasIdStr);

      List<Mahasiswa> mahasiswaList = kelasMahasiswaService.filterMahasiswaByKelas(kelasId);
      return kelasMahasiswaService.transformMahasiswaListToHashMap(mahasiswaList);
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "ReadKelasMahasiswaMe")
  @Route(url = "call/kelasmahasiswa/me/riwayat")
  public List<HashMap<String, Object>> getRiwayatMahasiswa(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);
    UUID mahasiswaId = mahasiswa.getId();

    return kelasMahasiswaService.getRiwayatKelasMahasiswa(mahasiswaId, by);
  }

  @Restricted(permissionName = "DeleteKelasMahasiswa")
  @Route(url = "call/kelasmahasiswa/delete")
  public List<HashMap<String, Object>> deleteKelasMahasiswa(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaService.deleteKelasMahasiswa(id);
    return kelasMahasiswaService.transformKelasMahasiswaListToHashMap(kelasMahasiswaList);
  }
}
