package siakreborn.kurikulumsemester.core;

import java.util.*;

import siakreborn.kurikulumsemester.KurikulumSemesterFactory;
import siakreborn.kurikulum.core.Kurikulum;
import siakreborn.kurikulum.core.KurikulumService;
import siakreborn.kurikulum.core.KurikulumServiceImpl;
import siakreborn.semester.core.Semester;
import siakreborn.semester.core.SemesterService;
import siakreborn.semester.core.SemesterServiceImpl;

public class KurikulumSemesterServiceImpl extends KurikulumSemesterServiceComponent {
  private KurikulumSemesterFactory kurikulumSemesterFactory = new KurikulumSemesterFactory();
  private KurikulumService kurikulumService = new KurikulumServiceImpl();
  private SemesterService semesterService = new SemesterServiceImpl();

  public List<KurikulumSemester> saveKurikulumSemester(HashMap<String, Object> body) {
    String kurikulumIdStr = (String) body.get("kurikulumId");
    String semesterIdStr = (String) body.get("semesterId");

    Kurikulum kurikulum = null;
    if (kurikulumIdStr != null) {
      UUID kurikulumId = UUID.fromString(kurikulumIdStr);
      kurikulum = kurikulumSemesterRepository.getProxyObject(siakreborn.kurikulum.core.KurikulumComponent.class,
          kurikulumId);
    }

    Semester semester = null;
    if (semesterIdStr != null) {
      UUID semesterId = UUID.fromString(semesterIdStr);
      semester = kurikulumSemesterRepository.getProxyObject(siakreborn.semester.core.SemesterComponent.class,
          semesterId);
    }

    KurikulumSemester kurikulumSemester = KurikulumSemesterFactory.createKurikulumSemester(
        "siakreborn.kurikulumsemester.core.KurikulumSemesterImpl", kurikulum, semester);

    kurikulumSemesterRepository.saveObject(kurikulumSemester);
    return getAllKurikulumSemester();
  }

  public KurikulumSemester updateKurikulumSemester(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kurikulumIdStr = (String) body.get("kurikulumId");
    String semesterIdStr = (String) body.get("semesterId");

    KurikulumSemester kurikulumSemester = kurikulumSemesterRepository.getObject(id);

    Kurikulum kurikulum = kurikulumSemester.getKurikulum();
    if (kurikulumIdStr != null) {
      UUID kurikulumId = UUID.fromString(kurikulumIdStr);
      kurikulum = kurikulumSemesterRepository.getProxyObject(siakreborn.kurikulum.core.KurikulumComponent.class,
          kurikulumId);
    }

    Semester semester = kurikulumSemester.getSemester();
    if (semesterIdStr != null) {
      UUID semesterId = UUID.fromString(semesterIdStr);
      semester = kurikulumSemesterRepository.getProxyObject(siakreborn.semester.core.SemesterComponent.class,
          semesterId);
    }

    kurikulumSemester.setKurikulum(kurikulum);
    kurikulumSemester.setSemester(semester);

    kurikulumSemesterRepository.updateObject(kurikulumSemester);
    kurikulumSemester = kurikulumSemesterRepository.getObject(id);

    return kurikulumSemester;
  }

  public KurikulumSemester getKurikulumSemester(UUID id) {
    KurikulumSemester kurikulumSemester = kurikulumSemesterRepository.getObject(id);
    return kurikulumSemester;
  }

  public List<KurikulumSemester> getAllKurikulumSemester() {
    List<KurikulumSemester> kurikulumSemesterList = kurikulumSemesterRepository.getAllObject("kurikulum_semester_impl",
        KurikulumSemesterImpl.class.getName());
    return kurikulumSemesterList;
  }

  public List<KurikulumSemester> filterKurikulumSemester(String columnName, UUID id) {
    List<KurikulumSemester> kurikulumSemesterList = kurikulumSemesterRepository.getListObject("kurikulum_semester_comp",
        columnName, id);
    return kurikulumSemesterList;
  }

  public List<KurikulumSemester> deleteKurikulumSemester(UUID id) {
    kurikulumSemesterRepository.deleteObject(id);
    return getAllKurikulumSemester();
  }

  public List<KurikulumSemester> saveSemester(HashMap<String, Object> body) {
    UUID id = UUID.randomUUID();
    body.put("id", id.toString());
    semesterService.saveSemester(body);
    Semester semester = semesterService.getSemester(id);

    List<String> kurikulumIds = (List<String>) body.get("kurikulumIds");

    for (String kurikulumId : kurikulumIds) {
      HashMap<String, Object> payload = new HashMap<>();
      payload.put("semesterId", semester.getId().toString());
      payload.put("kurikulumId", kurikulumId);

      saveKurikulumSemester(payload);
    }

    return getAllKurikulumSemester();
  }

  public Semester updateSemester(HashMap<String, Object> body) {
    Semester semester = semesterService.updateSemester(body);

    String semesterIdStr = (String) body.get("id");
    UUID semesterId = UUID.fromString(semesterIdStr);
    List<String> kurikulumIds = (List<String>) body.get("kurikulumIds");

    List<KurikulumSemester> kurikulumSemesterList = filterKurikulumSemester("semester_id", semesterId);

    // add new KurikulumSemester
    Set<String> idSet = new TreeSet<>();
    for (KurikulumSemester kurikulumSemester : kurikulumSemesterList) {
      idSet.add(kurikulumSemester.getKurikulum().getId().toString());
    }

    for (String kurikulumId : kurikulumIds) {
      if (!idSet.contains(kurikulumId)) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("kurikulumId", kurikulumId);
        payload.put("semesterId", semesterIdStr);

        saveKurikulumSemester(payload);
      }
    }

    // delete unused KurikulumSemester
    idSet.clear();
    for (String kurikulumId : kurikulumIds) {
      idSet.add(kurikulumId);
    }

    for (KurikulumSemester kurikulumSemester : kurikulumSemesterList) {
      if (!idSet.contains(kurikulumSemester.getKurikulum().getId().toString())) {
        deleteKurikulumSemester(kurikulumSemester.getId());
      }
    }

    return semester;
  }

  public HashMap<String, Object> getSemester(UUID semesterId) {
    Semester semester = semesterService.getSemester(semesterId);
    List<KurikulumSemester> kurikulumSemesterList = filterKurikulumSemester("semester_id", semester.getId());

    List<String> kurikulumIdList = new ArrayList<>();
    for (KurikulumSemester kurikulumSemester : kurikulumSemesterList) {
      kurikulumIdList.add(kurikulumSemester.getKurikulum().getId().toString());
    }
    String kurikulumIds = String.join(",", kurikulumIdList);

    HashMap<String, Object> result = semester.toHashMap();
    result.put("kurikulumIds", kurikulumIds);

    return result;
  }

  public List<HashMap<String, Object>> transformKurikulumSemesterListToHashMap(
      List<KurikulumSemester> kurikulumSemesterList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kurikulumSemesterList.size(); i++) {
      resultList.add(kurikulumSemesterList.get(i).toHashMap());
    }

    return resultList;
  }
}
