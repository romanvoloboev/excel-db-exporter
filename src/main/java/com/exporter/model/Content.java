package com.exporter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "content")
public class Content {
    private Integer id;
    private String god;
    private String KA;
    private String RN;
    private String operatorKA;
    private String platformaKA;
    private String naznachenieKA;
    private String srok;
    private String massa;
    private String izgotovitel;
    private String orbita;
    private String sektor;
    private String provaider;
    private String kosmodrom;

    public Content() {
    }

    public Content(String god, String KA, String RN, String operatorKA, String platformaKA, String naznachenieKA,
                   String srok, String massa, String izgotovitel, String orbita, String sektor, String provaider,
                   String kosmodrom) {
        this.god = god;
        this.KA = KA;
        this.RN = RN;
        this.operatorKA = operatorKA;
        this.platformaKA = platformaKA;
        this.naznachenieKA = naznachenieKA;
        this.srok = srok;
        this.massa = massa;
        this.izgotovitel = izgotovitel;
        this.orbita = orbita;
        this.sektor = sektor;
        this.provaider = provaider;
        this.kosmodrom = kosmodrom;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "content_seq")
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "KA", nullable = false)
    public String getKA() {
        return KA;
    }
    public void setKA(String KA) {
        this.KA = KA;
    }

    @Column(name = "god")
    public String getGod() {
        return god;
    }
    public void setGod(String god) {
        this.god = god;
    }

    @Column(name = "RN")
    public String getRN() {
        return RN;
    }
    public void setRN(String RN) {
        this.RN = RN;
    }

    @Column(name = "operatorKA")
    public String getOperatorKA() {
        return operatorKA;
    }
    public void setOperatorKA(String operatorKA) {
        this.operatorKA = operatorKA;
    }

    @Column(name = "platformaKA")
    public String getPlatformaKA() {
        return platformaKA;
    }
    public void setPlatformaKA(String platformaKA) {
        this.platformaKA = platformaKA;
    }

    @Column(name = "naznachenieKA")
    public String getNaznachenieKA() {
        return naznachenieKA;
    }
    public void setNaznachenieKA(String naznachenieKA) {
        this.naznachenieKA = naznachenieKA;
    }

    @Column(name = "srok")
    public String getSrok() {
        return srok;
    }
    public void setSrok(String srok) {
        this.srok = srok;
    }

    @Column(name = "massa")
    public String getMassa() {
        return massa;
    }
    public void setMassa(String massa) {
        this.massa = massa;
    }

    @Column(name = "izgotovitel")
    public String getIzgotovitel() {
        return izgotovitel;
    }
    public void setIzgotovitel(String izgotovitel) {
        this.izgotovitel = izgotovitel;
    }

    @Column(name = "orbita")
    public String getOrbita() {
        return orbita;
    }
    public void setOrbita(String orbita) {
        this.orbita = orbita;
    }

    @Column(name = "sektor")
    public String getSektor() {
        return sektor;
    }
    public void setSektor(String sektor) {
        this.sektor = sektor;
    }

    @Column(name = "provaider")
    public String getProvaider() {
        return provaider;
    }
    public void setProvaider(String provaider) {
        this.provaider = provaider;
    }

    @Column(name = "kosmodrom")
    public String getKosmodrom() {
        return kosmodrom;
    }
    public void setKosmodrom(String kosmodrom) {
        this.kosmodrom = kosmodrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(god, content.god) &&
                Objects.equals(KA, content.KA) &&
                Objects.equals(RN, content.RN) &&
                Objects.equals(operatorKA, content.operatorKA) &&
                Objects.equals(platformaKA, content.platformaKA) &&
                Objects.equals(naznachenieKA, content.naznachenieKA) &&
                Objects.equals(srok, content.srok) &&
                Objects.equals(massa, content.massa) &&
                Objects.equals(izgotovitel, content.izgotovitel) &&
                Objects.equals(orbita, content.orbita) &&
                Objects.equals(sektor, content.sektor) &&
                Objects.equals(provaider, content.provaider) &&
                Objects.equals(kosmodrom, content.kosmodrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(god, KA, RN, operatorKA, platformaKA, naznachenieKA, srok, massa, izgotovitel, orbita, sektor, provaider, kosmodrom);
    }
}
