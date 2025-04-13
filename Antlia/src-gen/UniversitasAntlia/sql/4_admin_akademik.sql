-- Authentication

INSERT INTO auth_role_comp (id) VALUES ('12672338-2822-420d-8c06-cff0d411d776') ON CONFLICT DO NOTHING;
INSERT INTO auth_role_impl (id,name,allowedPermissions) VALUES ('12672338-2822-420d-8c06-cff0d411d776','AdminAkademik','home,ReadDetailAlumni,ReadInformasiAlumni,VerifyMahasiswa,VerifyAlumni,ReadMahasiswaPublic,ReadAlumniPublic,ReadDetailMahasiswa,ReadAlumni,ReadMahasiswa,GraduateMahasiswa,ReadInformasiIndustri,ReadInformasiAkademik,SaveInformasiAkademik,ReadIndustri,DetailIndustri,ListIndustri,UpdateSubscriptionPlan,CreateSubscriptionPlan,SubscriptionApproveIndustri,CreateBobotKomponenPenilaian,UpdateBobotKomponenPenilaian,ReadBobotKomponenPenilaian,DeleteBobotKomponenPenilaian,CreateCapaian,UpdateCapaian,ReadCapaian,DeleteCapaian,SaveCPL,UpdateCPL,ReadCPL,DeleteCPL,SaveCPMK,UpdateCPMK,ReadCPMK,DeleteCPMK,SaveSubCPMK,UpdateSubCPMK,ReadSubCPMK,DeleteSubCPMK,CreateKelas,UpdateKelas,ReadKelas,DeleteKelas,CreateKelasDosen,UpdateKelasDosen,ReadKelasDosen,DeleteKelasDosen,CreateKomponenPenilaian,UpdateKomponenPenilaian,ReadKomponenPenilaian,DeleteKomponenPenilaian,CreateKurikulum,UpdateKurikulum,ReadKurikulum,DeleteKurikulum,CreateKurikulumSemester,UpdateKurikulumSemester,ReadKurikulumSemester,DeleteKurikulumSemester,CreateSemester,UpdateSemester,ReadSemester,DeleteSemester,CreateMataKuliah,UpdateMataKuliah,ReadMataKuliah,DeleteMataKuliah,ReadLaporanCPMK,ReadLaporanCPL,CreateProgramStudi,UpdateProgramStudi,ReadProgramStudi,DeleteProgramStudi,ReadPengisianRencanaStudi,UpdatePengisianRencanaStudi,SaveMataKuliahPrasyarat,UpdateMataKuliahPrasyarat,ReadMataKuliahPrasyarat,DeleteMataKuliahPrasyarat') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_comp (id) VALUES ('40a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('40a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Admin Akademik','admin@akademik.com') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('40a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','40a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_comp (id) VALUES ('448d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('448d7175-1028-4d11-8074-17ecb4536709','12672338-2822-420d-8c06-cff0d411d776','40a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;


-- Data

INSERT INTO adminakademik_comp (id, email, nama, objectname, modulesequence) VALUES
('143454fe-2bd1-4476-b613-44287e57059c', 'admin@akademik.com', 'Admin Akademik', 'siakreborn.adminakademik.core.AdminAkademikImpl', 'adminakademik_impl');

INSERT INTO adminakademik_impl (id) VALUES 
('143454fe-2bd1-4476-b613-44287e57059c');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('e846eb10-db46-46d1-8c44-0fce7bc7ed20','Mahasiswa diharapkan untuk melakukan pendaftaran semester gasal tahun akademik 2024/2025 melalui portal SIAK mulai tanggal 10 Juli hingga 20 Juli 2024. Pastikan semua kewajiban administrasi telah dipenuhi sebelum melakukan pendaftaran.','Pendaftaran Semester Gasal 2024/2025','siakreborn.informasi.akademik.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('bdb51411-55a4-4972-b12e-1f3208bb8480','Mahasiswa diharapkan untuk melakukan pendaftaran semester gasal tahun akademik 2024/2025 melalui portal SIAK mulai tanggal 10 Juli hingga 20 Juli 2024. Pastikan semua kewajiban administrasi telah dipenuhi sebelum melakukan pendaftaran.','Pendaftaran Semester Gasal 2024/2025','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_akademik');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('e846eb10-db46-46d1-8c44-0fce7bc7ed21','Ujian Tengah Semester (UTS) gasal akan dilaksanakan pada 1-12 Oktober 2024. Silakan cek jadwal dan lokasi ujian melalui menu "Jadwal Ujian" di portal SIAK. Harap datang tepat waktu dan membawa kartu ujian yang sudah dicetak.','Jadwal Ujian Tengah Semester Gasal','siakreborn.informasi.akademik.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('bdb51411-55a4-4972-b12e-1f3208bb8481','Ujian Tengah Semester (UTS) gasal akan dilaksanakan pada 1-12 Oktober 2024. Silakan cek jadwal dan lokasi ujian melalui menu "Jadwal Ujian" di portal SIAK. Harap datang tepat waktu dan membawa kartu ujian yang sudah dicetak.','Jadwal Ujian Tengah Semester Gasal','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_akademik');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('e846eb10-db46-46d1-8c44-0fce7bc7ed22','Pengisian KRS untuk semester mendatang akan dibuka pada 5-15 Agustus 2024. Mahasiswa diharapkan berkonsultasi dengan dosen pembimbing akademik sebelum mengisi KRS. Pastikan mata kuliah yang dipilih sesuai dengan kurikulum program studi.','Pengisian Kartu Rencana Studi (KRS)','siakreborn.informasi.akademik.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('bdb51411-55a4-4972-b12e-1f3208bb8482','Pengisian KRS untuk semester mendatang akan dibuka pada 5-15 Agustus 2024. Mahasiswa diharapkan berkonsultasi dengan dosen pembimbing akademik sebelum mengisi KRS. Pastikan mata kuliah yang dipilih sesuai dengan kurikulum program studi.','Pengisian Kartu Rencana Studi (KRS)','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_akademik');

INSERT INTO informasi_impl (id) VALUES
	 ('bdb51411-55a4-4972-b12e-1f3208bb8480'),
	 ('bdb51411-55a4-4972-b12e-1f3208bb8481'),
	 ('bdb51411-55a4-4972-b12e-1f3208bb8482');

INSERT INTO informasi_akademik (id,record_id,adminakademik_id,recordname,base_component_id) VALUES
	 ('e846eb10-db46-46d1-8c44-0fce7bc7ed20','bdb51411-55a4-4972-b12e-1f3208bb8480','143454fe-2bd1-4476-b613-44287e57059c','siakreborn.informasi.core.InformasiImpl','bdb51411-55a4-4972-b12e-1f3208bb8480');

INSERT INTO informasi_akademik (id,record_id,adminakademik_id,recordname,base_component_id) VALUES
	 ('e846eb10-db46-46d1-8c44-0fce7bc7ed21','bdb51411-55a4-4972-b12e-1f3208bb8481','143454fe-2bd1-4476-b613-44287e57059c','siakreborn.informasi.core.InformasiImpl','bdb51411-55a4-4972-b12e-1f3208bb8481');

INSERT INTO informasi_akademik (id,record_id,adminakademik_id,recordname,base_component_id) VALUES
	 ('e846eb10-db46-46d1-8c44-0fce7bc7ed22','bdb51411-55a4-4972-b12e-1f3208bb8482','143454fe-2bd1-4476-b613-44287e57059c','siakreborn.informasi.core.InformasiImpl','bdb51411-55a4-4972-b12e-1f3208bb8482');