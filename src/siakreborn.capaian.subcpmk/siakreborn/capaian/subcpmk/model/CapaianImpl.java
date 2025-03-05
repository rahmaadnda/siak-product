package siakreborn.capaian.subcpmk;

import siakreborn.capaian.core.CapaianDecorator;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;
import siakreborn.util.core.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import java.util.*;

@Entity(name = "capaian_subcpmk")
@Table(name = "capaian_subcpmk")
public class CapaianImpl extends CapaianDecorator {

  public int bobot;
  @ManyToOne(targetEntity = siakreborn.capaian.core.CapaianComponent.class)
  public Capaian parentCPMK;

  public CapaianImpl() {
    super();
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(int bobot, Capaian parentCPMK) {
    super();
    this.bobot = bobot;
    this.parentCPMK = parentCPMK;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(CapaianComponent record, int bobot, Capaian parentCPMK) {
    super(record);
    this.bobot = bobot;
    this.parentCPMK = parentCPMK;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(UUID id, CapaianComponent record, int bobot, Capaian parentCPMK) {
    super(id, record);
    this.bobot = bobot;
    this.parentCPMK = parentCPMK;
    this.objectName = CapaianImpl.class.getName();
  }

  public int getBobot() {
    return bobot;
  }

  public void setBobot(int bobot) {
    this.bobot = bobot;
  }

  public Capaian getParentCPMK() {
    return parentCPMK;
  }

  public void setParentCPMK(Capaian parentCPMK) {
    this.parentCPMK = parentCPMK;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " record='" + getRecord() + "'" +
        " bobot='" + getBobot() + "'" +
        " parentCPMK='" + getParentCPMK() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> capaianMap = record.toHashMap();
    capaianMap.put("id", this.getId());
    capaianMap.put("bobot", this.getBobot());
    capaianMap = Util.combine(capaianMap, this.getParentCPMK().toHashMap(), "parentCPMK");
    return capaianMap;
  }
}
