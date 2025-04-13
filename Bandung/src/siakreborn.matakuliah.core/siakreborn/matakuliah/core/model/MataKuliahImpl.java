package siakreborn.matakuliah.core;

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

import siakreborn.kurikulum.core.*;

@Entity(name = "mata_kuliah_impl")
@Table(name = "mata_kuliah_impl")
public class MataKuliahImpl extends MataKuliahComponent {

  public MataKuliahImpl(String kode, String nama, int sks, int term, Kurikulum kurikulum) {
    this.id = UUID.randomUUID();
    this.kode = kode;
    this.nama = nama;
    this.sks = sks;
    this.term = term;
    this.kurikulum = kurikulum;
    this.objectName = MataKuliahImpl.class.getName();
  }

  public MataKuliahImpl(UUID id, String kode, String nama, int sks, int term, Kurikulum kurikulum) {
    this.id = id;
    this.kode = kode;
    this.nama = nama;
    this.sks = sks;
    this.term = term;
    this.kurikulum = kurikulum;
    this.objectName = MataKuliahImpl.class.getName();
  }

  public MataKuliahImpl() {
    this.id = UUID.randomUUID();
    this.kode = "";
    this.nama = "";
    this.sks = 0;
    this.term = 0;
    this.objectName = MataKuliahImpl.class.getName();
  }

}
