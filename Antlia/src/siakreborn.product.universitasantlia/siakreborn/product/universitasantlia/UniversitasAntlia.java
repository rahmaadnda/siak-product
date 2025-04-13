package siakreborn.product.universitasantlia;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vmj.routing.route.VMJServer;
import vmj.routing.route.Router;
import vmj.hibernate.integrator.HibernateUtil;
import org.hibernate.cfg.Configuration;

import vmj.auth.model.UserResourceFactory;
import vmj.auth.model.RoleResourceFactory;
import vmj.auth.model.core.UserResource;
import vmj.auth.model.core.RoleResource;

import paymentgateway.payment.PaymentResourceFactory;
import paymentgateway.payment.core.PaymentResource;
import paymentgateway.payment.PaymentServiceFactory;
import paymentgateway.payment.core.PaymentService;
import siakreborn.programstudi.ProgramStudiResourceFactory;
import siakreborn.programstudi.core.ProgramStudiResource;
import siakreborn.programstudi.ProgramStudiServiceFactory;
import siakreborn.programstudi.core.ProgramStudiService;
import siakreborn.mahasiswa.MahasiswaResourceFactory;
import siakreborn.mahasiswa.core.MahasiswaResource;
import siakreborn.mahasiswa.MahasiswaServiceFactory;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.adminakademik.AdminAkademikResourceFactory;
import siakreborn.adminakademik.core.AdminAkademikResource;
import siakreborn.adminakademik.AdminAkademikServiceFactory;
import siakreborn.adminakademik.core.AdminAkademikService;
import siakreborn.observer.ObserverResourceFactory;
import siakreborn.observer.core.ObserverResource;
import siakreborn.observer.ObserverServiceFactory;
import siakreborn.observer.core.ObserverService;
import siakreborn.subscriptionplan.SubscriptionPlanResourceFactory;
import siakreborn.subscriptionplan.core.SubscriptionPlanResource;
import siakreborn.subscriptionplan.SubscriptionPlanServiceFactory;
import siakreborn.subscriptionplan.core.SubscriptionPlanService;
import siakreborn.subscription.SubscriptionResourceFactory;
import siakreborn.subscription.core.SubscriptionResource;
import siakreborn.subscription.SubscriptionServiceFactory;
import siakreborn.subscription.core.SubscriptionService;
import siakreborn.informasi.InformasiResourceFactory;
import siakreborn.informasi.core.InformasiResource;
import siakreborn.informasi.InformasiServiceFactory;
import siakreborn.informasi.core.InformasiService;
import siakreborn.dosen.DosenResourceFactory;
import siakreborn.dosen.core.DosenResource;
import siakreborn.dosen.DosenServiceFactory;
import siakreborn.dosen.core.DosenService;
import siakreborn.kurikulum.KurikulumResourceFactory;
import siakreborn.kurikulum.core.KurikulumResource;
import siakreborn.kurikulum.KurikulumServiceFactory;
import siakreborn.kurikulum.core.KurikulumService;
import siakreborn.semester.SemesterResourceFactory;
import siakreborn.semester.core.SemesterResource;
import siakreborn.semester.SemesterServiceFactory;
import siakreborn.semester.core.SemesterService;
import siakreborn.kurikulumsemester.KurikulumSemesterResourceFactory;
import siakreborn.kurikulumsemester.core.KurikulumSemesterResource;
import siakreborn.kurikulumsemester.KurikulumSemesterServiceFactory;
import siakreborn.kurikulumsemester.core.KurikulumSemesterService;
import siakreborn.matakuliah.MataKuliahResourceFactory;
import siakreborn.matakuliah.core.MataKuliahResource;
import siakreborn.matakuliah.MataKuliahServiceFactory;
import siakreborn.matakuliah.core.MataKuliahService;
import siakreborn.kelas.KelasResourceFactory;
import siakreborn.kelas.core.KelasResource;
import siakreborn.kelas.KelasServiceFactory;
import siakreborn.kelas.core.KelasService;
import siakreborn.kelasdosen.KelasDosenResourceFactory;
import siakreborn.kelasdosen.core.KelasDosenResource;
import siakreborn.kelasdosen.KelasDosenServiceFactory;
import siakreborn.kelasdosen.core.KelasDosenService;
import siakreborn.komponenpenilaian.KomponenPenilaianResourceFactory;
import siakreborn.komponenpenilaian.core.KomponenPenilaianResource;
import siakreborn.komponenpenilaian.KomponenPenilaianServiceFactory;
import siakreborn.komponenpenilaian.core.KomponenPenilaianService;
import siakreborn.penilaian.PenilaianResourceFactory;
import siakreborn.penilaian.core.PenilaianResource;
import siakreborn.penilaian.PenilaianServiceFactory;
import siakreborn.penilaian.core.PenilaianService;
import siakreborn.pembayaran.PembayaranResourceFactory;
import siakreborn.pembayaran.core.PembayaranResource;
import siakreborn.pembayaran.PembayaranServiceFactory;
import siakreborn.pembayaran.core.PembayaranService;
import siakreborn.capaian.CapaianResourceFactory;
import siakreborn.capaian.core.CapaianResource;
import siakreborn.capaian.CapaianServiceFactory;
import siakreborn.capaian.core.CapaianService;
import siakreborn.bobotkomponenpenilaian.BobotKomponenPenilaianResourceFactory;
import siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianResource;
import siakreborn.bobotkomponenpenilaian.BobotKomponenPenilaianServiceFactory;
import siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianService;
import siakreborn.rencanastudi.RencanaStudiResourceFactory;
import siakreborn.rencanastudi.core.RencanaStudiResource;
import siakreborn.rencanastudi.KelasMahasiswaServiceFactory;
import siakreborn.rencanastudi.core.KelasMahasiswaService;
import siakreborn.rencanastudi.RencanaStudiServiceFactory;
import siakreborn.rencanastudi.core.RencanaStudiService;
import siakreborn.matakuliahprasyarat.MataKuliahPrasyaratResourceFactory;
import siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratResource;
import siakreborn.matakuliahprasyarat.MataKuliahPrasyaratServiceFactory;
import siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratService;

