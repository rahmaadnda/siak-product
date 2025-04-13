package siakreborn.kelas.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.semester.core.Semester;

public interface Kelas {
	UUID getId();
	void setId(UUID id);
	String getNama();
	void setNama(String nama);
	int getKapasitas();
	void setKapasitas(int kapasitas);
	String getRuangan();
	void setRuangan(String ruangan);
	String getJadwal();
	void setJadwal(String jadwal);
	MataKuliah getMataKuliah();
	void setMataKuliah(MataKuliah mataKuliah);
	Semester getSemester();
	void setSemester(Semester semester);
	HashMap<String, Object> toHashMap();
}
