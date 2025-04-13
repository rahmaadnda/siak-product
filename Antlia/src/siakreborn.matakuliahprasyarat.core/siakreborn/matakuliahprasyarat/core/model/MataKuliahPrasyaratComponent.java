package siakreborn.matakuliahprasyarat.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.matakuliah.core.*;
import siakreborn.util.core.*;

@Entity(name="matakuliahprasyarat_comp")
@Table(name="matakuliahprasyarat_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MataKuliahPrasyaratComponent implements MataKuliahPrasyarat {
	@Id
	protected UUID id; 
	@ManyToOne(targetEntity=siakreborn.matakuliah.core.MataKuliahComponent.class)
	public MataKuliah mataKuliah;
	@ManyToOne(targetEntity=siakreborn.matakuliah.core.MataKuliahComponent.class)
	public MataKuliah parentMataKuliah;
	protected String syarat;

	protected String objectName = MataKuliahPrasyaratComponent.class.getName();

	public MataKuliahPrasyaratComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public MataKuliah getMataKuliah() {
		return this.mataKuliah;
	}

	public void setMataKuliah(MataKuliah mataKuliah) {
		this.mataKuliah = mataKuliah;
	}

	public MataKuliah getParentMataKuliah() {
		return this.parentMataKuliah;
	}

	public void setParentMataKuliah(MataKuliah parentMataKuliah) {
		this.parentMataKuliah = parentMataKuliah;
	}
	
	public String getSyarat() {
		return this.syarat;
	}

	public void setSyarat(String syarat) {
		this.syarat = syarat;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " mataKuliah='" + getMataKuliah() + "'" +
            " parentMataKuliah='" + getParentMataKuliah() + "'" +
            " syarat='" + getSyarat() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> Map = new HashMap<String, Object>();
		Map.put("id", getId());
		Map = Util.combine(Map, getMataKuliah().toHashMap(), "mataKuliah");
		Map = Util.combine(Map, getParentMataKuliah().toHashMap(), "parentMataKuliah");
		Map.put("syarat",getSyarat());

        return Map;
    }
}
