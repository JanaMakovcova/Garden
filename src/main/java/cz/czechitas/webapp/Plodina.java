package cz.czechitas.webapp;

import java.time.*;

public class Plodina {

    private Long id;
    private String typPlodiny;
    private String nazev;
    private String obrazek;
    private Month zacatekSazeni;
    private Month konecSazeni;
    private int dobaRustu;
    private Month zacatekSlizne;
    private Month koncecSklizne;

    public Plodina() {

    }

    public Plodina(Long id, String typPlodiny, String nazev, String obrazek, Month zacatekSazeni, Month konecSazeni, int dobaRustu, Month zacatekSlizne, Month koncecSklizne) {
        this.id = id;
        this.typPlodiny = typPlodiny;
        this.nazev = nazev;
        this.obrazek = obrazek;
        this.zacatekSazeni = zacatekSazeni;
        this.konecSazeni = konecSazeni;
        this.dobaRustu = dobaRustu;
        this.zacatekSlizne = zacatekSlizne;
        this.koncecSklizne = koncecSklizne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long newValue) {
        id = newValue;
    }

    public String getTypPlodiny() {
        return typPlodiny;
    }

    public void setTypPlodiny(String newValue) {
        typPlodiny = newValue;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String newValue) {
        nazev = newValue;
    }

    public String getObrazek() {
        return obrazek;
    }

    public void setObrazek(String newValue) {
        obrazek = newValue;
    }

    public Month getZacatekSazeni() {
        return zacatekSazeni;
    }

    public void setZacatekSazeni(Month newValue) {
        zacatekSazeni = newValue;
    }

    public Month getKonecSazeni() {
        return konecSazeni;
    }

    public void setKonecSazeni(Month newValue) {
        konecSazeni = newValue;
    }

    public int getDobaRustu() {
        return dobaRustu;
    }

    public void setDobaRustu(int newValue) {
        dobaRustu = newValue;
    }

    public Month getZacatekSlizne() {
        return zacatekSlizne;
    }

    public void setZacatekSlizne(Month newValue) {
        zacatekSlizne = newValue;
    }

    public Month getKoncecSklizne() {
        return koncecSklizne;
    }

    public void setKoncecSklizne(Month newValue) {
        koncecSklizne = newValue;
    }


}
