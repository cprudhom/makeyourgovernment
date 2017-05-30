package gvt; /**
 * This file is part of choco-solver, http://choco-solver.org/
 *
 * Copyright (c) 2017, IMT Atlantique. All rights reserved.
 *
 * Licensed under the BSD 4-clause license.
 * See LICENSE file in the project root for full license information.
 */

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.List;

import static gvt.Constantes.AGE_MAXIMUM;
import static gvt.Constantes.AGE_MINIMUM;
import static gvt.Constantes.Competences.affaires_etrangeres;
import static gvt.Constantes.Competences.agriculture;
import static gvt.Constantes.Competences.communication;
import static gvt.Constantes.Competences.culture;
import static gvt.Constantes.Competences.defense;
import static gvt.Constantes.Competences.ecologie;
import static gvt.Constantes.Competences.economie;
import static gvt.Constantes.Competences.education;
import static gvt.Constantes.Competences.enseignement_superieur;
import static gvt.Constantes.Competences.europe;
import static gvt.Constantes.Competences.finances;
import static gvt.Constantes.Competences.industrie;
import static gvt.Constantes.Competences.interieur;
import static gvt.Constantes.Competences.justice;
import static gvt.Constantes.Competences.logement;
import static gvt.Constantes.Competences.porte_parole;
import static gvt.Constantes.Competences.sante;
import static gvt.Constantes.Competences.sport;
import static gvt.Constantes.Competences.transports;
import static gvt.Constantes.Competences.travail;
import static gvt.Constantes.Courant;
import static gvt.Constantes.Genre;
import static gvt.Constantes.MIN_MAJEURS;
import static gvt.Constantes.Ministeres;
import static gvt.Constantes.NB_COMPETENCES;
import static gvt.Constantes.NB_COURANTS;
import static gvt.Constantes.NB_GENRES;
import static gvt.Constantes.NB_MINISTERES;
import static gvt.Constantes.NB_PARCOURS;
import static gvt.Constantes.NB_PARTIS;
import static gvt.Constantes.Parcours;
import static gvt.Constantes.Parti;

/**
 * <p>
 * Project: Gouvernement.
 *
 * @author Charles Prud'homme
 * @since 17/05/2017.
 */
public class GvtMaker {

