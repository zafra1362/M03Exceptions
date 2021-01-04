package com.company;

import com.company.Control.Operacions;
import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ClientAccountException;
import com.company.Models.Clients;
import com.company.Models.CompteStalvi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClientAccountException, BankAccountException {

        Scanner scanner = new Scanner(System.in);

        //Creo 2 comptes i les llisto
        CompteStalvi compte1 = new CompteStalvi("000000009");
        CompteStalvi compte2 = new CompteStalvi("695479275");


        List<CompteStalvi> llistaStalvi = new ArrayList<>(Arrays.asList(compte1,compte2));

        llistaStalvi.addAll(llistaStalvi);

        compte1.ingressar(14);
        compte2.ingressar(10);
        Clients client = null;

        //Faig el menu
        int opcio;

        do{
            System.out.println("1.- Client");
            System.out.println("2.- Treure");
            System.out.println("3.- Verificar");
            System.out.println("4.- Transferencia");
            System.out.println("5.- Usuaris");
            System.out.println("6.- Surt");

            System.out.print("Introdueix una opció: ");
            opcio = scanner.nextInt();

            switch (opcio){
                case 1:
                    client = new Clients("Ramon", "Medina,Zafra", "543978123Z");
                    break;

                case 2:
                    compte2.treure(5000);
                    break;

                case 3:
                    Operacions.verifyAccount(compte2);
                    break;

                case 4:
                    Operacions.transferencia(compte1,compte2,1362);
                    break;

                case 5:
                    compte1.getUsuarisC();
                    break;

                case 6:
                    break;

            }
        } while (opcio != 6);
    }
}