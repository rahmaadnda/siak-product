package siakreborn.komponenpenilaian.core;

import siakreborn.kelas.core.Kelas;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface KomponenPenilaian {
  UUID getId();

  void setId(UUID id);

  String getNama();

  void setNama(String nama);

  Kelas getKelas();

  void setKelas(Kelas kelas);

  double getBobot();

  void setBobot(double bobot);

  HashMap<String, Object> toHashMap();
}
