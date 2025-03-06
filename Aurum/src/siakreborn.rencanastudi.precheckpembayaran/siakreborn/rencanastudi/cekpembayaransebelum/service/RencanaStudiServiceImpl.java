package siakreborn.rencanastudi.precheckpembayaran;

import java.util.*;
import vmj.routing.route.exceptions.ForbiddenException;

import siakreborn.rencanastudi.core.RencanaStudiServiceComponent;
import siakreborn.rencanastudi.core.RencanaStudiServiceDecorator;
import siakreborn.semester.core.Semester;
import siakreborn.semester.core.SemesterService;
import siakreborn.semester.core.SemesterServiceImpl;
import siakreborn.pembayaran.core.Pembayaran;
import siakreborn.pembayaran.core.PembayaranService;
import siakreborn.pembayaran.core.PembayaranServiceImpl;

public class RencanaStudiServiceImpl extends RencanaStudiServiceDecorator {
  SemesterService semesterService = new SemesterServiceImpl();
  PembayaranService pembayaranService = new PembayaranServiceImpl();

  public RencanaStudiServiceImpl(RencanaStudiServiceComponent record) {
    super(record);
  }

  public HashMap<String, Object> getRencanaStudiClass(UUID mahasiswaId) {
    Semester activeSemester = semesterService.getActiveSemester();

    Pembayaran pembayaran = pembayaranService.getPembayaran(mahasiswaId, activeSemester.getId());

    if (pembayaran == null || !(pembayaran.getStatus().equalsIgnoreCase("complete")
        || pembayaran.getStatus().equalsIgnoreCase("settlement")
        || pembayaran.getStatus().equalsIgnoreCase("successful"))) {
      throw new ForbiddenException("Harap lakukan pembayaran semester terlebih dahulu");
    }

    return record.getRencanaStudiClass(mahasiswaId);
  }
}
