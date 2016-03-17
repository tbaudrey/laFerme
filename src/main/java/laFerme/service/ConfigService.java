/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {
    private final int nbrCarotteDebutPartie=3;
    private final int nbrBleDebutPartie=3;
    
    private final int bInfProductionBlePlantee = 3;
    private final int bSupProductionBlePlantee = 4;
    private final int NbrMoisAvantRecolteBle = 6;

    private final int bInfProductionCarottePlantee = 2;
    private final int bSupProductionCarottePlantee = 3;
    private final int NbrMoisAvantRecolteCarotte = 6;

    private final int NbrMoisAvantNaissanceChevreau = 12;

    private final int bInfProductionFromage = 2;
    private final int bSupProductionFromage = 3;
    private final int NbrMoisAvantRecolteFromage = 6;

    private final int NbrMoisAvantMortChevreSiNonNourrie = 3;
    private final int NbrMoisAvantMortFermierSiNonNourrie=3;
    
    private final int valeurBleVSCarotte=2;
    private final int valeurBleVSChevre=4;
    private final int valeurCarotteVSChevre=2;
    
    private final int nbrBleNourirFermier=3;
    private final int nbrCarotteNourirFermier=2;
    private final int nbrChevreNourirFermier=2;
    private final int nbrFromageNourirFermier=1;
    private final int nbrBleNourirChevre=1;

    public int getNbrBleNourirChevre() {
        return nbrBleNourirChevre;
    }
    public int getNbrBleNourirFermier() {
        return nbrBleNourirFermier;
    }

    public int getNbrCarotteNourirFermier() {
        return nbrCarotteNourirFermier;
    }

    public int getNbrChevreNourirFermier() {
        return nbrChevreNourirFermier;
    }

    public int getNbrFromageNourirFermier() {
        return nbrFromageNourirFermier;
    }

    public int getValeurCarotteVSChevre() {
        return valeurCarotteVSChevre;
    }

    public int getNbrCarotteDebutPartie() {
        return nbrCarotteDebutPartie;
    }

    public int getNbrBleDebutPartie() {
        return nbrBleDebutPartie;
    }

    public int getValeurBleVSCarotte() {
        return valeurBleVSCarotte;
    }

    public int getValeurBleVSChevre() {
        return valeurBleVSChevre;
    }

    public int getbInfProductionBlePlantee() {
        return bInfProductionBlePlantee;
    }

    public int getbSupProductionBlePlantee() {
        return bSupProductionBlePlantee;
    }

    public int getNbrMoisAvantRecolteBle() {
        return NbrMoisAvantRecolteBle;
    }

    public int getbInfProductionCarottePlantee() {
        return bInfProductionCarottePlantee;
    }

    public int getbSupProductionCarottePlantee() {
        return bSupProductionCarottePlantee;
    }

    public int getNbrMoisAvantRecolteCarotte() {
        return NbrMoisAvantRecolteCarotte;
    }

    public int getNbrMoisAvantNaissanceChevreau() {
        return NbrMoisAvantNaissanceChevreau;
    }

    public int getbInfProductionFromage() {
        return bInfProductionFromage;
    }

    public int getbSupProductionFromage() {
        return bSupProductionFromage;
    }

    public int getNbrMoisAvantRecolteFromage() {
        return NbrMoisAvantRecolteFromage;
    }

    public int getNbrMoisAvantMortChevreSiNonNourrie() {
        return NbrMoisAvantMortChevreSiNonNourrie;
    }

    public int getNbrMoisAvantMortFermierSiNonNourrie() {
        return NbrMoisAvantMortFermierSiNonNourrie;
    }
    
    
}
