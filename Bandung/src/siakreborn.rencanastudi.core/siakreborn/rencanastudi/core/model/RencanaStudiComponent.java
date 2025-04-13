package siakreborn.rencanastudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;
import siakreborn.util.core.*;

@Entity(name = "rencana_studi_comp")
@Table(name = "rencana_studi_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RencanaStudiComponent implements RencanaStudi {
  @Id
  protected UUID id;
  @ManyToOne(targetEntity = siakreborn.mahasiswa.core.MahasiswaComponent.class)
  public Mahasiswa mahasiswa;
  @ManyToOne(targetEntity = siakreborn.semester.core.SemesterComponent.class)
  public Semester semester;
  protected int totalSKS;
  protected String status;

  protected String objectName = RencanaStudiComponent.class.getName();

  public RencanaStudiComponent() {

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

  public Semester getSemester() {
    return this.semester;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  public int getTotalSKS() {
    return this.totalSKS;
  }

  public void setTotalSKS(int totalSKS) {
    this.totalSKS = totalSKS;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " mahasiswa='" + getMahasiswa() + "'" +
        " semester='" + getSemester() + "'" +
        " totalSKS='" + getTotalSKS() + "'" +
        " status='" + getStatus() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> rencanastudiMap = new HashMap<String, Object>();
    rencanastudiMap.put("id", getId());
    rencanastudiMap.put("totalSKS", getTotalSKS());
    rencanastudiMap.put("status", getStatus());
    rencanastudiMap = Util.combine(rencanastudiMap, getMahasiswa().toHashMap(), "mahasiswa");
    rencanastudiMap = Util.combine(rencanastudiMap, getSemester().toHashMap(), "semester");

    return rencanastudiMap;
  }
}
