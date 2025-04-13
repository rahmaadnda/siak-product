package siakreborn.kurikulumsemester.core;

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

import siakreborn.kurikulum.core.*;
import siakreborn.semester.core.*;

@Entity(name = "kurikulum_semester_impl")
@Table(name = "kurikulum_semester_impl")
public class KurikulumSemesterImpl extends KurikulumSemesterComponent {

  public KurikulumSemesterImpl(UUID id, Kurikulum kurikulum, Semester semester) {
    this.id = id;
    this.kurikulum = kurikulum;
    this.semester = semester;
    this.objectName = KurikulumSemesterImpl.class.getName();
  }

  public KurikulumSemesterImpl(Kurikulum kurikulum, Semester semester) {
    this.id = UUID.randomUUID();
    this.kurikulum = kurikulum;
    this.semester = semester;
    this.objectName = KurikulumSemesterImpl.class.getName();
  }

  public KurikulumSemesterImpl() {
    this.id = UUID.randomUUID();
    this.objectName = KurikulumSemesterImpl.class.getName();
  }

}
