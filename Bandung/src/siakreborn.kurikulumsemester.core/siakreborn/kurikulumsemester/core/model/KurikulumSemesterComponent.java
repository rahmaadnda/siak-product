package siakreborn.kurikulumsemester.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.kurikulum.core.*;
import siakreborn.semester.core.*;
import siakreborn.util.core.*;

@Entity(name = "kurikulum_semester_comp")
@Table(name = "kurikulum_semester_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KurikulumSemesterComponent implements KurikulumSemester {
  @Id
  protected UUID id;
  @ManyToOne(targetEntity = siakreborn.kurikulum.core.KurikulumComponent.class)
  public Kurikulum kurikulum;
  @ManyToOne(targetEntity = siakreborn.semester.core.SemesterComponent.class)
  public Semester semester;

  protected String objectName = KurikulumSemesterComponent.class.getName();

  public KurikulumSemesterComponent() {

  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Kurikulum getKurikulum() {
    return this.kurikulum;
  };

  public void setKurikulum(Kurikulum kurikulum) {
    this.kurikulum = kurikulum;
  }

  public Semester getSemester() {
    return this.semester;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        " kurikulum='" + getKurikulum() + "'" +
        " semester='" + getSemester() + "'" +
        "}";
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> Map = new HashMap<String, Object>();
    Map.put("id", getId());
    Map = Util.combine(Map, getKurikulum().toHashMap(), "kurikulum");
    Map = Util.combine(Map, getSemester().toHashMap(), "semester");

    return Map;
  }
}
