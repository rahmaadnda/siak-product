package siakreborn.informasi.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Informasi {
	public UUID getId();
	public void setId(UUID id);
	
	public String getJudul();
	public void setJudul(String judul);
	
	public String getDeskripsi();
	public void setDeskripsi(String deskripsi);
	
	public Date getTanggalPublikasi();
	public void setTanggalPublikasi(Date tanggalPublikasi);
	
	HashMap<String, Object> toHashMap();
}
