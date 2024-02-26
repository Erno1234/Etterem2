package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etterem {

    private ArrayList<Rendeles> rendelesek;
    private ArrayList<Etel> etlap;

    
    public List<Rendeles> getRendeles() {
       return rendelesek;
    }
    
    public void rendelesKiir(){
         for (Rendeles rendeles : getRendeles()) {
            System.out.println(rendeles.toString());
        }
    }

    public void etlapfajlBeOlv() {
        etlap = new ArrayList<>();
        try {
            List<String> sorok = Files.readAllLines(Paths.get("etelek.txt"));
            for (String sor : sorok) {
                String[] reszek = sor.split("\\|");
                if (reszek.length == 2) {
                    String nev = reszek[0].trim();
                    int ar = Integer.parseInt(reszek[1].trim());
                    etlap.add(new Etel(nev, ar));
                }
            }
        } catch (IOException e) {
        }
    }

    public void rendelfajlBeOlv() {
        rendelesek = new ArrayList<>();
        Map<String, Rendeles> rendelesekMap = new HashMap<>();
        String asztal = null;

        try {
            List<String> sorok = Files.readAllLines(Paths.get("rendeles.txt"));
            for (String sor : sorok) {
                if (sor.trim().isEmpty()) {
                    asztal = null;
                } else if (asztal == null) {
                    asztal = sor;
                    rendelesekMap.putIfAbsent(asztal, new Rendeles(asztal));
                } else {
                    Rendeles rendeles = rendelesekMap.get(asztal);
                    Etel etel = etelKivalaszt(sor);
                    if (etel != null) {
                        rendeles.hozzaAd(etel);
                    }
                }
            }
        } catch (IOException e) {
        }

        rendelesek.addAll(rendelesekMap.values());
    }

    private Etel etelKivalaszt(String etelNeve) {
        for (Etel etel : etlap) {
            if (etel.getNev().equals(etelNeve)) {
                return etel;
            }
        }
        return null;
    }
}
