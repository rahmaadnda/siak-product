package siakreborn.informasi.alumni;

import java.util.*;

import siakreborn.informasi.InformasiFactory;
import siakreborn.informasi.core.*;

import siakreborn.observer.ObserverServiceFactory;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverService;
import siakreborn.observer.alumni.ObserverServiceImpl;

import vmj.routing.route.exceptions.NotFoundException;

public class InformasiServiceImpl extends InformasiServiceDecorator {
  private InformasiFactory informasiFactory = new InformasiFactory();
  private ObserverService alumniService;

  public InformasiServiceImpl(InformasiServiceComponent record) {
    super(record);
    this.alumniService = ObserverServiceFactory.createObserverService(
      "siakreborn.observer.alumni.ObserverServiceImpl",
      ObserverServiceFactory.createObserverService(
        "siakreborn.observer.core.ObserverServiceImpl"
    ));
  }

  public List<Informasi> saveInformasi(HashMap<String, Object> body, String email) {
    Observer alumni = ((ObserverServiceImpl) alumniService).getObserverByEmail(email);

    String judul = (String) body.get("judul");
    String deskripsi = (String) body.get("deskripsi");
    Date tanggalPublikasi = new Date();

    Informasi informasi = InformasiFactory.createInformasi(
        "siakreborn.informasi.core.InformasiImpl",
        judul,
        deskripsi,
        tanggalPublikasi
    );
    Informasi informasiAlumni = informasiFactory.createInformasi("siakreborn.informasi.alumni.InformasiImpl", informasi, alumni);

    informasiRepository.saveObject(informasi);
    informasiRepository.saveObject(informasiAlumni);
    return getAllInformasi();
  }

  public Informasi updateInformasi(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String judul = (String) body.get("judul");
    String deskripsi = (String) body.get("deskripsi");
    Date tanggalPublikasi = new Date();

    Informasi savedInformasi = informasiRepository.getObject(id);
    UUID recordInformasiId = ((InformasiDecorator) savedInformasi).getRecord().getId();
    Informasi informasi = InformasiFactory.createInformasi(
        "siakreborn.informasi.core.InformasiImpl",
        judul,
        deskripsi,
        tanggalPublikasi
    );
    Informasi informasiAlumni = informasiFactory.createInformasi("siakreborn.informasi.alumni.InformasiImpl", id, informasi, ((InformasiImpl) savedInformasi).getAlumni());

    informasiRepository.updateObject(informasi);
    informasiRepository.updateObject(informasiAlumni);
    informasi = informasiRepository.getObject(id);

    return informasi;
  }

  public Informasi getInformasi(UUID id) {
    return record.getInformasi(id);
  }

  public List<Informasi> getAllInformasi() {
    List<Informasi> informasiList = informasiRepository.getAllObject("informasi_alumni");
    return informasiList;
  }

  public List<Informasi> deleteInformasi(UUID id) {
    informasiRepository.deleteObject(id);
    return getAllInformasi();
  }
}
