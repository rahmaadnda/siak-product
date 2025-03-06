package siakreborn.kelasdosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import siakreborn.dosen.core.Dosen;
import siakreborn.kelas.core.Kelas;

@MappedSuperclass
public abstract class KelasDosenDecorator extends KelasDosenComponent{
	@OneToOne(cascade=CascadeType.ALL)
	protected KelasDosenComponent record;
		
	public KelasDosenDecorator (KelasDosenComponent record, String objectName) {
		this.record = record;
		this.id = UUID.randomUUID();
		this.record.objectName = objectName;
	}

	public KelasDosenDecorator (UUID id, KelasDosenComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KelasDosenDecorator(){
		super();
		this.record = new KelasDosenImpl();
		this.id = UUID.randomUUID();
	}

	public KelasDosenComponent getRecord() {
        return this.record;
    }

    public void setRecord(KelasDosenComponent record) {
        this.record = record;
    }
	public Dosen getDosen() {
        return this.record.getDosen();
    }
    public void setDosen(Dosen dosen) {
        this.record.setDosen(dosen);
    }
	public Kelas getKelas() {
        return this.record.getKelas();
    }
    public void setKelas(Kelas kelas) {
        this.record.setKelas(kelas);
    }


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
