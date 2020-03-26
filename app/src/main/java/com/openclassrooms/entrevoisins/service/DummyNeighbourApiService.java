package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favNeighbour = new ArrayList<>();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * Get favorite neighbour
     */
   // @Override
   // public List<Neighbour> getFav() {
     //   return favNeighbour;
   // }

    /**
     * Delete favorite neighbour
     */
    @Override
   public void deleteFavNeighbour(Neighbour neighbour) {
       favNeighbour.remove(neighbour);

   }

    /**
     * Add favorite neighbour
     */
    //@Override
    //public void addFavNeighbour(Neighbour neighbour) {
    //    favNeighbour.add(neighbour);
//
    //}
}
