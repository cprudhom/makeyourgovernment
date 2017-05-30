package gvt; /**
 * This file is part of choco-solver_ http://choco-solver.org/
 *
 * Copyright (c) 2017_ IMT Atlantique. All rights reserved.
 *
 * Licensed under the BSD 4-clause license.
 * See LICENSE file in the project root for full license information.
 */

import java.util.ArrayList;
import java.util.List;

import static gvt.Constantes.Ministeres.Armees;
import static gvt.Constantes.Ministeres.Economie;
import static gvt.Constantes.Ministeres.Education_Nationale;
import static gvt.Constantes.Ministeres.Europe_Affaires_Etrangeres;
import static gvt.Constantes.Ministeres.Interieur;
import static gvt.Constantes.Ministeres.Justice;
import static gvt.Constantes.Ministeres.Premier_ministre;

/**
 * <p>
 * Project: Gouvernement.
 *
 * @author Charles Prud_homme
 * @since 17/05/2017.
 */
public class Constantes {

    public static int AGE_MINIMUM = 18;
    public static int AGE_MAXIMUM = 99;


    enum Competences {
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
        affaires_etrangeres,
    }

    public static final int NB_COMPETENCES = Competences.values().length;

    enum Courant {
        droite,
        gauche,
        centre,
        ecologie,
        inconnu,
    }

    public static final int NB_COURANTS = Courant.values().length;

    enum Parti {
        LR,
        PS,
        EM,
        LC,
        RG,
        UDI,
        EELV,
        MODEM,
        sans
    }

    public static final int NB_PARTIS = Parti.values().length;

    enum Genre {
        femme,
        homme
    }

    public static final int NB_GENRES = Genre.values().length;

    enum Parcours {
        politique,
        societe_civile
    }

    public static final int NB_PARCOURS = Parcours.values().length;

    enum Ministeres {
        Premier_ministre,
        Interieur(Competences.interieur),
        Armees(Competences.defense),
        Justice(Competences.justice),
        Education_Nationale(Competences.education),
        Economie(Competences.finances, Competences.economie, Competences.industrie),
        Europe_Affaires_Etrangeres(Competences.affaires_etrangeres,Competences.europe),
        Sante(Competences.sante),
        Travail_Emploi(Competences.travail),
        Agriculture(Competences.agriculture),
        Culture(Competences.culture),
        Transition_Ecologique(Competences.ecologie),
        Sports(Competences.sport),
        Enseignement_Superieur(Competences.enseignement_superieur),
        Action_Comptes_Publics,
        Cohésion_Territoires,
        Outre_Mer,
        Transition_Ecologique_Transports(Competences.transports, Competences.ecologie),
        Affaires_Européennes(Competences.affaires_etrangeres,Competences.europe)
        ;
        Competences[] competences;

        Ministeres(Competences... competences) {
            this.competences = competences;
        }
    }

    public static final int NB_MINISTERES = Ministeres.values().length;

    public static List MIN_MAJEURS = new ArrayList() {
        {
            add(Premier_ministre);
            add(Interieur);
            add(Armees);
            add(Justice);
            add(Education_Nationale);
            add(Economie);
            add(Europe_Affaires_Etrangeres);
        }
    };

}
