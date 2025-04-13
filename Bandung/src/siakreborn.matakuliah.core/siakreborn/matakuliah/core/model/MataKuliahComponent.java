package siakreborn.matakuliah.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.kurikulum.core.*;
import siakreborn.util.core.*;

@Entity(name = "mata_kuliah_comp")
@Table(name = "mata_kuliah_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MataKuliahComponent implements MataKuliah {
  @Id
  protected UUID id;
  protected String kode;
  protected String nama;
  protected int sks;
  protected int term;
  @ManyToOne(targetEntity = siakreborn.kurikulum.core.KurikulumComponent.class)
  public Kurikulum kurikulum;

  protected String objectName = MataKuliahComponent.class.getName();

  public MataKuliahComponent() {

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

  public String getNama() {
    return this.nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public int getSks() {
    return this.sks;
  }

  public void setSks(int sks) {
    this.sks = sks;
  }

  public int getTerm() {
    return this.term;
  }

  public void setTerm(int term) {
    this.term = term;
  }

  public Kurikulum getKurikulum() {
    return this.kurikulum;
  }

  public void setKurikulum(Kurikulum kurikulum) {
    this.kurikulum = kurikulum;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " kode='" + getKode() + "'" +
        " nama='" + getNama() + "'" +
        " sks='" + getSks() + "'" +
        " term='" + getTerm() + "'" +
        " kurikulum='" + getKurikulum() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("kode", getKode());
    Map.put("nama", getNama());
    Map.put("name", getNama());
    Map.put("sks", getSks());
    Map.put("term", getTerm());
    Map = Util.combine(Map, getKurikulum().toHashMap(), "kurikulum");

    return Map;
  }
}
