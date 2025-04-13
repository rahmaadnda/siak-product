package siakreborn.subscriptionplan.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface SubscriptionPlan {
	public UUID getId();
	public void setId(UUID id);
	public String getName();
	public void setName(String name);
	public String getDeskripsi();
	public void setDeskripsi(String deskripsi);
	public int getHarga();
	public void setHarga(int harga);
	HashMap<String, Object> toHashMap();
}
