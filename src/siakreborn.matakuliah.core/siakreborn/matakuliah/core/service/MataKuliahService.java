package siakreborn.matakuliah.core;

import java.util.*;

public interface MataKuliahService {
  List<MataKuliah> saveMataKuliah(HashMap<String, Object> body);

  MataKuliah updateMataKuliah(HashMap<String, Object> body);

  MataKuliah getMataKuliah(UUID id);

  List<MataKuliah> getAllMataKuliah();

  List<MataKuliah> deleteMataKuliah(UUID id);

  List<HashMap<String, Object>> transformMataKuliahListToHashMap(List<MataKuliah> mataKuliahList);
}
