package siakreborn.informasi.akademik;

import java.util.*;

import siakreborn.informasi.InformasiFactory;
import siakreborn.informasi.core.*;

import siakreborn.adminakademik.core.*;

import vmj.routing.route.exceptions.NotFoundException;

public class InformasiServiceImpl extends InformasiServiceDecorator {
  private InformasiFactory informasiFactory = new InformasiFactory();
  private AdminAkademikService adminAkademikService = new AdminAkademikServiceImpl();

  public InformasiServiceImpl(InformasiServiceComponent record) {
    super(record);
  }

  public List<Informasi> saveInformasi(HashMap<String, Object> body, String email) {
    AdminAkademik adminAkademik = adminAkademikService.getAdminAkademikByEmail(email);

    String judul = (String) body.get("judul");
    String deskripsi = (String) body.get("deskripsi");
    Date tanggalPublikasi = new Date();

    Informasi informasi = InformasiFactory.createInformasi(
        "siakreborn.informasi.core.InformasiImpl",
        judul,
        deskripsi,
        tanggalPublikasi
    );
    Informasi informasiAkademik = informasiFactory.createInformasi("siakreborn.informasi.akademik.InformasiImpl", informasi, adminAkademik);

    informasiRepository.saveObject(informasi);
    informasiRepository.saveObject(informasiAkademik);
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
    Informasi informasiAkademik = informasiFactory.createInformasi("siakreborn.informasi.akademik.InformasiImpl", id, informasi, ((InformasiImpl) savedInformasi).getAdminAkademik());

    informasiRepository.updateObject(informasi);
    informasiRepository.updateObject(informasiAkademik);
    informasi = informasiRepository.getObject(id);

    return informasi;
  }

  public Informasi getInformasi(UUID id) {
    return record.getInformasi(id);
  }

  public List<Informasi> getAllInformasi() {
    List<Informasi> informasiList = informasiRepository.getAllObject("informasi_akademik");
    return informasiList;
  }

  public List<Informasi> deleteInformasi(UUID id) {
    informasiRepository.deleteObject(id);
    return getAllInformasi();
  }
}
