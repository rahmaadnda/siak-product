package siakreborn.kurikulumsemester.core;

import java.util.*;

import siakreborn.semester.core.Semester;

public interface KurikulumSemesterService {
  List<KurikulumSemester> saveKurikulumSemester(HashMap<String, Object> body);

  KurikulumSemester updateKurikulumSemester(HashMap<String, Object> body);

  KurikulumSemester getKurikulumSemester(UUID id);

  List<KurikulumSemester> getAllKurikulumSemester();

  List<KurikulumSemester> deleteKurikulumSemester(UUID id);

  List<KurikulumSemester> saveSemester(HashMap<String, Object> body);

  Semester updateSemester(HashMap<String, Object> body);

  HashMap<String, Object> getSemester(UUID semesterId);

  List<HashMap<String, Object>> transformKurikulumSemesterListToHashMap(
      List<KurikulumSemester> kurikulumSemesterList);
}
