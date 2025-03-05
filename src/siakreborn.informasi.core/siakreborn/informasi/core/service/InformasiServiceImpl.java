package siakreborn.informasi.core;

import java.util.*;
import java.time.Instant;

import siakreborn.informasi.InformasiFactory;

import vmj.routing.route.exceptions.NotFoundException;

public class InformasiServiceImpl extends InformasiServiceComponent {
  private InformasiFactory informasiFactory = new InformasiFactory();

public List<Informasi> saveInformasi(HashMap<String, Object> body) {
    String judul = (String) body.get("judul");
    String deskripsi = (String) body.get("deskripsi");
    Date tanggalPublikasi = new Date();

    Informasi informasi = InformasiFactory.createInformasi(
        "siakreborn.informasi.core.InformasiImpl",
        judul,
        deskripsi,
        tanggalPublikasi
    );

    informasiRepository.saveObject(informasi);
    return getAllInformasi();
}

public Informasi updateInformasi(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String judul = (String) body.get("judul");
    String deskripsi = (String) body.get("deskripsi");
    String tanggalPublikasiStr = (String) body.get("tanggalPublikasi");
    Date tanggalPublikasi = Date.from(Instant.parse(tanggalPublikasiStr));
    
    Informasi informasi = informasiRepository.getObject(id);
    informasi.setJudul(judul);
    informasi.setDeskripsi(deskripsi);
    informasi.setTanggalPublikasi(tanggalPublikasi);
  
    informasiRepository.updateObject(informasi);

    informasi = informasiRepository.getObject(id);
    return informasi;
}


  public Informasi getInformasi(UUID id) {
    Informasi informasi = informasiRepository.getObject(id);
    return informasi;
  }

  public List<Informasi> getAllInformasi() {
    List<Informasi> informasiList = informasiRepository.getAllObject("informasi_impl", InformasiImpl.class.getName());
    return informasiList;
  }

  public List<Informasi> deleteInformasi(UUID id) {
    informasiRepository.deleteObject(id);
    return getAllInformasi();
  }

  public List<HashMap<String, Object>> transformInformasiListToHashMap(List<Informasi> informasiList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < informasiList.size(); i++) {
      resultList.add(informasiList.get(i).toHashMap());
    }

    return resultList;
  }
}
