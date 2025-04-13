module siakreborn.pembayaran.core {
  requires siakreborn.mahasiswa.core;
  requires siakreborn.semester.core;
  requires siakreborn.util.core;
  requires paymentgateway.payment.core;
  requires paymentgateway.payment.paymentlink;

  exports siakreborn.pembayaran;
  exports siakreborn.pembayaran.core;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.pembayaran.core to org.hibernate.orm.core, gson;
}
