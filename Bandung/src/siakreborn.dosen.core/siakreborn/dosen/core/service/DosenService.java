package siakreborn.dosen.core;

import java.util.*;

public interface DosenService {
  List<Dosen> saveDosen(HashMap<String, Object> body);

  Dosen updateDosen(HashMap<String, Object> body);

  Dosen getDosen(UUID id);

  Dosen getDosenByEmail(String email);

  List<Dosen> getAllDosen();

  List<Dosen> deleteDosen(UUID id);

  List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList);
}
