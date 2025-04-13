package siakreborn.matakuliah.core;

import siakreborn.kurikulum.core.Kurikulum;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface MataKuliah {
	UUID getId();
	void setId(UUID id);
	String getKode();
	void setKode(String kode);
	String getNama();
	void setNama(String nama);
	int getSks();
	void setSks(int sks);
	int getTerm();
	void setTerm(int term);
	Kurikulum getKurikulum();
	void setKurikulum(Kurikulum kurikulum);
	HashMap<String, Object> toHashMap();
}
