package siakreborn.kurikulum.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.programstudi.core.*;
import siakreborn.util.core.*;

@Entity(name = "kurikulum_comp")
@Table(name = "kurikulum_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KurikulumComponent implements Kurikulum {
  @Id
  protected UUID id;
  protected String kode;
  protected String noSK;
  protected String status;
  protected String profilLulusan;
  @ManyToOne(targetEntity = siakreborn.programstudi.core.ProgramStudiComponent.class)
  public ProgramStudi programStudi;

  protected String objectName = KurikulumComponent.class.getName();

  public KurikulumComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getKode() {
    return this.kode;
  }

  public void setKode(String kode) {
    this.kode = kode;
  }

  public String getNoSK() {
    return this.noSK;
  }

  public void setNoSK(String noSK) {
    this.noSK = noSK;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getProfilLulusan() {
    return this.profilLulusan;
  }

  public void setProfilLulusan(String profilLulusan) {
    this.profilLulusan = profilLulusan;
  }

  public ProgramStudi getProgramStudi() {
    return this.programStudi;
  }

  public void setProgramStudi(ProgramStudi programStudi) {
    this.programStudi = programStudi;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " kode='" + getKode() + "'" +
        " noSK='" + getNoSK() + "'" +
        " status='" + getStatus() + "'" +
        " profilLulusan='" + getProfilLulusan() + "'" +
        " programStudi='" + getProgramStudi() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("kode", getKode());
    Map.put("noSK", getNoSK());
    Map.put("status", getStatus());
    Map.put("profilLulusan", getProfilLulusan());
    Map.put("name", getKode() + " " + getNoSK());
    Map = Util.combine(Map, getProgramStudi().toHashMap(), "programStudi");

    return Map;
  }
}
