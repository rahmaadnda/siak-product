package siakreborn.matakuliahprasyarat.core;

import java.util.*;

import siakreborn.matakuliah.core.MataKuliah;

public interface MataKuliahPrasyaratService {
    List<MataKuliahPrasyarat> saveMataKuliahPrasyarat(HashMap<String, Object> body);

    MataKuliahPrasyarat updateMataKuliahPrasyarat(HashMap<String, Object> body);
  
    MataKuliahPrasyarat getMataKuliahPrasyarat(UUID id);
  
    List<MataKuliahPrasyarat> getAllMataKuliahPrasyarat();

    List<MataKuliahPrasyarat> getAllMataKuliahPrasyaratFromParent(UUID id);
    
    List<MataKuliahPrasyarat> deleteMataKuliahPrasyarat(UUID id);
  
    List<HashMap<String, Object>> transformMataKuliahPrasyaratListToHashMap(List<MataKuliahPrasyarat> mataKuliahPrasyaratList);

    List<HashMap<String, String>> listSyarat();
}