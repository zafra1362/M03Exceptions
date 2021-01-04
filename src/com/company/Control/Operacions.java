package com.company.Control;
import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ClientAccountException;
import com.company.Models.CompteStalvi;

import java.util.ArrayList;
import java.util.List;

import static com.company.Exceptions.ExceptionError.*;

//Es crea una llista de les comptes stalvi
public class Operacions {

    static List <CompteStalvi> llistaCStalvi = new ArrayList<>();

    //Verifico la compta amb un boolea
    public static boolean verifyAccount(CompteStalvi numCompte) throws BankAccountException {

        if(!llistaCStalvi.contains(numCompte)){
            throw new BankAccountException(COMPTE_NO_EXISTENT);
        }else{
            return false;
        }
    }

    //Es verifica el DNI en cas d'error surt el missatge
    public static boolean verifyDNI(String DNI) throws ClientAccountException {
        if(DNI.length() != 9){
            throw new ClientAccountException(DNI_ERROR);
        }
        else {return true;}
    }

    //Creo els ingressos i transferencies entre comptes
    public static void transferencia (CompteStalvi compta1, CompteStalvi compta2, double deposit) throws BankAccountException {
        if (compta1.getDeposit() >= deposit) {
            compta1.treure(deposit);
            compta2.ingressar(deposit);
        } else {
            throw new BankAccountException(ERROR_AL_TRANSFERIR);
        }
    }
}
