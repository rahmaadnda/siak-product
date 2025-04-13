module siakreborn.mahasiswa.core {
  exports siakreborn.mahasiswa;
  exports siakreborn.mahasiswa.core;

  requires siakreborn.util.core;
  requires siakreborn.programstudi.core;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.mahasiswa.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
