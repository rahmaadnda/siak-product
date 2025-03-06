package siakreborn.rencanastudi.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.kelas.core.Kelas;

public interface KelasMahasiswa {
  UUID getId();

  void setId(UUID id);

  RencanaStudi getRencanaStudi();

  void setRencanaStudi(RencanaStudi rencanaStudi);

  Kelas getKelas();

  void setKelas(Kelas kelas);

  Date getTanggalPengisian();

  void setTanggalPengisian(Date tanggalPengisian);

  HashMap<String, Object> toHashMap();
}