public class UniversitasAntlia {

	public static void main(String[] args) {

		// get hostAddress and portnum from env var
        // ex:
        // AMANAH_HOST_BE --> "localhost"
        // AMANAH_PORT_BE --> 7776
		String hostAddress= getEnvVariableHostAddress("AMANAH_HOST_BE");
        int portNum = getEnvVariablePortNumber("AMANAH_PORT_BE");
        activateServer(hostAddress, portNum);

		Configuration configuration = new Configuration();
		// panggil setter setelah membuat object dari kelas Configuration
        // ex:
        // AMANAH_DB_URL --> jdbc:postgresql://localhost:5432/superorg
        // AMANAH_DB_USERNAME --> postgres
        // AMANAH_DB_PASSWORD --> postgres123
		setDBProperties("AMANAH_DB_URL", "url", configuration);
        setDBProperties("AMANAH_DB_USERNAME", "username", configuration);
        setDBProperties("AMANAH_DB_PASSWORD","password", configuration);

		configuration.addAnnotatedClass(vmj.auth.model.core.Role.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRole.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.User.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.passworded.UserImpl.class);

		configuration.addAnnotatedClass(paymentgateway.payment.core.Payment.class);
		configuration.addAnnotatedClass(paymentgateway.payment.core.PaymentComponent.class);
		configuration.addAnnotatedClass(paymentgateway.payment.core.PaymentDecorator.class);
		configuration.addAnnotatedClass(paymentgateway.payment.core.PaymentImpl.class);
		configuration.addAnnotatedClass(paymentgateway.payment.paymentlink.PaymentLinkImpl.class);
		configuration.addAnnotatedClass(siakreborn.programstudi.core.ProgramStudi.class);
		configuration.addAnnotatedClass(siakreborn.programstudi.core.ProgramStudiComponent.class);
		configuration.addAnnotatedClass(siakreborn.programstudi.core.ProgramStudiDecorator.class);
		configuration.addAnnotatedClass(siakreborn.programstudi.core.ProgramStudiImpl.class);
		configuration.addAnnotatedClass(siakreborn.mahasiswa.core.Mahasiswa.class);
		configuration.addAnnotatedClass(siakreborn.mahasiswa.core.MahasiswaComponent.class);
		configuration.addAnnotatedClass(siakreborn.mahasiswa.core.MahasiswaDecorator.class);
		configuration.addAnnotatedClass(siakreborn.mahasiswa.core.MahasiswaImpl.class);
		configuration.addAnnotatedClass(siakreborn.adminakademik.core.AdminAkademik.class);
		configuration.addAnnotatedClass(siakreborn.adminakademik.core.AdminAkademikComponent.class);
		configuration.addAnnotatedClass(siakreborn.adminakademik.core.AdminAkademikDecorator.class);
		configuration.addAnnotatedClass(siakreborn.adminakademik.core.AdminAkademikImpl.class);
		configuration.addAnnotatedClass(siakreborn.observer.core.Observer.class);
		configuration.addAnnotatedClass(siakreborn.observer.core.ObserverComponent.class);
		configuration.addAnnotatedClass(siakreborn.observer.core.ObserverDecorator.class);
		configuration.addAnnotatedClass(siakreborn.observer.core.ObserverImpl.class);
		configuration.addAnnotatedClass(siakreborn.observer.alumni.ObserverImpl.class);
		configuration.addAnnotatedClass(siakreborn.subscriptionplan.core.SubscriptionPlan.class);
		configuration.addAnnotatedClass(siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class);
		configuration.addAnnotatedClass(siakreborn.subscriptionplan.core.SubscriptionPlanDecorator.class);
		configuration.addAnnotatedClass(siakreborn.subscriptionplan.core.SubscriptionPlanImpl.class);
		configuration.addAnnotatedClass(siakreborn.subscription.core.Subscription.class);
		configuration.addAnnotatedClass(siakreborn.subscription.core.SubscriptionComponent.class);
		configuration.addAnnotatedClass(siakreborn.subscription.core.SubscriptionDecorator.class);
		configuration.addAnnotatedClass(siakreborn.subscription.core.SubscriptionImpl.class);
		configuration.addAnnotatedClass(siakreborn.observer.industri.ObserverImpl.class);
		configuration.addAnnotatedClass(siakreborn.informasi.core.Informasi.class);
		configuration.addAnnotatedClass(siakreborn.informasi.core.InformasiComponent.class);
		configuration.addAnnotatedClass(siakreborn.informasi.core.InformasiDecorator.class);
		configuration.addAnnotatedClass(siakreborn.informasi.core.InformasiImpl.class);
		configuration.addAnnotatedClass(siakreborn.informasi.akademik.InformasiImpl.class);
		configuration.addAnnotatedClass(siakreborn.informasi.alumni.InformasiImpl.class);
		configuration.addAnnotatedClass(siakreborn.informasi.industri.InformasiImpl.class);
		configuration.addAnnotatedClass(siakreborn.dosen.core.Dosen.class);
		configuration.addAnnotatedClass(siakreborn.dosen.core.DosenComponent.class);
		configuration.addAnnotatedClass(siakreborn.dosen.core.DosenDecorator.class);
		configuration.addAnnotatedClass(siakreborn.dosen.core.DosenImpl.class);
		configuration.addAnnotatedClass(siakreborn.kurikulum.core.Kurikulum.class);
		configuration.addAnnotatedClass(siakreborn.kurikulum.core.KurikulumComponent.class);
		configuration.addAnnotatedClass(siakreborn.kurikulum.core.KurikulumDecorator.class);
		configuration.addAnnotatedClass(siakreborn.kurikulum.core.KurikulumImpl.class);
		configuration.addAnnotatedClass(siakreborn.semester.core.Semester.class);
		configuration.addAnnotatedClass(siakreborn.semester.core.SemesterComponent.class);
		configuration.addAnnotatedClass(siakreborn.semester.core.SemesterDecorator.class);
		configuration.addAnnotatedClass(siakreborn.semester.core.SemesterImpl.class);
		configuration.addAnnotatedClass(siakreborn.kurikulumsemester.core.KurikulumSemester.class);
		configuration.addAnnotatedClass(siakreborn.kurikulumsemester.core.KurikulumSemesterComponent.class);
		configuration.addAnnotatedClass(siakreborn.kurikulumsemester.core.KurikulumSemesterDecorator.class);
		configuration.addAnnotatedClass(siakreborn.kurikulumsemester.core.KurikulumSemesterImpl.class);
		configuration.addAnnotatedClass(siakreborn.matakuliah.core.MataKuliah.class);
		configuration.addAnnotatedClass(siakreborn.matakuliah.core.MataKuliahComponent.class);
		configuration.addAnnotatedClass(siakreborn.matakuliah.core.MataKuliahDecorator.class);
		configuration.addAnnotatedClass(siakreborn.matakuliah.core.MataKuliahImpl.class);
		configuration.addAnnotatedClass(siakreborn.kelas.core.Kelas.class);
		configuration.addAnnotatedClass(siakreborn.kelas.core.KelasComponent.class);
		configuration.addAnnotatedClass(siakreborn.kelas.core.KelasDecorator.class);
		configuration.addAnnotatedClass(siakreborn.kelas.core.KelasImpl.class);
		configuration.addAnnotatedClass(siakreborn.kelasdosen.core.KelasDosen.class);
		configuration.addAnnotatedClass(siakreborn.kelasdosen.core.KelasDosenComponent.class);
		configuration.addAnnotatedClass(siakreborn.kelasdosen.core.KelasDosenDecorator.class);
		configuration.addAnnotatedClass(siakreborn.kelasdosen.core.KelasDosenImpl.class);
		configuration.addAnnotatedClass(siakreborn.komponenpenilaian.core.KomponenPenilaian.class);
		configuration.addAnnotatedClass(siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class);
		configuration.addAnnotatedClass(siakreborn.komponenpenilaian.core.KomponenPenilaianDecorator.class);
		configuration.addAnnotatedClass(siakreborn.komponenpenilaian.core.KomponenPenilaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.penilaian.core.Penilaian.class);
		configuration.addAnnotatedClass(siakreborn.penilaian.core.PenilaianComponent.class);
		configuration.addAnnotatedClass(siakreborn.penilaian.core.PenilaianDecorator.class);
		configuration.addAnnotatedClass(siakreborn.penilaian.core.PenilaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.pembayaran.core.Pembayaran.class);
		configuration.addAnnotatedClass(siakreborn.pembayaran.core.PembayaranComponent.class);
		configuration.addAnnotatedClass(siakreborn.pembayaran.core.PembayaranDecorator.class);
		configuration.addAnnotatedClass(siakreborn.pembayaran.core.PembayaranImpl.class);
		configuration.addAnnotatedClass(siakreborn.penilaian.penilaianobe.PenilaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.capaian.core.Capaian.class);
		configuration.addAnnotatedClass(siakreborn.capaian.core.CapaianComponent.class);
		configuration.addAnnotatedClass(siakreborn.capaian.core.CapaianDecorator.class);
		configuration.addAnnotatedClass(siakreborn.capaian.core.CapaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaian.class);
		configuration.addAnnotatedClass(siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianComponent.class);
		configuration.addAnnotatedClass(siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianDecorator.class);
		configuration.addAnnotatedClass(siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.capaian.cpl.CapaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.capaian.cpmk.CapaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.capaian.subcpmk.CapaianImpl.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.KelasMahasiswa.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.KelasMahasiswaComponent.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.KelasMahasiswaDecorator.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.KelasMahasiswaImpl.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.PengisianRencanaStudi.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.PengisianRencanaStudiComponent.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.PengisianRencanaStudiDecorator.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.PengisianRencanaStudiImpl.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.RencanaStudi.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.RencanaStudiComponent.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.RencanaStudiDecorator.class);
		configuration.addAnnotatedClass(siakreborn.rencanastudi.core.RencanaStudiImpl.class);
		configuration.addAnnotatedClass(siakreborn.matakuliahprasyarat.core.MataKuliahPrasyarat.class);
		configuration.addAnnotatedClass(siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratComponent.class);
		configuration.addAnnotatedClass(siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratDecorator.class);
		configuration.addAnnotatedClass(siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratImpl.class);

		Map<String, Object> featureModelMappings = mappingFeatureModel();
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Map<String, String[]>>>(){}.getType();
        String convertedFeatureModelMappings = gson.toJson(featureModelMappings, type);
		
        configuration.setProperty("feature.model.mappings", convertedFeatureModelMappings);
		configuration.buildMappings();
		HibernateUtil.buildSessionFactory(configuration);

		createObjectsAndBindEndPoints();
	}

