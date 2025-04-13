package siakreborn.capaian.subcpmk;

import java.util.*;

import siakreborn.capaian.CapaianFactory;
import siakreborn.capaian.core.CapaianServiceDecorator;
import siakreborn.capaian.core.CapaianServiceComponent;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;
import siakreborn.capaian.core.CapaianDecorator;

public class CapaianServiceImpl extends CapaianServiceDecorator {
  private CapaianFactory capaianFactory = new CapaianFactory();

  public CapaianServiceImpl(CapaianServiceComponent record) {
    super(record);
  }

  public List<Capaian> saveCapaian(HashMap<String, Object> body) {
    String kode = (String) body.get("kode");
    String deskripsi = (String) body.get("deskripsi");
    String bobotStr = (String) body.get("bobot");
    int bobot = Integer.parseInt(bobotStr);
    String parentCPMKIdStr = (String) body.get("parentCPMKId");

    Capaian parentCPMK = null;
    if (parentCPMKIdStr != null) {
      UUID parentCPMKId = UUID.fromString(parentCPMKIdStr);
      parentCPMK = capaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class, parentCPMKId);
    }

    Capaian capaian = capaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", kode, deskripsi);
    Capaian capaianSubCPMK = capaianFactory.createCapaian("siakreborn.capaian.subcpmk.CapaianImpl", capaian, bobot,
        parentCPMK);

    capaianRepository.saveObject(capaian);
    capaianRepository.saveObject(capaianSubCPMK);

    return getAllCapaian();
  }

  public Capaian updateCapaian(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String deskripsi = (String) body.get("deskripsi");
    String bobotStr = (String) body.get("bobot");
    int bobot = Integer.parseInt(bobotStr);
    String parentCPMKIdStr = (String) body.get("parentCPMKId");

    Capaian parentCPMK = null;
    if (parentCPMKIdStr != null) {
      UUID parentCPMKId = UUID.fromString(parentCPMKIdStr);
      parentCPMK = capaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class, parentCPMKId);
    }

    Capaian savedCapaian = capaianRepository.getObject(id);
    UUID recordCapaianId = (((CapaianDecorator) savedCapaian).getRecord()).getId();
    Capaian capaian = capaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", recordCapaianId, kode,
        deskripsi);
    Capaian capaianCPMK = capaianFactory.createCapaian("siakreborn.capaian.subcpmk.CapaianImpl", id, capaian, bobot,
        parentCPMK);

    capaianRepository.updateObject(capaian);
    capaianRepository.updateObject(capaianCPMK);
    capaian = capaianRepository.getObject(id);

    return capaian;
  }

  public Capaian getCapaian(UUID id) {
    return record.getCapaian(id);
  }

  public List<Capaian> getAllCapaian() {
    List<Capaian> capaianList = capaianRepository.getAllObject("capaian_subcpmk");
    return capaianList;
  }

  public List<Capaian> filterCapaian(String columnName, UUID id) {
    List<Capaian> capaianList = capaianRepository.getListObject("capaian_subcpmk", columnName, id);
    return capaianList;
  }

  public List<Capaian> deleteCapaian(UUID id) {
    capaianRepository.deleteObject(id);
    return getAllCapaian();
  }
}
