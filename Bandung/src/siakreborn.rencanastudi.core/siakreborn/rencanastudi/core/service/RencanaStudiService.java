package siakreborn.rencanastudi.core;

import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;

public interface RencanaStudiService {
  RencanaStudi saveRencanaStudi(HashMap<String, Object> body, Mahasiswa mahasiswa);

  RencanaStudi getRencanaStudi(UUID id);

  HashMap<String, Object> getActiveRencanaStudi(UUID mahasiswaId);

  List<RencanaStudi> getRencanaStudiMahasiswa(UUID mahasiswaId);

  int getTotalSKS(UUID mahasiswaId);

  PengisianRencanaStudi getActivePengisianRencanaStudi();

  PengisianRencanaStudi updateActivePengisianRencanaStudi(HashMap<String, Object> body);

  HashMap<String, Object> getRencanaStudiClass(UUID mahasiswaId);

  List<RencanaStudi> getAllRencanaStudi();

  List<RencanaStudi> deleteRencanaStudi(UUID id);

  List<HashMap<String, Object>> transformRencanaStudiListToHashMap(List<RencanaStudi> RencanaStudiList);
}
