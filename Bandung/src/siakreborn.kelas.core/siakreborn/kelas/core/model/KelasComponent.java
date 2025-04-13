package siakreborn.kelas.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.matakuliah.core.*;
import siakreborn.semester.core.*;
import siakreborn.util.core.*;

@Entity(name = "kelas_comp")
@Table(name = "kelas_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KelasComponent implements Kelas {
  @Id
  protected UUID id;
  protected String nama;
  protected int kapasitas;
  protected String ruangan;
  protected String jadwal;
  @ManyToOne(targetEntity = siakreborn.matakuliah.core.MataKuliahComponent.class)
  public MataKuliah mataKuliah;
  @ManyToOne(targetEntity = siakreborn.semester.core.SemesterComponent.class)
  public Semester semester;

  protected String objectName = KelasComponent.class.getName();

  public KelasComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNama() {
    return this.nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public int getKapasitas() {
    return this.kapasitas;
  }

  public void setKapasitas(int kapasitas) {
    this.kapasitas = kapasitas;
  }

  public String getRuangan() {
    return this.ruangan;
  }

  public void setRuangan(String ruangan) {
    this.ruangan = ruangan;
  }

  public String getJadwal() {
    return this.jadwal;
  }

  public void setJadwal(String jadwal) {
    this.jadwal = jadwal;
  }

  public MataKuliah getMataKuliah() {
    return this.mataKuliah;
  }

  public void setMataKuliah(MataKuliah mataKuliah) {
    this.mataKuliah = mataKuliah;
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
        " nama='" + getNama() + "'" +
        " kapasitas='" + getKapasitas() + "'" +
        " ruangan='" + getRuangan() + "'" +
        " jadwal='" + getJadwal() + "'" +
        " mataKuliah='" + getMataKuliah() + "'" +
        " semester='" + getSemester() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("nama", getNama());
    Map.put("name", getNama());
    Map.put("kapasitas", getKapasitas());
    Map.put("ruangan", getRuangan());
    Map.put("jadwal", getJadwal());
    Map = Util.combine(Map, getMataKuliah().toHashMap(), "mataKuliah");
    Map = Util.combine(Map, getSemester().toHashMap(), "semester");

    return Map;
  }
}
