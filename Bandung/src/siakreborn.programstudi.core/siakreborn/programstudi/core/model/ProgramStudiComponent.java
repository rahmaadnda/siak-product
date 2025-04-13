package siakreborn.programstudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "program_studi_comp")
@Table(name = "program_studi_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProgramStudiComponent implements ProgramStudi {
  @Id
  protected UUID id;
  protected String kode;
  protected String noSK;
  protected String nama;
  protected String kaprodi;
  protected String jenjang;

  protected String objectName = ProgramStudiComponent.class.getName();

  public ProgramStudiComponent() {

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

  public String getNama() {
    return this.nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getKaprodi() {
    return this.kaprodi;
  }

  public void setKaprodi(String kaprodi) {
    this.kaprodi = kaprodi;
  }

  public String getJenjang() {
    return this.jenjang;
  }

  public void setJenjang(String jenjang) {
    this.jenjang = jenjang;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " kode='" + getKode() + "'" +
        " noSK='" + getNoSK() + "'" +
        " nama='" + getNama() + "'" +
        " kaprodi='" + getKaprodi() + "'" +
        " jenjang='" + getJenjang() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("kode", getKode());
    Map.put("noSK", getNoSK());
    Map.put("nama", getNama());
    Map.put("name", getNama());
    Map.put("kaprodi", getKaprodi());
    Map.put("jenjang", getJenjang());

    return Map;
  }
}
