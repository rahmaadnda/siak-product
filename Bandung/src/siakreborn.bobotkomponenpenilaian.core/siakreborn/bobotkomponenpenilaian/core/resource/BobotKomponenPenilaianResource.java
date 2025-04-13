package siakreborn.bobotkomponenpenilaian.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BobotKomponenPenilaianResource {
    List<HashMap<String,Object>> saveBobotKomponenPenilaian(VMJExchange vmjExchange);
    HashMap<String, Object> updateBobotKomponenPenilaian(VMJExchange vmjExchange);
    HashMap<String, Object> getBobotKomponenPenilaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBobotKomponenPenilaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBobotKomponenPenilaian(VMJExchange vmjExchange);
}
