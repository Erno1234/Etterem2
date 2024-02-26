package model;

import java.util.ArrayList;
import java.util.List;

public class Rendeles {

    private String asztal;
    private List<Etel> rendeles;
    private final String valasztoV = "====================";
    private final String valasztoV2 = "--------------------";

    public Rendeles(String asztal) {
        this.rendeles = new ArrayList<>();
        this.asztal = asztal;
    }

    public void hozzaAd(Etel etel) {
        rendeles.add(etel);
    }

    public String getAsztal() {
        return asztal;
    }

    public void setAsztal(String asztal) {
        this.asztal = asztal;
    }

    public List<Etel> getRendeles() {
        return rendeles;
    }

    public void setRendeles(List<Etel> rendeles) {
        this.rendeles = rendeles;
    }

    public int osszeg() {
        int osszeg = 0;
        for (Etel etel : rendeles) {
            osszeg += etel.getAr();
        }
        return osszeg;
    }

    public String rendelesek() {
        String rend = "";
        for (Etel etel : rendeles) {
            rend += etel.getNev() + "%15s" + etel.getAr() + "Ft";
        }
        return rend;
    }

    @Override
    public String toString() {
        String txt = "\n" + getAsztal() + " asztal: " + "\n" + valasztoV + "\n";
        for (Etel etel : rendeles) {
            txt += etel.getNev() + " | " + etel.getAr() + " Ft" + "\n";
        }
        txt += valasztoV2 + "\n Összesen: " + osszeg() + " Ft\n";
        return txt;
    }

}
