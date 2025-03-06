package siakreborn.rencanastudi.core;

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

@Entity(name = "kelas_mahasiswa_impl")
@Table(name = "kelas_mahasiswa_impl")
public class KelasMahasiswaImpl extends KelasMahasiswaComponent {

  public KelasMahasiswaImpl(RencanaStudi rencanaStudi, Kelas kelas, Date tanggalPengisian) {
    this.id = UUID.randomUUID();
    this.rencanaStudi = rencanaStudi;
    this.kelas = kelas;
    this.tanggalPengisian = tanggalPengisian;
    this.objectName = KelasMahasiswaImpl.class.getName();
  }

  public KelasMahasiswaImpl(UUID id, RencanaStudi rencanaStudi, Kelas kelas, Date tanggalPengisian) {
    this.id = id;
    this.rencanaStudi = rencanaStudi;
    this.kelas = kelas;
    this.tanggalPengisian = tanggalPengisian;
    this.objectName = KelasMahasiswaImpl.class.getName();
  }

  public KelasMahasiswaImpl() {
    this.id = UUID.randomUUID();
    this.objectName = KelasMahasiswaImpl.class.getName();
  }

}
