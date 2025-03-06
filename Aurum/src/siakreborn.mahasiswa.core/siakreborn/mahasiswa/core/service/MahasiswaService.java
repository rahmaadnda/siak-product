package siakreborn.mahasiswa.core;

import java.util.*;

public interface MahasiswaService {
  List<Mahasiswa> saveMahasiswa(HashMap<String, Object> body);

  Mahasiswa updateMahasiswa(HashMap<String, Object> body);

  Mahasiswa getMahasiswa(UUID id);

  Mahasiswa getMahasiswaByEmail(String email);

  List<Mahasiswa> getAllMahasiswa();

  List<Mahasiswa> deleteMahasiswa(UUID id);

  List<HashMap<String, Object>> transformMahasiswaListToHashMap(List<Mahasiswa> mahasiswaList);
}
