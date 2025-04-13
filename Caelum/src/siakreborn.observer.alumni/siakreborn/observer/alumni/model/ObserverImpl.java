package siakreborn.observer.alumni;

import siakreborn.observer.core.ObserverDecorator;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverComponent;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.util.core.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import java.util.*;

@Entity(name = "observer_alumni")
@Table(name = "observer_alumni")
public class ObserverImpl extends ObserverDecorator {

    @OneToOne(targetEntity = siakreborn.mahasiswa.core.MahasiswaComponent.class)
    public Mahasiswa mahasiswa;

    public String portofolioUrl;
    public String linkedinUrl;
    public String npm;
    public int tahunLulus;
    public String pekerjaan;
    public String tempatKerja;
    public boolean isPublic; 

    public ObserverImpl() {
        super();
        this.portofolioUrl = "";
        this.isPublic = false; 
        this.objectName = ObserverImpl.class.getName();
    }

    public ObserverImpl(Mahasiswa mahasiswa, String portofolioUrl, String linkedinUrl, String npm, int tahunLulus, String pekerjaan, String tempatKerja, boolean isPublic) {
        super();
        this.mahasiswa = mahasiswa;
        this.portofolioUrl = portofolioUrl;
        this.linkedinUrl = linkedinUrl;
        this.npm = npm;
        this.tahunLulus = tahunLulus;
        this.pekerjaan = pekerjaan;
        this.tempatKerja = tempatKerja;
        this.isPublic = isPublic; 
        this.objectName = ObserverImpl.class.getName();
    }

    public ObserverImpl(ObserverComponent record, Mahasiswa mahasiswa, String portofolioUrl, String linkedinUrl, String npm, int tahunLulus, String pekerjaan, String tempatKerja, boolean isPublic) {
        super(record);
        this.mahasiswa = mahasiswa;
        this.portofolioUrl = portofolioUrl;
        this.linkedinUrl = linkedinUrl;
        this.npm = npm;
        this.tahunLulus = tahunLulus;
        this.pekerjaan = pekerjaan;
        this.tempatKerja = tempatKerja;
        this.isPublic = isPublic; 
        this.objectName = ObserverImpl.class.getName();
    }

    public ObserverImpl(UUID id, ObserverComponent record, Mahasiswa mahasiswa, String portofolioUrl, String linkedinUrl, String npm, int tahunLulus, String pekerjaan, String tempatKerja, boolean isPublic) {
        super(id, record);
        this.mahasiswa = mahasiswa;
        this.portofolioUrl = portofolioUrl;
        this.linkedinUrl = linkedinUrl;
        this.npm = npm;
        this.tahunLulus = tahunLulus;
        this.pekerjaan = pekerjaan;
        this.tempatKerja = tempatKerja;
        this.isPublic = isPublic; 
        this.objectName = ObserverImpl.class.getName();
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getPortofolioUrl() {
        return portofolioUrl;
    }

    public void setPortofolioUrl(String portofolioUrl) {
        this.portofolioUrl = portofolioUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public int getTahunLulus() {
        return tahunLulus;
    }

    public void setTahunLulus(int tahunLulus) {
        this.tahunLulus = tahunLulus;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getTempatKerja() {
        return tempatKerja;
    }

    public void setTempatKerja(String tempatKerja) {
        this.tempatKerja = tempatKerja;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", record='" + getRecord() + "'" +
            ", portofolioUrl='" + getPortofolioUrl() + "'" +
            ", linkedinUrl='" + getLinkedinUrl() + "'" +
            ", npm='" + getNpm() + "'" +
            ", tahunLulus='" + getTahunLulus() + "'" +
            ", pekerjaan='" + getPekerjaan() + "'" +
            ", tempatKerja='" + getTempatKerja() + "'" +
            ", isPublic='" + isPublic + "'" + // Tambahkan isPublic di toString
            "}";
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> observerMap = record.toHashMap();
        observerMap.put("id", this.getId());
        observerMap = Util.combine(observerMap, this.getMahasiswa().toHashMap(), "mahasiswa");
        observerMap.put("portofolioUrl", this.getPortofolioUrl());
        observerMap.put("linkedinUrl", this.getLinkedinUrl());
        observerMap.put("npm", this.getNpm());
        observerMap.put("tahunLulus", this.getTahunLulus());
        observerMap.put("pekerjaan", this.getPekerjaan());
        observerMap.put("tempatKerja", this.getTempatKerja());
        observerMap.put("isPublic", this.isPublic());
        observerMap.put("isPublicString", String.valueOf(this.isPublic()));
        return observerMap;
    }
}