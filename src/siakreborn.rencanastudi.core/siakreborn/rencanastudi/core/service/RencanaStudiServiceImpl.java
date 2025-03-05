package siakreborn.rencanastudi.core;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.Instant;

import org.hibernate.Transaction;
import org.hibernate.Session;

import vmj.routing.route.exceptions.ForbiddenException;

import siakreborn.kelas.core.Kelas;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;
import siakreborn.semester.core.Semester;
import siakreborn.semester.core.SemesterService;
import siakreborn.semester.core.SemesterServiceImpl;
import siakreborn.kelas.core.Kelas;
import siakreborn.kelas.core.KelasService;
import siakreborn.kelas.core.KelasServiceImpl;
import siakreborn.kelasdosen.core.KelasDosenService;
import siakreborn.kelasdosen.core.KelasDosenServiceImpl;
import siakreborn.rencanastudi.RencanaStudiFactory;
import siakreborn.rencanastudi.PengisianRencanaStudiFactory;
import siakreborn.pembayaran.core.Pembayaran;
import siakreborn.pembayaran.core.PembayaranService;
import siakreborn.pembayaran.core.PembayaranServiceImpl;

public class RencanaStudiServiceImpl extends RencanaStudiServiceComponent {
  private RencanaStudiFactory rencanaStudiFactory = new RencanaStudiFactory();
  private PengisianRencanaStudiFactory pengisianRencanaStudiFactory = new PengisianRencanaStudiFactory();
  private SemesterService semesterService = new SemesterServiceImpl();
  private KelasService kelasService = new KelasServiceImpl();
  private KelasMahasiswaService kelasMahasiswaService = new KelasMahasiswaServiceImpl();
  private KelasDosenService kelasDosenService = new KelasDosenServiceImpl();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();
  private PembayaranService pembayaranService = new PembayaranServiceImpl();

  public RencanaStudi saveRencanaStudi(HashMap<String, Object> body, Mahasiswa mahasiswa) {
    PengisianRencanaStudi pengisianRencanaStudi = getActivePengisianRencanaStudi();
    Date mulaiPengisian = pengisianRencanaStudi.getMulai();
    Date akhirPengisian = pengisianRencanaStudi.getAkhir();
    Date now = new Date();

    if (mulaiPengisian == null || akhirPengisian == null || now.before(mulaiPengisian) || now.after(akhirPengisian)) {
      throw new ForbiddenException("Masa pengisian belum mulai atau telah berakhir");
    }

    List<String> kelasIds = (List<String>) body.get("kelasIds");

    Semester semester = semesterService.getActiveSemester();

    List<Kelas> kelasList = new ArrayList<>();
    int totalSks = 0;
    for (String kelasIdStr : kelasIds) {
      UUID kelasId = UUID.fromString(kelasIdStr);
      Kelas kelas = kelasService.getKelas(kelasId);
      totalSks += kelas.getMataKuliah().getSks();
      kelasList.add(kelas);
    }

    // create or update RencanaStudi
    List<RencanaStudi> rencanaStudiList = rencanaStudiRepository
        .getListObject("rencana_studi_comp", "mahasiswa_id", mahasiswa.getId());

    RencanaStudi rencanaStudi = null;
    for (RencanaStudi r : rencanaStudiList) {
      if (r.getSemester().getId().toString().equals(semester.getId().toString())) {
        rencanaStudi = r;
        break;
      }
    }

    if (rencanaStudi == null) {
      rencanaStudi = rencanaStudiFactory.createRencanaStudi("siakreborn.rencanastudi.core.RencanaStudiImpl",
          mahasiswa, semester, totalSks, "Menunggu persetujuan");
      rencanaStudiRepository.saveObject(rencanaStudi);
    } else {
      rencanaStudi.setTotalSKS(totalSks);
      rencanaStudi.setStatus("Menunggu persetujuan");
      rencanaStudiRepository.updateObject(rencanaStudi);
    }

    // add new KelasMahasiswa
    List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaService.filterKelasMahasiswa("rencanastudi_id",
        rencanaStudi.getId());
    Set<String> kelasIdSet = new TreeSet<>();
    for (KelasMahasiswa kelasMahasiswa : kelasMahasiswaList) {
      kelasIdSet.add(kelasMahasiswa.getKelas().getId().toString());
    }

    for (Kelas kelas : kelasList) {
      if (!kelasIdSet.contains(kelas.getId().toString())) {
        HashMap<String, Object> kelasMahasiswaBody = new HashMap<>();
        kelasMahasiswaBody.put("rencanaStudiId", rencanaStudi.getId().toString());
        kelasMahasiswaBody.put("kelasId", kelas.getId().toString());

        kelasMahasiswaService.saveKelasMahasiswa(kelasMahasiswaBody);
      }
    }

    // delete dropped KelasMahasiswa
    kelasIdSet.clear();
    for (Kelas kelas : kelasList) {
      kelasIdSet.add(kelas.getId().toString());
    }

    for (KelasMahasiswa kelasMahasiswa : kelasMahasiswaList) {
      if (!kelasIdSet.contains(kelasMahasiswa.getKelas().getId().toString())) {
        kelasMahasiswaService.deleteKelasMahasiswa(kelasMahasiswa.getId());
      }
    }

    // update status based on payment
    Pembayaran pembayaran = pembayaranService.getPembayaran(mahasiswa.getId(), semester.getId());
    if (pembayaran == null || !(pembayaran.getStatus().equalsIgnoreCase("complete")
        || pembayaran.getStatus().equalsIgnoreCase("settlement")
        || pembayaran.getStatus().equalsIgnoreCase("successful"))) {
      rencanaStudi.setStatus("Menunggu pembayaran");
      rencanaStudiRepository.updateObject(rencanaStudi);
    }

    return rencanaStudi;
  }

