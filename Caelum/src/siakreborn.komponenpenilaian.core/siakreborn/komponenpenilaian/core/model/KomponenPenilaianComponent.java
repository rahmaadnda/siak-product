package siakreborn.komponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.kelas.core.*;
import siakreborn.util.core.*;

@Entity(name = "komponen_penilaian_comp")
@Table(name = "komponen_penilaian_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KomponenPenilaianComponent implements KomponenPenilaian {
  @Id
  protected UUID id;
  protected String nama;
  @ManyToOne(targetEntity = siakreborn.kelas.core.KelasComponent.class)
  public Kelas kelas;
  protected double bobot;

  protected String objectName = KomponenPenilaianComponent.class.getName();

  public KomponenPenilaianComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNama() {
    return this.nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public Kelas getKelas() {
    return this.kelas;
  }

  public void setKelas(Kelas kelas) {
    this.kelas = kelas;
  }

  public double getBobot() {
    return this.bobot;
  }

  public void setBobot(double bobot) {
    this.bobot = bobot;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " nama='" + getNama() + "'" +
        " kelas='" + getKelas() + "'" +
        " bobot='" + getBobot() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("nama", getNama());
    Map.put("name", getNama());
    Map.put("bobot", getBobot());
    Map = Util.combine(Map, getKelas().toHashMap(), "kelas");

    return Map;
  }
}
