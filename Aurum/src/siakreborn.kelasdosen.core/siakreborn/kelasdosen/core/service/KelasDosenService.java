package siakreborn.kelasdosen.core;

import java.util.*;

import siakreborn.dosen.core.Dosen;

public interface KelasDosenService {
  List<KelasDosen> saveKelasDosen(HashMap<String, Object> body);

  KelasDosen updateKelasDosen(HashMap<String, Object> body);

  KelasDosen getKelasDosen(UUID id);

  List<KelasDosen> getAllKelasDosen();

  HashMap<String, Object> getKelasWithDosen(UUID kelasId);

  List<HashMap<String, Object>> getRiwayatKelasDosen(UUID mahasiswaId);

  List<Dosen> filterDosenByKelas(UUID kelasId);

  List<KelasDosen> deleteKelasDosen(UUID id);

  List<HashMap<String, Object>> transformKelasDosenListToHashMap(List<KelasDosen> kelasDosenList);

  List<HashMap<String, Object>> transformDosenListToHashMap(List<Dosen> dosenList);
}
