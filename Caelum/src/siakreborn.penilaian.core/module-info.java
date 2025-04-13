module siakreborn.penilaian.core {
  requires siakreborn.util.core;
  requires siakreborn.komponenpenilaian.core;
  requires siakreborn.mahasiswa.core;
  requires siakreborn.kelas.core;
  requires siakreborn.matakuliah.core;

  exports siakreborn.penilaian;
  exports siakreborn.penilaian.core;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.penilaian.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
