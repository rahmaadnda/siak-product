package siakreborn.pembayaran.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PembayaranResourceComponent implements PembayaranResource {
  protected RepositoryUtil<Pembayaran> pembayaranRepository;

  public PembayaranResourceComponent() {
    this.pembayaranRepository = new RepositoryUtil<Pembayaran>(siakreborn.pembayaran.core.PembayaranComponent.class);
  }

  public abstract HashMap<String, Object> savePembayaran(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> updatePembayaran(VMJExchange vmjExchange);

  public abstract HashMap<String, Object> getPembayaran(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> getAllPembayaran(VMJExchange vmjExchange);

  public abstract List<HashMap<String, Object>> deletePembayaran(VMJExchange vmjExchange);

}
