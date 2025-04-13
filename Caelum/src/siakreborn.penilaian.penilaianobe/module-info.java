module siakreborn.penilaian.penilaianobe {
  requires siakreborn.penilaian.core;
  requires siakreborn.komponenpenilaian.core;
  requires siakreborn.mahasiswa.core;
  requires siakreborn.kelas.core;
  requires siakreborn.bobotkomponenpenilaian.core;
  requires siakreborn.matakuliah.core;
  requires siakreborn.capaian.core;
  requires siakreborn.capaian.cpmk;
  requires siakreborn.capaian.cpl;
  requires siakreborn.util.core;
  requires siakreborn.rencanastudi.core;

  exports siakreborn.penilaian.penilaianobe;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.penilaian.penilaianobe to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
