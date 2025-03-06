package siakreborn.mahasiswa.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.programstudi.core.ProgramStudi;

public interface Mahasiswa {
  UUID getId();

  void setId(UUID id);

  String getNama();

  void setNama(String nama);

  String getNpm();

  void setNpm(String npm);

  String getEmail();

  void setEmail(String email);

  ProgramStudi getProgramStudi();

  void setProgramStudi(ProgramStudi programStudi);

  HashMap<String, Object> toHashMap();
}
