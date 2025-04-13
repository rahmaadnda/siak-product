package siakreborn.rencanastudi.precheckpembayaran;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.routing.route.Route;
import vmj.auth.annotations.Restricted;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;
import siakreborn.rencanastudi.core.RencanaStudi;
import siakreborn.rencanastudi.core.RencanaStudiResourceComponent;
import siakreborn.rencanastudi.core.RencanaStudiResourceDecorator;
import siakreborn.rencanastudi.core.RencanaStudiImpl;
import siakreborn.rencanastudi.core.RencanaStudiService;
import siakreborn.rencanastudi.core.RencanaStudiServiceComponent;

public class RencanaStudiResourceImpl extends RencanaStudiResourceDecorator {
  private RencanaStudiService rencanaStudiService;
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();

  public RencanaStudiResourceImpl(RencanaStudiResourceComponent recordController,
      RencanaStudiServiceComponent recordService) {
    super(recordController);
    this.rencanaStudiService = new RencanaStudiServiceImpl(recordService);
  }

  @Restricted(permissionName = "ReadRencanaStudiMe")
  @Route(url = "call/rencanastudi/kelas")
  public HashMap<String, Object> getRencanaStudiClass(VMJExchange vmjExchange) {
    String email = vmjExchange.getAuthPayload().getEmail();
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(email);

    return rencanaStudiService.getRencanaStudiClass(mahasiswa.getId());
  }
}
