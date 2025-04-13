package siakreborn.subscriptionplan.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "subscriptionplan_impl")
@Table(name = "subscriptionplan_impl")
public class SubscriptionPlanImpl extends SubscriptionPlanComponent {

  public SubscriptionPlanImpl(UUID id, String name, String deskripsi, int harga) {
    this.id = id;
    this.name = name;
    this.deskripsi = deskripsi;
    this.harga = harga;
    this.objectName = SubscriptionPlanImpl.class.getName();
  }

  public SubscriptionPlanImpl(String name, String deskripsi, int harga) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.deskripsi = deskripsi;
    this.harga = harga;
    this.objectName = SubscriptionPlanImpl.class.getName();
  }

  public SubscriptionPlanImpl() {
    this.id = UUID.randomUUID();
    this.name = "";
    this.deskripsi = "";
    this.harga = 0;
    this.objectName = SubscriptionPlanImpl.class.getName();
  }

}