  public RencanaStudi getRencanaStudi(UUID id) {
    RencanaStudi rencanaStudi = rencanaStudiRepository.getObject(id);
    return rencanaStudi;
  }

  public HashMap<String, Object> getRencanaStudiClass(UUID mahasiswaId) {
    PengisianRencanaStudi pengisianRencanaStudi = getActivePengisianRencanaStudi();
    Date mulaiPengisian = pengisianRencanaStudi.getMulai();
    Date akhirPengisian = pengisianRencanaStudi.getAkhir();
    Date now = new Date();

    if (mulaiPengisian == null || akhirPengisian == null || now.before(mulaiPengisian) || now.after(akhirPengisian)) {
      throw new ForbiddenException("Masa pengisian belum mulai atau telah berakhir");
    }

    Semester semester = semesterService.getActiveSemester();
    List<Kelas> kelasList = kelasService.filterKelasBySemester(semester.getId());

    List<HashMap<String, Object>> mataKuliahList = kelasService.mataKuliahGrouper(kelasList);

    HashMap<String, Object> rencanaStudi = getActiveRencanaStudi(mahasiswaId);

    Set<String> rencanaStudiKelasSet = new TreeSet<>();
    if (rencanaStudi != null) {
      List<HashMap<String, Object>> rencanaStudiKelasList = (List<HashMap<String, Object>>) rencanaStudi.get("kelas");
      for (HashMap<String, Object> kelas : rencanaStudiKelasList) {
        rencanaStudiKelasSet.add(kelas.get("id").toString());
      }
    }

    for (HashMap<String, Object> mataKuliah : mataKuliahList) {
      List<HashMap<String, Object>> mataKuliahKelasList = (List<HashMap<String, Object>>) mataKuliah.get("kelas");
      for (HashMap<String, Object> kelas : mataKuliahKelasList) {
        UUID kelasId = (UUID) kelas.get("id");
        if (rencanaStudiKelasSet.contains(kelasId.toString())) {
          kelas.put("selected", true);
        } else {
          kelas.put("selected", false);
        }

        HashMap<String, Object> kelasWithDosen = kelasDosenService.getKelasWithDosen(kelasId);
        kelas.put("dosen", kelasWithDosen.get("dosen"));
      }
    }

    HashMap<String, Object> result = new HashMap<>();
    result.put("title", "Periode " + semester.getKode());
    result.put("mataKuliah", mataKuliahList);

    return result;
  }

  public List<RencanaStudi> getAllRencanaStudi() {
    List<RencanaStudi> rencanaStudiList = rencanaStudiRepository.getAllObject("rencana_studi_impl",
        RencanaStudiImpl.class.getName());
    return rencanaStudiList;
  }

  public List<RencanaStudi> deleteRencanaStudi(UUID id) {
    rencanaStudiRepository.deleteObject(id);
    return getAllRencanaStudi();
  }

