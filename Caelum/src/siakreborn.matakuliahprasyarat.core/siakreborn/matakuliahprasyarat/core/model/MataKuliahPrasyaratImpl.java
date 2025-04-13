package siakreborn.matakuliahprasyarat.core;

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


@Entity(name="matakuliahprasyarat_impl")
@Table(name="matakuliahprasyarat_impl")
public class MataKuliahPrasyaratImpl extends MataKuliahPrasyaratComponent {

	public MataKuliahPrasyaratImpl(UUID id, MataKuliah mataKuliah, MataKuliah parentMataKuliah, String syarat) {
		this.id = id;
		this.mataKuliah = mataKuliah;
		this.parentMataKuliah = parentMataKuliah;
		this.syarat = syarat;
		this.objectName = MataKuliahPrasyarat.class.getName();
	}

	public MataKuliahPrasyaratImpl(MataKuliah mataKuliah, MataKuliah parentMataKuliah, String syarat) {
		this.id = UUID.randomUUID();
		this.mataKuliah = mataKuliah;
		this.parentMataKuliah = parentMataKuliah;
		this.syarat = syarat;
		this.objectName = MataKuliahPrasyarat.class.getName();
	}

	public MataKuliahPrasyaratImpl() {
		this.id = UUID.randomUUID();
		this.syarat = "";
		this.objectName = MataKuliahPrasyarat.class.getName();
	}


}
