package siakreborn.kelasdosen.core;

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

import siakreborn.dosen.core.*;
import siakreborn.kelas.core.*;

@Entity(name = "kelas_dosen_impl")
@Table(name = "kelas_dosen_impl")
public class KelasDosenImpl extends KelasDosenComponent {

  public KelasDosenImpl(Dosen dosen, Kelas kelas) {
    this.id = UUID.randomUUID();
    this.dosen = dosen;
    this.kelas = kelas;
    this.objectName = KelasDosenImpl.class.getName();
  }

  public KelasDosenImpl(UUID id, Dosen dosen, Kelas kelas) {
    this.id = id;
    this.dosen = dosen;
    this.kelas = kelas;
    this.objectName = KelasDosenImpl.class.getName();
  }

  public KelasDosenImpl() {
    this.id = UUID.randomUUID();
    this.objectName = KelasDosenImpl.class.getName();
  }

}