  public HashMap<String, Object> getActiveRencanaStudi(UUID mahasiswaId) {
    Semester semester = semesterService.getActiveSemester();
    List<RencanaStudi> rencanaStudiList = rencanaStudiRepository.getListObject("rencana_studi_comp", "mahasiswa_id",
        mahasiswaId);

    for (RencanaStudi rencanaStudi : rencanaStudiList) {
      if (rencanaStudi.getSemester().getId().toString().equals(semester.getId().toString())) {
        List<KelasMahasiswa> kelasMahasiswaList = kelasMahasiswaService.filterKelasMahasiswa("rencanastudi_id",
            rencanaStudi.getId());
        List<HashMap<String, Object>> kelasList = new ArrayList<>();
        for (KelasMahasiswa kelasMahasiswa : kelasMahasiswaList) {
          Kelas kelas = kelasMahasiswa.getKelas();
          Date tanggalPengisian = kelasMahasiswa.getTanggalPengisian();

          HashMap<String, Object> kelasMap = kelas.toHashMap();
          kelasMap.put("tanggalPengisian", DateTimeFormatter.ISO_INSTANT.format(tanggalPengisian.toInstant()));

          kelasList.add(kelasMap);
        }

        Pembayaran pembayaran = pembayaranService.getPembayaran(mahasiswaId, semester.getId());

        if (rencanaStudi.getStatus().equals("Menunggu pembayaran") && pembayaran != null) {
          rencanaStudi.setStatus("Menunggu persetujuan");
          rencanaStudiRepository.updateObject(rencanaStudi);
        }

        HashMap<String, Object> map = rencanaStudi.toHashMap();
        map.put("kelas", kelasList);
        return map;
      }
    }

    return null;
  }

  public int getTotalSKS(UUID mahasiswaId) {
    List<RencanaStudi> rencanaStudiList = getRencanaStudiMahasiswa(mahasiswaId);

    int totalSKS = 0;
    for (RencanaStudi rencanaStudi : rencanaStudiList) {
      totalSKS += rencanaStudi.getTotalSKS();
    }

    return totalSKS;
  }

  public List<RencanaStudi> getRencanaStudiMahasiswa(UUID mahasiswaId) {
    List<RencanaStudi> rencanaStudiList = rencanaStudiRepository.getListObject("rencana_studi_impl", "mahasiswa_id",
        mahasiswaId);

    return rencanaStudiList;
  }

  public PengisianRencanaStudi getActivePengisianRencanaStudi() {
    Semester semester = semesterService.getActiveSemester();
    List<PengisianRencanaStudi> pengisianRencanaStudiList = pengisianRencanaStudiRepository
        .getListObject("pengisian_rencana_studi_comp", "semester_id", semester.getId());

    if (pengisianRencanaStudiList.size() == 0) {
      UUID id = UUID.randomUUID();

      PengisianRencanaStudi pengisianRencanaStudi = pengisianRencanaStudiFactory
          .createPengisianRencanaStudi("siakreborn.rencanastudi.core.PengisianRencanaStudiImpl", id, null, null,
              semester);
      pengisianRencanaStudiRepository.saveObject(pengisianRencanaStudi);

      return pengisianRencanaStudiRepository.getObject(id);
    }

    return pengisianRencanaStudiList.get(0);
  }

  public PengisianRencanaStudi updateActivePengisianRencanaStudi(HashMap<String, Object> body) {
    String mulaiStr = (String) body.get("mulai");
    Date mulaiDate = Date.from(Instant.parse(mulaiStr));
    String akhirStr = (String) body.get("akhir");
    Date akhirDate = Date.from(Instant.parse(akhirStr));

    PengisianRencanaStudi pengisianRencanaStudi = getActivePengisianRencanaStudi();
    pengisianRencanaStudi.setMulai(mulaiDate);
    pengisianRencanaStudi.setAkhir(akhirDate);

    pengisianRencanaStudiRepository.updateObject(pengisianRencanaStudi);
    pengisianRencanaStudi = pengisianRencanaStudiRepository.getObject(pengisianRencanaStudi.getId());

    return pengisianRencanaStudi;
  }

  public List<HashMap<String, Object>> transformRencanaStudiListToHashMap(List<RencanaStudi> rencanaStudiList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < rencanaStudiList.size(); i++) {
      resultList.add(rencanaStudiList.get(i).toHashMap());
    }

    return resultList;
  }

  public List<HashMap<String, Object>> transformKelasListToHashMap(List<Kelas> kelasList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < kelasList.size(); i++) {
      resultList.add(kelasList.get(i).toHashMap());
    }

    return resultList;
  }
}
