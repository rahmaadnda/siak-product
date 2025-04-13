package siakreborn.penilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

import siakreborn.komponenpenilaian.core.*;
import siakreborn.mahasiswa.core.*;
import siakreborn.util.core.*;

@Entity(name = "penilaian_comp")
@Table(name = "penilaian_comp", uniqueConstraints = @UniqueConstraint(columnNames = { "komponenpenilaian_id",
    "mahasiswa_id" }))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PenilaianComponent implements Penilaian {
  @Id
  protected UUID id;
  protected int nilai;
  @ManyToOne(targetEntity = siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class)
  public KomponenPenilaian komponenPenilaian;
  @ManyToOne(targetEntity = siakreborn.mahasiswa.core.MahasiswaComponent.class)
  public Mahasiswa mahasiswa;

  protected String objectName = PenilaianComponent.class.getName();

  public PenilaianComponent() {

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

  public int getNilai() {
    return this.nilai;
  }

  public void setNilai(int nilai) {
    this.nilai = nilai;
  }

  public KomponenPenilaian getKomponenPenilaian() {
    return this.komponenPenilaian;
  }

  public void setKomponenPenilaian(KomponenPenilaian komponenPenilaian) {
    this.komponenPenilaian = komponenPenilaian;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " mahasiswa='" + getMahasiswa() + "'" +
        " nilai='" + getNilai() + "'" +
        " komponenPenilaian='" + getKomponenPenilaian() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("nilai", getNilai());
    Map = Util.combine(Map, getMahasiswa().toHashMap(), "mahasiswa");
    Map = Util.combine(Map, getKomponenPenilaian().toHashMap(), "komponenPenilaian");
    return Map;
  }
}
