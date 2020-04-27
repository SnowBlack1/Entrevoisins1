package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(

            //For Caroline's aboutMeTxt, it's a text in order to test ScrollView
            new Neighbour((long) 1, "Caroline", "https://i.pravatar.cc/300?u=a042581f4e29026704d", "Saint-Pierre-du-Mont, 5km", "+33 6 86 57 90 14", "www.facebook.fr/Caroline",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                    "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                    " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\" "),

            new Neighbour((long) 2, "Jack", "https://i.pravatar.cc/300?u=a042581f4e29026704e", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Jack",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 3, "Chloé", "https://i.pravatar.cc/300?u=a042581f4e29026704f", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Chloé",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 4, "Vincent", "https://i.pravatar.cc/300?u=a042581f4e29026704a", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Vincent",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 5, "Elodie", "https://i.pravatar.cc/300?u=a042581f4e29026704b", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Elodie",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 6, "Sylvain", "https://i.pravatar.cc/300?u=a042581f4e29026704c", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Sylvain",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 7, "Laetitia", "https://i.pravatar.cc/300?u=a042581f4e29026703d", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Laetitia",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 8, "Dan", "https://i.pravatar.cc/300?u=a042581f4e29026703b", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Dan",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 9, "Joseph", "https://i.pravatar.cc/300?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Joseph",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 10, "Emma", "https://i.pravatar.cc/300?u=a042581f4e29026706d", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Emma",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 11, "Patrick", "https://i.pravatar.cc/300?u=a042581f4e29026702d", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Patrick",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.."),

            new Neighbour((long) 12, "Ludovic", "https://i.pravatar.cc/300?u=a042581f3e39026702d", "Saint-Pierre-du-Mont ; 5km", "+33 6 86 57 90 14", "www.facebook.fr/Ludovic",
                     "Bonjour !Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot..")
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}
