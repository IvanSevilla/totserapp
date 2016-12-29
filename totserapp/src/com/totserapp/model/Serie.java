
package com.totserapp.model;

import java.util.ArrayList;

public class Serie {
    private final ArrayList<Artista> artistes = new ArrayList<>();
    private final ArrayList<Episodi> episodis = new ArrayList<>();
    private ArrayList<Valoracio> valoracions = new ArrayList<>();
    
    private Productora productora;

    private String titol, descripcio;
    
    private int  visualitzacions;
    private float valoració;
    
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

    public float getValoració() {
        return valoració;
    }

    public void setValoració(float valoració) {
        this.valoració = valoració;
    }

    public int getVisualitzacions() {
        return visualitzacions;
    }

    public void setVisualitzacions(int visualitzacions) {
        this.visualitzacions = visualitzacions;
    }
    
    public void valorar(Usuari usuari, int valor){
        valoracions.add(new Valoracio(valor, null));
    }

    public ArrayList<Valoracio> getValoracions() {
        return valoracions;
    }
}
