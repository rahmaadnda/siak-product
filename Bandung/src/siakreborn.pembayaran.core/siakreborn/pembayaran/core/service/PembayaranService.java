package siakreborn.pembayaran.core;

import java.util.*;

public interface PembayaranService {
  Pembayaran savePembayaran(HashMap<String, Object> body);

  Pembayaran savePembayaranMe(UUID mahasiswaId, HashMap<String, Object> body);

  Pembayaran updatePembayaran(HashMap<String, Object> body);

  Pembayaran getPembayaran(UUID id);

  Pembayaran getPembayaranMe(UUID mahasiswaId);

  Pembayaran getPembayaran(UUID mahasiswaId, UUID semesterId);

  List<Pembayaran> getAllPembayaran();

  List<Pembayaran> deletePembayaran(UUID id);

  List<HashMap<String, Object>> transformPembayaranListToHashMap(List<Pembayaran> pembayaranList);
}
