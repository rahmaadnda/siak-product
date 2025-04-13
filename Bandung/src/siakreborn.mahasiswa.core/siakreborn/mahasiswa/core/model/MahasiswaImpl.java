package siakreborn.mahasiswa.core;

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

import siakreborn.programstudi.core.ProgramStudi;

@Entity(name = "mahasiswa_impl")
@Table(name = "mahasiswa_impl")
public class MahasiswaImpl extends MahasiswaComponent {

  public MahasiswaImpl(String nama, String npm, int tahunAngkatan, String email, ProgramStudi programStudi, String statusAkademik) {
    this.id = UUID.randomUUID();
    this.nama = nama;
    this.npm = npm;
    this.tahunAngkatan = tahunAngkatan;
    this.email = email;
    this.programStudi = programStudi;
    this.statusAkademik = statusAkademik;
    this.isPublic = false;
    this.objectName = MahasiswaImpl.class.getName();
  }

  public MahasiswaImpl(UUID id, String nama, String npm, int tahunAngkatan, String email, ProgramStudi programStudi, String statusAkademik) {
    this.id = id;
    this.nama = nama;
    this.npm = npm;
    this.tahunAngkatan = tahunAngkatan;
    this.email = email;
    this.programStudi = programStudi;
    this.statusAkademik = statusAkademik;
    this.isPublic = false;
    this.objectName = MahasiswaImpl.class.getName();
  }

  public MahasiswaImpl() {
    this.id = UUID.randomUUID();
    this.nama = "";
    this.npm = "";
    this.tahunAngkatan = 0;
    this.email = "";
    this.statusAkademik = "Kosong";
    this.isPublic = false;
    this.objectName = MahasiswaImpl.class.getName();
  }

}
