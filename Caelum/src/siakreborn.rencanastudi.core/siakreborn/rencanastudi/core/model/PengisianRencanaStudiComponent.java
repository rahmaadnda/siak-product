package siakreborn.rencanastudi.core;

import java.util.*;
import java.time.format.DateTimeFormatter;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import siakreborn.semester.core.Semester;
import siakreborn.util.core.*;

@Entity(name = "pengisian_rencana_studi_comp")
@Table(name = "pengisian_rencana_studi_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PengisianRencanaStudiComponent implements PengisianRencanaStudi {
  @Id
  protected UUID id;

  protected Date mulai;

  protected Date akhir;

  @OneToOne(targetEntity = siakreborn.semester.core.SemesterComponent.class)
  protected Semester semester;

  protected String objectName = PengisianRencanaStudiComponent.class.getName();

  public PengisianRencanaStudiComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Date getMulai() {
    return this.mulai;
  }

  public void setMulai(Date mulai) {
    this.mulai = mulai;
  }

  public Date getAkhir() {
    return this.akhir;
  }

  public void setAkhir(Date akhir) {
    this.akhir = akhir;
  }

  public Semester getSemester() {
    return this.semester;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " mulai='" + getMulai() + "'" +
        " akhir='" + getAkhir() + "'" +
        " semester='" + getSemester() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> pengisianrencanastudiMap = new HashMap<String, Object>();
    pengisianrencanastudiMap.put("id", getId());
    if (getMulai() != null)
      pengisianrencanastudiMap.put("mulai", DateTimeFormatter.ISO_INSTANT.format(getMulai().toInstant()));
    if (getAkhir() != null)
      pengisianrencanastudiMap.put("akhir", DateTimeFormatter.ISO_INSTANT.format(getAkhir().toInstant()));
    pengisianrencanastudiMap = Util.combine(pengisianrencanastudiMap, getSemester().toHashMap(), "semester");

    return pengisianrencanastudiMap;
  }
}
