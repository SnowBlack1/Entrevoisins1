package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_neighbour);



        avatar = findViewById(R.id.avatar_img);

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
