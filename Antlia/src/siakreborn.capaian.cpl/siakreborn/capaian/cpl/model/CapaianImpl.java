package siakreborn.capaian.cpl;

import siakreborn.capaian.core.CapaianDecorator;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;
import siakreborn.kurikulum.core.Kurikulum;
import siakreborn.util.core.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import java.util.*;

@Entity(name = "capaian_cpl")
@Table(name = "capaian_cpl")
public class CapaianImpl extends CapaianDecorator {
  @ManyToOne(targetEntity = siakreborn.kurikulum.core.KurikulumComponent.class)
  public Kurikulum kurikulum;

  public CapaianImpl() {
    super();
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(Kurikulum kurikulum) {
    super();
    this.kurikulum = kurikulum;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(CapaianComponent record, Kurikulum kurikulum) {
    super(record);
    this.kurikulum = kurikulum;
    this.objectName = CapaianImpl.class.getName();
  }

  public CapaianImpl(UUID id, CapaianComponent record, Kurikulum kurikulum) {
    super(id, record);
    this.kurikulum = kurikulum;
    this.objectName = CapaianImpl.class.getName();
  }

  public Kurikulum getKurikulum() {
    return kurikulum;
  }

  public void setKurikulum(Kurikulum kurikulum) {
    this.kurikulum = kurikulum;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " record='" + getRecord() + "'" +
        " kurikulum='" + getKurikulum() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> capaianMap = record.toHashMap();
    capaianMap.put("id", this.getId());
    if (getKurikulum() != null) {
      capaianMap = Util.combine(capaianMap, this.getKurikulum().toHashMap(), "kurikulum");
    }
    return capaianMap;
  }

}
