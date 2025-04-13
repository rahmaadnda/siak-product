package siakreborn.penilaian.penilaianobe;

import siakreborn.util.core.Util;
import siakreborn.penilaian.core.PenilaianDecorator;
import siakreborn.komponenpenilaian.core.KomponenPenilaian;
import siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaian;
import siakreborn.penilaian.core.Penilaian;
import siakreborn.penilaian.core.PenilaianComponent;
import vmj.routing.route.exceptions.DeltaPropertyException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import java.util.*;

@Entity(name = "penilaian_penilaianobe")
@Table(name = "penilaian_penilaianobe")
public class PenilaianImpl extends PenilaianDecorator {
  @ManyToOne(targetEntity = siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianComponent.class)
  public BobotKomponenPenilaian bobotKomponenPenilaian;

  public PenilaianImpl() {
    super();
    this.objectName = PenilaianImpl.class.getName();
  }

  public PenilaianImpl(BobotKomponenPenilaian bobotKomponenPenilaian) {
    super();
    this.bobotKomponenPenilaian = bobotKomponenPenilaian;
    this.objectName = PenilaianImpl.class.getName();
  }

  public PenilaianImpl(PenilaianComponent record, BobotKomponenPenilaian bobotKomponenPenilaian) {
    super(record);
    this.bobotKomponenPenilaian = bobotKomponenPenilaian;
    this.objectName = PenilaianImpl.class.getName();
  }

  public PenilaianImpl(UUID id, PenilaianComponent record, BobotKomponenPenilaian bobotKomponenPenilaian) {
    super(id, record);
    this.bobotKomponenPenilaian = bobotKomponenPenilaian;
    this.objectName = PenilaianImpl.class.getName();
  }

  public KomponenPenilaian getKomponenPenilaian() {
    throw new DeltaPropertyException("KomponenPenilaian dihapus dari delta operational");
  }

  public void setKomponenPenilaian(KomponenPenilaian komponenPenilaian) {
    throw new DeltaPropertyException("KomponenPenilaian dihapus dari delta operational");
  }

  public BobotKomponenPenilaian getBobotKomponenPenilaian() {
    return this.bobotKomponenPenilaian;
  }

  public void setBobotKomponenPenilaian(BobotKomponenPenilaian bobotKomponenPenilaian) {
    this.bobotKomponenPenilaian = bobotKomponenPenilaian;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " record='" + getRecord() + "'" +
        " bobotKomponenPenilaian='" + getBobotKomponenPenilaian() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> map = record.toHashMap();
    map.put("id", this.getId());
    map = Util.combine(map, this.getBobotKomponenPenilaian().toHashMap(), "bobotKomponenPenilaian");
    return map;
  }
}
