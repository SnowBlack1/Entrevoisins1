package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Delete favorite neighbour
     *@param neighbour
     * */

    void deleteFavNeighbour(Neighbour neighbour);

    /** Get favorite neighbour*/
     List<Neighbour> getFav();

    /** Add favorite neighbour
     * @param neighbour*/

    void addFav(Neighbour neighbour);

}
