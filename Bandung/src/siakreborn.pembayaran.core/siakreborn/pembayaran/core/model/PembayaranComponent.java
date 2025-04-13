package siakreborn.pembayaran.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;
import siakreborn.util.core.*;

@Entity(name = "pembayaran_comp")
@Table(name = "pembayaran_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PembayaranComponent implements Pembayaran {
  @Id
  protected UUID id;
  protected String paymentId;
  @ManyToOne(targetEntity = siakreborn.mahasiswa.core.MahasiswaComponent.class)
  public Mahasiswa mahasiswa;
  @ManyToOne(targetEntity = siakreborn.semester.core.SemesterComponent.class)
  public Semester semester;
  public String status;
  public String paymentLink;
  public String vendor;

  protected String objectName = PembayaranComponent.class.getName();

  public PembayaranComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Mahasiswa getMahasiswa() {
    return this.mahasiswa;
  }

  public void setMahasiswa(Mahasiswa mahasiswa) {
    this.mahasiswa = mahasiswa;
  }

  public Semester getSemester() {
    return this.semester;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  public String getPaymentId() {
    return this.paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPaymentLink() {
    return this.paymentLink;
  }

  public void setPaymentLink(String paymentLink) {
    this.paymentLink = paymentLink;
  }

  public String getVendor() {
    return this.vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " mahasiswa='" + getMahasiswa() + "'" +
        " semester='" + getSemester() + "'" +
        " paymentId='" + getPaymentId() + "'" +
        " status='" + getStatus() + "'" +
        " paymentLink='" + getPaymentLink() + "'" +
        " vendor='" + getVendor() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> pembayaranMap = new HashMap<String, Object>();
    pembayaranMap.put("id", getId());
    pembayaranMap = Util.combine(pembayaranMap, this.getMahasiswa().toHashMap(), "mahasiswa");
    pembayaranMap = Util.combine(pembayaranMap, this.getSemester().toHashMap(), "semester");
    pembayaranMap.put("paymentId", getPaymentId());
    pembayaranMap.put("status", getStatus());
    pembayaranMap.put("paymentLink", getPaymentLink());
    pembayaranMap.put("vendor", getVendor());

    return pembayaranMap;
  }
}
