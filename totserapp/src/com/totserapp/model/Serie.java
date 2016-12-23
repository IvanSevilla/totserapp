
package com.totserapp.model;

import java.util.ArrayList;

public class Serie {
    private final ArrayList<Artista> artistes = new ArrayList<>();
    private final ArrayList<Episodi> episodis = new ArrayList<>();
    
    private Productora productora;

    private String titol, descripcio;
    
    private int valoració;
    
    public ArrayList<Episodi> getEpisodis() {
        return episodis;
    }
    public ArrayList<Artista> getArtistes() {
        return artistes;
    }

    public Serie(String titol, String descripcio) {
        this.titol = titol;
        this.descripcio = descripcio;
    }
    
    @Override
    public String toString(){
        String out = "";
        out += "Titol: " + titol;
        out += "\nDescripció: " + descripcio;
        return out;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setProductora(Productora productora) {
        this.productora = productora;
    }
    
    public Productora getProductora(){
        return productora;
    }

    public int getValoració() {
        return valoració;
    }

    public void setValoració(int valoració) {
        this.valoració = valoració;
    }
   
}
