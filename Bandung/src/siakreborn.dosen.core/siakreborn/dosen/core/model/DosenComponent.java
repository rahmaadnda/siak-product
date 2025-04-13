package siakreborn.dosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "dosen_comp")
@Table(name = "dosen_comp", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DosenComponent implements Dosen {
  @Id
  protected UUID id;
  protected String nama;
  protected String nip;
  protected String email;

  protected String objectName = DosenComponent.class.getName();

  public DosenComponent() {

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

  public String getNip() {
    return this.nip;
  }

  public void setNip(String nip) {
    this.nip = nip;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " nama='" + getNama() + "'" +
        " nip='" + getNip() + "'" +
        " email='" + getEmail() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map.put("nama", getNama());
    Map.put("nip", getNip());
    Map.put("email", getEmail());

    return Map;
  }
}
