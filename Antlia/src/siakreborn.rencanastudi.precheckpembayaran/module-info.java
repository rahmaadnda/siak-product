module siakreborn.rencanastudi.precheckpembayaran {
  requires siakreborn.rencanastudi.core;
  requires siakreborn.mahasiswa.core;
  requires siakreborn.semester.core;
  requires siakreborn.pembayaran.core;

  exports siakreborn.rencanastudi.precheckpembayaran;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.rencanastudi.precheckpembayaran to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
