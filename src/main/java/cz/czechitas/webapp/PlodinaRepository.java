package cz.czechitas.webapp;

import java.time.*;
import java.util.*;

public class PlodinaRepository {



    private List<Plodina> seznamPlodin = new ArrayList<>(Arrays.asList(
            new Plodina(1L, "Dýně", "dyne", Month.APRIL, Month.MAY, 90, Month.SEPTEMBER, Month.OCTOBER),
            new Kytka(2L, "Kdoulovec", "kdoulovec", Month.MARCH, Month.JUNE, 60, Month.SEPTEMBER, Month.OCTOBER, 1),
            new Kytka(3L, "Koukol", "koukol", Month.JUNE, Month.JULY, 70, Month.AUGUST, Month.SEPTEMBER, 2),
            new Plodina(4L, "Meloun", "meloun", Month.MARCH, Month.APRIL, 120, Month.AUGUST, Month.NOVEMBER)
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
        return new Plodina(
                puvodni.getId(),
                puvodni.getNazev(),
                puvodni.getObrazek(),
                puvodni.getZacatekSazeni(),
                puvodni.getKonecSazeni(),
                puvodni.getDobaRustu(),
                puvodni.getZacatekSlizne(),
                puvodni.getKoncecSklizne());
    }


}