package siakreborn.observer.industri;

import siakreborn.subscription.core.*;
import siakreborn.util.core.*;

import siakreborn.observer.core.ObserverDecorator;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverComponent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import java.util.*;

@Entity(name = "observer_industri")
@Table(name = "observer_industri")
public class ObserverImpl extends ObserverDecorator {

  @OneToOne(targetEntity = siakreborn.subscription.core.SubscriptionComponent.class)
  public Subscription subscription;

  public String websiteUrl;
  public String domain;
  public String alamat;
  public int tahunBerdiri;
  public int jumlahKaryawan;

  public static List<String> domainList = new ArrayList<>(
    Arrays.asList(
      "Teknologi",
      "Keuangan",
      "Kesehatan",
      "Pendidikan",
      "Manufaktur",
      "Ritel",
      "Perhotelan",
      "Transportasi",
      "Konstruksi",
      "Properti",
      "Media dan Hiburan",
      "Energi",
      "Telekomunikasi",
      "Pertanian",
      "Farmasi",
      "Otomotif",
      "Makanan dan Minuman",
      "Logistik",
      "Dirgantara",
      "Pertahanan",
      "Lainnya"
    )
  );


  public ObserverImpl() {
    super();
    this.websiteUrl = "";
    this.domain = "";
    this.alamat = "";
    this.tahunBerdiri = 0;
    this.jumlahKaryawan = 0;
    this.objectName = ObserverImpl.class.getName();
  }

  public ObserverImpl(Subscription subscription, String websiteUrl, String domain, String alamat, int tahunBerdiri, int jumlahKaryawan) {
    super();
    this.subscription = subscription;
    this.websiteUrl = websiteUrl;
    this.domain = domain;
    this.alamat = alamat;
    this.tahunBerdiri = tahunBerdiri;
    this.jumlahKaryawan = jumlahKaryawan;
    this.objectName = ObserverImpl.class.getName();
  }

  public ObserverImpl(ObserverComponent record, Subscription subscription, String websiteUrl, String domain, String alamat, int tahunBerdiri, int jumlahKaryawan) {
    super(record);
    this.subscription = subscription;
    this.websiteUrl = websiteUrl;
    this.domain = domain;
    this.alamat = alamat;
    this.tahunBerdiri = tahunBerdiri;
    this.jumlahKaryawan = jumlahKaryawan;
    this.objectName = ObserverImpl.class.getName();
  }

  public ObserverImpl(UUID id, ObserverComponent record, Subscription subscription, String websiteUrl, String domain, String alamat, int tahunBerdiri, int jumlahKaryawan) {
    super(id, record);
    this.subscription = subscription;
    this.websiteUrl = websiteUrl;
    this.domain = domain;
    this.alamat = alamat;
    this.tahunBerdiri = tahunBerdiri;
    this.jumlahKaryawan = jumlahKaryawan;
    this.objectName = ObserverImpl.class.getName();
  }

  public Subscription getSubscription() {
    return this.subscription;
  }

  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }

  public String getWebsiteUrl() {
    return this.websiteUrl;
  }

  public void setWebsiteUrl(String websiteUrl) {
    this.websiteUrl = websiteUrl;
  }

  public String getAlamat() {
    return this.alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public int getTahunBerdiri() {
    return this.tahunBerdiri;
  }

  public void setTahunBerdiri(int tahunBerdiri) {
    this.tahunBerdiri = tahunBerdiri;
  }

  public int getJumlahKaryawan() {
    return this.jumlahKaryawan;
  }

  public void setJumlahKaryawan(int jumlahKaryawan) {
    this.jumlahKaryawan = jumlahKaryawan;
  }

  public String getDomain() {
    return this.domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " record='" + getRecord() + "'" +
        " websiteUrl='" + getWebsiteUrl() + "'" +
        " domain='" + getDomain() + "'" +
        " subscription='" + getSubscription() + "'" +
        " alamat='" + getAlamat() + "'" +
        " tahunBerdiri='" + getTahunBerdiri() + "'" +
        " jumlahKaryawan='" + getJumlahKaryawan() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> observerMap = record.toHashMap();
    observerMap.put("id", this.getId());
    observerMap.put("websiteUrl", this.getWebsiteUrl());
    observerMap.put("domain", this.getDomain());
    observerMap.put("alamat", this.getAlamat());
    observerMap.put("tahunBerdiri", this.getTahunBerdiri());
    observerMap.put("jumlahKaryawan", this.getJumlahKaryawan());
    if (getSubscription() != null)
      observerMap = Util.combine(observerMap, getSubscription().toHashMap(), "subscription");
    return observerMap;
  }

}
