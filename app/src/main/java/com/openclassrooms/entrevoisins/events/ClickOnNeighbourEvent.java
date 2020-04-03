package com.openclassrooms.entrevoisins.events;

import android.content.Intent;
import android.view.View;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.SpecificNeighbour;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_KEY;

public class ClickOnNeighbourEvent {

    public Neighbour neighbour;

    public ClickOnNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
        //Intent intent = new Intent(v.getContext(), SpecificNeighbour.class);
        //intent.putExtra(NEIGHBOUR_KEY, neighbour);
        //v.getContext().startActivity(intent); //mettre View v en param méthode
    }


}




