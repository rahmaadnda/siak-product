package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.komponenpenilaian.core.*;
import siakreborn.capaian.core.*;
import siakreborn.util.core.*;

@Entity(name = "bobot_komponen_penilaian_comp")
@Table(name = "bobot_komponen_penilaian_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BobotKomponenPenilaianComponent implements BobotKomponenPenilaian {
  @Id
  protected UUID id;
  protected double bobot;
  @ManyToOne(targetEntity = siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class)
  public KomponenPenilaian komponenPenilaian;
  @ManyToOne(targetEntity = siakreborn.capaian.core.CapaianComponent.class)
  public Capaian cpmk;
  @ManyToOne(targetEntity = siakreborn.capaian.core.CapaianComponent.class)
  public Capaian subCPMK;

  protected String objectName = BobotKomponenPenilaianComponent.class.getName();

  public BobotKomponenPenilaianComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public double getBobot() {
    return this.bobot;
  }

  public void setBobot(double bobot) {
    this.bobot = bobot;
  }

  public KomponenPenilaian getKomponenPenilaian() {
    return this.komponenPenilaian;
  }

  public void setKomponenPenilaian(KomponenPenilaian komponenPenilaian) {
    this.komponenPenilaian = komponenPenilaian;
  }

  public Capaian getCPMK() {
    return this.cpmk;
  }

  public void setCPMK(Capaian cpmk) {
    this.cpmk = cpmk;
  }

  public Capaian getSubCPMK() {
    return this.cpmk;
  }

  public void setSubCPMK(Capaian subCPMK) {
    this.subCPMK = subCPMK;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " bobot='" + getBobot() + "'" +
        " komponenPenilaian='" + getKomponenPenilaian() + "'" +
        " cpmk='" + getCPMK() + "'" +
        " subcpmk='" + getSubCPMK() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("bobot", getBobot());
    if (getKomponenPenilaian() != null)
      Map = Util.combine(Map, getKomponenPenilaian().toHashMap(), "komponenPenilaian");
    if (getCPMK() != null)
      Map = Util.combine(Map, getCPMK().toHashMap(), "cpmk");
    if (getSubCPMK() != null)
      Map = Util.combine(Map, getSubCPMK().toHashMap(), "subCPMK");
    return Map;
  }
}