    private void run() {
        // Les donnees
        final List<Candidat> candidats = new ArrayList<Candidat>();
        candidats.add(new Candidat("Philippe",
                Genre.homme,
                52,
                Parti.LR,
                Courant.droite,
                Parcours.politique));
        candidats.add(new Candidat("Bertrand",
                Genre.homme,
                52,
                Parti.LR,
                Courant.droite,
                Parcours.politique, sante, travail));
        candidats.add(new Candidat("Ndiaye",
                Genre.femme,
                37,
                Parti.EM,
                Courant.centre,
                Parcours.societe_civile, communication, porte_parole));
        candidats.add(new Candidat("Hulot",
                Genre.homme,
                62,
                Parti.sans,
                Courant.ecologie,
                Parcours.societe_civile, ecologie));
        candidats.add(new Candidat("Orsenna",
                Genre.homme,
                70,
                Parti.EM,
                Courant.inconnu,
                Parcours.societe_civile, culture));
        candidats.add(new Candidat("Idrac",
                Genre.femme,
                65,
                Parti.LC,
                Courant.centre,
                Parcours.politique, transports, industrie
        ));
        candidats.add(new Candidat("Breton",
                Genre.homme,
                62,
                Parti.sans,
                Courant.droite,
                Parcours.politique, economie, finances, industrie));
        candidats.add(new Candidat("Lambert",
                Genre.femme,
                55,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile, agriculture));
        candidats.add(new Candidat("Bigorgne",
                Genre.homme,
                42,
                Parti.EM,
                Courant.inconnu,
                Parcours.societe_civile, education, enseignement_superieur));
        candidats.add(new Candidat("Guillou",
                Genre.femme,
                62,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile, agriculture));
        candidats.add(new Candidat("Panosyan",
                Genre.femme,
                45,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile, logement, industrie));
        candidats.add(new Candidat("Tessandier",
                Genre.femme,
                36,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile, communication));
        candidats.add(new Candidat("Dumas",
                Genre.femme,
                54,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile, culture, communication));
        candidats.add(new Candidat("Castéra Oudéa",
                Genre.femme,
                38,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile, sport));
        candidats.add(new Candidat("Bayrou",
                Genre.homme,
                65,
                Parti.MODEM,
                Courant.centre,
                Parcours.politique, education, justice));
        candidats.add(new Candidat("Le Drian",
                Genre.homme,
                69,
                Parti.PS,
                Courant.gauche,
                Parcours.politique, defense));
        candidats.add(new Candidat("Collomb",
                Genre.homme,
                69,
                Parti.LR,
                Courant.droite,
                Parcours.politique, interieur));
        candidats.add(new Candidat("Ferrand",
                Genre.homme,
                54,
                Parti.EM,
                Courant.centre,
                Parcours.politique,
                communication, travail));
        candidats.add(new Candidat("Le Maire",
                Genre.homme,
                48,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                agriculture, europe, affaires_etrangeres));

        candidats.add(new Candidat("Goulard",
                Genre.femme,
                52,
                Parti.MODEM,
                Courant.centre,
                Parcours.politique,
                europe, affaires_etrangeres));

        candidats.add(new Candidat("Lepage",
                Genre.femme,
                66,
                Parti.MODEM,
                Courant.centre,
                Parcours.politique,
                ecologie, education));
        candidats.add(new Candidat("Sarnez",
                Genre.femme,
                66,
                Parti.MODEM,
                Courant.centre,
                Parcours.politique,
                europe, industrie));

        candidats.add(new Candidat("Riester",
                Genre.homme,
                43,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                culture, communication));
        candidats.add(new Candidat("Robinet",
                Genre.homme,
                42,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                sante));
        candidats.add(new Candidat("Kosciusko",
                Genre.femme,
                44,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                ecologie, transports, logement, porte_parole));

        candidats.add(new Candidat("Castaner",
                Genre.homme,
                51,
                Parti.EM,
                Courant.centre,
                Parcours.politique,
                culture, economie, finances));

        candidats.add(new Candidat("Apparu",
                Genre.homme,
                47,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                logement));
        candidats.add(new Candidat("Buzyn",
                Genre.femme,
                54,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile,
                sante));
        candidats.add(new Candidat("Nyssen",
                Genre.femme,
                65,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile,
                culture));
        candidats.add(new Candidat("Penicaud",
                Genre.femme,
                62,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile,
                travail, economie));
        candidats.add(new Candidat("Blanquer",
                Genre.homme,
                52,
                Parti.sans,
                Courant.droite,
                Parcours.politique,
                education));
        candidats.add(new Candidat("Mézard",
                Genre.homme,
                69,
                Parti.RG,
                Courant.gauche,
                Parcours.politique,
                agriculture));
        candidats.add(new Candidat("Darmanin",
                Genre.homme,
                34,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                sport));
        candidats.add(new Candidat("Vidal",
                Genre.femme,
                53,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile,
                enseignement_superieur));
        candidats.add(new Candidat("Girardin",
                Genre.femme,
                53,
                Parti.RG,
                Courant.gauche,
                Parcours.politique));
        candidats.add(new Candidat("Flessel",
                Genre.femme,
                45,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile,
                sport));
        candidats.add(new Candidat("Borne",
                Genre.femme,
                56,
                Parti.sans,
                Courant.inconnu,
                Parcours.politique,
                travail, economie));


        candidats.add(new Candidat("Raffarin",
                Genre.homme,
                68,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                sante,
                interieur,
                porte_parole,
                ecologie,
                transports,
                economie,
                finances,
                education,
                enseignement_superieur,
                logement,
                industrie,
                culture,
                communication,
                justice,
                sport,
                defense,
                travail,
                agriculture,
                europe,
                affaires_etrangeres));

        candidats.add(new Candidat("Borloo",
                Genre.homme,
                66,
                Parti.UDI,
                Courant.centre,
                Parcours.politique,
                ecologie, economie, finances, logement, travail
        ));
        candidats.add(new Candidat("Azoulay",
                Genre.femme,
                44,
                Parti.PS,
                Courant.gauche,
                Parcours.politique,
                culture, communication));

        candidats.add(new Candidat("Delevoye",
                Genre.homme,
                70,
                Parti.EM,
                Courant.centre,
                Parcours.politique,
                economie, ecologie, justice));

        candidats.add(new Candidat("Lemoyne",
                Genre.homme,
                39,
                Parti.EM,
                Courant.centre,
                Parcours.politique,
                agriculture));

        candidats.add(new Candidat("Lanxade",
                Genre.homme,
                46,
                Parti.sans,
                Courant.inconnu,
                Parcours.societe_civile,
                economie, industrie
        ));
        candidats.add(new Candidat("Montchamp",
                Genre.femme,
                59,
                Parti.LR,
                Courant.droite,
                Parcours.politique,
                sante, sport
        ));



        int nb_candidats = candidats.size();

        int[][] competences_croisees = new int[NB_MINISTERES][nb_candidats];
        for(Ministeres ministere : Ministeres.values()){
            for(int i = 0 ; i < nb_candidats;i++){
                int compt = 0;
                for(Constantes.Competences comp : ministere.competences){
                    if(candidats.get(i).competences.contains(comp)){
                        compt++;
                    }
                }
                competences_croisees[ministere.ordinal()][i] = compt>0?1:0;
            }
        }

        int taux_min_femmes = 40; // pour cent
        int taux_max_femmes = 60; // pour cent
        int seuil_age_minimum = 45;
        int seuil_age_maximum = 55;
        int ecart_age_maximum = 30;
        int taux_soc_civile = 33; // pour cent
        int taux_EM = 33; // pour cent

        Model model = new Model();
        // Les variables
        // Il y 15 ministeres à pourvoir y compris celui du premier ministre
        // chaque ministere a pour domaine une liste de candidats, par défaut tous les candidats
        final IntVar[] ministeres = model.intVarArray(NB_MINISTERES, 0, nb_candidats - 1);
        // Indique le genre du ministre a la tete du ieme ministere
        IntVar[] genreMinistre = model.intVarArray(NB_MINISTERES, 0, NB_GENRES - 1);
        // Indique le courant du ministre a la tete du ieme ministere
        IntVar[] courantMinistre = model.intVarArray(NB_MINISTERES, 0, NB_COURANTS - 1);
        // Indique le parti du ministre a la tete du ieme ministere
        IntVar[] partiMinistre = model.intVarArray(NB_MINISTERES, 0, NB_PARTIS - 1);
        // Indique le parcours du ministre a la tete du ieme ministere
        IntVar[] parcoursMinistre = model.intVarArray(NB_MINISTERES, 0, NB_PARCOURS - 1);
        // Indique l'age du ministre a la tete du ieme ministere
        IntVar[] ageMinistre = model.intVarArray(NB_MINISTERES, AGE_MINIMUM, AGE_MAXIMUM);
        // Indique le score de competence du ministre a la tete du ieme ministere
        IntVar[] scoreMinistre = model.intVarArray(NB_MINISTERES, 0, NB_COMPETENCES - 1);

        // Definit l'encadrement du nombre de femmes dans le gouvernement
        IntVar nb_femmes = model.intVar("nombre de femmes ministres",
                taux_min_femmes * NB_MINISTERES / 100,
                taux_max_femmes * NB_MINISTERES / 100);
        // Definit l'encadrement de l'age moyen des ministres
        // pour eviter une division, on encadre la somme des ages
        IntVar ages_cumules = model.intVar("sommes des ages des ministres",
                seuil_age_minimum * NB_MINISTERES,
                seuil_age_maximum * NB_MINISTERES);
        // Definit l'age du plus jeune ministre et du plus vieux
        IntVar age_min = model.intVar("age du plus jeune ministre",
                AGE_MINIMUM, AGE_MAXIMUM);
        IntVar age_max = model.intVar("age du plus vieuw ministre",
                AGE_MINIMUM, AGE_MAXIMUM);
        // Definit le nombre de ministres de droite (ou de gauche) dans le gouverment
        // Une seule variable qui induit l'égalité entre les deux compteurs
        IntVar equilibre_dr_ga = model.intVar("nombre de minisitres de droite/gauche", 0, NB_MINISTERES);
        // Definit le nombre de ministres du centre dans le gouverment
        IntVar nb_centre = model.intVar("nombre de minisitres du centre", 0, NB_MINISTERES);
        // Indique le courant du ministre a la tete du ieme ministere, parmi les ministeres majeures
        IntVar[] courantMinistreMajeur = new IntVar[MIN_MAJEURS.size()];
        int k = 0;
        for (Ministeres ministere : Ministeres.values()) {
            if (MIN_MAJEURS.contains(ministere)) {
                courantMinistreMajeur[k++] = courantMinistre[ministere.ordinal()];
            }
        }


        // channeling
        int[] genres = candidats.stream().mapToInt(c -> c.genre.ordinal()).toArray();
        int[] courants = candidats.stream().mapToInt(c -> c.courant.ordinal()).toArray();
        int[] partis = candidats.stream().mapToInt(c -> c.parti.ordinal()).toArray();
        int[] parcours = candidats.stream().mapToInt(c -> c.parcours.ordinal()).toArray();
        int[] ages = candidats.stream().mapToInt(c -> c.age).toArray();
        for (Ministeres ministere : Ministeres.values()) {
            int i = ministere.ordinal();
            model.element(genreMinistre[i], genres, ministeres[i]).post();
            model.element(courantMinistre[i], courants, ministeres[i]).post();
            model.element(partiMinistre[i], partis, ministeres[i]).post();
            model.element(parcoursMinistre[i], parcours, ministeres[i]).post();
            model.element(ageMinistre[i], ages, ministeres[i]).post();
        }

        // Les contraintes
        // a. tous les ministeres doivent etre pourvus par un seul ministre, inherent au modele
        // b. un ministre ne peut etre a la tete que d'un seul ministere (contrainte "tous differents"):
        model.allDifferent(ministeres).post();
        // c. parite, encadre le nombre de femmes dans le gouvernement
        model.count(Genre.femme.ordinal(), genreMinistre, nb_femmes).post();
        // d. l'age moyen des ministres doit etre compris entre 45 ans et 55 ans
        // pour eviter une division, on encadre la somme des ages
        model.sum(ageMinistre, "=", ages_cumules).post();
        // e. l'écart maximum entre le plus jeune ministre et le doyen.ne doit dépasser 22 ans
        model.min(age_min, ageMinistre).post();
        model.max(age_max, ageMinistre).post();
        model.arithm(age_max, "-", age_min, ">=", ecart_age_maximum).post();

        // f. la répartition par courant sur l'ensemble des ministères doit respecter les règles suivantes:
        // f1. un tiers des ministres doit être issu de la société civile
        model.count(Parcours.societe_civile.ordinal(), parcoursMinistre,
                model.intVar(taux_soc_civile * NB_MINISTERES / 100, NB_MINISTERES)).post();
        // f2. chaque courant doit être représenté
        model.nValues(courantMinistre, model.intVar(NB_COURANTS)).post();
        // f3. le "parti" EM doit représenter plus du tiers des ministres
        model.count(Parti.EM.ordinal(), partiMinistre,
                model.intVar(taux_EM * NB_MINISTERES / 100, NB_MINISTERES)).post();

        // g. la répartition par courant sur les 7 ministères "majeurs" (incluant le PM) doit respecter les règles suivantes:
        // g1.  autant de ministre de droite que de gauche
        model.count(Courant.droite.ordinal(), courantMinistreMajeur, equilibre_dr_ga).post();
        model.count(Courant.gauche.ordinal(), courantMinistreMajeur, equilibre_dr_ga).post();
        // g2. plus de ministres du centre que de droite et gauche réunis
        model.count(Courant.centre.ordinal(), courantMinistreMajeur, nb_centre).post();
        model.arithm(nb_centre, "=", equilibre_dr_ga, "*", 2).post();

        // h. considérer les compétences requises pour être à la tête d'un ministère
        for (Ministeres ministere : Ministeres.values()) {
            int i = ministere.ordinal();
            model.element(scoreMinistre[i], competences_croisees[i], ministeres[i]).post();
        }

        // le PM est connu
        ministeres[Ministeres.Premier_ministre.ordinal()]
                .eq(findPos("Philippe", candidats)).post();

        // L'objectif
        // Indique le score du gouvernement
        IntVar scoreGouvernement = model.intVar("score du gouvernement", 0, NB_MINISTERES * NB_COMPETENCES);
        model.sum(scoreMinistre, "=", scoreGouvernement).post();

        model.setObjective(true, scoreGouvernement);
        // La résolution

//        ministeres[Interieur.ordinal()].eq(findPos("Collomb", candidats)).post();
//        ministeres[Armees.ordinal()].eq(findPos("Goulard", candidats)).post();
//        ministeres[Justice.ordinal()].eq(findPos("Bayrou", candidats)).post();
//        ministeres[Education_Nationale.ordinal()].eq(findPos("Blanquer", candidats)).post();
//        ministeres[Economie.ordinal()].eq(findPos("Le Maire", candidats)).post();
//        ministeres[Europe_Affaires_Etrangeres.ordinal()].eq(findPos("Le Drian", candidats)).post();
//        ministeres[Sante.ordinal()].eq(findPos("Buzyn", candidats)).post();
//        ministeres[Travail_Emploi.ordinal()].eq(findPos("Penicaud", candidats)).post();
//        ministeres[Agriculture.ordinal()].eq(findPos("Mézard", candidats)).post();
//        ministeres[Culture.ordinal()].eq(findPos("Nyssen", candidats)).post();
//        ministeres[Transition_Ecologique.ordinal()].eq(findPos("Hulot", candidats)).post();
//        ministeres[Sports.ordinal()].eq(findPos("Flessel", candidats)).post();
//        ministeres[Enseignement_Superieur.ordinal()].eq(findPos("Vidal", candidats)).post();
//        ministeres[Action_Comptes_Publics.ordinal()].eq(findPos("Darmanin", candidats)).post();
//        ministeres[Cohésion_Territoires.ordinal()].eq(findPos("Ferrand", candidats)).post();
//        ministeres[Outre_Mer.ordinal()].eq(findPos("Girardin", candidats)).post();
//        ministeres[Transition_Ecologique_Transports.ordinal()].eq(findPos("Borne", candidats)).post();
//        ministeres[Affaires_Européennes.ordinal()].eq(findPos("Sarnez", candidats)).post();



        Solver solver = model.getSolver();
        solver.showShortStatistics();
        while(solver.solve()) {
            System.out.printf("\nGouvernement #%d (score : %d)\n", solver.getSolutionCount(), scoreGouvernement.getValue());
            // L'affichage
            for (Ministeres ministere : Ministeres.values()) {
                System.out.printf("%s : %s (score: %d)\n",
                        ministere.toString(),
                        candidats.get(ministeres[ministere.ordinal()].getValue()).toString(),
                        scoreMinistre[ministere.ordinal()].getValue()
                        );
            }
            System.out.printf("Nb femmes: %d / %d\n", nb_femmes.getValue(), NB_MINISTERES);
            System.out.printf("Age moyen: %.2f\n", ages_cumules.getValue() / (NB_MINISTERES * 1f));
            System.out.printf("Age min.: %d\n", age_min.getValue());
            System.out.printf("Age max.: %d\n", age_max.getValue());
            System.out.printf("Eq. D/G.: %d\n", equilibre_dr_ga.getValue());
            System.out.printf("Nb centre.: %d\n", nb_centre.getValue());
        }
    }

    private int findPos(String s, List<Candidat> candidats) {
        for (int i = 0; i < candidats.size(); i++) {
            if (candidats.get(i).nom.equals(s)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        new GvtMaker().run();
    }
}
