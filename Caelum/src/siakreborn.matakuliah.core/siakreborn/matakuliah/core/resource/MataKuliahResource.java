package siakreborn.matakuliah.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface MataKuliahResource {
    List<HashMap<String,Object>> saveMataKuliah(VMJExchange vmjExchange);
    HashMap<String, Object> updateMataKuliah(VMJExchange vmjExchange);
    HashMap<String, Object> getMataKuliah(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllMataKuliah(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteMataKuliah(VMJExchange vmjExchange);
}
