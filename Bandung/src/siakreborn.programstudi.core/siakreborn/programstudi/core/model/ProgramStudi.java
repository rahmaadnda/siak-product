package siakreborn.programstudi.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface ProgramStudi {
	UUID getId();
	void setId(UUID id);
	String getKode();
	void setKode(String kode);
	String getNoSK();
	void setNoSK(String noSK);
	String getNama();
	void setNama(String nama);
	String getKaprodi();
	void setKaprodi(String kaprodi);
	String getJenjang();
	void setJenjang(String jenjang);
	HashMap<String, Object> toHashMap();
}
