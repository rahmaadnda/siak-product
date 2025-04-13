package siakreborn.informasi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity(name = "informasi_comp")
@Table(name = "informasi_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InformasiComponent implements Informasi {
    @Id
    protected UUID id;
    protected String judul;

    @Column(columnDefinition = "TEXT")
    protected String deskripsi;
    protected Date tanggalPublikasi;

    protected String objectName = InformasiComponent.class.getName();

    public InformasiComponent() {
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Date getTanggalPublikasi() {
        return this.tanggalPublikasi;
    }

    public void setTanggalPublikasi(Date tanggalPublikasi) {
        this.tanggalPublikasi = tanggalPublikasi;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", judul='" + getJudul() + "'" +
                ", deskripsi='" + getDeskripsi() + "'" +
                ", tanggalPublikasi='" + getTanggalPublikasi() + "'" +
                "}";
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> informasiMap = new HashMap<>();
        informasiMap.put("id", getId());
        informasiMap.put("judul", getJudul());
        informasiMap.put("deskripsi", getDeskripsi());
        informasiMap.put("tanggalPublikasi", getTanggalPublikasi());

        return informasiMap;
    }
}
