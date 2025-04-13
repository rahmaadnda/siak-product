package siakreborn.penilaian.penilaianobe;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

import siakreborn.penilaian.core.Penilaian;
import siakreborn.penilaian.core.PenilaianServiceDecorator;
import siakreborn.penilaian.core.PenilaianServiceComponent;
import siakreborn.komponenpenilaian.core.KomponenPenilaian;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.kelas.core.Kelas;
import siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaian;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.capaian.core.Capaian;
import siakreborn.rencanastudi.core.RencanaStudi;
import siakreborn.rencanastudi.core.KelasMahasiswa;

public class PenilaianServiceImpl extends PenilaianServiceDecorator {
  RepositoryUtil<KomponenPenilaian> komponenPenilaianRepository = new RepositoryUtil<KomponenPenilaian>(
      siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class);
  RepositoryUtil<Mahasiswa> mahasiswaRepository = new RepositoryUtil<Mahasiswa>(
      siakreborn.mahasiswa.core.MahasiswaComponent.class);
  RepositoryUtil<Kelas> kelasRepository = new RepositoryUtil<Kelas>(siakreborn.kelas.core.KelasComponent.class);
  RepositoryUtil<KelasMahasiswa> kelasMahasiswaRepository = new RepositoryUtil<KelasMahasiswa>(
      siakreborn.rencanastudi.core.KelasMahasiswaComponent.class);
  RepositoryUtil<BobotKomponenPenilaian> bobotKomponenPenilaianRepository = new RepositoryUtil<BobotKomponenPenilaian>(
      siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaian.class);
  RepositoryUtil<MataKuliah> mataKuliahRepository = new RepositoryUtil<MataKuliah>(
      siakreborn.matakuliah.core.MataKuliahComponent.class);
  RepositoryUtil<Capaian> capaianRepository = new RepositoryUtil<Capaian>(
      siakreborn.capaian.core.CapaianComponent.class);
  RepositoryUtil<RencanaStudi> rencanaStudiRepository = new RepositoryUtil<RencanaStudi>(
      siakreborn.rencanastudi.core.RencanaStudiComponent.class);

  public PenilaianServiceImpl(PenilaianServiceComponent record) {
    super(record);
  }

  public List<Penilaian> savePenilaian(HashMap<String, Object> body) {
    return record.savePenilaian(body);

    // String nilaiStr = (String) body.get("nilai");
    // int nilai = Integer.parseInt(nilaiStr);
    // String komponenPenilaianIdStr = (String) body.get("komponenPenilaianId");
    // String mahasiswaIdStr = (String) body.get("mahasiswaId");

    // KomponenPenilaian komponenPenilaian = null;
    // if (komponenPenilaianIdStr != null) {
    // UUID komponenPenilaianId = UUID.fromString(komponenPenilaianIdStr);
    // komponenPenilaian = penilaianRepository.getProxyObject(
    // siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class,
    // komponenPenilaianId);
    // }

    // Mahasiswa mahasiswa = null;
    // if (mahasiswaIdStr != null) {
    // UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);
    // mahasiswa =
    // penilaianRepository.getProxyObject(siakreborn.mahasiswa.core.MahasiswaComponent.class,
    // mahasiswaId);
    // }

    // List<BobotKomponenPenilaian> bobotKomponenPenilaianList =
    // bobotKomponenPenilaianRepository
    // .getListObject("bobot_komponen_penilaian_comp", "komponenpenilaian_id",
    // komponenPenilaian.getId());

    // for (BobotKomponenPenilaian bobotKomponenPenilaian :
    // bobotKomponenPenilaianList) {
    // double bobot = bobotKomponenPenilaian.getBobot();
    // double nilaiCapaian =
    // }
  }

  public HashMap<String, Object> getLaporanCPLMap(UUID kurikulumId, HashMap<String, Object> sourceMap) {
    List<Capaian> listCPL = capaianRepository.getListObject("capaian_cpl", "kurikulum_id",
        kurikulumId);
    Set<String> setCPL = new TreeSet<>();
    for (Capaian cpl : listCPL) {
      setCPL.add(cpl.getId().toString());
    }

    List<HashMap<String, Object>> mataKuliahList = new ArrayList<>();

    List<MataKuliah> listMataKuliah = mataKuliahRepository.getListObject("mata_kuliah_comp", "kurikulum_id",
        kurikulumId);
    for (MataKuliah mataKuliah : listMataKuliah) {
      HashMap<String, Object> cpmkResult = getLaporanCPMKMap(
          mataKuliah.getId(),
          sourceMap);
      List<Capaian> listCPMK = (List<Capaian>) cpmkResult.get("cpmkList");
      List<HashMap<String, Object>> listCPMKMahasiswa = (List<HashMap<String, Object>>) cpmkResult.get("mahasiswaList");

      // find CPL for this MataKuliah
      List<Capaian> listCPLMataKuliah = new ArrayList<>();
      Set<String> setCPLMataKuliah = new TreeSet<>();
      for (Capaian capaianCPMK : listCPMK) {
        siakreborn.capaian.cpmk.CapaianImpl cpmk = (siakreborn.capaian.cpmk.CapaianImpl) capaianCPMK;
        Capaian cpl = cpmk.getParentCPL();
        String id = cpl.getId().toString();
        if (setCPL.contains(id) && !setCPLMataKuliah.contains(id)) {
          listCPLMataKuliah.add(cpl);
          setCPLMataKuliah.add(id);
        }
      }

      // compute CPL attainment for each Mahasiswa in MataKuliah
      List<HashMap<String, Object>> listCPLAttainment = new ArrayList<>();
      for (HashMap<String, Object> cpmkAttainment : listCPMKMahasiswa) {
        String nama = (String) cpmkAttainment.get("nama");

        HashMap<String, Object> attainmentByCPL = getAttainmentByCPL(
            listCPLMataKuliah, listCPMK,
            cpmkAttainment);

        HashMap<String, Object> cplAttainments = compileCPLAttainments(
            attainmentByCPL,
            listCPLMataKuliah);
        cplAttainments.put("nama", nama);

        listCPLAttainment.add(cplAttainments);
      }

      HashMap<String, Object> resultMap = new HashMap<>();
      resultMap.put("nama", mataKuliah.getNama());
      resultMap.put("kode", mataKuliah.getKode());

      // count avg CPL for this MataKuliah from CPL Mahasiswa
      for (Capaian cpl : listCPLMataKuliah) {
        double totalAttainment = 0;
        for (HashMap<String, Object> cplAttainments : listCPLAttainment) {

          double attainment = (double) cplAttainments.get(cpl.getId().toString());
          totalAttainment += attainment;
        }

        double avgAttainment = 0;
        if (listCPLAttainment.size() > 0)
          avgAttainment = totalAttainment / (double) listCPLAttainment.size();

        avgAttainment = Math.round(avgAttainment * 100d) / 100d;

        resultMap.put(cpl.getId().toString(), avgAttainment);
      }

      // put list CPL Mahasiswa for info
      resultMap.put("cplAttainments", listCPLAttainment);

      mataKuliahList.add(resultMap);
    }

    HashMap<String, Object> result = new HashMap<>();
    result.put("cplList", listCPL);
    result.put("mataKuliahList", mataKuliahList);

    return result;
  }

