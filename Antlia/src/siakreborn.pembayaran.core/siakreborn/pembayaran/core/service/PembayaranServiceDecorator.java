package siakreborn.pembayaran.core;

import java.util.*;

public abstract class PembayaranServiceDecorator extends PembayaranServiceComponent {
  protected PembayaranServiceComponent record;

  public PembayaranServiceDecorator(PembayaranServiceComponent record) {
    this.record = record;
  }

  public Pembayaran savePembayaran(HashMap<String, Object> body) {
    return record.savePembayaran(body);
  }

  public Pembayaran savePembayaranMe(UUID mahasiswaId, HashMap<String, Object> body) {
    return record.savePembayaranMe(mahasiswaId, body);
  }

  public Pembayaran updatePembayaran(HashMap<String, Object> body) {
    return record.updatePembayaran(body);
  }

  public Pembayaran getPembayaran(UUID id) {
    return record.getPembayaran(id);
  }

  public Pembayaran getPembayaranMe(UUID mahasiswaId) {
    return record.getPembayaran(mahasiswaId);
  }

  public Pembayaran getPembayaran(UUID mahasiswaId, UUID semesterId) {
    return record.getPembayaran(mahasiswaId, semesterId);
  }

  public List<Pembayaran> deletePembayaran(UUID id) {
    return record.deletePembayaran(id);
  }

  public List<HashMap<String, Object>> transformPembayaranListToHashMap(List<Pembayaran> pembayaranList) {
    return record.transformPembayaranListToHashMap(pembayaranList);
  }
}
