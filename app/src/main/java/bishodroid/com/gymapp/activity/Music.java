package bishodroid.com.gymapp.activity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bishodroid.com.gymapp.R;

public class Music extends AppCompatActivity {

    private String[] proj = {"*"};
    private List<String> songs;
    private List<String> paths;
    private ListView list;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Cursor c = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, proj,
                MediaStore.Audio.Media.IS_MUSIC + " != 0", null, null);
        songs = new ArrayList<>();
        paths = new ArrayList<>();

        list = findViewById(R.id.music_songs);
        player = new MediaPlayer();
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    int name = c.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
                    int dur = c.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION);
                    String path=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA));
                    if(!path.endsWith(".mp3")|| path.contains("AUD-")){
                        Log.i("MUSIC","Skipping: "+path);
                    }else{
                        songs.add(c.getString(name));
                        paths.add(path);
                    }

                    Log.i("MUSIC", "DURATION: " + dur);
                } while (c.moveToNext());
            }
            c.close();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, songs);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(player.isPlaying()){
                    player.stop();
                    player.reset();
                }
                String path = paths.get(position);
                Log.i("MUSIC", "PLAYING..."+path);
                try {
                    player.setDataSource(path);
                    player.setLooping(true);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