  public HashMap<String, Object> getLaporanCPMKMap(UUID mataKuliahId,
      HashMap<String, Object> sourceMap) {
    // find all CPMK for this MataKuliah
    List<Capaian> listAllCPMK = (List<Capaian>) sourceMap.get("cpmk");
    List<Capaian> listCPMK = new ArrayList<>();
    for (Capaian cpmk : listAllCPMK) {
      MataKuliah mataKuliah = ((siakreborn.capaian.cpmk.CapaianImpl) cpmk).getMataKuliah();
      if (mataKuliah.getId().equals(mataKuliahId)) {
        listCPMK.add(cpmk);
      }
    }

    // find all Kelas for this MataKuliah
    List<Kelas> listAllKelas = (List<Kelas>) sourceMap.get("kelas");
    List<Kelas> listKelas = new ArrayList<>();
    for (Kelas kelas : listAllKelas) {
      if (kelas.getMataKuliah().getId().equals(mataKuliahId)) {
        listKelas.add(kelas);
      }
    }

    List<HashMap<String, Object>> listMahasiswaResult = new ArrayList<>();
    for (Kelas kelas : listKelas) {

      // find all KomponenPenilaian for each Kelas
      List<KomponenPenilaian> listAllKomponenPenilaian = (List<KomponenPenilaian>) sourceMap.get("komponenPenilaian");
      List<KomponenPenilaian> listKomponenPenilaian = new ArrayList<>();
      for (KomponenPenilaian komponenPenilaian : listAllKomponenPenilaian) {
        if (komponenPenilaian.getKelas().getId().equals(kelas.getId())) {
          listKomponenPenilaian.add(komponenPenilaian);
        }
      }

      List<BobotKomponenPenilaian> listBobotKomponenPenilaian = (List<BobotKomponenPenilaian>) sourceMap
          .get("bobotKomponenPenilaian");
      List<HashMap<String, Object>> komponenCPMKList = getKomponenCPMKList(listKomponenPenilaian,
          listBobotKomponenPenilaian, listCPMK);

      // find all Mahasiswa across all Kelas for this MataKuliah
      List<KelasMahasiswa> listAllKelasMahasiswa = (List<KelasMahasiswa>) sourceMap.get("kelasMahasiswa");
      List<KelasMahasiswa> listKelasMahasiswa = new ArrayList<>();
      for (KelasMahasiswa kelasMahasiswa : listAllKelasMahasiswa) {
        if (kelasMahasiswa.getKelas().getId().equals(kelas.getId())) {
          listKelasMahasiswa.add(kelasMahasiswa);
        }
      }

      for (KelasMahasiswa kelasMahasiswa : listKelasMahasiswa) {
        HashMap<String, Object> resultMap = new HashMap<>();

        Mahasiswa mahasiswa = kelasMahasiswa.getRencanaStudi().getMahasiswa();
        resultMap.put("nama", mahasiswa.getNama());
        resultMap.put("npm", mahasiswa.getNpm());
        resultMap.put("kelasNama", kelas.getNama());
        resultMap.put("kelasId", kelas.getId());

        // find all Penilaian for each Mahasiswa
        List<Penilaian> listPenilaian = (List<Penilaian>) sourceMap.get("penilaian");
        List<Penilaian> listPenilaianMahasiswa = getListPenilaianMahasiswa(listPenilaian, mahasiswa, kelas);

        // count each CPMK Komponen attainment
        HashMap<String, Object> attainmentByCPMK = getAttainmentByCPMK(komponenCPMKList, listPenilaianMahasiswa);

        // compile attainment results
        HashMap<String, Object> cpmkAttainments = compileCPMKAttainments(attainmentByCPMK, listCPMK);

        // put CPMK attainment using id
        for (Capaian cpmk : listCPMK) {
          HashMap<String, Object> attainmentMap = (HashMap<String, Object>) cpmkAttainments
              .get(cpmk.getId().toString());
          double attainment = (double) attainmentMap.get("attainment");
          resultMap.put(cpmk.getId().toString(), attainment);
        }

        // put CPMK attainments for info
        resultMap.put("cpmkAttainments", cpmkAttainments);

        listMahasiswaResult.add(resultMap);
      }
    }

    HashMap<String, Object> result = new HashMap<>();
    result.put("cpmkList", listCPMK);
    result.put("mahasiswaList", listMahasiswaResult);

    return result;
  }

  // groups KomponenPenilaian, BobotKomponenPenilaian, and CPMK
  // komponenCPMKList:
  // List of Map with:
  // -- key: cpmk, value: related CPMK
  // -- key: komponenPenilaian, value: related KomponenPenilaian
  // -- key: bobot, value: bobot of KomponenPenilaian for the related CPMK
  public List<HashMap<String, Object>> getKomponenCPMKList(List<KomponenPenilaian> listKomponenPenilaian,
      List<BobotKomponenPenilaian> listBobotKomponenPenilaian,
      List<Capaian> listCPMK) {
    // store CPMK to set for easy compare
    Set<String> setCPMK = new TreeSet<>();
    for (Capaian cpmk : listCPMK) {
      setCPMK.add(cpmk.getId().toString());
    }

    List<HashMap<String, Object>> komponenCPMKList = new ArrayList<>();
    for (KomponenPenilaian komponenPenilaian : listKomponenPenilaian) {
      // find BobotKomponenPenilaian for this KomponenPenilaian
      List<BobotKomponenPenilaian> listBobotKomponenKelas = new ArrayList<>();
      for (BobotKomponenPenilaian bobotKomponenPenilaian : listBobotKomponenPenilaian) {
        if (bobotKomponenPenilaian.getKomponenPenilaian().getId().equals(komponenPenilaian.getId())) {
          listBobotKomponenKelas.add(bobotKomponenPenilaian);
        }
      }

      List<HashMap<String, Object>> mappingList = new ArrayList<>();
      for (BobotKomponenPenilaian bobotKomponenPenilaian : listBobotKomponenKelas) {
        if (setCPMK.contains(bobotKomponenPenilaian.getCPMK().getId().toString())) {

          HashMap<String, Object> cpmkInfoMap = new HashMap<>();
          cpmkInfoMap.put("cpmk", bobotKomponenPenilaian.getCPMK());
          cpmkInfoMap.put("bobot", bobotKomponenPenilaian.getBobot());
          cpmkInfoMap.put("komponenPenilaian", komponenPenilaian);
          komponenCPMKList.add(cpmkInfoMap);
        }
      }
    }

    return komponenCPMKList;
  }

