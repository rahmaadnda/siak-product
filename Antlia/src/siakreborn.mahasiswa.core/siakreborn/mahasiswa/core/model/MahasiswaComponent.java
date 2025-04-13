package siakreborn.mahasiswa.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToOne;

import siakreborn.util.core.*;
import siakreborn.programstudi.core.ProgramStudi;

@Entity(name = "mahasiswa_comp")
@Table(name = "mahasiswa_comp", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MahasiswaComponent implements Mahasiswa {
  @Id
  protected UUID id;
  protected String nama;
  protected String npm;
  protected String email;

  @ManyToOne(targetEntity = siakreborn.programstudi.core.ProgramStudiComponent.class)
  public ProgramStudi programStudi;
  protected int tahunAngkatan;
  protected String statusAkademik;
  protected boolean isPublic;

  protected String objectName = MahasiswaComponent.class.getName();

  public MahasiswaComponent() {

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

  public String getNpm() {
    return this.npm;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }
  
  public int getTahunAngkatan() {
    return this.tahunAngkatan;
  }

  public void setTahunAngkatan(int tahunAngkatan) {
    this.tahunAngkatan = tahunAngkatan;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ProgramStudi getProgramStudi() {
    return this.programStudi;
  }

  public void setProgramStudi(ProgramStudi programStudi) {
    this.programStudi = programStudi;
  }

  public String getStatusAkademik() {
    return this.statusAkademik;
  }

  public void setStatusAkademik(String statusAkademik) {
    this.statusAkademik = statusAkademik;
  }

  public boolean getIsPublic() {
    return this.isPublic;
  }

  public void setIsPublic(boolean isPublic) {
    this.isPublic = isPublic;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " nama='" + getNama() + "'" +
        " npm='" + getNpm() + "'" +
        " tahunAngkatan='" + getTahunAngkatan() + "'" +
        " email='" + getEmail() + "'" +
        " programStudi='" + getProgramStudi() + "'" +
        " statusAkademik='" + getStatusAkademik() + "'" +
        " isPublic='" + getIsPublic() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("nama", getNama());
    Map.put("name", getNama());
    Map.put("npm", getNpm());
    Map.put("tahunAngkatan", getTahunAngkatan());
    Map.put("email", getEmail());
    Map = Util.combine(Map, getProgramStudi().toHashMap(), "programStudi");
    Map.put("statusAkademik", getStatusAkademik());
    Map.put("isPublic", getIsPublic());
    Map.put("isPublicString", String.valueOf(getIsPublic()));

    return Map;
  }
}
