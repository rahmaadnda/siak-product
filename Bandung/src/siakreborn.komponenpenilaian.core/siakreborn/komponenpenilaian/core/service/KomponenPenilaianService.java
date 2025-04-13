package siakreborn.komponenpenilaian.core;

import java.util.*;

public interface KomponenPenilaianService {
  List<KomponenPenilaian> saveKomponenPenilaian(HashMap<String, Object> body);

  KomponenPenilaian updateKomponenPenilaian(HashMap<String, Object> body);

  KomponenPenilaian getKomponenPenilaian(UUID id);

  List<KomponenPenilaian> getAllKomponenPenilaian();

  List<KomponenPenilaian> filterKomponenPenilaianByKelas(UUID kelasId);

  List<KomponenPenilaian> deleteKomponenPenilaian(UUID id);

  List<HashMap<String, Object>> transformKomponenPenilaianListToHashMap(
      List<KomponenPenilaian> komponenPenilaianList);
}
