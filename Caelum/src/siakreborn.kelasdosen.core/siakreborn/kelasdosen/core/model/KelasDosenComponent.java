package siakreborn.kelasdosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.dosen.core.*;
import siakreborn.kelas.core.*;
import siakreborn.util.core.*;

@Entity(name = "kelas_dosen_comp")
@Table(name = "kelas_dosen_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KelasDosenComponent implements KelasDosen {
  @Id
  protected UUID id;
  @ManyToOne(targetEntity = siakreborn.dosen.core.DosenComponent.class)
  public Dosen dosen;
  @ManyToOne(targetEntity = siakreborn.kelas.core.KelasComponent.class)
  public Kelas kelas;

  protected String objectName = KelasDosenComponent.class.getName();

  public KelasDosenComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Dosen getDosen() {
    return this.dosen;
  }

  public void setDosen(Dosen dosen) {
    this.dosen = dosen;
  }

  public Kelas getKelas() {
    return this.kelas;
  }

  public void setKelas(Kelas kelas) {
    this.kelas = kelas;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " dosen='" + getDosen() + "'" +
        " kelas='" + getKelas() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map = Util.combine(Map, getDosen().toHashMap(), "dosen");
    Map = Util.combine(Map, getKelas().toHashMap(), "kelas");

    return Map;
  }
}
