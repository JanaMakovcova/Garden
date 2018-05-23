package cz.czechitas.webapp;

import java.time.*;
import java.util.*;

public class Formular {

    private Month mesicSklizeni;
    private List<String> typPlodiny;
    private List<String> barva;

    public Month getMesicSklizeni() {
        return mesicSklizeni;
    }

    public void setMesicSklizeni(Month newValue) {
        mesicSklizeni = newValue;
    }

    public List<String> getTypPlodiny() {
        return typPlodiny;
    }

    public void setTypPlodiny(List<String> newValue) {
        typPlodiny = newValue;
    }

    public List<String> getBarva() {
        return barva;
    }

    public void setBarva(List<String> newValue) {
        barva = newValue;
    }
}
