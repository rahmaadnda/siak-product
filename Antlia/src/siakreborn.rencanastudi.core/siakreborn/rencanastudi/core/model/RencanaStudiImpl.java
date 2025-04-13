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

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;

@Entity(name = "rencana_studi_impl")
@Table(name = "rencana_studi_impl")
public class RencanaStudiImpl extends RencanaStudiComponent {

  public RencanaStudiImpl(Mahasiswa mahasiswa, Semester semester, int totalSKS, String status) {
    this.id = UUID.randomUUID();
    this.mahasiswa = mahasiswa;
    this.semester = semester;
    this.totalSKS = totalSKS;
    this.status = status;
    this.objectName = RencanaStudiImpl.class.getName();
  }

  public RencanaStudiImpl(UUID id, Mahasiswa mahasiswa, Semester semester, int totalSKS, String status) {
    this.id = id;
    this.mahasiswa = mahasiswa;
    this.semester = semester;
    this.totalSKS = totalSKS;
    this.status = status;
    this.objectName = RencanaStudiImpl.class.getName();
  }

  public RencanaStudiImpl() {
    this.id = UUID.randomUUID();
    this.totalSKS = 0;
    this.status = "";
    this.objectName = RencanaStudiImpl.class.getName();
  }

}
