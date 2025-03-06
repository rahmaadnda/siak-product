package siakreborn.capaian.cpl;

import java.util.*;

import siakreborn.capaian.CapaianFactory;
import siakreborn.capaian.core.CapaianServiceDecorator;
import siakreborn.capaian.core.CapaianServiceComponent;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;
import siakreborn.capaian.core.CapaianDecorator;
import siakreborn.kurikulum.core.Kurikulum;

public class CapaianServiceImpl extends CapaianServiceDecorator {
  private CapaianFactory capaianFactory = new CapaianFactory();

  public CapaianServiceImpl(CapaianServiceComponent record) {
    super(record);
  }

  public List<Capaian> saveCapaian(HashMap<String, Object> body) {
    String kode = (String) body.get("kode");
    String deskripsi = (String) body.get("deskripsi");
    String kurikulumIdStr = (String) body.get("kurikulumId");

    Kurikulum kurikulum = null;
    if (kurikulumIdStr != null) {
      UUID kurikulumId = UUID.fromString(kurikulumIdStr);
      kurikulum = capaianRepository.getProxyObject(siakreborn.kurikulum.core.KurikulumComponent.class, kurikulumId);
    }

    Capaian capaian = capaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", kode, deskripsi);
    Capaian capaianCPL = capaianFactory.createCapaian("siakreborn.capaian.cpl.CapaianImpl", capaian, kurikulum);

    capaianRepository.saveObject(capaian);
    capaianRepository.saveObject(capaianCPL);

    return getAllCapaian();
  }

  public Capaian updateCapaian(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String deskripsi = (String) body.get("deskripsi");
    String kurikulumIdStr = (String) body.get("kurikulumId");

    Kurikulum kurikulum = null;
    if (kurikulumIdStr != null) {
      UUID kurikulumId = UUID.fromString(kurikulumIdStr);
      kurikulum = capaianRepository.getProxyObject(siakreborn.kurikulum.core.KurikulumComponent.class, kurikulumId);
    }

    Capaian savedCapaian = capaianRepository.getObject(id);
    UUID recordCapaianId = (((CapaianDecorator) savedCapaian).getRecord()).getId();
    Capaian capaian = capaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", recordCapaianId, kode,
        deskripsi);
    Capaian capaianCPL = capaianFactory.createCapaian("siakreborn.capaian.cpl.CapaianImpl", id, capaian, kurikulum);

    capaianRepository.updateObject(capaian);
    capaianRepository.updateObject(capaianCPL);
    capaian = capaianRepository.getObject(id);

    return capaian;
  }

  public Capaian getCapaian(UUID id) {
    return record.getCapaian(id);
  }

  public List<Capaian> getAllCapaian() {
    List<Capaian> capaianList = capaianRepository.getAllObject("capaian_cpl");
    return capaianList;
  }

  public List<Capaian> filterCapaian(String columnName, UUID id) {
    List<Capaian> capaianList = capaianRepository.getListObject("capaian_cpl", columnName, id);
    return capaianList;
  }

  public List<Capaian> deleteCapaian(UUID id) {
    capaianRepository.deleteObject(id);
    return getAllCapaian();
  }
}
