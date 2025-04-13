package siakreborn.capaian.cpmk;

import siakreborn.capaian.core.CapaianDecorator;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.util.core.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import java.util.*;

@Entity(name = "capaian_cpmk")
@Table(name = "capaian_cpmk")
public class CapaianImpl extends CapaianDecorator {

  public int bobot;
  @ManyToOne(targetEntity = siakreborn.matakuliah.core.MataKuliahComponent.class)
  public MataKuliah mataKuliah;
  @ManyToOne(targetEntity = siakreborn.capaian.core.CapaianComponent.class)
  public Capaian parentCPL;

  public CapaianImpl() {
    super();
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(int bobot, MataKuliah mataKuliah, Capaian parentCPL) {
    super();
    this.bobot = bobot;
    this.mataKuliah = mataKuliah;
    this.parentCPL = parentCPL;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(CapaianComponent record, int bobot, MataKuliah mataKuliah, Capaian parentCPL) {
    super(record);
    this.bobot = bobot;
    this.mataKuliah = mataKuliah;
    this.parentCPL = parentCPL;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(UUID id, CapaianComponent record, int bobot, MataKuliah mataKuliah, Capaian parentCPL) {
    super(id, record);
    this.bobot = bobot;
    this.mataKuliah = mataKuliah;
    this.parentCPL = parentCPL;
    this.objectName = CapaianImpl.class.getName();
  }

  public int getBobot() {
    return bobot;
  }

  public void setBobot(int bobot) {
    this.bobot = bobot;
  }

  public MataKuliah getMataKuliah() {
    return mataKuliah;
  }

  public void setMataKuliah(MataKuliah mataKuliah) {
    this.mataKuliah = mataKuliah;
  }

  public Capaian getParentCPL() {
    return parentCPL;
  }

  public void setParentCPL(Capaian parentCPL) {
    this.parentCPL = parentCPL;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " record='" + getRecord() + "'" +
        " bobot='" + getBobot() + "'" +
        " mataKuliah='" + getMataKuliah() + "'" +
        " parentCPL='" + getParentCPL() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> capaianMap = record.toHashMap();
    capaianMap.put("id", this.getId());
    capaianMap.put("bobot", this.getBobot());
    capaianMap = Util.combine(capaianMap, this.getMataKuliah().toHashMap(), "mataKuliah");
    capaianMap = Util.combine(capaianMap, this.getParentCPL().toHashMap(), "parentCPL");
    return capaianMap;
  }
}
