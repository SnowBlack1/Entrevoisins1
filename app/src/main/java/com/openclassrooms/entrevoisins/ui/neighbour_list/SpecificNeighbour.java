package com.openclassrooms.entrevoisins.ui.neighbour_list;

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
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.openclassrooms.entrevoisins.Utils.Constants.NEIGHBOUR_KEY;


public class SpecificNeighbour extends AppCompatActivity {

    @BindView(R.id.nameavatar_txt)
    TextView nameAvatar;
    @BindView(R.id.name1_txt)
    TextView nameTitle;
    @BindView(R.id.address_txt)
    TextView adress;
    @BindView(R.id.phone_txt)
    TextView phone;
    @BindView(R.id.social_txt)
    TextView social;
    @BindView(R.id.aboutme_title)
    TextView aboutMeTitle;
    @BindView(R.id.aboutme_txt)
    TextView aboutMeText;
    @BindView(R.id.fav_btn)
    FloatingActionButton favBtn;
    @BindView(R.id.avatar_img)
    ImageView avatarImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private NeighbourApiService neighbourService;
    Neighbour neighbour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_neighbour);
        ButterKnife.bind(this);
        neighbourService = DI.getNeighbourApiService();

        neighbour = (Neighbour) getIntent().getSerializableExtra(NEIGHBOUR_KEY);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow_24dp);
        getSupportActionBar().setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        displayFavBtn();
        setNeighbourDetails();
    }


    private void displayFavBtn() {
        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (neighbourService.getFav().contains(neighbour)) {
                    neighbourService.deleteFavNeighbour(neighbour);
                    favBtn.setImageResource(R.drawable.ic_empty_star_24dp);
                } else {
                    neighbourService.addFav(neighbour);
                    favBtn.setImageResource(R.drawable.ic_yellow_star_24dp);
                }
            }
        });
    }

    private void setNeighbourDetails() {
        Glide.with(this)
                .load(neighbour.getAvatarUrl())
                .into(avatarImg);
        nameAvatar.setText(neighbour.getName());
        nameTitle.setText(neighbour.getName());
        adress.setText(neighbour.getAddress());
        phone.setText(neighbour.getPhoneNumber());
        social.setText(neighbour.getSocial());
        aboutMeTitle.setText(neighbour.getAboutMe());
        aboutMeText.setText(neighbour.getAboutMeText());
    }
}

