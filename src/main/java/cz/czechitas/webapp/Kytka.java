package cz.czechitas.webapp;

import java.time.*;

public class Kytka extends Plodina {

    private Integer barva;

    public Kytka () {

    }
    
    public Kytka(Long id, String nazev, String obrazek, Month zacatekSazeni, Month konecSazeni, int dobaRustu, Month zacatekSlizne, Month koncecSklizne, Integer barva) {
        super(id, nazev, obrazek, zacatekSazeni, konecSazeni, dobaRustu, zacatekSlizne, koncecSklizne);
        this.barva = barva;
    }

    public Integer getBarva() {
        return barva;
    }

    public void setBarva(Integer newValue) {
        barva = newValue;
    }
}