	public static void activateServer(String hostName, int portNumber) {
		VMJServer vmjServer = VMJServer.getInstance(hostName, portNumber);
		try {
			vmjServer.startServerGeneric();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createObjectsAndBindEndPoints() {
		System.out.println("== CREATING OBJECTS AND BINDING ENDPOINTS ==");
		UserResource userResource = UserResourceFactory
            .createUserResource("vmj.auth.model.core.UserResourceImpl"
			);

		RoleResource roleResource = RoleResourceFactory
        	.createRoleResource("vmj.auth.model.core.RoleResourceImpl"
			);
        
        UserResource userPasswordedResource = UserResourceFactory
	        .createUserResource("vmj.auth.model.passworded.UserResourceImpl"
			,
		    UserResourceFactory.createUserResource("vmj.auth.model.core.UserResourceImpl"));

        ProgramStudiService programstudiProgramStudiService = ProgramStudiServiceFactory
            .createProgramStudiService("siakreborn.programstudi.core.ProgramStudiServiceImpl"
            	);		

        ProgramStudiResource programstudiProgramStudiResource = ProgramStudiResourceFactory
            .createProgramStudiResource("siakreborn.programstudi.core.ProgramStudiResourceImpl"
                );
			
        MahasiswaService mahasiswaMahasiswaService = MahasiswaServiceFactory
            .createMahasiswaService("siakreborn.mahasiswa.core.MahasiswaServiceImpl"
            	);		

        MahasiswaResource mahasiswaMahasiswaResource = MahasiswaResourceFactory
            .createMahasiswaResource("siakreborn.mahasiswa.core.MahasiswaResourceImpl"
                );
			
        AdminAkademikService adminakademikAdminAkademikService = AdminAkademikServiceFactory
            .createAdminAkademikService("siakreborn.adminakademik.core.AdminAkademikServiceImpl"
            	);		

        AdminAkademikResource adminakademikAdminAkademikResource = AdminAkademikResourceFactory
            .createAdminAkademikResource("siakreborn.adminakademik.core.AdminAkademikResourceImpl"
                );
			
        ObserverService observerObserverService = ObserverServiceFactory
            .createObserverService("siakreborn.observer.core.ObserverServiceImpl"
            	);		

        ObserverResource observerObserverResource = ObserverResourceFactory
            .createObserverResource("siakreborn.observer.core.ObserverResourceImpl"
                );
			
        ObserverService alumniObserverService = ObserverServiceFactory
            .createObserverService("siakreborn.observer.alumni.ObserverServiceImpl"
            	, observerObserverService);		

        ObserverResource alumniObserverResource = ObserverResourceFactory
            .createObserverResource("siakreborn.observer.alumni.ObserverResourceImpl"
                , observerObserverResource, observerObserverService);
			
        MahasiswaService mappingalumniMahasiswaService = MahasiswaServiceFactory
            .createMahasiswaService("siakreborn.mahasiswa.mappingalumni.MahasiswaServiceImpl"
            	, mahasiswaMahasiswaService);		

        MahasiswaResource mappingalumniMahasiswaResource = MahasiswaResourceFactory
            .createMahasiswaResource("siakreborn.mahasiswa.mappingalumni.MahasiswaResourceImpl"
                , mahasiswaMahasiswaResource, mahasiswaMahasiswaService);
			
        SubscriptionPlanService subscriptionplanSubscriptionPlanService = SubscriptionPlanServiceFactory
            .createSubscriptionPlanService("siakreborn.subscriptionplan.core.SubscriptionPlanServiceImpl"
            	);		

        SubscriptionPlanResource subscriptionplanSubscriptionPlanResource = SubscriptionPlanResourceFactory
            .createSubscriptionPlanResource("siakreborn.subscriptionplan.core.SubscriptionPlanResourceImpl"
                );
			
        SubscriptionService subscriptionSubscriptionService = SubscriptionServiceFactory
            .createSubscriptionService("siakreborn.subscription.core.SubscriptionServiceImpl"
            	);		

        SubscriptionResource subscriptionSubscriptionResource = SubscriptionResourceFactory
            .createSubscriptionResource("siakreborn.subscription.core.SubscriptionResourceImpl"
                );
			
        ObserverService industriObserverService = ObserverServiceFactory
            .createObserverService("siakreborn.observer.industri.ObserverServiceImpl"
            	, observerObserverService);		

        ObserverResource industriObserverResource = ObserverResourceFactory
            .createObserverResource("siakreborn.observer.industri.ObserverResourceImpl"
                , observerObserverResource, observerObserverService);
			
        InformasiService informasiInformasiService = InformasiServiceFactory
            .createInformasiService("siakreborn.informasi.core.InformasiServiceImpl"
            	);		

        InformasiResource informasiInformasiResource = InformasiResourceFactory
            .createInformasiResource("siakreborn.informasi.core.InformasiResourceImpl"
                );
			
        InformasiService akademikInformasiService = InformasiServiceFactory
            .createInformasiService("siakreborn.informasi.akademik.InformasiServiceImpl"
            	, informasiInformasiService);		

        InformasiResource akademikInformasiResource = InformasiResourceFactory
            .createInformasiResource("siakreborn.informasi.akademik.InformasiResourceImpl"
                , informasiInformasiResource, informasiInformasiService);
			
        InformasiService alumniInformasiService = InformasiServiceFactory
            .createInformasiService("siakreborn.informasi.alumni.InformasiServiceImpl"
            	, informasiInformasiService);		

        InformasiResource alumniInformasiResource = InformasiResourceFactory
            .createInformasiResource("siakreborn.informasi.alumni.InformasiResourceImpl"
                , informasiInformasiResource, informasiInformasiService);
			
        InformasiService industriInformasiService = InformasiServiceFactory
            .createInformasiService("siakreborn.informasi.industri.InformasiServiceImpl"
            	, informasiInformasiService);		

        InformasiResource industriInformasiResource = InformasiResourceFactory
            .createInformasiResource("siakreborn.informasi.industri.InformasiResourceImpl"
                , informasiInformasiResource, informasiInformasiService);
			
        DosenService dosenDosenService = DosenServiceFactory
            .createDosenService("siakreborn.dosen.core.DosenServiceImpl"
            	);		

        DosenResource dosenDosenResource = DosenResourceFactory
            .createDosenResource("siakreborn.dosen.core.DosenResourceImpl"
                );
			
        KurikulumService kurikulumKurikulumService = KurikulumServiceFactory
            .createKurikulumService("siakreborn.kurikulum.core.KurikulumServiceImpl"
            	);		

        KurikulumResource kurikulumKurikulumResource = KurikulumResourceFactory
            .createKurikulumResource("siakreborn.kurikulum.core.KurikulumResourceImpl"
                );
			
        SemesterService semesterSemesterService = SemesterServiceFactory
            .createSemesterService("siakreborn.semester.core.SemesterServiceImpl"
            	);		

        SemesterResource semesterSemesterResource = SemesterResourceFactory
            .createSemesterResource("siakreborn.semester.core.SemesterResourceImpl"
                );
			
        KurikulumSemesterService kurikulumsemesterKurikulumSemesterService = KurikulumSemesterServiceFactory
            .createKurikulumSemesterService("siakreborn.kurikulumsemester.core.KurikulumSemesterServiceImpl"
            	);		

        KurikulumSemesterResource kurikulumsemesterKurikulumSemesterResource = KurikulumSemesterResourceFactory
            .createKurikulumSemesterResource("siakreborn.kurikulumsemester.core.KurikulumSemesterResourceImpl"
                );
			
        MataKuliahService matakuliahMataKuliahService = MataKuliahServiceFactory
            .createMataKuliahService("siakreborn.matakuliah.core.MataKuliahServiceImpl"
            	);		

        MataKuliahResource matakuliahMataKuliahResource = MataKuliahResourceFactory
            .createMataKuliahResource("siakreborn.matakuliah.core.MataKuliahResourceImpl"
                );
			
        KelasService kelasKelasService = KelasServiceFactory
            .createKelasService("siakreborn.kelas.core.KelasServiceImpl"
            	);		

        KelasResource kelasKelasResource = KelasResourceFactory
            .createKelasResource("siakreborn.kelas.core.KelasResourceImpl"
                );
			
        KelasDosenService kelasdosenKelasDosenService = KelasDosenServiceFactory
            .createKelasDosenService("siakreborn.kelasdosen.core.KelasDosenServiceImpl"
            	);		

        KelasDosenResource kelasdosenKelasDosenResource = KelasDosenResourceFactory
            .createKelasDosenResource("siakreborn.kelasdosen.core.KelasDosenResourceImpl"
                );
			
        KomponenPenilaianService komponenpenilaianKomponenPenilaianService = KomponenPenilaianServiceFactory
            .createKomponenPenilaianService("siakreborn.komponenpenilaian.core.KomponenPenilaianServiceImpl"
            	);		

        KomponenPenilaianResource komponenpenilaianKomponenPenilaianResource = KomponenPenilaianResourceFactory
            .createKomponenPenilaianResource("siakreborn.komponenpenilaian.core.KomponenPenilaianResourceImpl"
                );
			
        PenilaianService penilaianPenilaianService = PenilaianServiceFactory
            .createPenilaianService("siakreborn.penilaian.core.PenilaianServiceImpl"
            	);		

        PenilaianResource penilaianPenilaianResource = PenilaianResourceFactory
            .createPenilaianResource("siakreborn.penilaian.core.PenilaianResourceImpl"
                );
			
        PembayaranService pembayaranPembayaranService = PembayaranServiceFactory
            .createPembayaranService("siakreborn.pembayaran.core.PembayaranServiceImpl"
            	);		

        PembayaranResource pembayaranPembayaranResource = PembayaranResourceFactory
            .createPembayaranResource("siakreborn.pembayaran.core.PembayaranResourceImpl"
                );
			
        PenilaianService penilaianobePenilaianService = PenilaianServiceFactory
            .createPenilaianService("siakreborn.penilaian.penilaianobe.PenilaianServiceImpl"
            	, penilaianPenilaianService);		

        PenilaianResource penilaianobePenilaianResource = PenilaianResourceFactory
            .createPenilaianResource("siakreborn.penilaian.penilaianobe.PenilaianResourceImpl"
                , penilaianPenilaianResource, penilaianPenilaianService);
			
        CapaianService capaianCapaianService = CapaianServiceFactory
            .createCapaianService("siakreborn.capaian.core.CapaianServiceImpl"
            	);		

        CapaianResource capaianCapaianResource = CapaianResourceFactory
            .createCapaianResource("siakreborn.capaian.core.CapaianResourceImpl"
                );
			
        BobotKomponenPenilaianService bobotkomponenpenilaianBobotKomponenPenilaianService = BobotKomponenPenilaianServiceFactory
            .createBobotKomponenPenilaianService("siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianServiceImpl"
            	);		

        BobotKomponenPenilaianResource bobotkomponenpenilaianBobotKomponenPenilaianResource = BobotKomponenPenilaianResourceFactory
            .createBobotKomponenPenilaianResource("siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianResourceImpl"
                );
			
        CapaianService cplCapaianService = CapaianServiceFactory
            .createCapaianService("siakreborn.capaian.cpl.CapaianServiceImpl"
            	, capaianCapaianService);		

        CapaianResource cplCapaianResource = CapaianResourceFactory
            .createCapaianResource("siakreborn.capaian.cpl.CapaianResourceImpl"
                , capaianCapaianResource, capaianCapaianService);
			
        CapaianService cpmkCapaianService = CapaianServiceFactory
            .createCapaianService("siakreborn.capaian.cpmk.CapaianServiceImpl"
            	, capaianCapaianService);		

        CapaianResource cpmkCapaianResource = CapaianResourceFactory
            .createCapaianResource("siakreborn.capaian.cpmk.CapaianResourceImpl"
                , capaianCapaianResource, capaianCapaianService);
			
        CapaianService subcpmkCapaianService = CapaianServiceFactory
            .createCapaianService("siakreborn.capaian.subcpmk.CapaianServiceImpl"
            	, capaianCapaianService);		

        CapaianResource subcpmkCapaianResource = CapaianResourceFactory
            .createCapaianResource("siakreborn.capaian.subcpmk.CapaianResourceImpl"
                , capaianCapaianResource, capaianCapaianService);
			
        RencanaStudiService rencanastudiRencanaStudiService = RencanaStudiServiceFactory
        .createRencanaStudiService("siakreborn.rencanastudi.core.RencanaStudiServiceImpl");

	    RencanaStudiResource rencanastudiRencanaStudiResource = RencanaStudiResourceFactory
	        .createRencanaStudiResource("siakreborn.rencanastudi.core.RencanaStudiResourceImpl");
	
	    RencanaStudiService precheckpembayaranRencanaStudiService = RencanaStudiServiceFactory
	        .createRencanaStudiService("siakreborn.rencanastudi.precheckpembayaran.RencanaStudiServiceImpl",
	            rencanastudiRencanaStudiService);
	
	    RencanaStudiResource precheckpembayaranRencanaStudiResource = RencanaStudiResourceFactory
	        .createRencanaStudiResource("siakreborn.rencanastudi.precheckpembayaran.RencanaStudiResourceImpl",
	            rencanastudiRencanaStudiResource, rencanastudiRencanaStudiService);

        MataKuliahPrasyaratService matakuliahprasyaratMataKuliahPrasyaratService = MataKuliahPrasyaratServiceFactory
            .createMataKuliahPrasyaratService("siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratServiceImpl"
            	);		

        MataKuliahPrasyaratResource matakuliahprasyaratMataKuliahPrasyaratResource = MataKuliahPrasyaratResourceFactory
            .createMataKuliahPrasyaratResource("siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratResourceImpl"
                );
		
		System.out.println("precheckpembayaranRencanaStudiResource endpoints binding");
		Router.route(precheckpembayaranRencanaStudiResource);
		
		System.out.println("rencanastudiRencanaStudiResource endpoints binding");
		Router.route(rencanastudiRencanaStudiResource);

		System.out.println("matakuliahprasyaratMataKuliahPrasyaratResource endpoints binding");
		Router.route(matakuliahprasyaratMataKuliahPrasyaratResource);
		
		System.out.println("matakuliahprasyaratMataKuliahPrasyaratService endpoints binding");
		Router.route(matakuliahprasyaratMataKuliahPrasyaratService);
		
		System.out.println("subcpmkCapaianResource endpoints binding");
		Router.route(subcpmkCapaianResource);
		
		System.out.println("subcpmkCapaianService endpoints binding");
		Router.route(subcpmkCapaianService);
		
		System.out.println("cpmkCapaianResource endpoints binding");
		Router.route(cpmkCapaianResource);
		
		System.out.println("cpmkCapaianService endpoints binding");
		Router.route(cpmkCapaianService);
		
		System.out.println("cplCapaianResource endpoints binding");
		Router.route(cplCapaianResource);
		
		System.out.println("cplCapaianService endpoints binding");
		Router.route(cplCapaianService);
		
		System.out.println("bobotkomponenpenilaianBobotKomponenPenilaianResource endpoints binding");
		Router.route(bobotkomponenpenilaianBobotKomponenPenilaianResource);
		
		System.out.println("bobotkomponenpenilaianBobotKomponenPenilaianService endpoints binding");
		Router.route(bobotkomponenpenilaianBobotKomponenPenilaianService);
		
		System.out.println("capaianCapaianResource endpoints binding");
		Router.route(capaianCapaianResource);
		
		System.out.println("capaianCapaianService endpoints binding");
		Router.route(capaianCapaianService);
		
		System.out.println("penilaianobePenilaianResource endpoints binding");
		Router.route(penilaianobePenilaianResource);
		
		System.out.println("penilaianobePenilaianService endpoints binding");
		Router.route(penilaianobePenilaianService);
		
		System.out.println("pembayaranPembayaranResource endpoints binding");
		Router.route(pembayaranPembayaranResource);
		
		System.out.println("pembayaranPembayaranService endpoints binding");
		Router.route(pembayaranPembayaranService);
		
		System.out.println("penilaianPenilaianResource endpoints binding");
		Router.route(penilaianPenilaianResource);
		
		System.out.println("penilaianPenilaianService endpoints binding");
		Router.route(penilaianPenilaianService);
		
		System.out.println("komponenpenilaianKomponenPenilaianResource endpoints binding");
		Router.route(komponenpenilaianKomponenPenilaianResource);
		
		System.out.println("komponenpenilaianKomponenPenilaianService endpoints binding");
		Router.route(komponenpenilaianKomponenPenilaianService);
		
		System.out.println("kelasdosenKelasDosenResource endpoints binding");
		Router.route(kelasdosenKelasDosenResource);
		
		System.out.println("kelasdosenKelasDosenService endpoints binding");
		Router.route(kelasdosenKelasDosenService);
		
		System.out.println("kelasKelasResource endpoints binding");
		Router.route(kelasKelasResource);
		
		System.out.println("kelasKelasService endpoints binding");
		Router.route(kelasKelasService);
		
		System.out.println("matakuliahMataKuliahResource endpoints binding");
		Router.route(matakuliahMataKuliahResource);
		
		System.out.println("matakuliahMataKuliahService endpoints binding");
		Router.route(matakuliahMataKuliahService);
		
		System.out.println("kurikulumsemesterKurikulumSemesterResource endpoints binding");
		Router.route(kurikulumsemesterKurikulumSemesterResource);
		
		System.out.println("kurikulumsemesterKurikulumSemesterService endpoints binding");
		Router.route(kurikulumsemesterKurikulumSemesterService);
		
		System.out.println("semesterSemesterResource endpoints binding");
		Router.route(semesterSemesterResource);
		
		System.out.println("semesterSemesterService endpoints binding");
		Router.route(semesterSemesterService);
		
		System.out.println("kurikulumKurikulumResource endpoints binding");
		Router.route(kurikulumKurikulumResource);
		
		System.out.println("kurikulumKurikulumService endpoints binding");
		Router.route(kurikulumKurikulumService);
		
		System.out.println("dosenDosenResource endpoints binding");
		Router.route(dosenDosenResource);
		
		System.out.println("dosenDosenService endpoints binding");
		Router.route(dosenDosenService);
		
		System.out.println("industriInformasiResource endpoints binding");
		Router.route(industriInformasiResource);
		
		System.out.println("industriInformasiService endpoints binding");
		Router.route(industriInformasiService);
		
		System.out.println("alumniInformasiResource endpoints binding");
		Router.route(alumniInformasiResource);
		
		System.out.println("alumniInformasiService endpoints binding");
		Router.route(alumniInformasiService);
		
		System.out.println("akademikInformasiResource endpoints binding");
		Router.route(akademikInformasiResource);
		
		System.out.println("akademikInformasiService endpoints binding");
		Router.route(akademikInformasiService);
		
		System.out.println("informasiInformasiResource endpoints binding");
		Router.route(informasiInformasiResource);
		
		System.out.println("informasiInformasiService endpoints binding");
		Router.route(informasiInformasiService);
		
		System.out.println("industriObserverResource endpoints binding");
		Router.route(industriObserverResource);
		
		System.out.println("industriObserverService endpoints binding");
		Router.route(industriObserverService);
		
		System.out.println("subscriptionSubscriptionResource endpoints binding");
		Router.route(subscriptionSubscriptionResource);
		
		System.out.println("subscriptionSubscriptionService endpoints binding");
		Router.route(subscriptionSubscriptionService);
		
		System.out.println("subscriptionplanSubscriptionPlanResource endpoints binding");
		Router.route(subscriptionplanSubscriptionPlanResource);
		
		System.out.println("subscriptionplanSubscriptionPlanService endpoints binding");
		Router.route(subscriptionplanSubscriptionPlanService);
		
		System.out.println("mappingalumniMahasiswaResource endpoints binding");
		Router.route(mappingalumniMahasiswaResource);
		
		System.out.println("mappingalumniMahasiswaService endpoints binding");
		Router.route(mappingalumniMahasiswaService);
		
		System.out.println("alumniObserverResource endpoints binding");
		Router.route(alumniObserverResource);
		
		System.out.println("alumniObserverService endpoints binding");
		Router.route(alumniObserverService);
		
		System.out.println("observerObserverResource endpoints binding");
		Router.route(observerObserverResource);
		
		System.out.println("observerObserverService endpoints binding");
		Router.route(observerObserverService);
		
		System.out.println("adminakademikAdminAkademikResource endpoints binding");
		Router.route(adminakademikAdminAkademikResource);
		
		System.out.println("adminakademikAdminAkademikService endpoints binding");
		Router.route(adminakademikAdminAkademikService);
		
		System.out.println("mahasiswaMahasiswaResource endpoints binding");
		Router.route(mahasiswaMahasiswaResource);
		
		System.out.println("mahasiswaMahasiswaService endpoints binding");
		Router.route(mahasiswaMahasiswaService);
		
		System.out.println("programstudiProgramStudiResource endpoints binding");
		Router.route(programstudiProgramStudiResource);
		
		System.out.println("programstudiProgramStudiService endpoints binding");
		Router.route(programstudiProgramStudiService);
		
		System.out.println("authResource endpoints binding");
		Router.route(userPasswordedResource);
		Router.route(roleResource);
		Router.route(userResource);
	}

	private static Map<String, Object> mappingFeatureModel() {
		Map<String, Object> featureModelMappings = new HashMap<>();

		featureModelMappings.put(
            paymentgateway.payment.core.PaymentComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					paymentgateway.payment.core.PaymentComponent.class.getName()
				});
				put("deltas", new String[] {
					paymentgateway.payment.paymentlink.PaymentLinkImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.programstudi.core.ProgramStudiComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.programstudi.core.ProgramStudiComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.mahasiswa.core.MahasiswaComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.mahasiswa.core.MahasiswaComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.adminakademik.core.AdminAkademikComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.adminakademik.core.AdminAkademikComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.observer.core.ObserverComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.observer.core.ObserverComponent.class.getName()
				});
				put("deltas", new String[] {
					siakreborn.observer.alumni.ObserverImpl.class.getName(),
					siakreborn.observer.industri.ObserverImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.subscription.core.SubscriptionComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.subscription.core.SubscriptionComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.informasi.core.InformasiComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.informasi.core.InformasiComponent.class.getName()
				});
				put("deltas", new String[] {
					siakreborn.informasi.akademik.InformasiImpl.class.getName(),
					siakreborn.informasi.alumni.InformasiImpl.class.getName(),
					siakreborn.informasi.industri.InformasiImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.dosen.core.DosenComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.dosen.core.DosenComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.kurikulum.core.KurikulumComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.kurikulum.core.KurikulumComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.semester.core.SemesterComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.semester.core.SemesterComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.kurikulumsemester.core.KurikulumSemesterComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.kurikulumsemester.core.KurikulumSemesterComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.matakuliah.core.MataKuliahComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.matakuliah.core.MataKuliahComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.kelas.core.KelasComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.kelas.core.KelasComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.kelasdosen.core.KelasDosenComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.kelasdosen.core.KelasDosenComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.penilaian.core.PenilaianComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.penilaian.core.PenilaianComponent.class.getName()
				});
				put("deltas", new String[] {
					siakreborn.penilaian.penilaianobe.PenilaianImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.pembayaran.core.PembayaranComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.pembayaran.core.PembayaranComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.capaian.core.CapaianComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.capaian.core.CapaianComponent.class.getName()
				});
				put("deltas", new String[] {
					siakreborn.capaian.cpl.CapaianImpl.class.getName(),
					siakreborn.capaian.cpmk.CapaianImpl.class.getName(),
					siakreborn.capaian.subcpmk.CapaianImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.rencanastudi.core.RencanaStudiComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.rencanastudi.core.KelasMahasiswaComponent.class.getName(),
					siakreborn.rencanastudi.core.PengisianRencanaStudiComponent.class.getName(),
					siakreborn.rencanastudi.core.RencanaStudiComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		return featureModelMappings;
	}

	public static void setDBProperties(String varname, String typeProp, Configuration configuration) {
		String varNameValue = System.getenv(varname);
		String propertyName = String.format("hibernate.connection.%s",typeProp);
		if (varNameValue != null) {
			configuration.setProperty(propertyName, varNameValue);
		} else {
			String hibernatePropertyVal = configuration.getProperty(propertyName);
			if (hibernatePropertyVal == null) {
				String error_message = String.format("Please check '%s' in your local environment variable or "
                	+ "'hibernate.connection.%s' in your 'hibernate.properties' file!", varname, typeProp);
            	System.out.println(error_message);
			}
		}
	}

	// if the env variable for server host is null, use localhost instead.
    public static String getEnvVariableHostAddress(String varname_host){
            String hostAddress = System.getenv(varname_host)  != null ? System.getenv(varname_host) : "localhost"; // Host
            return hostAddress;
    }

    // try if the environment variable for port number is null, use 7776 instead
    public static int getEnvVariablePortNumber(String varname_port){
            String portNum = System.getenv(varname_port)  != null? System.getenv(varname_port)  : "7776"; //PORT
            int portNumInt = Integer.parseInt(portNum);
            return portNumInt;
    }

}