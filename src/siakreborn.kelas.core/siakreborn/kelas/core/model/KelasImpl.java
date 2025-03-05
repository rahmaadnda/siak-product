package siakreborn.kelas.core;

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

import siakreborn.matakuliah.core.*;
import siakreborn.semester.core.*;

@Entity(name="kelas_impl")
@Table(name="kelas_impl")
public class KelasImpl extends KelasComponent {

	public KelasImpl(String nama, int kapasitas, String ruangan, String jadwal, MataKuliah mataKuliah, Semester semester) {
		this.id = UUID.randomUUID();
		this.nama = nama;
		this.kapasitas = kapasitas;
		this.ruangan = ruangan;
		this.jadwal = jadwal;
		this.mataKuliah = mataKuliah;
		this.semester = semester;
		this.objectName = KelasImpl.class.getName();
	}

	public KelasImpl(UUID id, String nama, int kapasitas, String ruangan, String jadwal, MataKuliah mataKuliah, Semester semester) {
		this.id = id;
		this.nama = nama;
		this.kapasitas = kapasitas;
		this.ruangan = ruangan;
		this.jadwal = jadwal;
		this.mataKuliah = mataKuliah;
		this.semester = semester;
		this.objectName = KelasImpl.class.getName();
	}

	public KelasImpl() {
		this.id = UUID.randomUUID();
		this.nama = "";
		this.kapasitas = 0;
		this.ruangan = "";
		this.jadwal = "";
		this.objectName = KelasImpl.class.getName();
	}
}
