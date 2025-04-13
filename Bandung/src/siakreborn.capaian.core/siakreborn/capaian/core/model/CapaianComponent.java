package siakreborn.capaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "capaian_comp")
@Table(name = "capaian_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CapaianComponent implements Capaian {
  @Id
  protected UUID id;
  protected String kode;
  protected String deskripsi;

  protected String objectName = CapaianComponent.class.getName();

  public CapaianComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getKode() {
    return this.kode;
  }

  public void setKode(String kode) {
    this.kode = kode;
  }

  public String getDeskripsi() {
    return this.deskripsi;
  }

  public void setDeskripsi(String deskripsi) {
    this.deskripsi = deskripsi;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " kode='" + getKode() + "'" +
        " deskripsi='" + getDeskripsi() + "'" +
        " name='" + getKode() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> capaianMap = new HashMap<String, Object>();
    capaianMap.put("id", getId());
    capaianMap.put("kode", getKode());
    capaianMap.put("name", getKode());
    capaianMap.put("deskripsi", getDeskripsi());

    return capaianMap;
  }
}
