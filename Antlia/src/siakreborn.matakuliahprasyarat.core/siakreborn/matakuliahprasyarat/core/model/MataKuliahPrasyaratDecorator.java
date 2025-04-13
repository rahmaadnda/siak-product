package siakreborn.matakuliahprasyarat.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import siakreborn.matakuliah.core.MataKuliah;

@MappedSuperclass
public abstract class MataKuliahPrasyaratDecorator extends MataKuliahPrasyaratComponent {
    @OneToOne(cascade=CascadeType.ALL)
	protected MataKuliahPrasyaratComponent record;
		
	public MataKuliahPrasyaratDecorator (MataKuliahPrasyaratComponent record, String objectName) {
		this.record = record;
		this.id = UUID.randomUUID();
		this.record.objectName = objectName;
	}

	public MataKuliahPrasyaratDecorator (UUID id, MataKuliahPrasyaratComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public MataKuliahPrasyaratDecorator(){
		super();
		this.record = new MataKuliahPrasyaratImpl();
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return record.getId();
	}

	public void setId(UUID id) {
		this.record.setId(id);
	}

	public MataKuliahPrasyaratComponent getRecord() {
		return this.record;
	}

	public void setRecord(MataKuliahPrasyaratComponent record) {
		this.record = record;
	}

	public MataKuliah getMataKuliah() {
		return this.record.getMataKuliah();
	}

	public void setMataKuliah(MataKuliah mataKuliah) {
		this.record.setMataKuliah(mataKuliah);
	}

	public MataKuliah getParentMataKuliah() {
		return this.record.getParentMataKuliah();
	}

	public void setParentMataKuliah(MataKuliah parentMataKuliah) {
		this.record.setParentMataKuliah(parentMataKuliah);
	}

	public String getSyarat() {
		return record.getSyarat();
	}

	public void setSyarat(String syarat) {
		this.record.setSyarat(syarat);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
