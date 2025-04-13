package siakreborn.observer.core;

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

@Entity(name = "observer_impl")
@Table(name = "observer_impl")
public class ObserverImpl extends ObserverComponent {

  public ObserverImpl(UUID id, String nama, String email) {
    this.id = id;
    this.nama = nama;
    this.email = email;
    this.objectName = ObserverImpl.class.getName();
  }

  public ObserverImpl(String nama, String email) {
    this.id = UUID.randomUUID();
    this.nama = nama;
    this.email = email;
    this.objectName = ObserverImpl.class.getName();
  }

  public ObserverImpl() {
    this.id = UUID.randomUUID();
    this.nama = "";
    this.email = "";
    this.objectName = ObserverImpl.class.getName();
  }

}
