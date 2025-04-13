package siakreborn.matakuliah.core;

import java.util.*;

import siakreborn.matakuliah.MataKuliahFactory;
import siakreborn.kurikulum.core.Kurikulum;

public class MataKuliahServiceImpl extends MataKuliahServiceComponent {
  private MataKuliahFactory mataKuliahFactory = new MataKuliahFactory();

  public List<MataKuliah> saveMataKuliah(HashMap<String, Object> body) {
    String kode = (String) body.get("kode");
    String nama = (String) body.get("nama");
    String sksStr = (String) body.get("sks");
    int sks = Integer.parseInt(sksStr);
    String termStr = (String) body.get("term");
    int term = Integer.parseInt(termStr);
    String kurikulumIdStr = (String) body.get("kurikulumId");

    Kurikulum kurikulum = null;
    if (kurikulumIdStr != null) {
      UUID kurikulumId = UUID.fromString(kurikulumIdStr);
      kurikulum = mataKuliahRepository.getProxyObject(siakreborn.kurikulum.core.KurikulumComponent.class, kurikulumId);
    }

    MataKuliah mataKuliah = mataKuliahFactory.createMataKuliah("siakreborn.matakuliah.core.MataKuliahImpl", kode, nama,
        sks, term, kurikulum);

    mataKuliahRepository.saveObject(mataKuliah);
    return getAllMataKuliah();
  }

  public MataKuliah updateMataKuliah(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String nama = (String) body.get("nama");
    String sksStr = (String) body.get("sks");
    int sks = Integer.parseInt(sksStr);
    String termStr = (String) body.get("term");
    int term = Integer.parseInt(termStr);
    String kurikulumIdStr = (String) body.get("kurikulumId");

    MataKuliah mataKuliah = mataKuliahRepository.getObject(id);

    Kurikulum kurikulum = mataKuliah.getKurikulum();
    if (kurikulumIdStr != null) {
      UUID kurikulumId = UUID.fromString(kurikulumIdStr);
      kurikulum = mataKuliahRepository.getProxyObject(siakreborn.kurikulum.core.KurikulumComponent.class, kurikulumId);
    }

    mataKuliah.setKode(kode);
    mataKuliah.setNama(nama);
    mataKuliah.setSks(sks);
    mataKuliah.setTerm(term);
    mataKuliah.setKurikulum(kurikulum);

    mataKuliahRepository.updateObject(mataKuliah);
    mataKuliah = mataKuliahRepository.getObject(id);

    return mataKuliah;
  }

  public MataKuliah getMataKuliah(UUID id) {
    MataKuliah mataKuliah = mataKuliahRepository.getObject(id);
    return mataKuliah;
  }

  public List<MataKuliah> getAllMataKuliah() {
    List<MataKuliah> mataKuliahList = mataKuliahRepository.getAllObject("mata_kuliah_impl",
        MataKuliahImpl.class.getName());
    return mataKuliahList;
  }

  public List<MataKuliah> deleteMataKuliah(UUID id) {
    mataKuliahRepository.deleteObject(id);
    return getAllMataKuliah();
  }

  public List<HashMap<String, Object>> transformMataKuliahListToHashMap(List<MataKuliah> mataKuliahList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < mataKuliahList.size(); i++) {
      resultList.add(mataKuliahList.get(i).toHashMap());
    }

    return resultList;
  }
}
