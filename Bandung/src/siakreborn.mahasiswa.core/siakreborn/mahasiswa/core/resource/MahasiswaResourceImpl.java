package siakreborn.mahasiswa.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.mahasiswa.MahasiswaFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

import java.util.logging.Logger;

public class MahasiswaResourceImpl extends MahasiswaResourceComponent {
  private MahasiswaFactory mahasiswaFactory = new MahasiswaFactory();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();
  private static final Logger LOGGER = Logger.getLogger(MahasiswaResourceImpl.class.getName());

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

  @Restricted(permissionName = "ReadDetailMahasiswa")
  @Route(url = "call/mahasiswa/detail")
  public HashMap<String, Object> getMahasiswa(VMJExchange vmjExchange) {
    String idStr = null;
    String email = null;
    HashMap<String, Object> error = new HashMap<>();
		
		try {
			idStr = vmjExchange.getGETParam("id");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID id = UUID.fromString(idStr);
      Mahasiswa mahasiswa = mahasiswaService.getMahasiswa(id);
      return mahasiswa.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      error.put("error", e);
		}
		
		try {
			email = vmjExchange.getAuthPayload().getEmail();
      Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);
      return mahasiswa.toHashMap();
		} catch (Exception e) {
      LOGGER.severe("Error: " + e);
      error.put("error", e);
		}

    error.put("message", "Data dengan id: "+idStr+" atau token dengan email: " + email + " tidak ditemukan");
    return error;
  }

  @Restricted(permissionName = "ReadMahasiswa")
  @Route(url = "call/mahasiswa/list")
  public List<HashMap<String, Object>> getAllMahasiswa(VMJExchange vmjExchange) {
    List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswa();
    return mahasiswaService.transformMahasiswaListToHashMap(mahasiswaList);
  }
  
  @Restricted(permissionName = "ReadMahasiswa")
  @Route(url = "call/mahasiswa/listnotgraduated")
  public List<HashMap<String, Object>> getNotGraduated(VMJExchange vmjExchange) {
    List<Mahasiswa> mahasiswaList = mahasiswaService.getNotGraduated();
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

  @Restricted(permissionName = "VerifyMahasiswa")
  @Route(url = "call/mahasiswa/verify")
  public HashMap<String, Object> verify(VMJExchange vmjExchange) {
		Mahasiswa verified = mahasiswaService.verify((HashMap<String, Object>) vmjExchange.getPayload());

    if (verified != null) {
        return verified.toHashMap();
    } else {
        HashMap<String, Object> notFoundMap = new HashMap<>();
        notFoundMap.put("message", "Data tidak ditemukan");
        return notFoundMap;
    }
	}

  @Restricted(permissionName = "GraduateMahasiswa")
  @Route(url = "call/mahasiswa/graduate")
	public List<HashMap<String, Object>> graduate(VMJExchange vmjExchange) {
    HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
    List<String> idMahasiswaList = (List<String>) body.get("idMahasiswaList");
    List<Mahasiswa> result = new ArrayList<>();

    for (String idMahasiswaStr : idMahasiswaList) {
      UUID idMahasiswa = UUID.fromString(idMahasiswaStr);
      Mahasiswa tempMahasiswa = ((MahasiswaServiceImpl) mahasiswaService).graduate(idMahasiswa);
      result.add(tempMahasiswa);
    }

    return mahasiswaService.transformMahasiswaListToHashMap(result);
	}
  
  @Route(url = "call/mahasiswa/angkatan")
  public List<HashMap<String, Object>> getAllAngkatan(VMJExchange vmjExchange) {
      return mahasiswaService.getAllAngkatan();
  }

  @Restricted(permissionName = "ReadMahasiswaPublic")
  @Route(url = "call/mahasiswa/listpublic")
  public List<HashMap<String, Object>> getAllMahasiswaPublic(VMJExchange vmjExchange) {
    List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswaPublic();
    return mahasiswaService.transformMahasiswaListToHashMap(mahasiswaList);
  }

  @Route(url = "call/mahasiswa/optionpublic")
  public HashMap<String, Object> getOptionPublic(VMJExchange vmjExchange) {
    HashMap<String, Object> optionPublic = new HashMap<>();
    optionPublic.put("id", "true");
    optionPublic.put("name", "isPublic");
    return optionPublic;
  }
}