  public List<Penilaian> getListPenilaianMahasiswa(List<Penilaian> listPenilaian, Mahasiswa mahasiswa, Kelas kelas) {
    List<Penilaian> listPenilaianMahasiswa = new ArrayList<>();
    for (Penilaian penilaian : listPenilaian) {
      KomponenPenilaian komponenPenilaian = penilaian.getKomponenPenilaian();
      if (penilaian.getMahasiswa().getId().equals(mahasiswa.getId()) &&
          komponenPenilaian.getKelas().getId().equals(kelas.getId())) {
        listPenilaianMahasiswa.add(penilaian);
      }
    }

    return listPenilaianMahasiswa;
  }

  public HashMap<String, Object> getAttainmentByCPL(List<Capaian> listCPL,
      List<Capaian> listCPMK,
      HashMap<String, Object> cpmkAttainment) {
    Set<String> setCPL = new TreeSet<>();
    for (Capaian cpl : listCPL) {
      setCPL.add(cpl.getId().toString());
    }

    HashMap<String, Object> attainmentByCPL = new HashMap<>();
    for (Capaian capaian : listCPMK) {
      siakreborn.capaian.cpmk.CapaianImpl cpmk = (siakreborn.capaian.cpmk.CapaianImpl) capaian;
      Capaian cpl = cpmk.getParentCPL();
      double bobot = (double) cpmk.getBobot();
      if (setCPL.contains(cpl.getId().toString())) {
        double nilaiCPMK = (double) cpmkAttainment.get(cpmk.getId().toString());
        nilaiCPMK *= bobot;

        // create or update CPL attainment
        if (attainmentByCPL.containsKey(cpl.getId().toString())) {
          HashMap<String, Object> cplAttainment = (HashMap<String, Object>) attainmentByCPL
              .get(cpl.getId().toString());
          double totalCPMK = (double) cplAttainment.get("totalCPMK");
          double totalBobot = (double) cplAttainment.get("totalBobot");

          totalCPMK += nilaiCPMK;
          totalBobot += bobot;

          cplAttainment.put("totalCPMK", totalCPMK);
          cplAttainment.put("totalBobot", totalBobot);

          attainmentByCPL.put(cpl.getId().toString(), cplAttainment);
        } else {
          HashMap<String, Object> cplAttainment = new HashMap<>();
          cplAttainment.put("totalCPMK", nilaiCPMK);
          cplAttainment.put("totalBobot", bobot);
          cplAttainment.put("cpl", cpl);

          attainmentByCPL.put(cpl.getId().toString(), cplAttainment);
        }
      }
    }

    return attainmentByCPL;
  }

  public HashMap<String, Object> getAttainmentByCPMK(List<HashMap<String, Object>> komponenCPMKList,
      List<Penilaian> listPenilaianMahasiswa) {
    HashMap<String, Object> attainmentByCPMK = new HashMap<>();
    for (HashMap<String, Object> cpmkInfoMap : komponenCPMKList) {
      KomponenPenilaian komponenPenilaian = (KomponenPenilaian) cpmkInfoMap.get("komponenPenilaian");
      String komponenPenilaianId = komponenPenilaian.getId().toString();
      Capaian cpmk = (Capaian) cpmkInfoMap.get("cpmk");
      double bobot = (double) cpmkInfoMap.get("bobot");

      // find Penilaian for this KomponenPenilaian
      Penilaian penilaianTerkait = null;
      for (Penilaian penilaian : listPenilaianMahasiswa) {
        if (penilaian.getKomponenPenilaian().getId().toString().equals(komponenPenilaianId)) {
          penilaianTerkait = penilaian;
          break;
        }
      }

      double weightedNilai = 0;

      // if Penilaian exists, update weightedNilai based on bobot
      if (penilaianTerkait != null) {
        weightedNilai = penilaianTerkait.getNilai() * bobot;
      }

      // create or update attainment
      if (attainmentByCPMK.containsKey(cpmk.getId().toString())) {
        HashMap<String, Object> cpmkAttainment = (HashMap<String, Object>) attainmentByCPMK
            .get(cpmk.getId().toString());
        double totalNilai = (double) cpmkAttainment.get("totalNilai");
        double totalBobot = (double) cpmkAttainment.get("totalBobot");
        totalNilai += weightedNilai;
        totalBobot += bobot;
        cpmkAttainment.put("totalNilai", totalNilai);
        cpmkAttainment.put("totalBobot", totalBobot);
        attainmentByCPMK.put(cpmk.getId().toString(), cpmkAttainment);
      } else {
        HashMap<String, Object> cpmkAttainment = new HashMap<>();
        cpmkAttainment.put("totalNilai", weightedNilai);
        cpmkAttainment.put("totalBobot", bobot);
        cpmkAttainment.put("cpmk", cpmk);
        attainmentByCPMK.put(cpmk.getId().toString(), cpmkAttainment);
      }
    }

    return attainmentByCPMK;
  }

  public HashMap<String, Object> compileCPLAttainments(HashMap<String, Object> attainmentByCPL,
      List<Capaian> listCPL) {
    HashMap<String, Object> cplAttainments = new HashMap<>();
    for (Map.Entry<String, Object> entry : attainmentByCPL.entrySet()) {
      String cplId = entry.getKey();
      HashMap<String, Object> cplAttainment = (HashMap<String, Object>) entry.getValue();
      double totalCPMK = (double) cplAttainment.get("totalCPMK");
      double totalBobot = (double) cplAttainment.get("totalBobot");
      Capaian cpl = (Capaian) cplAttainment.get("cpl");

      double finalAttainment = totalCPMK / totalBobot;
      finalAttainment = Math.round(finalAttainment * 100d) / 100d;

      cplAttainments.put(cplId, finalAttainment);
    }

    for (Capaian cpl : listCPL) {
      String id = cpl.getId().toString();
      if (!cplAttainments.containsKey(id)) {
        cplAttainments.put(id, 0d);
      }
    }

    return cplAttainments;
  }

