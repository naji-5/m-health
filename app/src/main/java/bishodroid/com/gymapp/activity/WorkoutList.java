package bishodroid.com.gymapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bishodroid.com.gymapp.R;
import bishodroid.com.gymapp.model.Workout;
import bishodroid.com.gymapp.adapter.WorkoutListAdapter;

public class WorkoutList extends AppCompatActivity {

    private List<Workout> workouts;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
        String workout = getIntent().getStringExtra("workout");

        //TODO get workouts from db based on category
        workouts = new ArrayList<>();
        workouts.add(new Workout("Bench press", "3AtDnEC4zak", "chest"));
        workouts.add(new Workout("Incline bench press", "3AtDnEC4zak", "chest"));
        workouts.add(new Workout("Push up", "3AtDnEC4zak", "chest"));

        list = findViewById(R.id.workouts_list);
        WorkoutListAdapter adapter = new WorkoutListAdapter(this, workouts);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO start youtube video
                Toast.makeText(WorkoutList.this,workouts.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
