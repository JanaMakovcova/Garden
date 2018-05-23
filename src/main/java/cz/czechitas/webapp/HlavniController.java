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

        List<Plodina> seznamPlodin = dodavatelDat.findAll();

        ModelAndView drzakNaData = new ModelAndView("index");
        drzakNaData.addObject("seznam", seznamPlodin);
        drzakNaData.addObject("dnes", LocalDate.now());
        return drzakNaData;
    }


    @RequestMapping("/plodiny-dnes")
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

        ModelAndView drzakNaData = new ModelAndView("plodiny-dnes");
        drzakNaData.addObject("seznam", aktualniPlodiny);
        drzakNaData.addObject("dnes", LocalDate.now());
        return drzakNaData;
    }

    @RequestMapping(value = "formular", method = RequestMethod.GET)
    public ModelAndView zobrazFormular() {
        return new ModelAndView("formular");
    }

    @RequestMapping(value = "/formular", method = RequestMethod.POST)
    public ModelAndView zpracujFormular(Formular vyplnenyFormular) {

        List<Plodina> seznamPlodin = dodavatelDat.findAll();
        List<Plodina> vybranePlodiny = new ArrayList<>(seznamPlodin.size());
        Month mesicSklizne = vyplnenyFormular.getMesicSklizeni();
        List<String> typPlodiny = vyplnenyFormular.getTypPlodiny();
        List<String> vybraneBarvy = vyplnenyFormular.getBarva();
       
        
        for (Plodina jednaPlodina : seznamPlodin) {
            if ((jednaPlodina.getZacatekSlizne().getValue() <= mesicSklizne.getValue())
                    && (jednaPlodina.getKoncecSklizne().getValue() >= mesicSklizne.getValue())) {

                for (String typ: typPlodiny) {
                    
                    if (typ.equals(jednaPlodina.getTypPlodiny())) {

                        if (jednaPlodina.getTypPlodiny().equals("kytka")) {

                            

                            for (String barva: vybraneBarvy) {

                                if (barva.equals(((Kytka)jednaPlodina).getBarva())){
                                    vybranePlodiny.add(jednaPlodina);
                                }
                            }


                            //vybranePlodiny.add(jednaPlodina);


                        }  else {
                            vybranePlodiny.add(jednaPlodina);
                        }
                    }
                }
            }
        }

            ModelAndView drzakNaData = new ModelAndView("plodiny-vybrane");
            drzakNaData.addObject("seznam", vybranePlodiny);
            drzakNaData.addObject("dnes", LocalDate.now());
            return drzakNaData;

    }
}
