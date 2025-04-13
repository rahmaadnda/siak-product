package siakreborn.komponenpenilaian.core;

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

import siakreborn.kelas.core.*;

@Entity(name = "komponen_penilaian_impl")
@Table(name = "komponen_penilaian_impl")
public class KomponenPenilaianImpl extends KomponenPenilaianComponent {

  public KomponenPenilaianImpl(String nama, Kelas kelas, double bobot) {
    this.id = UUID.randomUUID();
    this.nama = nama;
    this.kelas = kelas;
    this.bobot = bobot;
    this.objectName = KomponenPenilaianImpl.class.getName();
  }

  public KomponenPenilaianImpl(UUID id, String nama, Kelas kelas, double bobot) {
    this.id = id;
    this.nama = nama;
    this.kelas = kelas;
    this.bobot = bobot;
    this.objectName = KomponenPenilaianImpl.class.getName();
  }

  public KomponenPenilaianImpl() {
    this.id = UUID.randomUUID();
    this.nama = "";
    this.bobot = 0;
    this.objectName = KomponenPenilaianImpl.class.getName();
  }

}
