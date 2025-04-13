package siakreborn.penilaian.penilaianobe;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;
import vmj.hibernate.integrator.RepositoryUtil;

import siakreborn.penilaian.core.Penilaian;
import siakreborn.penilaian.core.PenilaianImpl;
import siakreborn.penilaian.core.PenilaianResourceDecorator;
import siakreborn.penilaian.core.PenilaianResourceComponent;
import siakreborn.penilaian.core.PenilaianService;
import siakreborn.penilaian.core.PenilaianServiceComponent;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianService;
import siakreborn.capaian.core.CapaianServiceImpl;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;

import java.util.*;

public class PenilaianResourceImpl extends PenilaianResourceDecorator {
  PenilaianService penilaianService;
  CapaianService capaianService = new CapaianServiceImpl();
  MahasiswaService mahasiswaService = new MahasiswaServiceImpl();

  RepositoryUtil<Capaian> capaianRepository = new RepositoryUtil<Capaian>(
      siakreborn.capaian.core.CapaianComponent.class);
  RepositoryUtil<MataKuliah> mataKuliahRepository = new RepositoryUtil<MataKuliah>(
      siakreborn.matakuliah.core.MataKuliahComponent.class);

  public PenilaianResourceImpl(PenilaianResourceComponent recordController, PenilaianServiceComponent recordService) {
    super(recordController);
    this.penilaianService = new PenilaianServiceImpl(recordService);
  }

