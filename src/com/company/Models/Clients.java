package com.company.Models;


import com.company.Control.Operacions;
import com.company.Exceptions.ClientAccountException;

import java.util.List;

//Per crear els clients
public class Clients {
    private String Nom;
    private String Cognoms;
    private String DNI;

    //Llisto els clients
    List<Clients> clientsList;

    //I es verifica la compta
    public Clients(String nom, String cognoms, String DNI) throws ClientAccountException {
        this.Nom = nom;
        this.Cognoms = cognoms;
        if(Operacions.verifyDNI(DNI)) this.DNI = DNI;
    }

    //Es mira si son iguals les credencials
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCognoms() {
        return Cognoms;
    }

    public void setCognoms(String cognoms) {
        Cognoms = cognoms;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Nom='" + Nom + '\'' +
                ", Cognoms='" + Cognoms + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
