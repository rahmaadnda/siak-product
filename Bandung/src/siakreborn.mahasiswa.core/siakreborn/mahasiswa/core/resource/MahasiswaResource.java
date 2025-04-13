package siakreborn.mahasiswa.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface MahasiswaResource {
    List<HashMap<String,Object>> saveMahasiswa(VMJExchange vmjExchange);
    HashMap<String, Object> updateMahasiswa(VMJExchange vmjExchange);
    HashMap<String, Object> getMahasiswa(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllMahasiswa(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteMahasiswa(VMJExchange vmjExchange);
}
