package siakreborn.adminakademik.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "adminakademik_comp")
@Table(name = "adminakademik_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AdminAkademikComponent implements AdminAkademik {
  @Id
  protected UUID id;
  protected String nama;
  protected String email;

  protected String objectName = AdminAkademikComponent.class.getName();

  public AdminAkademikComponent() {

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
        " email='" + getEmail() + "'" +
        " name='" + getNama() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> adminAkademikMap = new HashMap<String, Object>();
    adminAkademikMap.put("id", getId());
    adminAkademikMap.put("nama", getNama());
    adminAkademikMap.put("name", getNama());
    adminAkademikMap.put("email", getEmail());

    return adminAkademikMap;
  }
}
