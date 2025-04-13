package siakreborn.observer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "observer_comp")
@Table(name = "observer_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ObserverComponent implements Observer {
  @Id
  protected UUID id;
  protected String nama;
  protected String email;

  protected String objectName = ObserverComponent.class.getName();

  public ObserverComponent() {

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
    HashMap<String, Object> observerMap = new HashMap<String, Object>();
    observerMap.put("id", getId());
    observerMap.put("nama", getNama());
    observerMap.put("name", getNama());
    observerMap.put("email", getEmail());

    return observerMap;
  }
}
