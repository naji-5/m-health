package bishodroid.com.gymapp.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import bishodroid.com.gymapp.R;

public class Signup extends AppCompatActivity implements View.OnClickListener{

    private TextInputEditText name, email, password, age, height, weight;
    private Spinner goal;
    private RadioGroup gender;
    private Button signup, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.signup_name);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        age = findViewById(R.id.signup_age);
        height = findViewById(R.id.signup_height);
        weight = findViewById(R.id.signup_weight);

        goal = findViewById(R.id.spinner);
        gender = findViewById(R.id.signup_gender);
        signup = findViewById(R.id.signup_signup);
        signup.setOnClickListener(this);
        login = findViewById(R.id.signup_login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup_signup:
                signup();
                break;
            case R.id.signup_login:

                //Finish this activity and go to Login when user taps on Login
                finish();
                startActivity(new Intent(Signup.this, Login.class));

                break;
        }
    }

    /**
     * This method will perform the user signup and will save their information in database.
     */
    private void signup(){

    }
}
