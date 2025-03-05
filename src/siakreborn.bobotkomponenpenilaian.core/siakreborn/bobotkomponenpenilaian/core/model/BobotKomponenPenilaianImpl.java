package siakreborn.bobotkomponenpenilaian.core;

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
import siakreborn.capaian.core.*;

@Entity(name = "bobot_komponen_penilaian_impl")
@Table(name = "bobot_komponen_penilaian_impl")
public class BobotKomponenPenilaianImpl extends BobotKomponenPenilaianComponent {

  public BobotKomponenPenilaianImpl(double bobot, KomponenPenilaian komponenPenilaian, Capaian cpmk, Capaian subCPMK) {
    this.id = UUID.randomUUID();
    this.bobot = bobot;
    this.komponenPenilaian = komponenPenilaian;
    this.cpmk = cpmk;
    this.subCPMK = subCPMK;
    this.objectName = BobotKomponenPenilaianImpl.class.getName();
  }

  public BobotKomponenPenilaianImpl(UUID id, double bobot, KomponenPenilaian komponenPenilaian, Capaian cpmk,
      Capaian subCPMK) {
    this.id = id;
    this.bobot = bobot;
    this.komponenPenilaian = komponenPenilaian;
    this.cpmk = cpmk;
    this.subCPMK = subCPMK;
    this.objectName = BobotKomponenPenilaianImpl.class.getName();
  }

  public BobotKomponenPenilaianImpl() {
    this.id = UUID.randomUUID();
    this.bobot = 0;
    this.objectName = BobotKomponenPenilaianImpl.class.getName();
  }

}
