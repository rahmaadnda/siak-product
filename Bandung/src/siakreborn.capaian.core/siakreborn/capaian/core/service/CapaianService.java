package siakreborn.capaian.core;

import java.util.*;

public interface CapaianService {
  List<Capaian> saveCapaian(HashMap<String, Object> body);

  Capaian updateCapaian(HashMap<String, Object> body);

  Capaian getCapaian(UUID id);

  List<Capaian> getAllCapaian();

  List<Capaian> deleteCapaian(UUID id);

  List<HashMap<String, Object>> getCapaianKelas(UUID kelasId);

  List<HashMap<String, Object>> transformCapaianListToHashMap(List<Capaian> capaianList);
}
