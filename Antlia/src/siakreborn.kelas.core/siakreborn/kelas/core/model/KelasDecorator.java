package siakreborn.kelas.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.semester.core.Semester;

@MappedSuperclass
public abstract class KelasDecorator extends KelasComponent{
	@OneToOne(cascade=CascadeType.ALL)
	protected KelasComponent record;
		
	public KelasDecorator (KelasComponent record, String objectName) {
		this.record = record;
		this.id = UUID.randomUUID();
		this.record.objectName = objectName;
	}

	public KelasDecorator (UUID id, KelasComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KelasDecorator(){
		super();
		this.record = new KelasImpl();
		this.id = UUID.randomUUID();
	}

	public KelasComponent getRecord() {
        return this.record;
    }

    public void setRecord(KelasComponent record) {
        this.record = record;
    }
	
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public int getKapasitas() {
		return record.getKapasitas();
	}
	public void setKapasitas(int kapasitas) {
		record.setKapasitas(kapasitas);
	}
	public String getRuangan() {
		return record.getRuangan();
	}
	public void setRuangan(String ruangan) {
		record.setRuangan(ruangan);
	}
	public String getJadwal() {
		return record.getJadwal();
	}
	public void setJadwal(String jadwal) {
		record.setJadwal(jadwal);
	}
	public MataKuliah getMataKuliah() {
        return this.record.getMataKuliah();
    }
    public void setMataKuliah(MataKuliah mataKuliah) {
        this.record.setMataKuliah(mataKuliah);
    }
	public Semester getSemester(){
		return this.record.getSemester();
	}
	public void setSemester(Semester semester){
		this.record.setSemester(semester);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
