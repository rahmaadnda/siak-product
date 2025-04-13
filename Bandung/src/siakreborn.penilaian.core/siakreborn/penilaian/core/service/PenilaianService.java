package siakreborn.penilaian.core;

import java.util.*;

public interface PenilaianService {
  List<Penilaian> savePenilaian(HashMap<String, Object> body);

  Penilaian updatePenilaian(HashMap<String, Object> body);

  Penilaian getPenilaian(UUID id);

  List<Penilaian> getAllPenilaian();

  List<Penilaian> filterPenilaian(String columnName, UUID id);

  List<Penilaian> filterPenilaianByMahasiswaAndKelas(UUID mahasiswaId, UUID kelasId);

  HashMap<String, Object> getPenilaianAkhir(UUID mahasiswaId, UUID kelasId);

  HashMap<String, Object> getPenilaianAkhirBulk(UUID mahasiswaId, List<UUID> kelasIdList);

  List<Penilaian> deletePenilaian(UUID id);

  List<HashMap<String, Object>> transformPenilaianListToHashMap(List<Penilaian> penilaianList);
}
