package com.openclassrooms.entrevoisins.events;

import android.content.Intent;
import android.view.View;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.SpecificNeighbour;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_KEY;

public class ClickOnNeighbourEvent {

    public Neighbour neighbour;
    private View v;

    public ClickOnNeighbourEvent(Neighbour neighbour) {
       // this.neighbour = neighbour;
    }

}




