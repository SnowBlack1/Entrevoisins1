package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_ABOUT_ME_TEXT_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_ABOUT_ME_TITLE_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_ADRESS_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_AVATAR_URL_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_ID_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_NAME_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_PHONE_KEY;
import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_SOCIAL_KEY;

public class SpecificNeighbour extends AppCompatActivity {

    private Neighbour specificNeighbour;

    private ImageView avatarImg;
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

        specificNeighbour = new Neighbour(
                this.getIntent().getExtras().getInt(NEIGHBOUR_ID_KEY),
                this.getIntent().getExtras().getString(NEIGHBOUR_NAME_KEY),
                this.getIntent().getExtras().getString(NEIGHBOUR_AVATAR_URL_KEY),
                this.getIntent().getExtras().getString(NEIGHBOUR_ADRESS_KEY),
                this.getIntent().getExtras().getString(NEIGHBOUR_PHONE_KEY),
                this.getIntent().getExtras().getString(NEIGHBOUR_SOCIAL_KEY),
                this.getIntent().getExtras().getString(NEIGHBOUR_ABOUT_ME_TITLE_KEY),
                this.getIntent().getExtras().getString(NEIGHBOUR_ABOUT_ME_TEXT_KEY)
        );


        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra(NEIGHBOUR_KEY);

        if (neighbour != null) {

            avatarImg = findViewById(R.id.avatar_img);
            Glide.with(this)
                    .load(neighbour.getAvatarUrl())
                    .into(avatarImg);

            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_back_arrow_24dp);
            getSupportActionBar().setTitle(null);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

            favBtn = findViewById(R.id.fav_btn);
            if (neighbourService.getFav().contains(neighbour)) {
                favBtn.setImageResource(R.drawable.ic_star_white_24dp);
            } else {
                favBtn.setImageResource(R.drawable.ic_star_border_white_24dp);
            }

            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (neighbourService.getFav().contains(neighbour)) {
                        neighbourService.deleteFavNeighbour(neighbour);
                        favBtn.setImageResource(R.drawable.ic_star_border_white_24dp);
                    } else {
                        neighbourService.addFavNeighbour(neighbour);
                        favBtn.setImageResource(R.drawable.ic_star_white_24dp);
                    }
                }
            });


            nameAvatar = findViewById(R.id.nameavatar_txt);
            nameAvatar.setText(neighbour.getName());

            nameTitle = findViewById(R.id.name1_txt);
            nameTitle.setText(neighbour.getName());

            adress = findViewById(R.id.address_txt);
            adress.setText(neighbour.getAddress());

            phone = findViewById(R.id.phone_txt);
            phone.setText(neighbour.getPhoneNumber());

            social = findViewById(R.id.social_txt);
            social.setText(neighbour.getSocial());

            aboutMeTitle = findViewById(R.id.aboutme_title);
            aboutMeTitle.setText(neighbour.getAboutMe());

            aboutMeText = findViewById(R.id.aboutme_txt);
            aboutMeText.setText(neighbour.getAboutMeText());
        }
    }

}
