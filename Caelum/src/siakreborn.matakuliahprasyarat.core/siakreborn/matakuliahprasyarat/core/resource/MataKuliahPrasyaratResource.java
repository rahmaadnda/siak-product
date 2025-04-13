package siakreborn.matakuliahprasyarat.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface MataKuliahPrasyaratResource {
    List<HashMap<String,Object>> saveMataKuliahPrasyarat(VMJExchange vmjExchange);
    HashMap<String, Object> updateMataKuliahPrasyarat(VMJExchange vmjExchange);
    HashMap<String, Object> getMataKuliahPrasyarat(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllMataKuliahPrasyarat(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllMataKuliahPrasyaratFromParent(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteMataKuliahPrasyarat(VMJExchange vmjExchange);
	List<HashMap<String,String>> listSyarat(VMJExchange vmjExchange);

}
