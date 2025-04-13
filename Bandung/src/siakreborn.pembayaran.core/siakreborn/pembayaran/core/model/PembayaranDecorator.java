package siakreborn.pembayaran.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;

@MappedSuperclass
public abstract class PembayaranDecorator extends PembayaranComponent {
  protected PembayaranComponent record;

  public PembayaranDecorator(PembayaranComponent record) {
    this.record = record;
    this.id = UUID.randomUUID();
  }

  public PembayaranDecorator(UUID id, PembayaranComponent record) {
    this.id = id;
    this.record = record;
  }

  public PembayaranDecorator() {
    super();
    this.record = new PembayaranImpl();
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return record.getId();
  }

  public void setId(UUID id) {
    record.setId(id);
  }

  public String getPaymentId() {
    return record.getPaymentId();
  }

  public void setPaymentId(String paymentId) {
    record.setPaymentId(paymentId);
  }

  public String getStatus() {
    return record.getStatus();
  }

  public void setStatus(String status) {
    record.setStatus(status);
  }

  public String getPaymentLink() {
    return record.getPaymentLink();
  }

  public void setPaymentLink(String paymentLink) {
    record.setPaymentLink(paymentLink);
  }

  public String getVendor() {
    return record.getVendor();
  }

  public void setVendor(String vendor) {
    record.setVendor(vendor);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
