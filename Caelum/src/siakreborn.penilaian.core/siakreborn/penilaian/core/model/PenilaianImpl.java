package siakreborn.penilaian.core;

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

import siakreborn.komponenpenilaian.core.*;
import siakreborn.mahasiswa.core.*;

@Entity(name = "penilaian_impl")
@Table(name = "penilaian_impl")
public class PenilaianImpl extends PenilaianComponent {

  public PenilaianImpl(Mahasiswa mahasiswa, int nilai, KomponenPenilaian komponenPenilaian) {
    this.id = UUID.randomUUID();
    this.mahasiswa = mahasiswa;
    this.nilai = nilai;
    this.komponenPenilaian = komponenPenilaian;
    this.objectName = PenilaianImpl.class.getName();
  }

  public PenilaianImpl(UUID id, Mahasiswa mahasiswa, int nilai, KomponenPenilaian komponenPenilaian) {
    this.id = id;
    this.mahasiswa = mahasiswa;
    this.nilai = nilai;
    this.komponenPenilaian = komponenPenilaian;
    this.objectName = PenilaianImpl.class.getName();
  }

  public PenilaianImpl() {
    this.id = UUID.randomUUID();
    this.nilai = 0;
    this.objectName = PenilaianImpl.class.getName();
  }

}
