package siakreborn.kurikulum.core;

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

import siakreborn.programstudi.core.*;

@Entity(name="kurikulum_impl")
@Table(name="kurikulum_impl")
public class KurikulumImpl extends KurikulumComponent {

	public KurikulumImpl(String kode, String noSK, String status, String profilLulusan, ProgramStudi programStudi) {
		this.id = UUID.randomUUID();
		this.kode = kode;
		this.noSK = noSK;
		this.status = status;
		this.profilLulusan = profilLulusan;
		this.programStudi = programStudi;
		this.objectName = KurikulumImpl.class.getName();
	}

	public KurikulumImpl(UUID id, String kode, String noSK, String status, String profilLulusan, ProgramStudi programStudi) {
		this.id = id;
		this.kode = kode;
		this.noSK = noSK;
		this.status = status;
		this.profilLulusan = profilLulusan;
		this.programStudi = programStudi;
		this.objectName = KurikulumImpl.class.getName();
	}

	public KurikulumImpl() {
		this.id = UUID.randomUUID();
		this.kode = "";
		this.noSK = "";
		this.status = "";
		this.profilLulusan = "";
		this.objectName = KurikulumImpl.class.getName();
	}


}
