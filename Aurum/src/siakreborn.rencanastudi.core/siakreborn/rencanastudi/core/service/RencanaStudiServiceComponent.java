package siakreborn.rencanastudi.core;

import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class RencanaStudiServiceComponent implements RencanaStudiService {
  protected RepositoryUtil<RencanaStudi> rencanaStudiRepository;
  protected RepositoryUtil<PengisianRencanaStudi> pengisianRencanaStudiRepository;

  public RencanaStudiServiceComponent() {
    this.rencanaStudiRepository = new RepositoryUtil<RencanaStudi>(
        siakreborn.rencanastudi.core.RencanaStudiComponent.class);
    this.pengisianRencanaStudiRepository = new RepositoryUtil<PengisianRencanaStudi>(
        siakreborn.rencanastudi.core.PengisianRencanaStudiComponent.class);
  }

  public abstract RencanaStudi saveRencanaStudi(HashMap<String, Object> body, Mahasiswa mahasiswa);

  public abstract RencanaStudi getRencanaStudi(UUID id);

  public abstract List<RencanaStudi> getRencanaStudiMahasiswa(UUID mahasiswaId);

  public abstract HashMap<String, Object> getActiveRencanaStudi(UUID mahasiswaId);

  public abstract PengisianRencanaStudi getActivePengisianRencanaStudi();

  public abstract int getTotalSKS(UUID mahasiswaId);

  public abstract PengisianRencanaStudi updateActivePengisianRencanaStudi(HashMap<String, Object> body);

  public abstract HashMap<String, Object> getRencanaStudiClass(UUID mahasiswaId);

  public abstract List<RencanaStudi> getAllRencanaStudi();

  public abstract List<RencanaStudi> deleteRencanaStudi(UUID id);

  public abstract List<HashMap<String, Object>> transformRencanaStudiListToHashMap(List<RencanaStudi> semesterList);
}
