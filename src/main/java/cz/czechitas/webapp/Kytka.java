package cz.czechitas.webapp;

import java.time.*;

public class Kytka extends Plodina {

    private String barva;

    public Kytka () {

    }
    
    public Kytka(Long id, String typPlodiny, String nazev, String obrazek, Month zacatekSazeni, Month konecSazeni, int dobaRustu, Month zacatekSlizne, Month koncecSklizne, String barva) {
        super(id, typPlodiny, nazev, obrazek, zacatekSazeni, konecSazeni, dobaRustu, zacatekSlizne, koncecSklizne);
        this.barva = barva;
    }

    
    public String getBarva() {
        return barva;
    }

    public void setBarva(String newValue) {
        barva = newValue;
    }
}
