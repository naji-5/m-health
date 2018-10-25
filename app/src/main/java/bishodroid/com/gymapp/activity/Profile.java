package bishodroid.com.gymapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import bishodroid.com.gymapp.R;

public class Profile extends AppCompatActivity implements View.OnClickListener{

    private static final String CM = "CM";
    private static final String KG = "Kg";
    private static final String YRS = "Years";

    private static boolean editMode = false;

    private ImageView image;
    private EditText email, password, age, weight, height;
    private ProgressBar progress;
    private TextView percent;
    private Button editSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        image = findViewById(R.id.profile_image);
        image.setOnClickListener(this);
        email = findViewById(R.id.profile_email);
        password = findViewById(R.id.profile_password);
        age = findViewById(R.id.profile_age);
        weight = findViewById(R.id.profile_weight);
        height = findViewById(R.id.profile_height);

        progress = findViewById(R.id.profile_workout_progress);
        percent = findViewById(R.id.profile_prog_percent);
        editSave = findViewById(R.id.profile_edit_save);
        editSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profile_image:
                addImage();
                break;
            case R.id.profile_edit_save:
                editOrSave();
        }
    }


    private void addImage(){

    }

    private void editOrSave(){
        editMode = !editMode;
        updateFields(editMode);
        performAction(editMode);
    }

    private void updateFields(boolean isEditMode){
        if(isEditMode){
            editSave.setText("Save");
            email.setEnabled(true);
            password.setEnabled(true);
            password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            age.setEnabled(true);
            height.setEnabled(true);
            weight.setEnabled(true);
        }else{
            editSave.setText("Edit");
            email.setEnabled(false);
            password.setEnabled(false);
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            age.setEnabled(false);
            height.setEnabled(false);
            weight.setEnabled(false);
        }
    }

    private void performAction(boolean isEditMode){
        Toast.makeText(this,"Saved.", Toast.LENGTH_SHORT).show();
    }
}
