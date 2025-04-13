package siakreborn.penilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import siakreborn.komponenpenilaian.core.KomponenPenilaian;
import siakreborn.mahasiswa.core.Mahasiswa;

@MappedSuperclass
public abstract class PenilaianDecorator extends PenilaianComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected PenilaianComponent record;

  public PenilaianDecorator(PenilaianComponent record) {
    this.record = record;
    this.id = UUID.randomUUID();
  }

  public PenilaianDecorator(UUID id, PenilaianComponent record) {
    this.id = id;
    this.record = record;
  }

  public PenilaianDecorator() {
    super();
    this.record = new PenilaianImpl();
    this.id = UUID.randomUUID();
  }

  public PenilaianComponent getRecord() {
    return this.record;
  }

  public void setRecord(PenilaianComponent record) {
    this.record = record;
  }

  public Mahasiswa getMahasiswa() {
    return record.getMahasiswa();
  }

  public void setMahasiswa(Mahasiswa mahasiswa) {
    record.setMahasiswa(mahasiswa);
  }

  public int getNilai() {
    return record.getNilai();
  }

  public void setNilai(int nilai) {
    record.setNilai(nilai);
  }

  public KomponenPenilaian getKomponenPenilaian() {
    return this.record.getKomponenPenilaian();
  }

  public void setKomponenPenilaian(KomponenPenilaian komponenPenilaian) {
    this.record.setKomponenPenilaian(komponenPenilaian);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
