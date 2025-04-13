package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;

import vmj.routing.route.exceptions.BadRequestException;

import siakreborn.bobotkomponenpenilaian.BobotKomponenPenilaianFactory;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianService;
import siakreborn.capaian.core.CapaianServiceImpl;
import siakreborn.komponenpenilaian.core.KomponenPenilaian;

public class BobotKomponenPenilaianServiceImpl extends BobotKomponenPenilaianServiceComponent {
  private BobotKomponenPenilaianFactory bobotKomponenPenilaianFactory = new BobotKomponenPenilaianFactory();
  private CapaianService capaianService = new CapaianServiceImpl();

  public List<BobotKomponenPenilaian> saveBobotKomponenPenilaian(HashMap<String, Object> body) {
    String capaianIdStr = (String) body.get("capaianId");
    String komponenPenilaianIdStr = (String) body.get("komponenPenilaianId");

    BobotKomponenPenilaian bobotKomponenPenilaian = getBobotKomponenPenilaian(
        UUID.fromString(capaianIdStr), UUID.fromString(komponenPenilaianIdStr));

    if (bobotKomponenPenilaian != null) {
      body.put("id", bobotKomponenPenilaian.getId().toString());
      updateBobotKomponenPenilaian(body);
    } else {
      String bobotStr = (String) body.get("bobot");
      double bobot = Double.parseDouble(bobotStr);

      KomponenPenilaian komponenPenilaian = null;
      if (komponenPenilaianIdStr != null) {
        UUID komponenPenilaianId = UUID.fromString(komponenPenilaianIdStr);
        komponenPenilaian = bobotKomponenPenilaianRepository
            .getProxyObject(siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class, komponenPenilaianId);
      }

      Capaian capaian = null;
      Capaian cpmk = null;
      Capaian subCPMK = null;
      if (capaianIdStr != null) {
        UUID capaianId = UUID.fromString(capaianIdStr);
        String capaianType = getCapaianType(capaianId);

        if (capaianType == null) {
          throw new BadRequestException("Id Capaian tidak ditemukan");
        }

        capaian = bobotKomponenPenilaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class,
            capaianId);

        if (capaianType.equals("cpmk")) {
          cpmk = capaian;
          subCPMK = null;
        } else {
          cpmk = null;
          subCPMK = capaian;
        }
      }

      bobotKomponenPenilaian = bobotKomponenPenilaianFactory.createBobotKomponenPenilaian(
          "siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianImpl", bobot, komponenPenilaian, cpmk, subCPMK);
      bobotKomponenPenilaianRepository.saveObject(bobotKomponenPenilaian);
    }

