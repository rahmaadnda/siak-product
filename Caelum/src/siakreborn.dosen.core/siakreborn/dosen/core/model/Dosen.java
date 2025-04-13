package siakreborn.dosen.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Dosen {
  UUID getId();

  void setId(UUID id);

  String getNama();

  void setNama(String nama);

  String getNip();

  void setNip(String nip);

  String getEmail();

  void setEmail(String email);

  HashMap<String, Object> toHashMap();
}
