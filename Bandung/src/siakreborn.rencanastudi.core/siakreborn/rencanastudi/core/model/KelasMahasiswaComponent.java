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
import javax.persistence.ManyToOne;

import siakreborn.kelas.core.*;
import siakreborn.util.core.*;

@Entity(name = "kelas_mahasiswa_comp")
@Table(name = "kelas_mahasiswa_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KelasMahasiswaComponent implements KelasMahasiswa {
  @Id
  protected UUID id;
  @ManyToOne(targetEntity = siakreborn.rencanastudi.core.RencanaStudiComponent.class)
  public RencanaStudi rencanaStudi;
  @ManyToOne(targetEntity = siakreborn.kelas.core.KelasComponent.class)
  public Kelas kelas;

  public Date tanggalPengisian;

  protected String objectName = KelasMahasiswaComponent.class.getName();

  public KelasMahasiswaComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public RencanaStudi getRencanaStudi() {
    return this.rencanaStudi;
  }

  public void setRencanaStudi(RencanaStudi rencanaStudi) {
    this.rencanaStudi = rencanaStudi;
  }

  public Kelas getKelas() {
    return this.kelas;
  }

  public void setKelas(Kelas kelas) {
    this.kelas = kelas;
  }

  public Date getTanggalPengisian() {
    return this.tanggalPengisian;
  }

  public void setTanggalPengisian(Date tanggalPengisian) {
    this.tanggalPengisian = tanggalPengisian;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " tanggalPengisian='" + getTanggalPengisian() + "'" +
        " rencanaStudi='" + getRencanaStudi() + "'" +
        " kelas='" + getKelas() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("tanggalPengisian", DateTimeFormatter.ISO_INSTANT.format(getTanggalPengisian().toInstant()));
    Map = Util.combine(Map, getRencanaStudi().toHashMap(), "rencanaStudi");
    Map = Util.combine(Map, getKelas().toHashMap(), "kelas");

    return Map;
  }
}
