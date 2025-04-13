package siakreborn.kelas.core;

import java.util.*;

public interface KelasService {
  List<Kelas> saveKelas(HashMap<String, Object> body);

  Kelas updateKelas(HashMap<String, Object> body);

  Kelas getKelas(UUID id);

  List<Kelas> getAllKelas();

  List<Kelas> filterKelasByMataKuliah(UUID mataKuliahId);

  List<Kelas> filterKelasBySemester(UUID semesterId);

  List<HashMap<String, Object>> groupKelasByMataKuliah();

  List<HashMap<String, Object>> mataKuliahGrouper(List<Kelas> kelasList);

  List<Kelas> deleteKelas(UUID id);

  List<HashMap<String, Object>> transformKelasListToHashMap(List<Kelas> kelasList);
}
