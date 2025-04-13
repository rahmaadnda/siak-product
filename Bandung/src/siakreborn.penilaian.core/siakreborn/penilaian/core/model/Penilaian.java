package siakreborn.penilaian.core;

import siakreborn.komponenpenilaian.core.KomponenPenilaian;
import siakreborn.mahasiswa.core.Mahasiswa;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Penilaian {
  UUID getId();

  void setId(UUID id);

  Mahasiswa getMahasiswa();

  void setMahasiswa(Mahasiswa mahasiswa);

  int getNilai();

  void setNilai(int nilai);

  KomponenPenilaian getKomponenPenilaian();

  void setKomponenPenilaian(KomponenPenilaian KomponenPenilaian);

  HashMap<String, Object> toHashMap();
}
