package siakreborn.komponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import siakreborn.kelas.core.Kelas;

@MappedSuperclass
public abstract class KomponenPenilaianDecorator extends KomponenPenilaianComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected KomponenPenilaianComponent record;

  public KomponenPenilaianDecorator(KomponenPenilaianComponent record, String objectName) {
    this.record = record;
    this.id = UUID.randomUUID();
    this.record.objectName = objectName;
  }

  public KomponenPenilaianDecorator(UUID id, KomponenPenilaianComponent record) {
    this.id = id;
    this.record = record;
  }

  public KomponenPenilaianDecorator() {
    super();
    this.record = new KomponenPenilaianImpl();
    this.id = UUID.randomUUID();
  }

  public KomponenPenilaianComponent getRecord() {
    return this.record;
  }

  public void setRecord(KomponenPenilaianComponent record) {
    this.record = record;
  }

  public String getNama() {
    return record.getNama();
  }

  public void setNama(String nama) {
    record.setNama(nama);
  }

  public Kelas getKelas() {
    return this.record.getKelas();
  }

  public void setKelas(Kelas kelas) {
    this.record.setKelas(kelas);
  }

  public double getBobot() {
    return record.getBobot();
  }

  public void setBobot(double bobot) {
    record.setBobot(bobot);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
