package gvt; /**
 * This file is part of choco-solver, http://choco-solver.org/
 *
 * Copyright (c) 2017, IMT Atlantique. All rights reserved.
 *
 * Licensed under the BSD 4-clause license.
 * See LICENSE file in the project root for full license information.
 */

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Project: Gouvernement.
 *
 * @author Charles Prud'homme
 * @since 17/05/2017.
 */
public class Candidat {

    String nom;
    int age;
    Constantes.Parti parti;
    Constantes.Courant courant;
    List<Constantes.Competences> competences;
    Constantes.Genre genre;
    Constantes.Parcours parcours;


    public Candidat(String nom, Constantes.Genre genre, int age, Constantes.Parti parti,
                    Constantes.Courant courant,
                    Constantes.Parcours parcours, Constantes.Competences... competences) {
        this.nom = nom;
        this.age = age;
        this.parti = parti;
        this.courant = courant;
        this.competences = Arrays.asList(competences);
        this.genre = genre;
        this.parcours = parcours;
    }

    @Override
    public String toString() {
        return nom + " ("+genre+"), "+age + " ans, "+parti;
    }
}
