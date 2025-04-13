package siakreborn.kurikulum.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.programstudi.core.ProgramStudi;

@MappedSuperclass
public abstract class KurikulumDecorator extends KurikulumComponent{
	@OneToOne(cascade=CascadeType.ALL)
	protected KurikulumComponent record;
		
	public KurikulumDecorator (KurikulumComponent record, String objectName) {
		this.record = record;
		this.id = UUID.randomUUID();
		this.record.objectName = objectName;
	}

	public KurikulumDecorator (UUID id, KurikulumComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KurikulumDecorator(){
		super();
		this.record = new KurikulumImpl();
		this.id = UUID.randomUUID();
	}

	public KurikulumComponent getRecord() {
        return this.record;
    }

    public void setRecord(KurikulumComponent record) {
        this.record = record;
    }

	public String getKode() {
		return record.getKode();
	}
	public void setKode(String kode) {
		record.setKode(kode);
	}
	public String getNoSK() {
		return record.getNoSK();
	}
	public void setNoSK(String noSK) {
		record.setNoSK(noSK);
	}
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}
	public String getProfilLulusan() {
		return record.getProfilLulusan();
	}
	public void setProfilLulusan(String profilLulusan) {
		record.setProfilLulusan(profilLulusan);
	}
	public ProgramStudi getProgramStudi() {
        return this.record.getProgramStudi();
    }
    public void setProgramStudi(ProgramStudi programStudi) {
        this.record.setProgramStudi(programStudi);
    }

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
