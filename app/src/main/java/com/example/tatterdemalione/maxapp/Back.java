package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by sgcharles on 16/3/27.
 */
public class Back extends Activity {
    Button replay, back, playgame;
    private String theme, username, name, level;
    private int points, isCoach, userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_layout);

        Bundle extras = getIntent().getExtras();
        theme = extras.getString("theme");
        username = extras.getString("username");
        name = extras.getString("name");
        userId = Integer.parseInt(extras.getString("userId"));
        points = Integer.parseInt( extras.getString("points"));
        isCoach = Integer.parseInt( extras.getString("isCoach") );
        level = extras.getString("level");

        replay = (Button)findViewById(R.id.replay);
        replay.setOnClickListener(onReplay);

        back = (Button) findViewById(R.id.backtolevel);
        back.setOnClickListener(backToLevel);

        Intent myIntent = getIntent();
        username = myIntent.getStringExtra("username");
        level = myIntent.getStringExtra("level");

        playgame = (Button)findViewById(R.id.palygame);
    }

    private View.OnClickListener onReplay = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Back.this, Video.class);
            intent.putExtra("username", username);
            intent.putExtra("name", name);
            intent.putExtra( "points", Integer.toString(points) );
            intent.putExtra("theme", theme);
            intent.putExtra( "isCoach", Integer.toString(isCoach) );
            intent.putExtra( "userId", Integer.toString(userId) );
            intent.putExtra("level", level);
            startActivity(intent);



        }
    };
    private View.OnClickListener backToLevel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Back.this, LevelsMain.class);
            intent.putExtra("username", username);
            intent.putExtra("name", name);
            intent.putExtra( "points", Integer.toString(points) );
            intent.putExtra("theme", theme);
            intent.putExtra( "isCoach", Integer.toString(isCoach) );
            intent.putExtra( "userId", Integer.toString(userId) );
            intent.putExtra("level", level);
            startActivity(intent);
        }
    };
}

