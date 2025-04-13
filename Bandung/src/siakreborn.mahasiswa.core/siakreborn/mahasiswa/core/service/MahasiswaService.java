package siakreborn.mahasiswa.core;

import java.util.*;

public interface MahasiswaService {
  List<Mahasiswa> saveMahasiswa(HashMap<String, Object> body);

  Mahasiswa updateMahasiswa(HashMap<String, Object> body);

  Mahasiswa getMahasiswa(UUID id);

  Mahasiswa getMahasiswaByEmail(String email);

  List<Mahasiswa> getAllMahasiswa();

  List<Mahasiswa> getNotGraduated();

  List<Mahasiswa> getAllMahasiswaPublic();

  List<Mahasiswa> deleteMahasiswa(UUID id);

  List<HashMap<String, Object>> transformMahasiswaListToHashMap(List<Mahasiswa> mahasiswaList);

  Mahasiswa verify(HashMap<String, Object> body);

  Mahasiswa graduate(UUID id);

  List<HashMap<String, Object>> getAllAngkatan();

}
