module siakreborn.observer.industri {
  requires siakreborn.observer.core;
  requires siakreborn.subscription.core;
  requires siakreborn.subscriptionplan.core;
  requires siakreborn.util.core;
  
  exports siakreborn.observer.industri;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires vmj.auth.model;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.observer.industri to org.hibernate.orm.core, gson;
}
