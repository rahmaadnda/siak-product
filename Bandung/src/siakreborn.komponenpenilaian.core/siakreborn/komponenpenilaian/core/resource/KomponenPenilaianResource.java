package siakreborn.komponenpenilaian.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KomponenPenilaianResource {
    List<HashMap<String,Object>> saveKomponenPenilaian(VMJExchange vmjExchange);
    HashMap<String, Object> updateKomponenPenilaian(VMJExchange vmjExchange);
    HashMap<String, Object> getKomponenPenilaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKomponenPenilaian(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKomponenPenilaian(VMJExchange vmjExchange);
}
