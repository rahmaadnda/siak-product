package siakreborn.matakuliah.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.kurikulum.core.Kurikulum;

@MappedSuperclass
public abstract class MataKuliahDecorator extends MataKuliahComponent{
	@OneToOne(cascade=CascadeType.ALL)
	protected MataKuliahComponent record;
		
	public MataKuliahDecorator (MataKuliahComponent record, String objectName) {
		this.record = record;
		this.id = UUID.randomUUID();
		this.record.objectName = objectName;
	}

	public MataKuliahDecorator (UUID id, MataKuliahComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public MataKuliahDecorator(){
		super();
		this.record = new MataKuliahImpl();
		this.id = UUID.randomUUID();
	}

	public MataKuliahComponent getRecord() {
        return this.record;
    }

    public void setRecord(MataKuliahComponent record) {
        this.record = record;
    }

	public String getKode() {
		return record.getKode();
	}
	public void setKode(String kode) {
		record.setKode(kode);
	}
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public int getSks() {
		return record.getSks();
	}
	public void setSks(int sks) {
		record.setSks(sks);
	}
	public int getTerm() {
		return record.getTerm();
	}
	public void setTerm(int term) {
		record.setTerm(term);
	}
	public Kurikulum getKurikulum() {
        return this.record.getKurikulum();
    }
    public void setKurikulum(Kurikulum kurikulum) {
        this.record.setKurikulum(kurikulum);
    }


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
