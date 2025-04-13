package siakreborn.kurikulum.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.programstudi.core.ProgramStudi;

public interface Kurikulum {
	UUID getId();
    void setId(UUID id);

	String getKode();
	void setKode(String kode);

	String getNoSK();
	void setNoSK(String noSK);

	String getStatus();
	void setStatus(String status);

	String getProfilLulusan();
	void setProfilLulusan(String profilLulusan);

	ProgramStudi getProgramStudi();
	void setProgramStudi(ProgramStudi programStudi);

	HashMap<String, Object> toHashMap();
}
