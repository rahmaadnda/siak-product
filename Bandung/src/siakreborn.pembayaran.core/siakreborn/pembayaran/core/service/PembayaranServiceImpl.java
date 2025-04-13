package siakreborn.pembayaran.core;

import java.util.*;

import vmj.routing.route.exceptions.ForbiddenException;

import siakreborn.pembayaran.PembayaranFactory;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;
import siakreborn.semester.core.Semester;
import siakreborn.semester.core.SemesterService;
import siakreborn.semester.core.SemesterServiceImpl;
import paymentgateway.payment.core.Payment;
import paymentgateway.payment.core.PaymentService;
import paymentgateway.payment.PaymentServiceFactory;

public class PembayaranServiceImpl extends PembayaranServiceComponent {
  private PembayaranFactory pembayaranFactory = new PembayaranFactory();
  private SemesterService semesterService = new SemesterServiceImpl();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();
  private PaymentServiceFactory paymentServiceFactory = new PaymentServiceFactory();
  private PaymentService paymentService = paymentServiceFactory.createPaymentService(
      "paymentgateway.payment.paymentlink.PaymentServiceImpl",
      PaymentServiceFactory.createPaymentService(
          "paymentgateway.payment.core.PaymentServiceImpl"));

  public Pembayaran savePembayaran(HashMap<String, Object> body) {
    String mahasiswaIdStr = (String) body.get("mahasiswaId");
    String semesterIdStr = (String) body.get("semesterId");
    String vendorName = (String) body.get("vendorName");

    Mahasiswa mahasiswa = null;
    if (mahasiswaIdStr != null) {
      UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);
      mahasiswa = mahasiswaService.getMahasiswa(mahasiswaId);
    }

    Semester semester = null;
    if (semesterIdStr != null) {
      UUID semesterId = UUID.fromString(semesterIdStr);
      semester = semesterService.getSemester(semesterId);
    }

    Pembayaran cekPembayaran = getPembayaran(mahasiswa.getId(), semester.getId());
    if (cekPembayaran != null) {
      throw new ForbiddenException("Anda sudah membayar semester ini");
    }

    HashMap<String, Object> paymentBody = new HashMap<>();
    paymentBody.put("vendor_name", vendorName);
    paymentBody.put("amount", "5000000");
    // paymentBody.put("bank", "bca");
    paymentBody.put("name", mahasiswa.getNama());
    paymentBody.put("sender_name", mahasiswa.getNama());
    paymentBody.put("email", mahasiswa.getEmail());
    paymentBody.put("title", "Pembayaran Semester " + semester.getKode());
    Payment payment = paymentService.createPayment(paymentBody);
    String paymentLink = ((paymentgateway.payment.paymentlink.PaymentLinkImpl) payment).getPaymentLink();

    Pembayaran pembayaran = pembayaranFactory.createPembayaran("siakreborn.pembayaran.core.PembayaranImpl", mahasiswa,
        semester, String.valueOf(payment.getIdTransaction()), "pending", paymentLink, vendorName);

    pembayaranRepository.saveObject(pembayaran);
    return pembayaran;
  }

  public Pembayaran savePembayaranMe(UUID mahasiswaId, HashMap<String, Object> body) {
    Semester semester = semesterService.getActiveSemester();

    Mahasiswa mahasiswa = null;
    mahasiswa = mahasiswaService.getMahasiswa(mahasiswaId);

    Pembayaran cekPembayaran = getPembayaran(mahasiswaId, semester.getId());
    if (cekPembayaran != null) {
      throw new ForbiddenException("Anda sudah membayar semester ini");
    }

    String vendorName = (String) body.get("vendorName");

    HashMap<String, Object> paymentBody = new HashMap<>();
    paymentBody.put("vendor_name", vendorName);
    paymentBody.put("amount", "5000000");
    // paymentBody.put("bank", "bca");
    paymentBody.put("name", mahasiswa.getNama());
    paymentBody.put("sender_name", mahasiswa.getNama());
    paymentBody.put("email", mahasiswa.getEmail());
    paymentBody.put("title", "Pembayaran Semester " + semester.getKode());
    Payment payment = paymentService.createPayment(paymentBody);
    String paymentLink = ((paymentgateway.payment.paymentlink.PaymentLinkImpl) payment).getPaymentLink();

    Pembayaran pembayaran = pembayaranFactory.createPembayaran("siakreborn.pembayaran.core.PembayaranImpl", mahasiswa,
        semester, String.valueOf(payment.getIdTransaction()), "pending", paymentLink, vendorName);

    pembayaranRepository.saveObject(pembayaran);
    return pembayaran;
  }

  public Pembayaran updatePembayaran(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String mahasiswaIdStr = (String) body.get("mahasiswaId");
    String semesterIdStr = (String) body.get("semesterId");
    String status = (String) body.get("status");

    Pembayaran pembayaran = pembayaranRepository.getObject(id);

    Mahasiswa mahasiswa = null;
    if (mahasiswaIdStr != null) {
      UUID mahasiswaId = UUID.fromString(mahasiswaIdStr);
      mahasiswa = pembayaranRepository.getProxyObject(siakreborn.mahasiswa.core.MahasiswaComponent.class,
          mahasiswaId);
    }

    Semester semester = null;
    if (semesterIdStr != null) {
      UUID semesterId = UUID.fromString(semesterIdStr);
      semester = pembayaranRepository.getProxyObject(siakreborn.semester.core.SemesterComponent.class,
          semesterId);
    }

    pembayaran.setMahasiswa(mahasiswa);
    pembayaran.setSemester(semester);
    pembayaran.setStatus(status);

    pembayaranRepository.updateObject(pembayaran);
    pembayaran = pembayaranRepository.getObject(id);

    return pembayaran;
  }

  public Pembayaran getPembayaran(UUID id) {
    Pembayaran pembayaran = pembayaranRepository.getObject(id);
    return pembayaran;
  }

  public Pembayaran getPembayaranMe(UUID mahasiswaId) {
    Semester semester = semesterService.getActiveSemester();
    return getPembayaran(mahasiswaId, semester.getId());
  }

  public Pembayaran getPembayaran(UUID mahasiswaId, UUID semesterId) {
    List<Pembayaran> pembayaranList = pembayaranRepository.getListObject("pembayaran_comp", "mahasiswa_id",
        mahasiswaId);
    for (Pembayaran pembayaran : pembayaranList) {
      if (pembayaran.getSemester().getId().equals(semesterId)) {
        String paymentId = pembayaran.getPaymentId();
        String vendorName = pembayaran.getVendor();
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("id", paymentId);
        requestData.put("vendor_name", vendorName);

        Map<String, Object> result = paymentService.checkPaymentStatus(requestData);
        String status = (String) result.get("status");

        pembayaran.setStatus(status);
        pembayaranRepository.updateObject(pembayaran);

        return pembayaran;
      }
    }

    return null;
  }

  public List<Pembayaran> getAllPembayaran() {
    List<Pembayaran> pembayaranList = pembayaranRepository.getAllObject("pembayaran_impl",
        PembayaranImpl.class.getName());
    return pembayaranList;
  }

  public List<Pembayaran> deletePembayaran(UUID id) {
    pembayaranRepository.deleteObject(id);
    return getAllPembayaran();
  }

  public List<HashMap<String, Object>> transformPembayaranListToHashMap(List<Pembayaran> pembayaranList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < pembayaranList.size(); i++) {
      resultList.add(pembayaranList.get(i).toHashMap());
    }

    return resultList;
  }
}
