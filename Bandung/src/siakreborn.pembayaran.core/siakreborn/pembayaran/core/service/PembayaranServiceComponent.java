package siakreborn.pembayaran.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class PembayaranServiceComponent implements PembayaranService {
  protected RepositoryUtil<Pembayaran> pembayaranRepository;

  public PembayaranServiceComponent() {
    this.pembayaranRepository = new RepositoryUtil<Pembayaran>(siakreborn.pembayaran.core.PembayaranComponent.class);
  }

  public abstract Pembayaran savePembayaran(HashMap<String, Object> body);

  public abstract Pembayaran savePembayaranMe(UUID mahasiswaId, HashMap<String, Object> body);

  public abstract Pembayaran updatePembayaran(HashMap<String, Object> body);

  public abstract Pembayaran getPembayaran(UUID id);

  public abstract Pembayaran getPembayaranMe(UUID mahasiswaId);

  public abstract Pembayaran getPembayaran(UUID mahasiswaId, UUID semesterId);

  public abstract List<Pembayaran> getAllPembayaran();

  public abstract List<Pembayaran> deletePembayaran(UUID id);

  public abstract List<HashMap<String, Object>> transformPembayaranListToHashMap(List<Pembayaran> pembayaranList);
}
