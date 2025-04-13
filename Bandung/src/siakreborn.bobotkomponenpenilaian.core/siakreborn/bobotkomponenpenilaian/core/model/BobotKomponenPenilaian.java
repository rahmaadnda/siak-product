package siakreborn.bobotkomponenpenilaian.core;

import siakreborn.capaian.core.Capaian;
import siakreborn.komponenpenilaian.core.KomponenPenilaian;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface BobotKomponenPenilaian {
  UUID getId();

  void setId(UUID id);

  double getBobot();

  void setBobot(double bobot);

  KomponenPenilaian getKomponenPenilaian();

  void setKomponenPenilaian(KomponenPenilaian komponenPenilaian);

  Capaian getCPMK();

  void setCPMK(Capaian cpmk);

  Capaian getSubCPMK();

  void setSubCPMK(Capaian subcpmk);

  HashMap<String, Object> toHashMap();
}
