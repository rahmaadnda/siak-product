package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;

public interface BobotKomponenPenilaianService {
  List<BobotKomponenPenilaian> saveBobotKomponenPenilaian(HashMap<String, Object> body);

  BobotKomponenPenilaian updateBobotKomponenPenilaian(HashMap<String, Object> body);

  BobotKomponenPenilaian getBobotKomponenPenilaian(UUID id);

  List<BobotKomponenPenilaian> getAllBobotKomponenPenilaian();

  List<BobotKomponenPenilaian> deleteBobotKomponenPenilaian(UUID id);

  HashMap<String, Object> getKomponenPenilaianKelasMapping(UUID kelasId);

  List<HashMap<String, Object>> transformBobotKomponenPenilaianListToHashMap(
      List<BobotKomponenPenilaian> bobotKomponenPenilaianList);
}
