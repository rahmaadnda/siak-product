package siakreborn.dosen.core;

import java.util.*;

import siakreborn.dosen.DosenFactory;
import vmj.routing.route.exceptions.NotFoundException;

public class DosenServiceImpl extends DosenServiceComponent {
  private DosenFactory dosenFactory = new DosenFactory();

  public List<Dosen> saveDosen(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String nip = (String) body.get("nip");
    String email = (String) body.get("email");

    Dosen dosen = dosenFactory.createDosen("siakreborn.dosen.core.DosenImpl", nama, nip, email);
    dosenRepository.saveObject(dosen);

    return getAllDosen();
  }

  public Dosen updateDosen(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nama = (String) body.get("nama");
    String nip = (String) body.get("nip");
    String email = (String) body.get("email");

    Dosen dosen = dosenRepository.getObject(id);
    dosen.setNama(nama);
    dosen.setNip(nip);
    dosen.setEmail(email);

    dosenRepository.updateObject(dosen);
    dosen = dosenRepository.getObject(id);

    return dosen;
  }

  public Dosen getDosen(UUID id) {
    Dosen dosen = dosenRepository.getObject(id);
    return dosen;
  }

  public List<Dosen> getAllDosen() {
    List<Dosen> dosenList = dosenRepository.getAllObject("dosen_impl", DosenImpl.class.getName());
    return dosenList;
  }

  public Dosen getDosenByEmail(String email) {
    try {
      Dosen dosen = dosenRepository.getListObject("dosen_comp", "email", email).get(0);
      return dosen;
    } catch (Exception e) {
      throw new NotFoundException("dosen tidak ditemukan");
    }
  }

  public List<Dosen> deleteDosen(UUID id) {
    dosenRepository.deleteObject(id);
    return getAllDosen();
  }

  public List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < dosenList.size(); i++) {
      resultList.add(dosenList.get(i).toHashMap());
    }

    return resultList;
  }
}
