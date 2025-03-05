package siakreborn.adminakademik.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface AdminAkademik {
	public UUID getId();
	public void setId(UUID id);
	public String getNama();
	public void setNama(String nama);
	public String getEmail();
	public void setEmail(String email);
	HashMap<String, Object> toHashMap();
}
