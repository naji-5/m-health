package bishodroid.com.gymapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import bishodroid.com.gymapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView profile, workouts, meals, calendar, music, cardio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.main_profile);
        profile.setOnClickListener(this);
        workouts = findViewById(R.id.workouts_chest);
        workouts.setOnClickListener(this);
        meals = findViewById(R.id.main_meals);
        meals.setOnClickListener(this);
        calendar = findViewById(R.id.main_calendar);
        calendar.setOnClickListener(this);
        music = findViewById(R.id.main_music);
        music.setOnClickListener(this);
        cardio = findViewById(R.id.main_cardio);
        cardio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_profile:
                startActivity(new Intent(MainActivity.this, Profile.class));
                break;
            case R.id.workouts_chest:
                startActivity(new Intent(MainActivity.this, Workouts.class));
                break;
            case R.id.main_meals:
                startActivity(new Intent(MainActivity.this, Meals.class ));
                break;
            case R.id.main_calendar:
                //startActivity(new Intent(MainActivity.this, ));
                break;
            case R.id.main_music:
                startActivity(new Intent(MainActivity.this, Music.class));
                break;
            case R.id.main_cardio:
                //startActivity(new Intent(MainActivity.this, ));
                break;
                default:
                    Log.d("MAIN", "Not registered for clickListener");
        }
    }
}
