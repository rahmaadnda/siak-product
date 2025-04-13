package siakreborn.dosen.core;

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

@Entity(name = "dosen_impl")
@Table(name = "dosen_impl")
public class DosenImpl extends DosenComponent {

  public DosenImpl(String nama, String nip, String email) {
    this.id = UUID.randomUUID();
    this.nama = nama;
    this.nip = nip;
    this.email = email;
    this.objectName = DosenImpl.class.getName();
  }

  public DosenImpl(UUID id, String nama, String nip, String email) {
    this.id = UUID.randomUUID();
    this.nama = nama;
    this.nip = nip;
    this.email = email;
    this.objectName = DosenImpl.class.getName();
  }

  public DosenImpl() {
    this.id = UUID.randomUUID();
    this.nama = "";
    this.nip = "";
    this.email = "";
    this.objectName = DosenImpl.class.getName();
  }

}
