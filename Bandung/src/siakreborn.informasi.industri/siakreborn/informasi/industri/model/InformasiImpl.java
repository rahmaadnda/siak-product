package siakreborn.informasi.industri;

import siakreborn.informasi.core.*;
import siakreborn.observer.core.Observer;
import siakreborn.observer.industri.*;

import siakreborn.util.core.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import java.util.*;

@Entity(name = "informasi_industri")
@Table(name = "informasi_industri")
public class InformasiImpl extends InformasiDecorator {

    @OneToOne(targetEntity = siakreborn.observer.industri.ObserverImpl.class)
    public Observer industri;

    public InformasiImpl() {
        super();
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(Observer industri) {
        super();
        this.industri = industri;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(InformasiComponent record, Observer industri) {
        super(record);
        this.industri = industri;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(UUID id, InformasiComponent record, Observer industri) {
        super(id, record);
        this.industri = industri;
        this.objectName = InformasiImpl.class.getName();
    }

    public Observer getIndustri() {
        return industri;
    }

    public void setIndustri(Observer industri) {
        this.industri = industri;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", record='" + getRecord() + "'" +
            ", industri='" + getIndustri() + "'" +
            "}";
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> informasiMap = record.toHashMap();
        informasiMap.put("id", this.getId());
        informasiMap = Util.combine(informasiMap, ((ObserverImpl) this.getIndustri()).toHashMap(), "industri");
        return informasiMap;
    }
}