    return getAllBobotKomponenPenilaian();
  }

  public BobotKomponenPenilaian updateBobotKomponenPenilaian(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String bobotStr = (String) body.get("bobot");
    double bobot = Double.parseDouble(bobotStr);
    String komponenPenilaianIdStr = (String) body.get("komponenPenilaianId");
    String capaianIdStr = (String) body.get("capaianId");

    BobotKomponenPenilaian bobotKomponenPenilaian = bobotKomponenPenilaianRepository.getObject(id);

    KomponenPenilaian komponenPenilaian = bobotKomponenPenilaian.getKomponenPenilaian();
    if (komponenPenilaianIdStr != null) {
      UUID komponenPenilaianId = UUID.fromString(komponenPenilaianIdStr);
      komponenPenilaian = bobotKomponenPenilaianRepository
          .getProxyObject(siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class, komponenPenilaianId);
    }

    Capaian capaian = null;
    Capaian cpmk = null;
    Capaian subCPMK = null;
    if (capaianIdStr != null) {
      UUID capaianId = UUID.fromString(capaianIdStr);
      String capaianType = getCapaianType(capaianId);

      if (capaianType == null) {
        throw new BadRequestException("Id Capaian tidak ditemukan");
      }

      capaian = bobotKomponenPenilaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class,
          capaianId);

      if (capaianType.equals("cpmk")) {
        cpmk = capaian;
        subCPMK = null;
      } else {
        cpmk = null;
        subCPMK = capaian;
      }
    }

    bobotKomponenPenilaian.setBobot(bobot);
    bobotKomponenPenilaian.setKomponenPenilaian(komponenPenilaian);
    bobotKomponenPenilaian.setCPMK(cpmk);
    bobotKomponenPenilaian.setSubCPMK(subCPMK);

    bobotKomponenPenilaianRepository.updateObject(bobotKomponenPenilaian);
    bobotKomponenPenilaian = bobotKomponenPenilaianRepository.getObject(id);

    return bobotKomponenPenilaian;
  }

  public BobotKomponenPenilaian getBobotKomponenPenilaian(UUID id) {
    BobotKomponenPenilaian bobotKomponenPenilaian = bobotKomponenPenilaianRepository.getObject(id);
    return bobotKomponenPenilaian;
  }

  public BobotKomponenPenilaian getBobotKomponenPenilaian(UUID capaianId, UUID komponenPenilaianId) {
    BobotKomponenPenilaian[] bobotKomponenPenilaianWrapper = new BobotKomponenPenilaian[1];

    bobotKomponenPenilaianRepository.executeQuery(session -> {
      String sql = BobotKomponenPenilaianServiceQueries.SELECT_BOBOT_KOMPONEN_PENILAIAN_KOMPONEN_CAPAIAN.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql)
          .setParameter("capaianId", capaianId)
          .setParameter("komponenPenilaianId", komponenPenilaianId)
          .list();

      if (results.size() > 0) {
        Object[] result = results.get(0);
        String idStr = (String) result[0];
        double bobot = (double) result[1];
        String komponenPenilaianIdStr = (String) result[2];
        String subCPMKIdStr = (String) result[3];
        String cpmkIdStr = (String) result[4];

        UUID id = UUID.fromString(idStr);

        KomponenPenilaian komponenPenilaian = null;
        if (komponenPenilaianIdStr != null) {
          UUID komponenPenilaianId2 = UUID.fromString(komponenPenilaianIdStr);
          komponenPenilaian = bobotKomponenPenilaianRepository
              .getProxyObject(siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class, komponenPenilaianId2);
        }

        Capaian subCPMK = null;
        if (subCPMKIdStr != null) {
          UUID subCPMKId = UUID.fromString(subCPMKIdStr);
          subCPMK = bobotKomponenPenilaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class,
              subCPMKId);
        }

        Capaian cpmk = null;
        if (cpmkIdStr != null) {
          UUID cpmkId = UUID.fromString(cpmkIdStr);
          cpmk = bobotKomponenPenilaianRepository.getProxyObject(siakreborn.capaian.core.CapaianComponent.class,
              cpmkId);
        }

        bobotKomponenPenilaianWrapper[0] = bobotKomponenPenilaianFactory.createBobotKomponenPenilaian(
            "siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianImpl", id, bobot, komponenPenilaian, cpmk,
            subCPMK);
      } else {
        bobotKomponenPenilaianWrapper[0] = null;
      }
    });

    return bobotKomponenPenilaianWrapper[0];
  }

  public List<BobotKomponenPenilaian> getAllBobotKomponenPenilaian() {
    List<BobotKomponenPenilaian> bobotKomponenPenilaianList = bobotKomponenPenilaianRepository
        .getAllObject("bobot_komponen_penilaian_impl", BobotKomponenPenilaianImpl.class.getName());
    return bobotKomponenPenilaianList;
  }

  public HashMap<String, Object> getKomponenPenilaianKelasMapping(UUID kelasId) {
    List<HashMap<String, Object>> capaianList = capaianService.getCapaianKelas(kelasId);

    List<HashMap<String, Object>> komponenList = new ArrayList<>();
    bobotKomponenPenilaianRepository.executeQuery(session -> {
      String sql = BobotKomponenPenilaianServiceQueries.SELECT_KOMPONEN_PENILAIAN_MAPPING.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql)
          .setParameter("kelasId", kelasId)
          .list();

      HashMap<String, Object> komponenMap = new HashMap<>();
      for (int i = 0; i < results.size(); i++) {
        Object[] result = results.get(i);

        String id = (String) result[0];
        String nama = (String) result[1];
        double bobot = (double) result[2];
        String capaianId = (String) result[3];

        if (komponenMap.containsKey(id)) {
          HashMap<String, Object> map = (HashMap<String, Object>) komponenMap.get(id);
          map.put(capaianId, bobot);
        } else {
          HashMap<String, Object> map = new HashMap<>();
          map.put("id", id);
          map.put("nama", nama);
          map.put(capaianId, bobot);

          komponenMap.put(id, map);
        }
      }

      for (Map.Entry<String, Object> entry : komponenMap.entrySet()) {
        HashMap<String, Object> map = (HashMap<String, Object>) entry.getValue();
        komponenList.add(map);
      }
    });

    HashMap<String, Object> result = new HashMap<>();
    result.put("capaian", capaianList);
    result.put("komponen", komponenList);

    return result;
  }

  public List<BobotKomponenPenilaian> deleteBobotKomponenPenilaian(UUID id) {
    bobotKomponenPenilaianRepository.deleteObject(id);
    return getAllBobotKomponenPenilaian();
  }

  public List<HashMap<String, Object>> transformBobotKomponenPenilaianListToHashMap(
      List<BobotKomponenPenilaian> bobotKomponenPenilaianList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < bobotKomponenPenilaianList.size(); i++) {
      resultList.add(bobotKomponenPenilaianList.get(i).toHashMap());
    }

    return resultList;
  }

  public String getCapaianType(UUID capaianId) {
    String[] wrapper = new String[1];
    bobotKomponenPenilaianRepository.executeQuery(session -> {
      String sql = BobotKomponenPenilaianServiceQueries.SELECT_CAPAIAN_TYPE.toString();

      List<String> results = (List<String>) session.createNativeQuery(sql)
          .setParameter("capaianId", capaianId)
          .list();

      if (results.size() < 1)
        wrapper[0] = null;
      else {
        String result = results.get(0);
        wrapper[0] = result;
      }
    });

    return wrapper[0];
  }

  enum BobotKomponenPenilaianServiceQueries {
    SELECT_BOBOT_KOMPONEN_PENILAIAN_KOMPONEN_CAPAIAN("SELECT\r\n" + //
        "    CAST(bkpc.id AS VARCHAR),\r\n" + //
        "    bkpc.bobot,\r\n" + //
        "    CAST(bkpc.komponenpenilaian_id AS VARCHAR),\r\n" + //
        "    CAST(bkpc.subcpmk_id AS VARCHAR),\r\n" + //
        "    CAST(bkpc.cpmk_id AS VARCHAR) \r\n" + //
        "FROM\r\n" + //
        "bobot_komponen_penilaian_comp bkpc\r\n" + //
        "WHERE\r\n" + //
        "(bkpc.cpmk_id = :capaianId OR bkpc.subcpmk_id = :capaianId)\r\n"
        + //
        "AND komponenpenilaian_id = :komponenPenilaianId\r\n" + //
        ";"),
    SELECT_KOMPONEN_PENILAIAN_MAPPING("SELECT \r\n" + //
        "    CAST(kpc.id AS VARCHAR),\r\n" + //
        "    kpc.nama,\r\n" + //
        "    bkpc.bobot,\r\n" + //
        "    CASE\r\n" + //
        "        WHEN bkpc.cpmk_id IS NOT NULL THEN CAST(bkpc.cpmk_id AS VARCHAR)\r\n" + //
        "        ELSE CAST(bkpc.subcpmk_id AS VARCHAR)\r\n" + //
        "    END AS capaian_id\r\n" + //
        "FROM\r\n" + //
        "    bobot_komponen_penilaian_comp bkpc \r\n" + //
        "JOIN\r\n" + //
        "    komponen_penilaian_comp kpc ON bkpc.komponenpenilaian_id = kpc.id\r\n" + //
        "WHERE \r\n" + //
        "    kpc.kelas_id = :kelasId\r\n" + //
        ";\r\n" + //
        ""),
    SELECT_CAPAIAN_TYPE("SELECT \r\n" + //
        "    CASE\r\n" + //
        "        WHEN EXISTS (\r\n" + //
        "            SELECT * FROM capaian_cpmk cpmk\r\n" + //
        "            WHERE cpmk.id = :capaianId OR cpmk.record_id = :capaianId\r\n"
        + //
        "        ) THEN 'cpmk'\r\n" + //
        "        WHEN EXISTS (\r\n" + //
        "            SELECT * FROM capaian_subcpmk subcpmk\r\n" + //
        "            WHERE subcpmk.id = :capaianId OR subcpmk.record_id = :capaianId\r\n"
        + //
        "        ) THEN 'subcpmk'\r\n" + //
        "        ELSE null\r\n" + //
        "    END AS \"type\";\r\n" + //
        "    ");

    private final String query;

    BobotKomponenPenilaianServiceQueries(String query) {
      this.query = query;
    }

    @Override
    public String toString() {
      return query;
    }
  }
}
