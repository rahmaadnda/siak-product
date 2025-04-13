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

import siakreborn.semester.core.Semester;

@Entity(name = "pengisian_rencana_studi_impl")
@Table(name = "pengisian_rencana_studi_impl")
public class PengisianRencanaStudiImpl extends PengisianRencanaStudiComponent {

  public PengisianRencanaStudiImpl(Date mulai, Date akhir, Semester semester) {
    this.id = UUID.randomUUID();
    this.mulai = mulai;
    this.akhir = akhir;
    this.semester = semester;
    this.objectName = PengisianRencanaStudiImpl.class.getName();
  }

  public PengisianRencanaStudiImpl(UUID id, Date mulai, Date akhir, Semester semester) {
    this.id = id;
    this.mulai = mulai;
    this.akhir = akhir;
    this.semester = semester;
    this.objectName = PengisianRencanaStudiImpl.class.getName();
  }

  public PengisianRencanaStudiImpl() {
    this.id = UUID.randomUUID();
    this.objectName = PengisianRencanaStudiImpl.class.getName();
  }
}
