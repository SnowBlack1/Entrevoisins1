package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;

import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class SpecificNeighbour extends AppCompatActivity {

    private ImageView avatar;
    private TextView nameAvatar;
    private TextView nameTitle;
    private TextView adress;
    private TextView phone;
    private TextView social;
    private TextView aboutMeTitle;
    private TextView aboutMeText;
    private FloatingActionButton favBtn;
    private NeighbourApiService neighbourService;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_neighbour);
        neighbourService = DI.getNeighbourApiService();


        avatar = findViewById(R.id.avatar);
        //Glide.with(this)
                //.load(neighbour.getAvatarUrl())
                //.into(avatar);

        //toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //toolbar.setNavigationIcon(R.drawable.);
        //toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //finish();
            //}
        //});

        avatar = findViewById(R.id.avatar_img);
        //Glide.with(this)
               // .load(neighbour.getAvatarUrl())
              //  .into(avatar);

        nameAvatar = findViewById(R.id.nameavatar_txt);
        //nameAvatar.setText();

        nameTitle = findViewById(R.id.name1_txt);
        adress = findViewById(R.id.address_txt);
        phone = findViewById(R.id.phone_txt);
        social = findViewById(R.id.social_txt);
        aboutMeTitle = findViewById(R.id.aboutme_title);
        aboutMeText = findViewById(R.id.aboutme_txt);
    }


}
