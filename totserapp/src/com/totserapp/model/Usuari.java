package com.totserapp.model;

public class Usuari{
    public String nom, nick, password, adreca, dni;
    
    public Usuari(String nom, String nick, String password, String adreca, String dni) {
        this.nom = nom;
        this.nick = nick;
        this.password = password;
        this.adreca = adreca;
        this.dni = dni;
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
