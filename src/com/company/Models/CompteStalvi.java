package com.company.Models;

import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ExceptionError;

import java.util.ArrayList;
import java.util.List;

//Faig una array list per als usuaris i li faig un numero de compte amb un deposit predeterminat
public class CompteStalvi {
    private List<Clients> usuarisC = new ArrayList<>();
    private String numCompta;
    private double deposit;


    public CompteStalvi(String numCompta) {
        this.numCompta = numCompta;
        deposit = 0;
    }

    public int addUser(Clients clients) {
        usuarisC.add(clients);
        return usuarisC.size();
    }


    //Sempre que hi ha mes d'un usuaria aplico:
    public int removeUser(String dni) throws BankAccountException {
        if (usuarisC.size() > 1) {
            usuarisC.removeIf(u -> dni.equals(u.getDNI()));
        }

        // En cas de que només hi hagi un usuari no es podrá eliminar
        else {
            throw new BankAccountException(ExceptionError.CERO_USUARIS);
        }
        return usuarisC.size();
    }

    public void ingressar(double d) {
        deposit += d;
    }

    //Sempre que l'usuari tregui diners
    public void treure(double d) throws BankAccountException {
        if (deposit - d >= 0) {
            deposit -= d;
        } else {
            throw new BankAccountException(ExceptionError.COMPTE_OBERTA);
        }
    }

    public String getNumCompta() {
        return numCompta;
    }

    public double getDeposit() {
        return deposit;
    }

    public List<Clients> getUsuarisC() {
        return usuarisC;
    }


}
