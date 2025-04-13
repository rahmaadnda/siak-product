package siakreborn.semester.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Semester {
  UUID getId();

  void setId(UUID id);

  String getKode();

  void setKode(String kode);

  String getStatus();

  void setStatus(String status);

  String getTanggalMulai();

  void setTanggalMulai(String tanggalMulai);

  String getTanggalSelesai();

  void setTanggalSelesai(String tanggalSelesai);

  String getDeskripsi();

  void setDeskripsi(String deskripsi);

  HashMap<String, Object> toHashMap();
}
