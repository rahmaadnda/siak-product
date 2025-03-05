package siakreborn.capaian.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Capaian {
	public UUID getId();
	public void setId(UUID id);
	public String getKode();
	public void setKode(String kode);
	public String getDeskripsi();
	public void setDeskripsi(String deskripsi);
	HashMap<String, Object> toHashMap();
}
