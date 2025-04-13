package siakreborn.kurikulum.core;

import java.util.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.exceptions.*;
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

    Map<String, byte[]> uploadedFile = (HashMap<String, byte[]>) body.get("sKUrl");

    String base64Encoded  = Base64.getEncoder().encodeToString(uploadedFile.get("content"));

    byte[] sKUrl = base64Encoded.getBytes(StandardCharsets.UTF_8);

    byte[] fileContent = uploadedFile.get("content");

    int fileSize = uploadedFile.get("content").length;

    if (fileSize > 15000000)
        throw new FileSizeException(15.0, ((double) fileSize) / 1000000, "megabyte");

    if (!(fileContent[0] == 0x25 && fileContent[1] == 0x50 && fileContent[2] == 0x44 && fileContent[3] == 0x46)) {
        throw new FileTypeException("PDF");
    }

    Kurikulum kurikulum = kurikulumFactory.createKurikulum("siakreborn.kurikulum.core.KurikulumImpl", kode, noSK,
        status, profilLulusan, programStudi, sKUrl);

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

    if (body.containsKey("sKUrl")) {
      Object rawUploadedFile = body.get("sKUrl");
      
      if (rawUploadedFile instanceof HashMap) {
          Map<String, byte[]> uploadedFile = (HashMap<String, byte[]>) rawUploadedFile;
          
          if (uploadedFile != null) {
              String base64Encoded  = Base64.getEncoder().encodeToString(uploadedFile.get("content"));

              byte[] sKUrl = base64Encoded.getBytes(StandardCharsets.UTF_8);

              byte[] fileContent = uploadedFile.get("content");

              int fileSize = uploadedFile.get("content").length;

              if (fileSize > 15000000)
                  throw new FileSizeException(15.0, ((double) fileSize) / 1000000, "megabyte");

              if (!(fileContent[0] == 0x25 && fileContent[1] == 0x50 && fileContent[2] == 0x44 && fileContent[3] == 0x46)) {
                  throw new FileTypeException("PDF");
              }

              kurikulum.setSKUrl(sKUrl);
          }
      } else {
          throw new IllegalArgumentException("Invalid type for 'sKUrl': Expected HashMap<String, byte[]>.");
      }
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
