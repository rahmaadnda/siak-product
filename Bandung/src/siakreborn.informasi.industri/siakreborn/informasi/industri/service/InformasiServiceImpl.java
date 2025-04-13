package siakreborn.informasi.industri;

import java.util.*;

import siakreborn.informasi.InformasiFactory;
import siakreborn.informasi.core.*;

import siakreborn.observer.ObserverServiceFactory;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverService;
import siakreborn.observer.industri.ObserverServiceImpl;

import vmj.routing.route.exceptions.NotFoundException;

public class InformasiServiceImpl extends InformasiServiceDecorator {
  private InformasiFactory informasiFactory = new InformasiFactory();
  private ObserverService industriService;

  public InformasiServiceImpl(InformasiServiceComponent record) {
    super(record);
    this.industriService = ObserverServiceFactory.createObserverService(
      "siakreborn.observer.industri.ObserverServiceImpl",
      ObserverServiceFactory.createObserverService(
        "siakreborn.observer.core.ObserverServiceImpl"
    ));
  }

  public List<Informasi> saveInformasi(HashMap<String, Object> body, String email) {
    Observer industri = ((ObserverServiceImpl) industriService).getObserverByEmail(email);
    String judul = (String) body.get("judul");
    String deskripsi = (String) body.get("deskripsi");
    Date tanggalPublikasi = new Date();

    Informasi informasi = InformasiFactory.createInformasi(
        "siakreborn.informasi.core.InformasiImpl",
        judul,
        deskripsi,
        tanggalPublikasi
    );
    Informasi informasiIndustri = informasiFactory.createInformasi("siakreborn.informasi.industri.InformasiImpl", informasi, industri);

    informasiRepository.saveObject(informasi);
    informasiRepository.saveObject(informasiIndustri);
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
    Informasi informasiIndustri = informasiFactory.createInformasi("siakreborn.informasi.industri.InformasiImpl", id, informasi, ((InformasiImpl) savedInformasi).getIndustri());

    informasiRepository.updateObject(informasi);
    informasiRepository.updateObject(informasiIndustri);
    informasi = informasiRepository.getObject(id);

    return informasi;
  }

  public Informasi getInformasi(UUID id) {
    return record.getInformasi(id);
  }

  public List<Informasi> getAllInformasi() {
    List<Informasi> informasiList = informasiRepository.getAllObject("informasi_industri");
    return informasiList;
  }

  public List<Informasi> deleteInformasi(UUID id) {
    informasiRepository.deleteObject(id);
    return getAllInformasi();
  }
}
