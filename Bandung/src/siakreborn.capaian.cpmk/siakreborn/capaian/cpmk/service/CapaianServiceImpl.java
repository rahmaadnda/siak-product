package siakreborn.capaian.cpmk;

import java.util.*;

import siakreborn.capaian.CapaianFactory;
import siakreborn.capaian.core.CapaianServiceDecorator;
import siakreborn.capaian.core.CapaianServiceComponent;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;
import siakreborn.capaian.core.CapaianDecorator;
import siakreborn.matakuliah.core.MataKuliah;

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
    String mataKuliahIdStr = (String) body.get("mataKuliahId");
    String parentCPLIdStr = (String) body.get("parentCPLId");

    MataKuliah mataKuliah = null;
    if (mataKuliahIdStr != null) {
      UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
      mataKuliah = capaianRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, mataKuliahId);
    }

    Capaian parentCPL = null;
    if (parentCPLIdStr != null) {
      UUID parentCPLId = UUID.fromString(parentCPLIdStr);
      parentCPL = capaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class, parentCPLId);
    }

    Capaian capaian = capaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", kode, deskripsi);
    Capaian capaianCPMK = capaianFactory.createCapaian("siakreborn.capaian.cpmk.CapaianImpl", capaian, bobot,
        mataKuliah, parentCPL);

    capaianRepository.saveObject(capaian);
    capaianRepository.saveObject(capaianCPMK);

    return getAllCapaian();
  }

  public Capaian updateCapaian(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String deskripsi = (String) body.get("deskripsi");
    String bobotStr = (String) body.get("bobot");
    int bobot = Integer.parseInt(bobotStr);
    String mataKuliahIdStr = (String) body.get("mataKuliahId");
    String parentCPLIdStr = (String) body.get("parentCPLId");

    MataKuliah mataKuliah = null;
    if (mataKuliahIdStr != null) {
      UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
      mataKuliah = capaianRepository.getProxyObject(siakreborn.matakuliah.core.MataKuliahComponent.class, mataKuliahId);
    }

    Capaian parentCPL = null;
    if (parentCPLIdStr != null) {
      UUID parentCPLId = UUID.fromString(parentCPLIdStr);
      parentCPL = capaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class, parentCPLId);
    }

    Capaian savedCapaian = capaianRepository.getObject(id);
    UUID recordCapaianId = ((CapaianDecorator) savedCapaian).getRecord().getId();
    Capaian capaian = capaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", recordCapaianId, kode,
        deskripsi);
    Capaian capaianCPMK = capaianFactory.createCapaian("siakreborn.capaian.cpmk.CapaianImpl", id, capaian, bobot,
        mataKuliah, parentCPL);

    capaianRepository.updateObject(capaian);
    capaianRepository.updateObject(capaianCPMK);
    capaian = capaianRepository.getObject(id);

    return capaian;
  }

  public Capaian getCapaian(UUID id) {
    return record.getCapaian(id);
  }

  public List<Capaian> getAllCapaian() {
    List<Capaian> capaianList = capaianRepository.getAllObject("capaian_cpmk");
    return capaianList;
  }

  public List<Capaian> filterCapaian(String columnName, UUID id) {
    List<Capaian> capaianList = capaianRepository.getListObject("capaian_cpmk", columnName, id);
    return capaianList;
  }

  public List<Capaian> deleteCapaian(UUID id) {
    capaianRepository.deleteObject(id);
    return getAllCapaian();
  }
}
