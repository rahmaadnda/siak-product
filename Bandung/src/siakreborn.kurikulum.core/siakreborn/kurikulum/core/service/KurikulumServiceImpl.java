package siakreborn.kurikulum.core;

import java.util.*;

import siakreborn.kurikulum.KurikulumFactory;
import siakreborn.programstudi.core.ProgramStudi;

public class KurikulumServiceImpl extends KurikulumServiceComponent {
  private KurikulumFactory kurikulumFactory = new KurikulumFactory();

  public List<Kurikulum> saveKurikulum(HashMap<String, Object> body) {
    String kode = (String) body.get("kode");
    String noSK = (String) body.get("noSK");
    String status = (String) body.get("status");
    String profilLulusan = (String) body.get("profilLulusan");
    String programStudiIdStr = (String) body.get("programStudiId");

    ProgramStudi programStudi = null;
    if (programStudiIdStr != null) {
      UUID programStudiId = UUID.fromString(programStudiIdStr);
      programStudi = kurikulumRepository.getProxyObject(siakreborn.programstudi.core.ProgramStudiComponent.class,
          programStudiId);
    }

    Kurikulum kurikulum = kurikulumFactory.createKurikulum("siakreborn.kurikulum.core.KurikulumImpl", kode, noSK,
        status, profilLulusan, programStudi);

    kurikulumRepository.saveObject(kurikulum);
    return getAllKurikulum();
  }

  public Kurikulum updateKurikulum(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String noSK = (String) body.get("noSK");
    String status = (String) body.get("status");
    String profilLulusan = (String) body.get("profilLulusan");
    String programStudiIdStr = (String) body.get("programStudiId");

    Kurikulum kurikulum = kurikulumRepository.getObject(id);

    ProgramStudi programStudi = kurikulum.getProgramStudi();
    if (programStudiIdStr != null) {
      UUID programStudiId = UUID.fromString(programStudiIdStr);
      programStudi = kurikulumRepository.getProxyObject(siakreborn.programstudi.core.ProgramStudiComponent.class,
          programStudiId);
    }

    kurikulum.setKode(kode);
    kurikulum.setNoSK(noSK);
    kurikulum.setStatus(status);
    kurikulum.setProfilLulusan(profilLulusan);
    kurikulum.setProgramStudi(programStudi);

    kurikulumRepository.updateObject(kurikulum);
    kurikulum = kurikulumRepository.getObject(id);

    return kurikulum;
  }

  public Kurikulum getKurikulum(UUID id) {
    Kurikulum kurikulum = kurikulumRepository.getObject(id);
    return kurikulum;
  }

  public List<Kurikulum> getAllKurikulum() {
    List<Kurikulum> kurikulumList = kurikulumRepository.getAllObject("kurikulum_impl", KurikulumImpl.class.getName());
    return kurikulumList;
  }

  public List<Kurikulum> filterKurikulumByProgramStudi(UUID programStudiId) {
    List<Kurikulum> kurikulumList = kurikulumRepository.getListObject("kurikulum_comp", "programstudi_id",
        programStudiId);
    return kurikulumList;
  }

  public List<Kurikulum> deleteKurikulum(UUID id) {
    kurikulumRepository.deleteObject(id);
    return getAllKurikulum();
  }

  public List<HashMap<String, Object>> transformKurikulumListToHashMap(List<Kurikulum> kurikulumList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kurikulumList.size(); i++) {
      resultList.add(kurikulumList.get(i).toHashMap());
    }

    return resultList;
  }
}
