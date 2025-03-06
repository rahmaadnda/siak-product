package siakreborn.capaian.core;

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

@Entity(name = "capaian_impl")
@Table(name = "capaian_impl")
public class CapaianImpl extends CapaianComponent {

  public CapaianImpl(UUID id, String kode, String deskripsi) {
    this.id = id;
    this.kode = kode;
    this.deskripsi = deskripsi;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(String kode, String deskripsi) {
    this.id = UUID.randomUUID();
    this.kode = kode;
    this.deskripsi = deskripsi;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl() {
    this.id = UUID.randomUUID();
    this.kode = "";
    this.deskripsi = "";
    this.objectName = CapaianImpl.class.getName();
  }

}
