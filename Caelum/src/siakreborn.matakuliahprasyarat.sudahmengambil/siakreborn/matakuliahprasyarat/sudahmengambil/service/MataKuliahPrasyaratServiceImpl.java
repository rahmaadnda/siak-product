package siakreborn.matakuliahprasyarat.sudahmengambil;

import java.util.*;

import siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratServiceDecorator;
import siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratServiceComponent;

public class MataKuliahPrasyaratServiceImpl extends MataKuliahPrasyaratServiceDecorator {

    public MataKuliahPrasyaratServiceImpl(MataKuliahPrasyaratServiceComponent record) {
        super(record);
    }

    public List<HashMap<String, String>> listSyarat() {
        List<HashMap<String, String>> syaratList = new ArrayList<>();

        HashMap<String, String> lulus = new HashMap<>();
        lulus.put("name", "Sudah Lulus");
        syaratList.add(lulus);

        HashMap<String, String> mengambil = new HashMap<>();
        mengambil.put("name", "Sudah Mengambil");
        syaratList.add(mengambil);

        return syaratList;
    }
}