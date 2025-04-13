package siakreborn.rencanastudi.core;

import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;

public interface KelasMahasiswaService {
  List<KelasMahasiswa> saveKelasMahasiswa(HashMap<String, Object> body);

  KelasMahasiswa updateKelasMahasiswa(HashMap<String, Object> body);

  KelasMahasiswa getKelasMahasiswa(UUID id);

  List<KelasMahasiswa> getAllKelasMahasiswa();

  List<KelasMahasiswa> filterKelasMahasiswa(String columnName, UUID id);

  List<Mahasiswa> filterMahasiswaByKelas(UUID kelasId);

  List<KelasMahasiswa> deleteKelasMahasiswa(UUID id);

  List<HashMap<String, Object>> getRiwayatKelasMahasiswa(UUID mahasiswaId, String by);

  List<HashMap<String, Object>> transformKelasMahasiswaListToHashMap(
      List<KelasMahasiswa> kelasMahasiswaList);

  List<HashMap<String, Object>> transformMahasiswaListToHashMap(
      List<Mahasiswa> mahasiswaList);
}
