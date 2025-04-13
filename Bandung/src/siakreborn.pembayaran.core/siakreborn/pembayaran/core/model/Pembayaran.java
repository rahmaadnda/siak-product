package siakreborn.pembayaran.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.semester.core.Semester;

public interface Pembayaran {
  public UUID getId();

  public void setId(UUID id);

  public Mahasiswa getMahasiswa();

  public void setMahasiswa(Mahasiswa mahasiswa);

  public Semester getSemester();

  public void setSemester(Semester semester);

  public String getPaymentId();

  public void setPaymentId(String paymentId);

  public String getStatus();

  public void setStatus(String status);

  public String getPaymentLink();

  public void setPaymentLink(String paymentLink);

  public String getVendor();

  public void setVendor(String vendor);

  HashMap<String, Object> toHashMap();
}
