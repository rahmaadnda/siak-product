package siakreborn.mahasiswa.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import siakreborn.programstudi.core.ProgramStudi;

@MappedSuperclass
public abstract class MahasiswaDecorator extends MahasiswaComponent {
  @OneToOne(cascade = CascadeType.ALL)
  protected MahasiswaComponent record;

  public MahasiswaDecorator(MahasiswaComponent record, String objectName) {
    this.record = record;
    this.id = UUID.randomUUID();
    this.record.objectName = objectName;
  }

  public MahasiswaDecorator(UUID id, MahasiswaComponent record) {
    this.id = id;
    this.record = record;
  }

  public MahasiswaDecorator() {
    super();
    this.record = new MahasiswaImpl();
    this.id = UUID.randomUUID();
  }

  public MahasiswaComponent getRecord() {
    return this.record;
  }

  public void setRecord(MahasiswaComponent record) {
    this.record = record;
  }

  public String getNama() {
    return record.getNama();
  }

  public void setNama(String nama) {
    record.setNama(nama);
  }

  public String getNpm() {
    return record.getNpm();
  }

  public void setNpm(String npm) {
    record.setNpm(npm);
  }
  
	public int getTahunAngkatan() {
		return record.getTahunAngkatan();
	}
	
	public void setTahunAngkatan(int tahunAngkatan) {
		record.setTahunAngkatan(tahunAngkatan);
	}

  public String getEmail() {
    return record.getEmail();
  }

  public void setEmail(String email) {
    record.setEmail(email);
  }
  
  public String getStatusAkademik() {
    return record.getStatusAkademik();
  }

  public void setStatusAkademik(String statusAkademik) {
    record.setStatusAkademik(statusAkademik);
  }

  public boolean getIsPublic() {
    return record.getIsPublic();
  }

  public void setIsPublic(boolean isPublic) {
    record.setIsPublic(isPublic);
  }

  public ProgramStudi getProgramStudi() {
    return record.getProgramStudi();
  }

  public void setProgramStudi(ProgramStudi programStudi) {
    record.setProgramStudi(programStudi);
  }

  public HashMap<String, Object> toHashMap() {
    return this.record.toHashMap();
  }

}
