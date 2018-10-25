package bishodroid.com.gymapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.flipkart.youtubeview.activity.YouTubeActivity;

import java.util.List;

import bishodroid.com.gymapp.R;
import bishodroid.com.gymapp.model.Workout;
import bishodroid.com.gymapp.util.Config;

public class WorkoutListAdapter extends BaseAdapter{

    private List<Workout> workouts;
    private Context context;

    public WorkoutListAdapter(Context context, List<Workout> workouts) {
        this.context = context;
        this.workouts = workouts;
    }

    @Override
    public int getCount() {
        return workouts.size();
    }

    @Override
    public Object getItem(int position) {
        return workouts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final Workout workout = workouts.get(position);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.workout_list_item, null);
            TextView title = convertView.findViewById(R.id.workout_title);
            title.setText(workout.getTitle());
            ImageView play = convertView.findViewById(R.id.workout_video);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent video = new Intent(context, YouTubeActivity.class);
                    video.putExtra("apiKey", Config.YOUTUBE_API_KEY);
                    video.putExtra("videoId",workout.getVideoUrl());
                    context.startActivity(video);
                }
            });
            Button add = convertView.findViewById(R.id.workout_add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }
}
