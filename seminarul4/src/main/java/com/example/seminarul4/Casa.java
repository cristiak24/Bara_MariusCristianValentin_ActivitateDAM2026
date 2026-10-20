package com.example.seminarul4;

import java.io.Serializable;

public class Casa implements Serializable {
    private String nume;
    private int suprafata;
    private String tip;
    private String oras;
    private boolean arePiscina;
    private float rating;

    public Casa(String nume, int suprafata, String tip, String oras,
                boolean arePiscina, float rating) {
        this.nume = nume;
        this.suprafata = suprafata;
        this.tip = tip;
        this.oras = oras;
        this.arePiscina = arePiscina;
        this.rating = rating;
    }

    public String getNume() { return nume; }
    public int getSuprafata() { return suprafata; }
    public String getTip() { return tip; }
    public String getOras() { return oras; }
    public boolean isArePiscina() { return arePiscina; }
    public float getRating() { return rating; }

    @Override
    public String toString() {
        return "Casa{" +
                "nume='" + nume + '\'' +
                ", suprafata=" + suprafata + " mp" +
                ", tip='" + tip + '\'' +
                ", oras='" + oras + '\'' +
                ", piscina=" + (arePiscina ? "da" : "nu") +
                ", rating=" + rating +
                '}';
    }
}