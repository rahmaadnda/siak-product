package siakreborn.matakuliahprasyarat.core;

import java.util.*;

import siakreborn.matakuliahprasyarat.MataKuliahPrasyaratFactory;
import siakreborn.matakuliah.core.MataKuliah;

public class MataKuliahPrasyaratServiceImpl extends MataKuliahPrasyaratServiceComponent {
    private MataKuliahPrasyaratFactory mataKuliahPrasyaratFactory = new MataKuliahPrasyaratFactory();

    public List<MataKuliahPrasyarat> saveMataKuliahPrasyarat(HashMap<String, Object> body) {
        String syarat = (String) body.get("syarat");
        String mataKuliahIdStr = (String) body.get("mataKuliahId");
        String parentMataKuliahIdStr = (String) body.get("parentMataKuliahId");

        MataKuliah parentMataKuliah = null;
        if (parentMataKuliahIdStr != null) {
            UUID parentMataKuliahId = UUID.fromString(parentMataKuliahIdStr);
            parentMataKuliah = mataKuliahPrasyaratRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, parentMataKuliahId);
        }

        MataKuliah mataKuliah = null;
        if (mataKuliahIdStr != null) {
            UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
            mataKuliah = mataKuliahPrasyaratRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, mataKuliahId);
        }

        MataKuliahPrasyarat mataKuliahPrasyarat = mataKuliahPrasyaratFactory.createMataKuliahPrasyarat(
            "siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratImpl", mataKuliah, parentMataKuliah, syarat);

        mataKuliahPrasyaratRepository.saveObject(mataKuliahPrasyarat);

        return getAllMataKuliahPrasyarat();
      }
    
      public MataKuliahPrasyarat updateMataKuliahPrasyarat(HashMap<String, Object> body) {
        String idStr = (String) body.get("id");
        UUID id = UUID.fromString(idStr);
    
        String syarat = (String) body.get("syarat");
        String mataKuliahIdStr = (String) body.get("mataKuliahId");
        String parentMataKuliahIdStr = (String) body.get("parentMataKuliahId");

        MataKuliahPrasyarat mataKuliahPrasyarat = mataKuliahPrasyaratRepository.getObject(id);
    
        MataKuliah parentMataKuliah = null;
        if (parentMataKuliahIdStr != null) {
            UUID parentMataKuliahId = UUID.fromString(parentMataKuliahIdStr);
            parentMataKuliah = mataKuliahPrasyaratRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, parentMataKuliahId);
        }

        MataKuliah mataKuliah = null;
        if (mataKuliahIdStr != null) {
            UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
            mataKuliah = mataKuliahPrasyaratRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, mataKuliahId);
        }

        mataKuliahPrasyarat.setSyarat(syarat);
        mataKuliahPrasyarat.setMataKuliah(mataKuliah);
        mataKuliahPrasyarat.setParentMataKuliah(parentMataKuliah);

        mataKuliahPrasyaratRepository.updateObject(mataKuliahPrasyarat);
        mataKuliahPrasyarat = mataKuliahPrasyaratRepository.getObject(id);
    
        return mataKuliahPrasyarat;
      }
    
      public MataKuliahPrasyarat getMataKuliahPrasyarat(UUID id) {
        MataKuliahPrasyarat mataKuliahPrasyarat = mataKuliahPrasyaratRepository.getObject(id);
        return mataKuliahPrasyarat;
      }
    
      public List<MataKuliahPrasyarat> getAllMataKuliahPrasyarat() {
        List<MataKuliahPrasyarat> mataKuliahPrasyaratList = mataKuliahPrasyaratRepository.getAllObject("matakuliahprasyarat_impl",
            MataKuliahPrasyaratImpl.class.getName());
        return mataKuliahPrasyaratList;
      }
    
      public List<MataKuliahPrasyarat> getAllMataKuliahPrasyaratFromParent(UUID id) {
        List<MataKuliahPrasyarat> mataKuliahPrasyaratList = mataKuliahPrasyaratRepository.getListObject("matakuliahprasyarat_impl", "parentmatakuliah_id", id);
        return mataKuliahPrasyaratList;
      }
      
      public List<MataKuliahPrasyarat> deleteMataKuliahPrasyarat(UUID id) {
        mataKuliahPrasyaratRepository.deleteObject(id);
        return getAllMataKuliahPrasyarat();
      }
    
      public List<HashMap<String, Object>> transformMataKuliahPrasyaratListToHashMap(List<MataKuliahPrasyarat> mataKuliahPrasyaratList) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < mataKuliahPrasyaratList.size(); i++) {
            resultList.add(mataKuliahPrasyaratList.get(i).toHashMap());
        }
        return resultList;
      }

      public List<HashMap<String, String>> listSyarat() {
        List<HashMap<String, String>> syaratList = new ArrayList<>();
        HashMap<String, String> lulus = new HashMap<>();
        lulus.put("name", "Sudah Lulus");
        syaratList.add(lulus);
        return syaratList;
      }

}