  @Restricted(permissionName = "CreatePenilaian")
  @Route(url = "call/penilaian/save")
  public List<HashMap<String, Object>> savePenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<Penilaian> penilaianList = penilaianService.savePenilaian((HashMap<String, Object>) vmjExchange.getPayload());
    return penilaianService.transformPenilaianListToHashMap(penilaianList);
  }

  @Restricted(permissionName = "UpdatePenilaian")
  @Route(url = "call/penilaian/update")
  public HashMap<String, Object> updatePenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    Penilaian penilaian = penilaianService.updatePenilaian((HashMap<String, Object>) vmjExchange.getPayload());
    return penilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadPenilaian")
  @Route(url = "call/penilaian/detail")
  public HashMap<String, Object> getPenilaian(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Penilaian penilaian = penilaianService.getPenilaian(id);
    return penilaian.toHashMap();
  }

  @Restricted(permissionName = "ReadPenilaian")
  @Route(url = "call/penilaian/list")
  public List<HashMap<String, Object>> getAllPenilaian(VMJExchange vmjExchange) {
    List<Penilaian> penilaianList = penilaianService.getAllPenilaian();
    return penilaianService.transformPenilaianListToHashMap(penilaianList);
  }

  @Restricted(permissionName = "DeletePenilaian")
  @Route(url = "call/penilaian/delete")
  public List<HashMap<String, Object>> deletePenilaian(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Penilaian> penilaianList = penilaianService.deletePenilaian(id);
    return penilaianService.transformPenilaianListToHashMap(penilaianList);
  }

  @Restricted(permissionName = "ReadPenilaian")
  @Route(url = "call/penilaian/filter")
  public List<HashMap<String, Object>> filterPenilaian(VMJExchange vmjExchange) {
    String by = (String) vmjExchange.getGETParam("by");

    if (by.equals("mahasiswa") || by.equals("komponenPenilaian")) {
      String idStr = (String) vmjExchange.getGETParam(by + "Id");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID id = UUID.fromString(idStr);

      String columnName = by.toLowerCase() + "_id";

      List<Penilaian> penilaianList = penilaianService.filterPenilaian(columnName, id);
      return penilaianService.transformPenilaianListToHashMap(penilaianList);
    } else if (by.equals("mahasiswa,kelas")) {
      String mahasiswaIdStr = (String) vmjExchange.getGETParam("mahasiswaId");
      if(mahasiswaIdStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);

      String idStr = (String) vmjExchange.getGETParam("kelasId");
      if(idStr == null) {
        throw new IllegalArgumentException("Invalid UUID");
      }
      UUID kelasId = UUID.fromString(idStr);

      List<Penilaian> penilaianList = penilaianService.filterPenilaianByMahasiswaAndKelas(mahasiswaId, kelasId);
      return penilaianService.transformPenilaianListToHashMap(penilaianList);
    }

    return new ArrayList<>();
  }

  @Restricted(permissionName = "ReadLaporanCPMK")
  @Route(url = "call/cpmk/laporan-chart/list")
  public HashMap<String, Object> getLaporanCPMKChart(VMJExchange vmjExchange) {
    // HashMap<String, Object> laporanCPMK = getLaporanCPMK(vmjExchange);
    String mataKuliahIdStr = (String) vmjExchange.getGETParam("mataKuliahId");
    if(mataKuliahIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);

    HashMap<String, Object> sourceMap = ((PenilaianServiceImpl) penilaianService).getSourceMap();
    HashMap<String, Object> laporanCPMK = ((PenilaianServiceImpl) penilaianService).getLaporanCPMKMap(mataKuliahId,
        sourceMap);

    List<Capaian> listCPMK = (List<Capaian>) laporanCPMK.get("cpmkList");
    List<HashMap<String, Object>> cpmkMahasiswaList = (List<HashMap<String, Object>>) laporanCPMK.get("mahasiswaList");

    HashMap<String, Object> chartMap = new HashMap<>();

    // chart labels
    List<String> labels = new ArrayList<>();
    for (Capaian cpmk : listCPMK) {
      labels.add(cpmk.getKode());
    }
    chartMap.put("labels", labels);

    // chart data
    List<Double> data = new ArrayList<>();
    for (Capaian cpmk : listCPMK) {
      String id = cpmk.getId().toString();
      double totalAttainment = 0;
      for (HashMap<String, Object> cpmkMahasiswaMap : cpmkMahasiswaList) {
        double attainment = (double) cpmkMahasiswaMap.get(id);
        totalAttainment += attainment;
      }

      double avgAttainment = 0;
      if (cpmkMahasiswaList.size() > 0)
        avgAttainment = totalAttainment / (double) cpmkMahasiswaList.size();

      data.add(Math.round(avgAttainment * 100d) / 100d);
    }
    chartMap.put("data", data);

    return chartMap;
  }

  @Restricted(permissionName = "ReadLaporanCPL")
  @Route(url = "call/cpl/laporan-chart/list")
  public HashMap<String, Object> getLaporanCPLChart(VMJExchange vmjExchange) {
    // HashMap<String, Object> laporanCPL = getLaporanCPL(vmjExchange);
    String kurikulumIdStr = (String) vmjExchange.getGETParam("kurikulumId");
    if(kurikulumIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kurikulumId = UUID.fromString(kurikulumIdStr);

    HashMap<String, Object> sourceMap = ((PenilaianServiceImpl) penilaianService).getSourceMap();
    HashMap<String, Object> laporanCPL = ((PenilaianServiceImpl) penilaianService).getLaporanCPLMap(kurikulumId,
        sourceMap);

    List<Capaian> listCPL = (List<Capaian>) laporanCPL.get("cplList");
    List<HashMap<String, Object>> cplMataKuliahList = (List<HashMap<String, Object>>) laporanCPL.get("mataKuliahList");

    HashMap<String, Object> chartMap = new HashMap<>();

    // chart labels
    List<String> labels = new ArrayList<>();
    for (Capaian cpl : listCPL) {
      labels.add(cpl.getKode());
    }
    chartMap.put("labels", labels);

    // chart data
    List<Double> data = new ArrayList<>();
    for (Capaian cpl : listCPL) {
      String id = cpl.getId().toString();
      double totalAttainment = 0;
      int mataKuliahCount = 0;
      for (HashMap<String, Object> cplMataKuliahMap : cplMataKuliahList) {
        if (cplMataKuliahMap.containsKey(id)) {
          double attainment = (double) cplMataKuliahMap.get(id);
          totalAttainment += attainment;
          mataKuliahCount++;
        }
      }

      double avgAttainment = 0;
      if (mataKuliahCount > 0)
        avgAttainment = totalAttainment / (double) mataKuliahCount;

      data.add(Math.round(avgAttainment * 100d) / 100d);
    }
    chartMap.put("data", data);

    return chartMap;
  }

  @Restricted(permissionName = "ReadLaporanCPMK")
  @Route(url = "call/cpmk/laporan-mahasiswa/list")
  public HashMap<String, Object> getLaporanCPMK(VMJExchange vmjExchange) {
    String mataKuliahIdStr = (String) vmjExchange.getGETParam("mataKuliahId");
    if(mataKuliahIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);

    HashMap<String, Object> sourceMap = ((PenilaianServiceImpl) penilaianService).getSourceMap();

    HashMap<String, Object> result = ((PenilaianServiceImpl) penilaianService).getLaporanCPMKMap(mataKuliahId,
        sourceMap);
    List<Capaian> cpmkList = (List<Capaian>) result.get("cpmkList");
    result.put("cpmkList", capaianService.transformCapaianListToHashMap(cpmkList));

    return result;
  }

  @Restricted(permissionName = "ReadLaporanCPL")
  @Route(url = "call/cpl/laporan-mahasiswa/list")
  public HashMap<String, Object> getLaporanCPL(VMJExchange vmjExchange) {
    String kurikulumIdStr = (String) vmjExchange.getGETParam("kurikulumId");
    if(kurikulumIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kurikulumId = UUID.fromString(kurikulumIdStr);

    HashMap<String, Object> sourceMap = ((PenilaianServiceImpl) penilaianService).getSourceMap();

    HashMap<String, Object> result = ((PenilaianServiceImpl) penilaianService).getLaporanCPLMap(kurikulumId, sourceMap);
    List<Capaian> cplList = (List<Capaian>) result.get("cplList");
    result.put("cplList", capaianService.transformCapaianListToHashMap(cplList));

    return result;
  }

  @Restricted(permissionName = "ReadLaporanCPLMe")
  @Route(url = "call/cpl/laporan-mahasiswa/me")
  public List<HashMap<String, Object>> getLaporanCPLMe(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    List<HashMap<String, Object>> result = ((PenilaianServiceImpl) penilaianService)
        .getCPLAttainmentMahasiswa(mahasiswa.getId());

    return result;
  }

  // v2
  @Restricted(permissionName = "ReadLaporanCPMK")
  @Route(url = "call/v2/cpmk/laporan/list")
  public HashMap<String, Object> getLaporanCPMKV2(VMJExchange vmjExchange) {
    String mataKuliahIdStr = (String) vmjExchange.getGETParam("mataKuliahId");
    if(mataKuliahIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);

    HashMap<String, Object> result = ((PenilaianServiceImpl) penilaianService).getLaporanCPMKMapV2(mataKuliahId);

    return result;
  }

  @Restricted(permissionName = "ReadLaporanCPMK")
  @Route(url = "call/v2/cpmk/laporan/chart")
  public HashMap<String, Object> getLaporanCPMKChartV2(VMJExchange vmjExchange) {
    String mataKuliahIdStr = (String) vmjExchange.getGETParam("mataKuliahId");
    if(mataKuliahIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);

    HashMap<String, Object> result = ((PenilaianServiceImpl) penilaianService).getLaporanCPMKChartV2(mataKuliahId);

    return result;
  }

  @Restricted(permissionName = "ReadLaporanCPL")
  @Route(url = "call/v2/cpl/laporan/list")
  public HashMap<String, Object> getLaporanCPLV2(VMJExchange vmjExchange) {
    String kurikulumIdStr = (String) vmjExchange.getGETParam("kurikulumId");
    if(kurikulumIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kurikulumId = UUID.fromString(kurikulumIdStr);

    HashMap<String, Object> result = ((PenilaianServiceImpl) penilaianService).getLaporanCPLMapV2(kurikulumId);

    return result;
  }

  @Restricted(permissionName = "ReadLaporanCPL")
  @Route(url = "call/v2/cpl/laporan/chart")
  public HashMap<String, Object> getLaporanCPLChartV2(VMJExchange vmjExchange) {
    String kurikulumIdStr = (String) vmjExchange.getGETParam("kurikulumId");
    if(kurikulumIdStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID kurikulumId = UUID.fromString(kurikulumIdStr);

    HashMap<String, Object> result = ((PenilaianServiceImpl) penilaianService).getLaporanCPLChartV2(kurikulumId);

    return result;
  }
}
