package siakreborn.rencanastudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.kelas.core.Kelas;

@MappedSuperclass
public abstract class KelasMahasiswaDecorator extends KelasMahasiswaComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected KelasMahasiswaComponent record;

  public KelasMahasiswaDecorator(KelasMahasiswaComponent record, String objectName) {
    this.record = record;
    this.id = UUID.randomUUID();
    this.record.objectName = objectName;
  }

  public KelasMahasiswaDecorator(UUID id, KelasMahasiswaComponent record) {
    this.id = id;
    this.record = record;
  }

  public KelasMahasiswaDecorator() {
    super();
    this.record = new KelasMahasiswaImpl();
    this.id = UUID.randomUUID();
  }

  public KelasMahasiswaComponent getRecord() {
    return this.record;
  }

  public void setRecord(KelasMahasiswaComponent record) {
    this.record = record;
  }

  public RencanaStudi getRencanaStudi() {
    return this.record.getRencanaStudi();
  }

  public void setRencanaStudi(RencanaStudi rencanaStudi) {
    this.record.setRencanaStudi(rencanaStudi);
  }

  public Kelas getKelas() {
    return this.record.getKelas();
  }

  public void setKelas(Kelas kelas) {
    this.record.setKelas(kelas);
  }

  public Date getTanggalPengisian() {
    return this.record.getTanggalPengisian();
  }

  public void setTanggalPengisian(Date tanggalPengisian) {
    this.record.setTanggalPengisian(tanggalPengisian);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
