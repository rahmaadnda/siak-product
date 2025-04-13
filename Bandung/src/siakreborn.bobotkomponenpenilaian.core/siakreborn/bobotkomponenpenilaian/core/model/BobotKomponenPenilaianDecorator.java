package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import siakreborn.komponenpenilaian.core.KomponenPenilaian;
import siakreborn.capaian.core.Capaian;

@MappedSuperclass
public abstract class BobotKomponenPenilaianDecorator extends BobotKomponenPenilaianComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected BobotKomponenPenilaianComponent record;

  public BobotKomponenPenilaianDecorator(BobotKomponenPenilaianComponent record, String objectName) {
    this.record = record;
    this.id = UUID.randomUUID();
    this.record.objectName = objectName;
  }

  public BobotKomponenPenilaianDecorator(UUID id, BobotKomponenPenilaianComponent record) {
    this.id = id;
    this.record = record;
  }

  public BobotKomponenPenilaianDecorator() {
    super();
    this.record = new BobotKomponenPenilaianImpl();
    this.id = UUID.randomUUID();
  }

  public BobotKomponenPenilaianComponent getRecord() {
    return this.record;
  }

  public void setRecord(BobotKomponenPenilaianComponent record) {
    this.record = record;
  }

  public double getBobot() {
    return record.getBobot();
  }

  public void setBobot(double bobot) {
    record.setBobot(bobot);
  }

  public KomponenPenilaian getKomponenPenilaian() {
    return this.record.getKomponenPenilaian();
  }

  public void setKomponenPenilaian(KomponenPenilaian komponenPenilaian) {
    this.record.setKomponenPenilaian(komponenPenilaian);
  }

  public Capaian getCPMK() {
    return this.record.getCPMK();
  }

  public void setCPMK(Capaian cpmk) {
    this.record.setCPMK(cpmk);
  }

  public Capaian getSubCPMK() {
    return this.record.getSubCPMK();
  }

  public void setSubCPMK(Capaian subCPMK) {
    this.record.setSubCPMK(subCPMK);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