  public HashMap<String, Object> compileCPMKAttainments(HashMap<String, Object> attainmentByCPMK,
      List<Capaian> listCPMK) {
    HashMap<String, Object> cpmkAttainments = new HashMap<>();
    for (Map.Entry<String, Object> entry : attainmentByCPMK.entrySet()) {
      String cpmkId = entry.getKey();
      HashMap<String, Object> cpmkAttainment = (HashMap<String, Object>) entry.getValue();
      double totalNilai = (double) cpmkAttainment.get("totalNilai");
      double totalBobot = (double) cpmkAttainment.get("totalBobot");
      Capaian cpmk = (Capaian) cpmkAttainment.get("cpmk");

      double finalAttainment = totalNilai / totalBobot;
      finalAttainment = Math.round(finalAttainment * 100d) / 100d;
      HashMap<String, Object> attainmentResult = new HashMap<>();
      attainmentResult.put("attainment", finalAttainment);
      attainmentResult.put("cpmk", cpmk);
      cpmkAttainments.put(cpmkId, attainmentResult);
    }

    // fill missing CPMK attainments with 0
    for (Capaian cpmk : listCPMK) {
      String id = cpmk.getId().toString();
      if (!cpmkAttainments.containsKey(id)) {
        HashMap<String, Object> blankAttainment = new HashMap<>();
        blankAttainment.put("attainment", (double) 0);
        blankAttainment.put("cpmk", cpmk);
        cpmkAttainments.put(id, blankAttainment);
      }
    }

    return cpmkAttainments;
  }

  public HashMap<String, Object> getSourceMap() {
    List<Capaian> listCPMK = capaianRepository.getAllObject("capaian_cpmk",
        siakreborn.capaian.cpmk.CapaianImpl.class.getName());
    List<Kelas> listKelas = kelasRepository.getAllObject("kelas_impl",
        siakreborn.kelas.core.KelasImpl.class.getName());
    List<Penilaian> listPenilaian = penilaianRepository.getAllObject("penilaian_impl",
        siakreborn.penilaian.core.PenilaianImpl.class.getName());
    List<KomponenPenilaian> listKomponenPenilaian = komponenPenilaianRepository
        .getAllObject("komponen_penilaian_impl",
            siakreborn.komponenpenilaian.core.KomponenPenilaianImpl.class.getName());
    List<BobotKomponenPenilaian> listBobotKomponenPenilaian = bobotKomponenPenilaianRepository
        .getAllObject("bobot_komponen_penilaian_impl",
            siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianImpl.class.getName());
    List<KelasMahasiswa> listKelasMahasiswa = kelasMahasiswaRepository.getAllObject("kelas_mahasiswa_impl",
        siakreborn.rencanastudi.core.KelasMahasiswaImpl.class.getName());

    HashMap<String, Object> sourceMap = new HashMap<>();
    sourceMap.put("cpmk", listCPMK);
    sourceMap.put("kelas", listKelas);
    sourceMap.put("penilaian", listPenilaian);
    sourceMap.put("komponenPenilaian", listKomponenPenilaian);
    sourceMap.put("bobotKomponenPenilaian", listBobotKomponenPenilaian);
    sourceMap.put("kelasMahasiswa", listKelasMahasiswa);

    return sourceMap;
  }

  public List<HashMap<String, Object>> getCPLAttainmentMahasiswa(UUID mahasiswaId) {
    List<HashMap<String, Object>> attainments = new ArrayList<>();
    penilaianRepository.executeQuery(session -> {
      String sql = PenilaianServiceQueries.SELECT_LAPORAN_CPL_MAHASISWA.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql).setParameter("mahasiswaId",
          mahasiswaId).list();
      for (int i = 0; i < results.size(); i++) {
        Object[] result = results.get(i);
        String id = (String) result[0];
        String kode = (String) result[1];
        double nilai = (double) result[2];
        nilai = Math.round(nilai * 100) / 100d;

        HashMap<String, Object> attainment = new HashMap<>();
        attainment.put("id", id);
        attainment.put("kode", kode);
        attainment.put("nilai", nilai);

        attainments.add(attainment);
      }
    });

