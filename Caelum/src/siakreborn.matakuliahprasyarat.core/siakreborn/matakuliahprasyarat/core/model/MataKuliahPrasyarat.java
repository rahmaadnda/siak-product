package siakreborn.matakuliahprasyarat.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.matakuliah.core.MataKuliah;

public interface MataKuliahPrasyarat {
	UUID getId();

	void setId(UUID id);

	MataKuliah getMataKuliah();

	void setMataKuliah(MataKuliah mataKuliah);

	MataKuliah getParentMataKuliah();

	void setParentMataKuliah(MataKuliah parentMataKuliah);

	String getSyarat();

	void setSyarat(String syarat);

	HashMap<String, Object> toHashMap();
}
