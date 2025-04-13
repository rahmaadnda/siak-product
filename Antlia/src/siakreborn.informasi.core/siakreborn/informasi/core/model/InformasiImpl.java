package siakreborn.informasi.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "informasi_impl")
@Table(name = "informasi_impl")
public class InformasiImpl extends InformasiComponent {

    public InformasiImpl(UUID id, String judul, String deskripsi, Date tanggalPublikasi) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalPublikasi = tanggalPublikasi;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(String judul, String deskripsi, Date tanggalPublikasi) {
        this.id = UUID.randomUUID();
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalPublikasi = tanggalPublikasi;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl() {
        this.id = UUID.randomUUID();
        this.judul = "";
        this.deskripsi = "";
        this.tanggalPublikasi = new Date();
        this.objectName = InformasiImpl.class.getName();
    }
}
