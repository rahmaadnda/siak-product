package siakreborn.kelasdosen.core;

import java.util.*;

import siakreborn.kelasdosen.KelasDosenFactory;
import siakreborn.kelas.core.Kelas;
import siakreborn.kelas.core.KelasService;
import siakreborn.kelas.core.KelasServiceImpl;
import siakreborn.dosen.core.Dosen;
import siakreborn.semester.core.Semester;

public class KelasDosenServiceImpl extends KelasDosenServiceComponent {
  private KelasDosenFactory kelasDosenFactory = new KelasDosenFactory();
  private KelasService kelasService = new KelasServiceImpl();

  public List<KelasDosen> saveKelasDosen(HashMap<String, Object> body) {
    String dosenIdStr = (String) body.get("dosenId");
    String kelasIdStr = (String) body.get("kelasId");

    Dosen dosen = null;
    if (dosenIdStr != null) {
      UUID dosenId = UUID.fromString(dosenIdStr);
      dosen = kelasDosenRepository.getProxyObject(siakreborn.dosen.core.DosenComponent.class, dosenId);
    }

    Kelas kelas = null;
    if (kelasIdStr != null) {
      UUID kelasId = UUID.fromString(kelasIdStr);
      kelas = kelasDosenRepository.getProxyObject(siakreborn.kelas.core.KelasComponent.class, kelasId);
    }

    KelasDosen kelasDosen = kelasDosenFactory.createKelasDosen("siakreborn.kelasdosen.core.KelasDosenImpl", dosen,
        kelas);
    kelasDosenRepository.saveObject(kelasDosen);

    return getAllKelasDosen();
  }

  public KelasDosen updateKelasDosen(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String dosenIdStr = (String) body.get("dosenId");
    String kelasIdStr = (String) body.get("kelasId");

    KelasDosen kelasDosen = kelasDosenRepository.getObject(id);

    Dosen dosen = kelasDosen.getDosen();
    if (dosenIdStr != null) {
      UUID dosenId = UUID.fromString(dosenIdStr);
      dosen = kelasDosenRepository.getProxyObject(siakreborn.dosen.core.DosenComponent.class, dosenId);
    }

    Kelas kelas = kelasDosen.getKelas();
    if (kelasIdStr != null) {
      UUID kelasId = UUID.fromString(kelasIdStr);
      kelas = kelasDosenRepository.getProxyObject(siakreborn.kelas.core.KelasComponent.class, kelasId);
    }

    kelasDosen.setDosen(dosen);
    kelasDosen.setKelas(kelas);

    kelasDosenRepository.updateObject(kelasDosen);
    kelasDosen = kelasDosenRepository.getObject(id);

    return kelasDosen;
  }

  public KelasDosen getKelasDosen(UUID id) {
    KelasDosen kelasDosen = kelasDosenRepository.getObject(id);
    return kelasDosen;
  }

  public List<KelasDosen> getAllKelasDosen() {
    List<KelasDosen> kelasDosenList = kelasDosenRepository.getAllObject("kelas_dosen_impl",
        KelasDosenImpl.class.getName());
    return kelasDosenList;
  }

  public HashMap<String, Object> getKelasWithDosen(UUID kelasId) {
    Kelas kelas = kelasService.getKelas(kelasId);
    List<Dosen> dosenList = filterDosenByKelas(kelasId);

    String dosenNames = "";
    for (Dosen dosen : dosenList) {
      if (dosenNames.equals(""))
        dosenNames += dosen.getNama();
      else
        dosenNames += "\n" + dosen.getNama();
    }

    HashMap<String, Object> result = kelas.toHashMap();
    result.put("dosen", dosenNames);

    return result;
  }

  public List<HashMap<String, Object>> getRiwayatKelasDosen(UUID dosenId) {
    List<Kelas> kelasList = filterKelasByDosen(dosenId);

    HashMap<String, Semester> mapSemester = new HashMap<>();
    HashMap<String, List<Kelas>> groups = new HashMap<>();

    for (Kelas kelas : kelasList) {
      Semester semester = kelas.getSemester();

      if (!mapSemester.containsKey(semester.getId().toString())) {
        mapSemester.put(semester.getId().toString(), semester);
      }

      List<Kelas> group = new ArrayList<>();
      if (groups.containsKey(semester.getId().toString())) {
        group = groups.get(semester.getId().toString());
      } else {
        groups.put(semester.getId().toString(), group);
      }

      group.add(kelas);
    }

    List<HashMap<String, Object>> result = new ArrayList<>();
    for (Map.Entry<String, List<Kelas>> entry : groups.entrySet()) {
      String id = entry.getKey();
      List<Kelas> group = entry.getValue();

      Semester semester = mapSemester.get(id);

      HashMap<String, Object> groupInfo = semester.toHashMap();

      groupInfo.put("kelas", transformKelasListToHashMap(group));

      result.add(groupInfo);
    }

    return result;
  }

  public List<Dosen> filterDosenByKelas(UUID kelasId) {
    List<KelasDosen> kelasDosenList = kelasDosenRepository.getListObject("kelas_dosen_comp", "kelas_id", kelasId);
    List<Dosen> dosenList = new ArrayList<Dosen>();
    for (int i = 0; i < kelasDosenList.size(); i++) {
      dosenList.add(kelasDosenList.get(i).getDosen());
    }

    return dosenList;
  }

  public List<Kelas> filterKelasByDosen(UUID dosenId) {
    List<KelasDosen> kelasDosenList = kelasDosenRepository.getListObject("kelas_dosen_comp", "dosen_id", dosenId);
    List<Kelas> kelasList = new ArrayList<Kelas>();
    for (int i = 0; i < kelasDosenList.size(); i++) {
      kelasList.add(kelasDosenList.get(i).getKelas());
    }

    return kelasList;
  }

  public List<KelasDosen> deleteKelasDosen(UUID id) {
    kelasDosenRepository.deleteObject(id);
    return getAllKelasDosen();
  }

  public List<HashMap<String, Object>> transformKelasDosenListToHashMap(List<KelasDosen> kelasDosenList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kelasDosenList.size(); i++) {
      resultList.add(kelasDosenList.get(i).toHashMap());
    }

    return resultList;
  }

  public List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < dosenList.size(); i++) {
      resultList.add(dosenList.get(i).toHashMap());
    }

    return resultList;
  }

  public List<HashMap<String, Object>> transformKelasListToHashMap(List<Kelas> kelasList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kelasList.size(); i++) {
      resultList.add(kelasList.get(i).toHashMap());
    }

    return resultList;
  }
}
