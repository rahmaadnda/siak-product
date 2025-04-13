package siakreborn.rencanastudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.semester.core.Semester;

@MappedSuperclass
public abstract class PengisianRencanaStudiDecorator extends PengisianRencanaStudiComponent {
  protected PengisianRencanaStudiComponent record;

  public PengisianRencanaStudiDecorator(PengisianRencanaStudiComponent record) {
    this.record = record;
    this.id = UUID.randomUUID();
  }

  public PengisianRencanaStudiDecorator(UUID id, PengisianRencanaStudiComponent record) {
    this.id = id;
    this.record = record;
  }

  public PengisianRencanaStudiDecorator() {
    super();
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return record.getId();
  }

  public void setId(UUID id) {
    record.setId(id);
  }

  public Date getMulai() {
    return record.getMulai();
  }

  public void setMulai(Date mulai) {
    record.setMulai(mulai);
  }

  public Date getAkhir() {
    return record.getAkhir();
  }

  public void setAkhir(Date akhir) {
    record.setAkhir(akhir);
  }

  public Semester getSemester() {
    return record.getSemester();
  }

  public void setSemester(Semester semester) {
    record.setSemester(semester);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
