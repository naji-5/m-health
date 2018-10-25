package bishodroid.com.gymapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bishodroid.com.gymapp.R;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText email, password;
    private Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Email and password views initialization
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);

        //Login and signup buttons initialization
        login = findViewById(R.id.login_login);
        login.setOnClickListener(this);
        signup = findViewById(R.id.login_signup);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_login:
                login();
                break;
            case R.id.login_signup:

                //Finish this activity and Start the signup activity
                finish();
                startActivity(new Intent(Login.this, Signup.class));

                break;
        }
    }

    /**
     * This method is called when user taps Login button
     * Will take email and password and verify against database
     * If user input is correct, login, else show error message
     */
    private void login(){
        finish();
        startActivity(new Intent(Login.this, MainActivity.class));
    }
}
