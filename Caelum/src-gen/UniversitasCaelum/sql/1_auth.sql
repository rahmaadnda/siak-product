INSERT INTO auth_user_comp (id) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('10a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('11a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('12a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('13a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('14a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('15a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('c793f70a-a83e-4d08-881e-e593752fb6cf'),
('c803f70a-a83e-4d08-881e-e593752fb6cf'),
('c813f70a-a83e-4d08-881e-e593752fb6cf'),
('c823f70a-a83e-4d08-881e-e593752fb6cf')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_impl (id, allowedPermissions, name, email) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','admin','admin@user.com'),
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Bonaventura Galang K. A. H.','bona@user.com'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Aidah Novallia Putri','aidah@user.com'),
('4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Farel Muhammad Daffa','farel@user.com'),
('5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Ramadhan Azka Dhamawan','azka@user.com'),
('6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Pramudya Wibisono','pram@user.com'),
('7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Nur Fajar Sayyidul Ayyam','fajar@user.com'),
('8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Zacky Muchlas Dharmawan','zacky@user.com'),
('9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Dr. Ade Azurat, S.Kom.','ade@user.com'),
('10a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Iis Solichah, S.Kom., M.Kom, M.C.S.','iis@user.com'),
('11a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Dr. Maya Retno Ayu Setyautami, S.Kom., M.Kom.','maya@user.com'),
('12a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Ichlasul Affan, S.Kom., M.Kom.','affan@user.com'),
('13a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Daya Adianto, S.Kom., M.Kom.','daya@user.com'),
('14a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Akademik','academic@user.com'),
('15a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Dosen','dosen@user.com'),
('c793f70a-a83e-4d08-881e-e593752fb6cf','','Debby Trinita','debby@user.com'),
('c803f70a-a83e-4d08-881e-e593752fb6cf','','Monica Oktaviona','monica@user.com'),
('c813f70a-a83e-4d08-881e-e593752fb6cf','','Rahma Adinda Putri','rahma@user.com'),
('c823f70a-a83e-4d08-881e-e593752fb6cf','','Dr. Siti Aminah, S.Kom., M.Kom.','ami@user.com')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_passworded (id, user_id, password) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('10a9ff33-6dd2-4c0a-b113-a90ee32a01ca','10a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('11a9ff33-6dd2-4c0a-b113-a90ee32a01ca','11a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('12a9ff33-6dd2-4c0a-b113-a90ee32a01ca','12a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('13a9ff33-6dd2-4c0a-b113-a90ee32a01ca','13a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('14a9ff33-6dd2-4c0a-b113-a90ee32a01ca','14a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('15a9ff33-6dd2-4c0a-b113-a90ee32a01ca','15a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('c793f70a-a83e-4d08-881e-e593752fb6cf','c793f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('c803f70a-a83e-4d08-881e-e593752fb6cf','c803f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('c813f70a-a83e-4d08-881e-e593752fb6cf','c813f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('c823f70a-a83e-4d08-881e-e593752fb6cf','c823f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b')
ON CONFLICT DO NOTHING;

INSERT INTO auth_role_comp (id) VALUES
('15f6727e-66f8-484f-b77f-83eeec82cd10'),
('25f6727e-66f8-484f-b77f-83eeec82cd10'),
('35f6727e-66f8-484f-b77f-83eeec82cd10'),
('45f6727e-66f8-484f-b77f-83eeec82cd10'),
('55f6727e-66f8-484f-b77f-83eeec82cd10')
ON CONFLICT DO NOTHING;

INSERT INTO auth_role_impl (id, name, allowedPermissions) VALUES
('15f6727e-66f8-484f-b77f-83eeec82cd10','administrator','administrator'),
('25f6727e-66f8-484f-b77f-83eeec82cd10','Mahasiswa','home,ReadBobotKomponenPenilaian,ReadCapaian,ReadCPL,ReadCPMK,ReadSubCPMK,ReadKelas,ReadKelasDosen,ReadKomponenPenilaian,ReadKurikulum,ReadKurikulumSemester,ReadSemester,ReadMahasiswaMe,ReadMataKuliah,CreatePembayaranMe,ReadPembayaranMe,ReadPenilaianMe,ReadLaporanCPLMe,ReadProgramStudi,CreateRencanaStudiMe,ReadRencanaStudiMe,ReadKelasMahasiswaMe,UpdateMahasiswa,ReadDetailMahasiswa,ReadInformasiIndustri,ReadInformasiAlumni,ReadInformasiAkademik,ReadMataKuliahPrasyarat'),
('35f6727e-66f8-484f-b77f-83eeec82cd10','Dosen','home,CreateBobotKomponenPenilaian,UpdateBobotKomponenPenilaian,ReadBobotKomponenPenilaian,DeleteBobotKomponenPenilaian,ReadCapaian,ReadCPL,SaveCPMK,UpdateCPMK,ReadCPMK,DeleteCPMK,SaveSubCPMK,UpdateSubCPMK,ReadSubCPMK,DeleteSubCPMK,ReadKelas,ReadKelasDosen,ReadKelasDosenMe,CreateKomponenPenilaian,UpdateKomponenPenilaian,ReadKomponenPenilaian,DeleteKomponenPenilaian,ReadKurikulum,ReadKurikulumSemester,ReadSemester,ReadMataKuliah,CreatePenilaian,UpdatePenilaian,ReadPenilaian,DeletePenilaian,ReadLaporanCPMK,ReadLaporanCPL,ReadProgramStudi,ReadKelasMahasiswa,ReadMataKuliahPrasyarat'),
('45f6727e-66f8-484f-b77f-83eeec82cd10','Subbagian Akademik','home,CreateBobotKomponenPenilaian,UpdateBobotKomponenPenilaian,ReadBobotKomponenPenilaian,DeleteBobotKomponenPenilaian,CreateCapaian,UpdateCapaian,ReadCapaian,DeleteCapaian,SaveCPL,UpdateCPL,ReadCPL,DeleteCPL,SaveCPMK,UpdateCPMK,ReadCPMK,DeleteCPMK,SaveSubCPMK,UpdateSubCPMK,ReadSubCPMK,DeleteSubCPMK,CreateKelas,UpdateKelas,ReadKelas,DeleteKelas,CreateKelasDosen,UpdateKelasDosen,ReadKelasDosen,DeleteKelasDosen,CreateKomponenPenilaian,UpdateKomponenPenilaian,ReadKomponenPenilaian,DeleteKomponenPenilaian,CreateKurikulum,UpdateKurikulum,ReadKurikulum,DeleteKurikulum,CreateKurikulumSemester,UpdateKurikulumSemester,ReadKurikulumSemester,DeleteKurikulumSemester,CreateSemester,UpdateSemester,ReadSemester,DeleteSemester,CreateMataKuliah,UpdateMataKuliah,ReadMataKuliah,DeleteMataKuliah,ReadLaporanCPMK,ReadLaporanCPL,CreateProgramStudi,UpdateProgramStudi,ReadProgramStudi,DeleteProgramStudi,ReadPengisianRencanaStudi,UpdatePengisianRencanaStudi,SaveMataKuliahPrasyarat,UpdateMataKuliahPrasyarat,ReadMataKuliahPrasyarat,DeleteMataKuliahPrasyarat,ReadDetailAlumni,ReadInformasiAlumni,VerifyMahasiswa,VerifyAlumni,ReadMahasiswaPublic,ReadAlumniPublic,ReadDetailMahasiswa,ReadAlumni,ReadMahasiswa,GraduateMahasiswa,ReadInformasiIndustri,ReadInformasiAkademik,SaveInformasiAkademik,ReadIndustri,DetailIndustri,ListIndustri,UpdateSubscriptionPlan,CreateSubscriptionPlan,SubscriptionApproveIndustri'),
('55f6727e-66f8-484f-b77f-83eeec82cd10','MahasiswaAlumni','home,ReadBobotKomponenPenilaian,ReadCapaian,ReadCPL,ReadCPMK,ReadSubCPMK,ReadKelas,ReadKelasDosen,ReadKomponenPenilaian,ReadKurikulum,ReadKurikulumSemester,ReadSemester,ReadMahasiswaMe,ReadMataKuliah,CreatePembayaranMe,ReadPembayaranMe,ReadPenilaianMe,ReadLaporanCPLMe,ReadProgramStudi,CreateRencanaStudiMe,ReadRencanaStudiMe,ReadKelasMahasiswaMe,UpdateMahasiswa,ReadDetailMahasiswa,ReadInformasiIndustri,ReadInformasiAlumni,ReadInformasiAkademik,CreateAkunAlumni,ReadMataKuliahPrasyarat')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_comp (id) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10'),
('2af6727e-66f8-484f-b77f-83eeec82cd10'),
('3af6727e-66f8-484f-b77f-83eeec82cd10'),
('4af6727e-66f8-484f-b77f-83eeec82cd10'),
('5af6727e-66f8-484f-b77f-83eeec82cd10'),
('6af6727e-66f8-484f-b77f-83eeec82cd10'),
('7af6727e-66f8-484f-b77f-83eeec82cd10'),
('8af6727e-66f8-484f-b77f-83eeec82cd10'),
('9af6727e-66f8-484f-b77f-83eeec82cd10'),
('10f6727e-66f8-484f-b77f-83eeec82cd10'),
('11f6727e-66f8-484f-b77f-83eeec82cd10'),
('12f6727e-66f8-484f-b77f-83eeec82cd10'),
('13f6727e-66f8-484f-b77f-83eeec82cd10'),
('14f6727e-66f8-484f-b77f-83eeec82cd10'),
('15f6727e-66f8-484f-b77f-83eeec82cd10'),
('16f6727e-66f8-484f-b77f-83eeec82cd10'),
('17f6727e-66f8-484f-b77f-83eeec82cd10'),
('18f6727e-66f8-484f-b77f-83eeec82cd10'),
('19f6727e-66f8-484f-b77f-83eeec82cd10')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_impl (id, authRole, authUser) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10','15f6727e-66f8-484f-b77f-83eeec82cd10','1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('5af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('6af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('7af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('8af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('9af6727e-66f8-484f-b77f-83eeec82cd10','35f6727e-66f8-484f-b77f-83eeec82cd10','9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('10f6727e-66f8-484f-b77f-83eeec82cd10','35f6727e-66f8-484f-b77f-83eeec82cd10','10a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('11f6727e-66f8-484f-b77f-83eeec82cd10','35f6727e-66f8-484f-b77f-83eeec82cd10','11a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('12f6727e-66f8-484f-b77f-83eeec82cd10','35f6727e-66f8-484f-b77f-83eeec82cd10','12a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('13f6727e-66f8-484f-b77f-83eeec82cd10','35f6727e-66f8-484f-b77f-83eeec82cd10','13a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('14f6727e-66f8-484f-b77f-83eeec82cd10','45f6727e-66f8-484f-b77f-83eeec82cd10','14a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('15f6727e-66f8-484f-b77f-83eeec82cd10','35f6727e-66f8-484f-b77f-83eeec82cd10','15a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('16f6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','c793f70a-a83e-4d08-881e-e593752fb6cf'),
('17f6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','c803f70a-a83e-4d08-881e-e593752fb6cf'),
('18f6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','c813f70a-a83e-4d08-881e-e593752fb6cf'),
('19f6727e-66f8-484f-b77f-83eeec82cd10','35f6727e-66f8-484f-b77f-83eeec82cd10','c823f70a-a83e-4d08-881e-e593752fb6cf')
ON CONFLICT DO NOTHING;