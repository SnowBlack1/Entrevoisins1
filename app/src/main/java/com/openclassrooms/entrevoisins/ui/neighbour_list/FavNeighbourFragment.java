package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavNeighbourFragment extends Fragment {
    private NeighbourApiService mApiService;
    private List<Neighbour> mFavoriteNeighbours;
    private RecyclerView mRecyclerView;


    //Create & return a new instance of the fragment
    public static FavNeighbourFragment newInstance() {
        FavNeighbourFragment fragment = new FavNeighbourFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neighbour_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        //initList();

        initFavoriteList();

        return view;
    }

    private void initFavoriteList() {
        SharedPreferences mPreferences = getContext().getSharedPreferences("SharedPref",Context.MODE_PRIVATE);
        mPreferences.getAll();

        mFavoriteNeighbours = new ArrayList<>();

        if (mPreferences.getAll().isEmpty()) {
        } else {
            for (String s : mPreferences.getAll().keySet()) {
                for (Neighbour n : mApiService.getNeighbours())
                    if (n.getId() == Integer.parseInt(s)) {
                        mFavoriteNeighbours.add(n);
                    }
            }
        }

        if (mFavoriteNeighbours == null) {
        } else {
            mRecyclerView.setAdapter(new NeighbourRecyclerViewAdapter(mFavoriteNeighbours));
        }

    }

    // Refreshing view when user uses app
    @Override
    public void onResume() {
        super.onResume();
        initFavoriteList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     *
     * @param event
     */
    @Subscribe
    public void onDeleteNeighbour(DeleteNeighbourEvent event) {
        mApiService.deleteFavNeighbour(event.neighbour);
        mApiService.deleteNeighbour(event.neighbour);
        initFavoriteList();
    }
}
