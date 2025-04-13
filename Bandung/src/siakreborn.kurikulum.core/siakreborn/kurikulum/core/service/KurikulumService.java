package siakreborn.kurikulum.core;

import java.util.*;

public interface KurikulumService {
  List<Kurikulum> saveKurikulum(HashMap<String, Object> body);

  Kurikulum updateKurikulum(HashMap<String, Object> body);

  Kurikulum getKurikulum(UUID id);

  List<Kurikulum> getAllKurikulum();

  List<Kurikulum> filterKurikulumByProgramStudi(UUID programStudiId);

  List<Kurikulum> deleteKurikulum(UUID id);

  List<HashMap<String, Object>> transformKurikulumListToHashMap(List<Kurikulum> kurikulumList);
}
