package cz.czechitas.webapp;

import java.time.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    private PlodinaRepository dodavatelDat = new PlodinaRepository();

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        return new ModelAndView("redirect:/plodiny/");
    }

    
    @RequestMapping("/plodiny/")
    public ModelAndView zobrazSeznam() {
        List<Plodina> seznamPlodin = dodavatelDat.findAll();
        Month aktualniMesic;
        List<Plodina> aktualniPlodiny = new ArrayList<>(seznamPlodin.size());
        aktualniMesic = LocalDate.now().getMonth();
        
        for (Plodina jednaPlodina : seznamPlodin) {
         if ((jednaPlodina.getZacatekSazeni().getValue() <= aktualniMesic.getValue())
                 && (jednaPlodina.getKonecSazeni().getValue() >= aktualniMesic.getValue())) {
             aktualniPlodiny.add(jednaPlodina);
         }
            
        }

        ModelAndView drzakNaData = new ModelAndView("plodiny/index");
        drzakNaData.addObject("seznam", aktualniPlodiny);
        drzakNaData.addObject("dnes", LocalDate.now());
        return drzakNaData;
    }
}
