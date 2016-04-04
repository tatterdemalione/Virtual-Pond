package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by sgcharles on 16/3/27.
 */
public class Video extends Activity{

    private VideoView videoView;
    Intent intent;
    private String theme, username, name, level;
    private int points, isCoach, userId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent myIntent = getIntent();
        Bundle extras = getIntent().getExtras();
        theme = extras.getString("theme");
        username = extras.getString("username");
        name = extras.getString("name");
        userId = Integer.parseInt(extras.getString("userId"));
        points = Integer.parseInt( extras.getString("points"));
        isCoach = Integer.parseInt( extras.getString("isCoach") );
        level = myIntent.getStringExtra("level");//get these from prevideo.java

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.video);


        videoView = (VideoView) findViewById(R.id.videoView);

        switch(level)
        {
            case "1":
                videoView.setVideoURI(Uri.parse("http://cse.stfx.ca/~testphp/videos/stop.mp4"));
                break;
            case "2":
                videoView.setVideoURI(Uri.parse("http://cse.stfx.ca/~testphp/videos/stride.mp4"));
                break;
            case "3":
                videoView.setVideoURI(Uri.parse("http://cse.stfx.ca/~testphp/videos/recover.mp4"));
                break;
            case "4":
                videoView.setVideoURI(Uri.parse("http://cse.stfx.ca/~testphp/videos/crossovers.mp4"));
                break;
            case "5":
                videoView.setVideoURI(Uri.parse("http://cse.stfx.ca/~testphp/videos/bcrossovers.mp4"));
                break;
            case "6":
                videoView.setVideoURI(Uri.parse("http://cse.stfx.ca/~testphp/videos/turn.mp4"));
                break;
        }


        MediaController mediaController = new MediaController(this);

        videoView.setMediaController(mediaController);
        videoView.start();
        //videoView.requestFocus();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                intent = new Intent(Video.this, Back.class);
                intent.putExtra("username", username);
                intent.putExtra("name", name);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", theme);
                intent.putExtra( "isCoach", Integer.toString(isCoach) );
                intent.putExtra( "userId", Integer.toString(userId) );
                intent.putExtra("level", level);
                startActivity(intent);
            }
        });
    }
}
