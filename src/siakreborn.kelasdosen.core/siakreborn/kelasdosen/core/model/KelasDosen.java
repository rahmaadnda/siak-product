package siakreborn.kelasdosen.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.dosen.core.Dosen;
import siakreborn.kelas.core.Kelas;

public interface KelasDosen {
	UUID getId();
	void setId(UUID id);
	Dosen getDosen();
	void setDosen(Dosen dosen);
	Kelas getKelas();
	void setKelas(Kelas kelas);
	HashMap<String, Object> toHashMap();
}
