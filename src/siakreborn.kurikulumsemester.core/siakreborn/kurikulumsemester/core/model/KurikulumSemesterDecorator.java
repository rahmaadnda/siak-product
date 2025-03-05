package siakreborn.kurikulumsemester.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.kurikulum.core.Kurikulum;
import siakreborn.semester.core.Semester;

@MappedSuperclass
public abstract class KurikulumSemesterDecorator extends KurikulumSemesterComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected KurikulumSemesterComponent record;

  public KurikulumSemesterDecorator(KurikulumSemesterComponent record, String objectName) {
    this.record = record;
    this.id = UUID.randomUUID();
    this.record.objectName = objectName;
  }

  public KurikulumSemesterDecorator(UUID id, KurikulumSemesterComponent record) {
    this.id = id;
    this.record = record;
  }

  public KurikulumSemesterDecorator() {
    super();
    this.record = new KurikulumSemesterImpl();
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return record.getId();
  }

  public void setId(UUID id) {
    record.setId(id);
  }

  public KurikulumSemesterComponent getRecord() {
    return this.record;
  }

  public void setRecord(KurikulumSemesterComponent record) {
    this.record = record;
  }

  public Kurikulum getKurikulum() {
    return this.record.getKurikulum();
  }

  public void setKurikulum(Kurikulum kurikulum) {
    this.record.setKurikulum(kurikulum);
  }

  public Semester getSemester() {
    return this.record.getSemester();
  }

  public void setSemester(Semester semester) {
    this.record.setSemester(semester);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
