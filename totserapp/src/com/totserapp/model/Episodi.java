package com.totserapp.model;

import java.util.HashMap;

public class Episodi {
    private HashMap<String, Valoracio> valoracions = new HashMap<>();
    
    private String title, idioma, description, data, duration;

    public Episodi(String title, String idioma, String description, String data, String duration) {
        this.title = title;
        this.idioma = idioma;
        this.description = description;
        this.data = data;
        this.duration = duration;
    }
    
    @Override
    public String toString(){
//        System.out.println("\nTitol: " + title);
//        System.out.println("--------------------------------------------------");
//        System.out.println("Duració; " + duration);
//        System.out.println("Data d'estrena: " + data);
//        System.out.println("Idioma: " + idioma);
//        System.out.println(description);
        return "Episodi";
    }
    

    public HashMap<String, Valoracio> getValoracions() {
        return valoracions;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
