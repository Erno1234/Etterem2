package model;

public class Etel {

    private String nev;
    private int ar;

    public Etel(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
    }

    public int getAr() {
        return ar;
    }

    public String getNev() {
        return nev;
    }


    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

      
    @Override
    public String toString() {
        return nev + "|"+ ar + "Ft";
    }
}
