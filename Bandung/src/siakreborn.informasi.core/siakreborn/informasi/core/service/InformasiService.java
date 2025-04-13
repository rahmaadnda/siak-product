package siakreborn.informasi.core;

import java.util.*;

public interface InformasiService {
  List<Informasi> saveInformasi(HashMap<String, Object> body);

  Informasi updateInformasi(HashMap<String, Object> body);

  Informasi getInformasi(UUID id);

  List<Informasi> getAllInformasi();

  List<Informasi> deleteInformasi(UUID id);

  List<HashMap<String, Object>> transformInformasiListToHashMap(List<Informasi> informasiList);
}