    return attainments;
  }

  // v2
  public HashMap<String, Object> getLaporanCPMKMapV2(UUID mataKuliahId) {
    HashMap<String, Object> attainments = new HashMap<>();
    penilaianRepository.executeQuery(session -> {
      String sql = PenilaianServiceQueries.SELECT_LAPORAN_CPMK.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql).setParameter("mataKuliahId",
          mataKuliahId).list();

      for (int i = 0; i < results.size(); i++) {
        Object[] result = results.get(i);
        String mahasiswaId = (String) result[0];
        String mahasiswaName = (String) result[1];
        String mahasiswaNpm = (String) result[2];
        String kelasName = (String) result[3];
        String kelasId = (String) result[4];
        String capaianId = (String) result[5];
        double capaianAttainment = (double) result[6];
        capaianAttainment = Math.round(capaianAttainment * 100) / 100d;

        if (attainments.containsKey(mahasiswaId)) {
          HashMap<String, Object> attainmentMap = (HashMap<String, Object>) attainments.get(mahasiswaId);
          attainmentMap.put(capaianId, capaianAttainment);
        } else {
          HashMap<String, Object> attainmentMap = new HashMap<>();
          attainmentMap.put("nama", mahasiswaName);
          attainmentMap.put("npm", mahasiswaNpm);
          attainmentMap.put("kelasNama", kelasName);
          attainmentMap.put("kelasId", kelasId);
          attainmentMap.put(capaianId, capaianAttainment);

          attainments.put(mahasiswaId, attainmentMap);
        }
      }
    });

    List<HashMap<String, Object>> mahasiswaList = new ArrayList<>();
    for (Map.Entry<String, Object> entry : attainments.entrySet()) {
      mahasiswaList.add((HashMap<String, Object>) entry.getValue());
    }

    List<HashMap<String, Object>> cpmkList = new ArrayList<>();
    penilaianRepository.executeQuery(session -> {
      String sql = PenilaianServiceQueries.SELECT_CPMK_MATA_KULIAH.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql).setParameter("mataKuliahId",
          mataKuliahId).list();

      for (int i = 0; i < results.size(); i++) {
        Object[] result = results.get(i);

        HashMap<String, Object> cpmk = new HashMap<>();
        cpmk.put("id", result[0]);
        cpmk.put("kode", result[1]);

        cpmkList.add(cpmk);
      }
    });

    HashMap<String, Object> result = new HashMap<>();
    result.put("mahasiswaList", mahasiswaList);
    result.put("cpmkList", cpmkList);
    return result;
  }

  public HashMap<String, Object> getLaporanCPMKChartV2(UUID mataKuliahId) {
    HashMap<String, Object> laporanCPMKMap = getLaporanCPMKMapV2(mataKuliahId);

    List<HashMap<String, Object>> cpmkList = (List<HashMap<String, Object>>) laporanCPMKMap.get("cpmkList");
    List<HashMap<String, Object>> mahasiswaList = (List<HashMap<String, Object>>) laporanCPMKMap.get("mahasiswaList");

    List<Double> data = new ArrayList<>();
    List<String> labels = new ArrayList<>();
    for (HashMap<String, Object> cpmk : cpmkList) {
      String kode = (String) cpmk.get("kode");
      String id = (String) cpmk.get("id");

      double totalNilaiCPMK = 0;
      for (HashMap<String, Object> mahasiswa : mahasiswaList) {
        double nilaiCPMK = (double) mahasiswa.get(id);
        totalNilaiCPMK += nilaiCPMK;
      }

      double avgNilaiCPMK = totalNilaiCPMK / mahasiswaList.size();
      avgNilaiCPMK = Math.round(avgNilaiCPMK * 100) / 100d;

      data.add(avgNilaiCPMK);
      labels.add(kode);
    }

    HashMap<String, Object> result = new HashMap<>();
    result.put("data", data);
    result.put("labels", labels);

    return result;
  }

  public HashMap<String, Object> getLaporanCPLMapV2(UUID kurikulumId) {
    HashMap<String, Object> attainments = new HashMap<>();
    penilaianRepository.executeQuery(session -> {
      String sql = PenilaianServiceQueries.SELECT_LAPORAN_CPL.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql).setParameter("kurikulumId",
          kurikulumId).list();

      for (int i = 0; i < results.size(); i++) {
        Object[] result = results.get(i);
        String mataKuliahName = (String) result[0];
        String mataKuliahKode = (String) result[1];
        String cplId = (String) result[2];
        String cplkode = (String) result[3];
        double cplAttainment = (double) result[4];
        cplAttainment = Math.round(cplAttainment * 100) / 100d;

        if (attainments.containsKey(mataKuliahKode)) {
          HashMap<String, Object> attainmentMap = (HashMap<String, Object>) attainments.get(mataKuliahKode);
          attainmentMap.put(cplId, cplAttainment);
        } else {
          HashMap<String, Object> attainmentMap = new HashMap<>();
          attainmentMap.put("nama", mataKuliahName);
          attainmentMap.put("kode", mataKuliahKode);
          attainmentMap.put(cplId, cplAttainment);

          attainments.put(mataKuliahKode, attainmentMap);
        }
      }
    });

    List<HashMap<String, Object>> mataKuliahList = new ArrayList<>();
    for (Map.Entry<String, Object> entry : attainments.entrySet()) {
      mataKuliahList.add((HashMap<String, Object>) entry.getValue());
    }

    List<HashMap<String, Object>> cplList = new ArrayList<>();
    penilaianRepository.executeQuery(session -> {
      String sql = PenilaianServiceQueries.SELECT_CPL_KURIKULUM.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql).setParameter("kurikulumId",
          kurikulumId).list();

      for (int i = 0; i < results.size(); i++) {
        Object[] result = results.get(i);

        HashMap<String, Object> cpl = new HashMap<>();
        cpl.put("id", result[0]);
        cpl.put("kode", result[1]);

        cplList.add(cpl);
      }
    });

    HashMap<String, Object> result = new HashMap<>();
    result.put("mataKuliahList", mataKuliahList);
    result.put("cplList", cplList);
    return result;
  }

  public HashMap<String, Object> getLaporanCPLChartV2(UUID mataKuliahId) {
    HashMap<String, Object> laporanCPLMap = getLaporanCPLMapV2(mataKuliahId);

    List<HashMap<String, Object>> cplList = (List<HashMap<String, Object>>) laporanCPLMap.get("cplList");
    List<HashMap<String, Object>> mataKuliahList = (List<HashMap<String, Object>>) laporanCPLMap.get("mataKuliahList");

    List<Double> data = new ArrayList<>();
    List<String> labels = new ArrayList<>();
    for (HashMap<String, Object> cpl : cplList) {
      String kode = (String) cpl.get("kode");
      String id = (String) cpl.get("id");

      double totalNilaiCPL = 0;
      int totalMataKuliah = 0;
      for (HashMap<String, Object> mataKuliah : mataKuliahList) {
        if (mataKuliah.containsKey(id)) {
          totalNilaiCPL += (double) mataKuliah.get(id);
          totalMataKuliah++;
        }
        ;
      }

      double avgNilaiCPL = totalMataKuliah > 0 ? totalNilaiCPL / totalMataKuliah : 0;
      avgNilaiCPL = Math.round(avgNilaiCPL * 100) / 100d;

      data.add(avgNilaiCPL);
      labels.add(kode);
    }

    HashMap<String, Object> result = new HashMap<>();
    result.put("data", data);
    result.put("labels", labels);

    return result;
  }

  enum PenilaianServiceQueries {
    SELECT_LAPORAN_CPMK("SELECT \r\n" + //
        "    CAST(mc.id AS VARCHAR),\r\n" + //
        "    mc.nama,\r\n" + //
        "    mc.npm,\r\n" + //
        "    kc.nama as kelas_nama,\r\n" + //
        "    CAST (kc.id AS VARCHAR) AS kelas_id,\r\n" + //
        "    CASE \r\n" + //
        "        WHEN subcpmk.id IS NOT NULL THEN CAST(subcpmk.id AS VARCHAR)\r\n" + //
        "        ELSE CAST(cpmk.id AS VARCHAR)\r\n" + //
        "    END AS capaian_id,\r\n" + //
        "    CASE \r\n" + //
        "        WHEN subcpmk.id IS NOT NULL THEN \r\n" + //
        "            SUM(\r\n" + //
        "                COALESCE(pc.nilai, 0) * bkpc.bobot\r\n" + //
        "            ) / \r\n" + //
        "            NULLIF(SUM(bkpc.bobot), 0) \r\n" + //
        "        ELSE \r\n" + //
        "            SUM(\r\n" + //
        "                COALESCE(pc.nilai, 0) * bkpc.bobot\r\n" + //
        "            ) / \r\n" + //
        "            NULLIF(SUM(bkpc.bobot), 0) \r\n" + //
        "    END AS attainment\r\n" + //
        "FROM \r\n" + //
        "    mahasiswa_comp mc\r\n" + //
        "JOIN \r\n" + //
        "    rencana_studi_comp rsc ON rsc.mahasiswa_id = mc.id \r\n" + //
        "JOIN \r\n" + //
        "    kelas_mahasiswa_comp kmc ON kmc.rencanastudi_id = rsc.id\r\n" + //
        "JOIN \r\n" + //
        "    kelas_comp kc ON kc.id = kmc.kelas_id \r\n" + //
        "JOIN \r\n" + //
        "    mata_kuliah_comp mkc ON mkc.id = kc.matakuliah_id \r\n" + //
        "JOIN \r\n" + //
        "    komponen_penilaian_comp kpc ON kpc.kelas_id = kc.id\r\n" + //
        "JOIN \r\n" + //
        "    bobot_komponen_penilaian_comp bkpc ON bkpc.komponenpenilaian_id = kpc.id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    penilaian_comp pc ON pc.komponenpenilaian_id = kpc.id AND pc.mahasiswa_id = mc.id\r\n" + //
        "LEFT JOIN \r\n" + //
        "    capaian_subcpmk subcpmk ON subcpmk.id = bkpc.subcpmk_id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    capaian_cpmk cpmk ON cpmk.id = bkpc.cpmk_id OR cpmk.id = subcpmk.parentcpmk_id \r\n" + //
        "WHERE \r\n" + //
        "    mkc.id = :mataKuliahId\r\n" + //
        "GROUP BY \r\n" + //
        "    mc.id, mc.nama, subcpmk.id, cpmk.id, mc.npm, kc.nama, kc.id\r\n" + //
        "ORDER BY \r\n" + //
        "    mc.nama, capaian_id;\r\n" + //
        ""),

    SELECT_LAPORAN_CPL("WITH komponen_cpmk AS \r\n" + //
        "(\r\n" + //
        "(\r\n" + //
        "SELECT\r\n" + //
        "    mkc.nama AS matakuliah_nama,\r\n" + //
        "    mkc.kode AS matakuliah_kode,\r\n" + //
        "    mc.nama AS nama,\r\n" + //
        "    cc.kode AS komponen,\r\n" + //
        "    SUM(COALESCE(pc.nilai, 0) * bkpc.bobot) / NULLIF(SUM(bkpc.bobot), 0) AS nilai,\r\n" + //
        "    subcpmk.bobot,\r\n" + //
        "    subcpmk.parentcpmk_id AS cpmk_id,\r\n" + //
        "    cpmk.bobot AS cpmk_bobot,\r\n" + //
        "    cpl.id AS cpl_id,\r\n" + //
        "    cc2.kode AS cpl_kode\r\n" + //
        "FROM \r\n" + //
        "    mahasiswa_comp mc\r\n" + //
        "JOIN \r\n" + //
        "    rencana_studi_comp rsc ON rsc.mahasiswa_id = mc.id \r\n" + //
        "JOIN \r\n" + //
        "    kelas_mahasiswa_comp kmc ON kmc.rencanastudi_id = rsc.id\r\n" + //
        "JOIN \r\n" + //
        "    kelas_comp kc ON kc.id = kmc.kelas_id \r\n" + //
        "JOIN \r\n" + //
        "    mata_kuliah_comp mkc ON mkc.id = kc.matakuliah_id \r\n" + //
        "JOIN\r\n" + //
        "    kurikulum_comp kc2 ON kc2.id = mkc.kurikulum_id\r\n" + //
        "JOIN \r\n" + //
        "    komponen_penilaian_comp kpc ON kpc.kelas_id = kc.id\r\n" + //
        "JOIN\r\n" + //
        "    bobot_komponen_penilaian_comp bkpc ON kpc.id = bkpc.komponenpenilaian_id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    penilaian_comp pc ON pc.komponenpenilaian_id = kpc.id AND pc.mahasiswa_id = mc.id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_subcpmk subcpmk ON subcpmk.id = bkpc.subcpmk_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpmk cpmk ON cpmk.id = subcpmk.parentcpmk_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpl cpl ON cpl.id = cpmk.parentcpl_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_comp cc ON cc.id = subcpmk.record_id\r\n" + //
        "JOIN\r\n" + //
        "    capaian_comp cc2 ON cc2.id = cpl.record_id\r\n" + //
        "WHERE \r\n" + //
        "    kc2.id = :kurikulumId\r\n" + //
        "GROUP BY\r\n" + //
        "    mkc.nama, mkc.kode, mc.nama, cc.kode, subcpmk.bobot, subcpmk.parentcpmk_id, cpmk.bobot, cpl.id, cc2.kode\r\n"
        + //
        ")\r\n" + //
        "--\r\n" + //
        "--\r\n" + //
        "UNION ALL \r\n" + //
        "--\r\n" + //
        "--\r\n" + //
        "(\r\n" + //
        "SELECT\r\n" + //
        "    mkc.nama AS matakuliah_nama,\r\n" + //
        "    mkc.kode AS matakuliah_kode,\r\n" + //
        "    mc.nama,\r\n" + //
        "    kpc.nama AS komponen,\r\n" + //
        "    pc.nilai,\r\n" + //
        "    bkpc.bobot,\r\n" + //
        "    cpmk.id AS cpmk_id,\r\n" + //
        "    cpmk.bobot AS cpmmk_bobot,\r\n" + //
        "    cpl.id AS cpl_id,\r\n" + //
        "    cc2.kode AS cpl_kode\r\n" + //
        "FROM \r\n" + //
        "    mahasiswa_comp mc\r\n" + //
        "JOIN \r\n" + //
        "    rencana_studi_comp rsc ON rsc.mahasiswa_id = mc.id \r\n" + //
        "JOIN \r\n" + //
        "    kelas_mahasiswa_comp kmc ON kmc.rencanastudi_id = rsc.id\r\n" + //
        "JOIN \r\n" + //
        "    kelas_comp kc ON kc.id = kmc.kelas_id \r\n" + //
        "JOIN \r\n" + //
        "    mata_kuliah_comp mkc ON mkc.id = kc.matakuliah_id \r\n" + //
        "JOIN\r\n" + //
        "    kurikulum_comp kc2 ON kc2.id = mkc.kurikulum_id\r\n" + //
        "JOIN \r\n" + //
        "    komponen_penilaian_comp kpc ON kpc.kelas_id = kc.id\r\n" + //
        "JOIN\r\n" + //
        "    bobot_komponen_penilaian_comp bkpc ON kpc.id = bkpc.komponenpenilaian_id \r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpmk cpmk ON cpmk.id = bkpc.cpmk_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpl cpl ON cpl.id = cpmk.parentcpl_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_comp cc ON cc.id = cpmk.record_id\r\n" + //
        "JOIN\r\n" + //
        "    capaian_comp cc2 ON cc2.id = cpl.record_id\r\n" + //
        "LEFT JOIN \r\n" + //
        "    penilaian_comp pc ON pc.komponenpenilaian_id = kpc.id AND pc.mahasiswa_id = mc.id\r\n" + //
        "WHERE \r\n" + //
        "    kc2.id = :kurikulumId)\r\n" + //
        ")\r\n" + //
        "--\r\n" + //
        "--\r\n" + //
        "SELECT \r\n" + //
        "    matakuliah_nama,\r\n" + //
        "    matakuliah_kode,\r\n" + //
        "    CAST(cpl_id AS VARCHAR),\r\n" + //
        "    cpl_kode,\r\n" + //
        "    SUM(nilai * cpmk_bobot) / NULLIF(SUM(cpmk_bobot), 0) AS nilai\r\n" + //
        "FROM\r\n" + //
        "(SELECT\r\n" + //
        "    matakuliah_nama,\r\n" + //
        "    matakuliah_kode,\r\n" + //
        "    nama,\r\n" + //
        "    SUM(COALESCE(nilai, 0) * bobot) / NULLIF(SUM(bobot), 0) AS nilai,\r\n" + //
        "    cpmk_id,\r\n" + //
        "    cpmk_bobot,\r\n" + //
        "    cpl_id,\r\n" + //
        "    cpl_kode\r\n" + //
        "FROM komponen_cpmk\r\n" + //
        "GROUP BY\r\n" + //
        "    matakuliah_nama, matakuliah_kode, nama, cpmk_id, cpmk_bobot, cpl_id, cpl_kode\r\n" + //
        ")\r\n" + //
        "AS cpmk_attainment\r\n" + //
        "GROUP BY\r\n" + //
        "    matakuliah_nama, matakuliah_kode, cpl_id, cpl_kode;"),

    SELECT_CPMK_MATA_KULIAH("SELECT DISTINCT\r\n" + //
        "    CASE \r\n" + //
        "        WHEN subcpmk.id IS NOT NULL THEN CAST(subcpmk.id AS VARCHAR)\r\n" + //
        "        ELSE CAST(cpmk.id AS VARCHAR)\r\n" + //
        "    END AS capaian_id,\r\n" + //
        "    cc.kode AS capaian_kode\r\n" + //
        "FROM \r\n" + //
        "    kelas_comp kc\r\n" + //
        "JOIN \r\n" + //
        "    mata_kuliah_comp mkc ON mkc.id = kc.matakuliah_id \r\n" + //
        "JOIN \r\n" + //
        "    komponen_penilaian_comp kpc ON kpc.kelas_id = kc.id\r\n" + //
        "JOIN \r\n" + //
        "    bobot_komponen_penilaian_comp bkpc ON bkpc.komponenpenilaian_id = kpc.id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    capaian_subcpmk subcpmk ON subcpmk.id = bkpc.subcpmk_id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    capaian_cpmk cpmk ON cpmk.id = bkpc.cpmk_id OR cpmk.id = subcpmk.parentcpmk_id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    capaian_cpl cpl ON cpl.id = cpmk.parentcpl_id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    capaian_comp cc ON\r\n" + //
        "    CASE \r\n" + //
        "        WHEN subcpmk.id IS NOT NULL THEN cc.id = subcpmk.record_id \r\n" + //
        "        ELSE cc.id = cpmk.record_id \r\n" + //
        "    END\r\n" + //
        "WHERE \r\n" + //
        "    mkc.id = :mataKuliahId\r\n" + //
        ";"),

    SELECT_CPL_KURIKULUM("SELECT DISTINCT \r\n" + //
        "    CAST(cc.id AS VARCHAR),\r\n" + //
        "    cc2.kode\r\n" + //
        "FROM\r\n" + //
        "    kurikulum_comp kc \r\n" + //
        "JOIN\r\n" + //
        "    capaian_cpl cc ON cc.kurikulum_id = kc.id \r\n" + //
        "JOIN \r\n" + //
        "    capaian_comp cc2 ON cc2.id = cc.record_id\r\n" + //
        "WHERE \r\n" + //
        "    kc.id = :kurikulumId\r\n" + //
        ";"),

    SELECT_LAPORAN_CPL_MAHASISWA("WITH komponen_cpmk AS \r\n" + //
        "(\r\n" + //
        "(\r\n" + //
        "SELECT\r\n" + //
        "    mkc.nama AS matakuliah_nama,\r\n" + //
        "    mkc.kode AS matakuliah_kode,\r\n" + //
        "    mc.nama AS nama,\r\n" + //
        "    cc.kode AS komponen,\r\n" + //
        "    SUM(COALESCE(pc.nilai, 0) * bkpc.bobot) / NULLIF(SUM(bkpc.bobot), 0) AS nilai,\r\n" + //
        "    subcpmk.bobot,\r\n" + //
        "    subcpmk.parentcpmk_id AS cpmk_id,\r\n" + //
        "    cpmk.bobot AS cpmk_bobot,\r\n" + //
        "    cpl.id AS cpl_id,\r\n" + //
        "    cc2.kode AS cpl_kode\r\n" + //
        "FROM \r\n" + //
        "    mahasiswa_comp mc\r\n" + //
        "JOIN \r\n" + //
        "    rencana_studi_comp rsc ON rsc.mahasiswa_id = mc.id \r\n" + //
        "JOIN \r\n" + //
        "    kelas_mahasiswa_comp kmc ON kmc.rencanastudi_id = rsc.id\r\n" + //
        "JOIN \r\n" + //
        "    kelas_comp kc ON kc.id = kmc.kelas_id \r\n" + //
        "JOIN \r\n" + //
        "    mata_kuliah_comp mkc ON mkc.id = kc.matakuliah_id \r\n" + //
        "JOIN\r\n" + //
        "    kurikulum_comp kc2 ON kc2.id = mkc.kurikulum_id\r\n" + //
        "JOIN \r\n" + //
        "    komponen_penilaian_comp kpc ON kpc.kelas_id = kc.id\r\n" + //
        "JOIN\r\n" + //
        "    bobot_komponen_penilaian_comp bkpc ON kpc.id = bkpc.komponenpenilaian_id \r\n" + //
        "LEFT JOIN \r\n" + //
        "    penilaian_comp pc ON pc.komponenpenilaian_id = kpc.id AND pc.mahasiswa_id = mc.id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_subcpmk subcpmk ON subcpmk.id = bkpc.subcpmk_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpmk cpmk ON cpmk.id = subcpmk.parentcpmk_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpl cpl ON cpl.id = cpmk.parentcpl_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_comp cc ON cc.id = subcpmk.record_id\r\n" + //
        "JOIN\r\n" + //
        "    capaian_comp cc2 ON cc2.id = cpl.record_id\r\n" + //
        "WHERE \r\n" + //
        "    mc.id = :mahasiswaId\r\n" + //
        "GROUP BY\r\n" + //
        "    mkc.nama, mkc.kode, mc.nama, cc.kode, subcpmk.bobot, subcpmk.parentcpmk_id, cpmk.bobot, cpl.id, cc2.kode\r\n"
        + //
        ")\r\n" + //
        "--\r\n" + //
        "--\r\n" + //
        "UNION ALL \r\n" + //
        "--\r\n" + //
        "--\r\n" + //
        "(\r\n" + //
        "SELECT\r\n" + //
        "    mkc.nama AS matakuliah_nama,\r\n" + //
        "    mkc.kode AS matakuliah_kode,\r\n" + //
        "    mc.nama,\r\n" + //
        "    kpc.nama AS komponen,\r\n" + //
        "    pc.nilai,\r\n" + //
        "    bkpc.bobot,\r\n" + //
        "    cpmk.id AS cpmk_id,\r\n" + //
        "    cpmk.bobot AS cpmmk_bobot,\r\n" + //
        "    cpl.id AS cpl_id,\r\n" + //
        "    cc2.kode AS cpl_kode\r\n" + //
        "FROM \r\n" + //
        "    mahasiswa_comp mc\r\n" + //
        "JOIN \r\n" + //
        "    rencana_studi_comp rsc ON rsc.mahasiswa_id = mc.id \r\n" + //
        "JOIN \r\n" + //
        "    kelas_mahasiswa_comp kmc ON kmc.rencanastudi_id = rsc.id\r\n" + //
        "JOIN \r\n" + //
        "    kelas_comp kc ON kc.id = kmc.kelas_id \r\n" + //
        "JOIN \r\n" + //
        "    mata_kuliah_comp mkc ON mkc.id = kc.matakuliah_id \r\n" + //
        "JOIN\r\n" + //
        "    kurikulum_comp kc2 ON kc2.id = mkc.kurikulum_id\r\n" + //
        "JOIN \r\n" + //
        "    komponen_penilaian_comp kpc ON kpc.kelas_id = kc.id\r\n" + //
        "JOIN\r\n" + //
        "    bobot_komponen_penilaian_comp bkpc ON kpc.id = bkpc.komponenpenilaian_id \r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpmk cpmk ON cpmk.id = bkpc.cpmk_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_cpl cpl ON cpl.id = cpmk.parentcpl_id\r\n" + //
        "JOIN \r\n" + //
        "    capaian_comp cc ON cc.id = cpmk.record_id\r\n" + //
        "JOIN\r\n" + //
        "    capaian_comp cc2 ON cc2.id = cpl.record_id\r\n" + //
        "LEFT JOIN \r\n" + //
        "    penilaian_comp pc ON pc.komponenpenilaian_id = kpc.id AND pc.mahasiswa_id = mc.id\r\n" + //
        "WHERE \r\n" + //
        "    mc.id = :mahasiswaId\r\n" + //
        ")\r\n" + //
        ")\r\n" + //
        "--\r\n" + //
        "--\r\n" + //
        "SELECT\r\n" + //
        "    cpl_id,\r\n" + //
        "    cpl_kode,\r\n" + //
        "    SUM(nilai) / COUNT(cpl_id) AS nilai\r\n" + //
        "FROM\r\n" + //
        "(\r\n" + //
        "SELECT \r\n" + //
        "    matakuliah_nama,\r\n" + //
        "    matakuliah_kode,\r\n" + //
        "    CAST(cpl_id AS VARCHAR),\r\n" + //
        "    cpl_kode,\r\n" + //
        "    SUM(nilai * cpmk_bobot) / NULLIF(SUM(cpmk_bobot), 0) AS nilai\r\n" + //
        "FROM\r\n" + //
        "(SELECT\r\n" + //
        "    matakuliah_nama,\r\n" + //
        "    matakuliah_kode,\r\n" + //
        "    nama,\r\n" + //
        "    SUM(COALESCE(nilai, 0) * bobot) / NULLIF(SUM(bobot), 0) AS nilai,\r\n" + //
        "    cpmk_id,\r\n" + //
        "    cpmk_bobot,\r\n" + //
        "    cpl_id,\r\n" + //
        "    cpl_kode\r\n" + //
        "FROM komponen_cpmk\r\n" + //
        "GROUP BY\r\n" + //
        "    matakuliah_nama, matakuliah_kode, nama, cpmk_id, cpmk_bobot, cpl_id, cpl_kode\r\n" + //
        ")\r\n" + //
        "AS cpmk_attainment\r\n" + //
        "GROUP BY\r\n" + //
        "    matakuliah_nama, matakuliah_kode, cpl_id, cpl_kode\r\n" + //
        ")\r\n" + //
        "AS cpl_attainment\r\n" + //
        "GROUP BY cpl_id, cpl_kode;");

    private final String query;

    PenilaianServiceQueries(String query) {
      this.query = query;
    }

    @Override
    public String toString() {
      return query;
    }
  }
}
