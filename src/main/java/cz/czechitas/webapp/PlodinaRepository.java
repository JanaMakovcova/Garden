package cz.czechitas.webapp;

import java.time.*;
import java.util.*;

public class PlodinaRepository {



    private List<Plodina> seznamPlodin = new ArrayList<>(Arrays.asList(
            new Plodina(1L, "zelenina","Dýně", "dyne", Month.APRIL, Month.MAY, 90, Month.SEPTEMBER, Month.OCTOBER),
            new Kytka(2L, "kytka", "Kdoulovec", "kdoulovec", Month.MARCH, Month.JUNE, 60, Month.SEPTEMBER, Month.OCTOBER, "cervena"),
            new Kytka(3L, "kytka", "Koukol", "koukol", Month.JUNE, Month.JULY, 70, Month.AUGUST, Month.SEPTEMBER, "fialova"),
            new Plodina(4L, "zelenina", "Meloun", "meloun", Month.MARCH, Month.APRIL, 120, Month.AUGUST, Month.NOVEMBER),
            new Plodina(5L, "zelenina","Lilek", "lilek", Month.FEBRUARY, Month.MARCH, 150, Month.JULY, Month.NOVEMBER),
            new Kytka(6L, "kytka", "Slunečnice", "slunecnice", Month.APRIL, Month.MAY, 90, Month.JULY, Month.NOVEMBER, "zluta"),
            new Plodina(7L, "zelenina", "Petržel", "petrzel", Month.MARCH, Month.MAY, 150, Month.JUNE, Month.OCTOBER),
            new Kytka(8L, "kytka", "Růže", "ruze", Month.MARCH, Month.MAY, 60, Month.JUNE, Month.SEPTEMBER, "cervena"),
            new Plodina(9L, "zelenina", "Rajče", "rajce", Month.MAY, Month.JUNE, 60, Month.JULY, Month.SEPTEMBER),
            new Kytka(10L, "kytka", "Sněženka","snezenka", Month.SEPTEMBER, Month.OCTOBER, 210, Month.MARCH, Month.MARCH, "bila" )
    ));

    public synchronized List<Plodina> findAll() {
        List<Plodina> plodiny = new ArrayList<>(seznamPlodin.size());
        for (Plodina jednaPlodina : seznamPlodin) {
            plodiny.add(clone(jednaPlodina));
        }
        return plodiny;
    }
    

    public synchronized Plodina findOne(Long id) {
        int index = najdiIndexZaznamu(id);
        if (index == -1) {
            return null;
        }
        return clone(seznamPlodin.get(index));
    }
    

    private int najdiIndexZaznamu(Long id) {
        if (id == null) {
            throw new NullPointerException("Plodina.ID nesmi byt null");
        }
        for (int i = 0; i < seznamPlodin.size(); i++) {
            Plodina plodina = seznamPlodin.get(i);
            if (plodina.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private Plodina clone(Plodina puvodni) {
       if (puvodni instanceof Kytka) {
           
           Kytka kytkaPuvodni = (Kytka)puvodni;
           return new Kytka(
                   kytkaPuvodni.getId(),
                   kytkaPuvodni.getTypPlodiny(),
                   kytkaPuvodni.getNazev(),
                   kytkaPuvodni.getObrazek(),
                   kytkaPuvodni.getZacatekSazeni(),
                   kytkaPuvodni.getKonecSazeni(),
                   kytkaPuvodni.getDobaRustu(),
                   kytkaPuvodni.getZacatekSlizne(),
                   kytkaPuvodni.getKoncecSklizne(),
                   kytkaPuvodni.getBarva());

       } else
        return new Plodina(
                puvodni.getId(),
                puvodni.getTypPlodiny(),
                puvodni.getNazev(),
                puvodni.getObrazek(),
                puvodni.getZacatekSazeni(),
                puvodni.getKonecSazeni(),
                puvodni.getDobaRustu(),
                puvodni.getZacatekSlizne(),
                puvodni.getKoncecSklizne());
    }
    /**
    private Kytka clone(Kytka kytkaPuvodni) {
        
            return new Kytka(
                    kytkaPuvodni.getId(),
                    kytkaPuvodni.getTypPlodiny(),
                    kytkaPuvodni.getNazev(),
                    kytkaPuvodni.getObrazek(),
                    kytkaPuvodni.getZacatekSazeni(),
                    kytkaPuvodni.getKonecSazeni(),
                    kytkaPuvodni.getDobaRustu(),
                    kytkaPuvodni.getZacatekSlizne(),
                    kytkaPuvodni.getKoncecSklizne(),
                    kytkaPuvodni.getBarva());

    }
     **/


}
