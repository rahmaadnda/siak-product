package siakreborn.pembayaran.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PembayaranResource {
  HashMap<String, Object> savePembayaran(VMJExchange vmjExchange);

  HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange);

  HashMap<String, Object> getPembayaran(VMJExchange vmjExchange);

  List<HashMap<String, Object>> getAllPembayaran(VMJExchange vmjExchange);

  List<HashMap<String, Object>> deletePembayaran(VMJExchange vmjExchange);
}
