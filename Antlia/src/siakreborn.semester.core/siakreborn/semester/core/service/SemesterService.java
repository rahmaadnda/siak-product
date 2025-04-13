package siakreborn.semester.core;

import java.util.*;

public interface SemesterService {
  List<Semester> saveSemester(HashMap<String, Object> body);

  Semester updateSemester(HashMap<String, Object> body);

  Semester getSemester(UUID id);

  Semester getActiveSemester();

  List<Semester> getAllSemester();

  List<Semester> deleteSemester(UUID id);

  List<HashMap<String, Object>> transformSemesterListToHashMap(List<Semester> semesterList);
}
