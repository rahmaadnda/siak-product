package siakreborn.matakuliahprasyarat.core;

import java.util.*;

import siakreborn.matakuliah.core.MataKuliah;

public abstract class MataKuliahPrasyaratServiceDecorator extends MataKuliahPrasyaratServiceComponent {
  protected MataKuliahPrasyaratServiceComponent record;

  public MataKuliahPrasyaratServiceDecorator(MataKuliahPrasyaratServiceComponent record) {
    this.record = record;
  }

  public List<MataKuliahPrasyarat> saveMataKuliahPrasyarat(HashMap<String, Object> body) {
    return record.saveMataKuliahPrasyarat(body);
  }

  public MataKuliahPrasyarat updateMataKuliahPrasyarat(HashMap<String, Object> body) {
    return record.updateMataKuliahPrasyarat(body);
  }

  public MataKuliahPrasyarat getMataKuliahPrasyarat(UUID id) {
    return record.getMataKuliahPrasyarat(id);
  }

  public List<MataKuliahPrasyarat> getAllMataKuliahPrasyarat() {
    return record.getAllMataKuliahPrasyarat();
  }

  public List<MataKuliahPrasyarat> getAllMataKuliahPrasyaratFromParent(UUID id) {
    return record.getAllMataKuliahPrasyaratFromParent(id);
  }
  
  public List<MataKuliahPrasyarat> deleteMataKuliahPrasyarat(UUID id) {
    return record.deleteMataKuliahPrasyarat(id);
  }

  public List<HashMap<String, Object>> transformMataKuliahPrasyaratListToHashMap(List<MataKuliahPrasyarat> mataKuliahPrasyaratList) {
    return record.transformMataKuliahPrasyaratListToHashMap(mataKuliahPrasyaratList);
  }

  public List<HashMap<String, String>> listSyarat() {
    return record.listSyarat();
  }

}
