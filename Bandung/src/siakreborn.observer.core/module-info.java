module siakreborn.observer.core {
  exports siakreborn.observer;
  exports siakreborn.observer.core;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.observer.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
