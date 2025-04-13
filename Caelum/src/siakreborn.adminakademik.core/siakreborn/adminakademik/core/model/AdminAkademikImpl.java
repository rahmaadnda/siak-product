package siakreborn.adminakademik.core;

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

@Entity(name = "adminakademik_impl")
@Table(name = "adminakademik_impl")
public class AdminAkademikImpl extends AdminAkademikComponent {

  public AdminAkademikImpl(UUID id, String nama, String email) {
    this.id = id;
    this.nama = nama;
    this.email = email;
    this.objectName = AdminAkademikImpl.class.getName();
  }

  public AdminAkademikImpl(String nama, String email) {
    this.id = UUID.randomUUID();
    this.nama = nama;
    this.email = email;
    this.objectName = AdminAkademikImpl.class.getName();
  }

  public AdminAkademikImpl() {
    this.id = UUID.randomUUID();
    this.nama = "";
    this.email = "";
    this.objectName = AdminAkademikImpl.class.getName();
  }

}
