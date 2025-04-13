package siakreborn.rencanastudi.core;

import java.util.*;

import siakreborn.mahasiswa.core.Mahasiswa;

public abstract class RencanaStudiServiceDecorator extends RencanaStudiServiceComponent {
  protected RencanaStudiServiceComponent record;

  public RencanaStudiServiceDecorator(RencanaStudiServiceComponent record) {
    this.record = record;
  }

  public RencanaStudi saveRencanaStudi(HashMap<String, Object> body, Mahasiswa mahasiswa) {
    return record.saveRencanaStudi(body, mahasiswa);
  }

  public RencanaStudi getRencanaStudi(UUID id) {
    return record.getRencanaStudi(id);
  }

  public HashMap<String, Object> getActiveRencanaStudi(UUID mahasiswaId) {
    return record.getActiveRencanaStudi(mahasiswaId);
  }

  public List<RencanaStudi> getRencanaStudiMahasiswa(UUID mahasiswaId) {
    return record.getRencanaStudiMahasiswa(mahasiswaId);
  }

  public PengisianRencanaStudi getActivePengisianRencanaStudi() {
    return record.getActivePengisianRencanaStudi();
  }

  public PengisianRencanaStudi updateActivePengisianRencanaStudi(HashMap<String, Object> body) {
    return record.updateActivePengisianRencanaStudi(body);
  }

  public int getTotalSKS(UUID mahasiswaId) {
    return record.getTotalSKS(mahasiswaId);
  }

  public HashMap<String, Object> getRencanaStudiClass(UUID mahasiswaId) {
    return record.getRencanaStudiClass(mahasiswaId);
  }

  public List<RencanaStudi> getAllRencanaStudi() {
    return record.getAllRencanaStudi();
  }

  public List<RencanaStudi> deleteRencanaStudi(UUID id) {
    return record.deleteRencanaStudi(id);
  }

  public List<HashMap<String, Object>> transformRencanaStudiListToHashMap(List<RencanaStudi> semesterList) {
    return record.transformRencanaStudiListToHashMap(semesterList);
  }
}
