/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import laFerme.entity.Fermier;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class NourirService2 {

    public String nourirFermier(String ressourcePrNourir, Fermier fermier) {

        switch (ressourcePrNourir) {
            case "Ble":
                
                
            case "Carotte":

            case "Chevre":

            case "Fromage":
                
            default:

                return ("Echange impossible. Vous avez mal renseigner les ressources a echanger !");
        }
    }
}
