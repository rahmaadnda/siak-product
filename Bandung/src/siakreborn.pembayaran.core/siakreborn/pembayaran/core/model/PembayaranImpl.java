package siakreborn.pembayaran.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;

@Entity(name = "pembayaran_impl")
@Table(name = "pembayaran_impl")
public class PembayaranImpl extends PembayaranComponent {

  public PembayaranImpl(UUID id, Mahasiswa mahasiswa, Semester semester, String paymentId, String status,
      String paymentLink, String vendor) {
    this.id = id;
    this.mahasiswa = mahasiswa;
    this.semester = semester;
    this.paymentId = paymentId;
    this.status = status;
    this.paymentLink = paymentLink;
    this.vendor = vendor;
  }

  public PembayaranImpl(Mahasiswa mahasiswa, Semester semester, String paymentId, String status, String paymentLink,
      String vendor) {
    this.id = UUID.randomUUID();
    this.mahasiswa = mahasiswa;
    this.semester = semester;
    this.paymentId = paymentId;
    this.status = status;
    this.paymentLink = paymentLink;
    this.vendor = vendor;
  }

  public PembayaranImpl() {
    this.id = UUID.randomUUID();
  }

}
