package siakreborn.subscriptionplan.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "subscriptionplan_comp")
@Table(name = "subscriptionplan_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SubscriptionPlanComponent implements SubscriptionPlan {
  @Id
  protected UUID id;
  protected String name;
  protected String deskripsi;
  protected int harga;

  protected String objectName = SubscriptionPlanComponent.class.getName();

  public SubscriptionPlanComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDeskripsi() {
    return this.deskripsi;
  }

  public void setDeskripsi(String deskripsi) {
    this.deskripsi = deskripsi;
  }
 
  public int getHarga() {
    return this.harga;
  }

  public void setHarga(int harga) {
    this.harga = harga;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " name='" + getName() + "'" +
        " deskripsi='" + getDeskripsi() + "'" +
        " harga='" + getHarga() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> subscriptionplanMap = new HashMap<String, Object>();
    subscriptionplanMap.put("id", getId());
    subscriptionplanMap.put("name", getName());
    subscriptionplanMap.put("deskripsi", getDeskripsi());
    subscriptionplanMap.put("harga", getHarga());

    return subscriptionplanMap;
  }
}
