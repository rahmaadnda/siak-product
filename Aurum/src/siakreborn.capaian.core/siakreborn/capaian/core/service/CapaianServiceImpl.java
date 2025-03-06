package siakreborn.capaian.core;

import java.util.*;

import siakreborn.capaian.CapaianFactory;

public class CapaianServiceImpl extends CapaianServiceComponent {
  private CapaianFactory capaianFactory = new CapaianFactory();

  public List<Capaian> saveCapaian(HashMap<String, Object> body) {
    String kode = (String) body.get("kode");
    String deskripsi = (String) body.get("deskripsi");

    Capaian capaian = CapaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", kode, deskripsi);

    return getAllCapaian();
  }

  public Capaian updateCapaian(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String deskripsi = (String) body.get("deskripsi");

    Capaian capaian = capaianRepository.getObject(id);
    capaian.setKode(kode);
    capaian.setDeskripsi(deskripsi);

    capaianRepository.updateObject(capaian);
    capaian = capaianRepository.getObject(id);

    return capaian;
  }

  public Capaian getCapaian(UUID id) {
    Capaian capaian = capaianRepository.getObject(id);
    return capaian;
  }

  public List<Capaian> getAllCapaian() {
    List<Capaian> capaianList = capaianRepository.getAllObject("capaian_impl", CapaianImpl.class.getName());
    return capaianList;
  }

  public List<HashMap<String, Object>> getCapaianKelas(UUID kelasId) {
    List<HashMap<String, Object>> capaianList = new ArrayList<>();
    capaianRepository.executeQuery(session -> {
      String sql = CapaianServiceQueries.SELECT_CAPAIAN_KELAS.toString();

      List<Object[]> results = (List<Object[]>) session.createNativeQuery(sql).setParameter("kelasId",
          kelasId).list();
      for (int i = 0; i < results.size(); i++) {
        Object[] result = results.get(i);

        HashMap<String, Object> capaian = new HashMap<>();
        capaian.put("kode", result[0]);
        capaian.put("name", result[0]);
        capaian.put("id", result[1]);
        capaian.put("capaianId", result[1]);
        capaian.put("type", result[2]);

        capaianList.add(capaian);
      }
    });

    return capaianList;
  }

  public List<Capaian> deleteCapaian(UUID id) {
    capaianRepository.deleteObject(id);
    return getAllCapaian();
  }

  public List<HashMap<String, Object>> transformCapaianListToHashMap(List<Capaian> capaianList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < capaianList.size(); i++) {
      resultList.add(capaianList.get(i).toHashMap());
    }

    return resultList;
  }

  enum CapaianServiceQueries {
    SELECT_CAPAIAN_KELAS("SELECT \r\n" + //
        "    kode,\r\n" + //
        "    CAST(id AS VARCHAR),\r\n" + //
        "    type\r\n" + //
        "FROM\r\n" + //
        "(\r\n" + //
        "    (\r\n" + //
        "        SELECT\r\n" + //
        "            cc.kode AS kode,\r\n" + //
        "            cpmk.id AS id,\r\n" + //
        "            'cpmk' AS type\r\n" + //
        "        FROM\r\n" + //
        "            capaian_cpmk cpmk\r\n" + //
        "        JOIN\r\n" + //
        "            capaian_comp cc ON cc.id = cpmk.record_id\r\n" + //
        "        JOIN\r\n" + //
        "            mata_kuliah_comp mkc ON mkc.id = cpmk.matakuliah_id\r\n" + //
        "        JOIN\r\n" + //
        "        \tkelas_comp kc ON kc.matakuliah_id = mkc.id\r\n" + //
        "        WHERE \r\n" + //
        "            kc.id = :kelasId\r\n" + //
        "    )\r\n" + //
        "    UNION ALL\r\n" + //
        "    (\r\n" + //
        "        SELECT\r\n" + //
        "            cc.kode AS kode,\r\n" + //
        "            subcpmk.id AS id,\r\n" + //
        "            'subcpmk' AS type\r\n" + //
        "        FROM\r\n" + //
        "            capaian_subcpmk subcpmk\r\n" + //
        "        JOIN\r\n" + //
        "            capaian_comp cc ON cc.id = subcpmk.record_id\r\n" + //
        "        JOIN\r\n" + //
        "            capaian_cpmk cpmk ON subcpmk.parentcpmk_id = cpmk.id\r\n" + //
        "        JOIN\r\n" + //
        "            mata_kuliah_comp mkc ON mkc.id = cpmk.matakuliah_id\r\n" + //
        "        JOIN\r\n" + //
        "        \tkelas_comp kc ON kc.matakuliah_id = mkc.id\r\n" + //
        "        WHERE \r\n" + //
        "            kc.id = :kelasId\r\n" + //
        "    )\r\n" + //
        ") AS capaian;\r\n" + //
        "");

    private final String query;

    CapaianServiceQueries(String query) {
      this.query = query;
    }

    @Override
    public String toString() {
      return query;
    }
  }
}
