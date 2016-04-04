package com.example.tatterdemalione.maxapp;

/***********************************/
/* PLAYER MAIN CLASS               */
/* Created by Noah                 */
/* March 25th, 2016                */
/***********************************/

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerMain extends Activity {

    RelativeLayout relativeLayout;
    Intent intent;
    Intent intent2;
    Intent intent3;
    Intent goBack;
    TextView display;
    private String theme, username, name;
    private int points, isCoach, userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_main_layout);

        intent = new Intent(this, LevelsMain.class);
        intent2 = new Intent(this, GameMain.class);
        intent3 = new Intent(this, ProfileMain.class);


        Button mLevels = (Button) findViewById(R.id.btnPlayLevels);
        Button mGame = (Button) findViewById(R.id.btnPlayGame);
        Button mProfile = (Button) findViewById(R.id.btnViewProfile);
        mLevels.setOnClickListener(listener1);
        mGame.setOnClickListener(listener2);
        mProfile.setOnClickListener(listener3);

        display = (TextView) findViewById(R.id.display);

        Bundle extras = getIntent().getExtras();
        display.setText("Welcome " + extras.getString("username"));

        /* Retrieve user information from previous screen */
        theme = extras.getString("theme");
        username = extras.getString("username");
        name = extras.getString("name");
        userId = Integer.parseInt( extras.getString("userId") );
        points = Integer.parseInt( extras.getString("points") );
        isCoach = Integer.parseInt( extras.getString("userId") );


        // need to set background based on user preference

        Intent myIntent = getIntent();

        username = myIntent.getStringExtra("username");

        // now we use the username to determine the chosen theme via the database
        // theme = flag for theme retrieved from database

        relativeLayout = (RelativeLayout) findViewById(R.id.playerMain);
        if (theme.equals("Minions"))
        {
            relativeLayout.setBackgroundResource(R.drawable.minion);
            setContentView(relativeLayout);
        }
        else if (theme.equals("Space"))
        {
            relativeLayout.setBackgroundResource(R.drawable.space);
            setContentView(relativeLayout);
        }
        else if (theme.equals("Dinosaurs"))
        {
            relativeLayout.setBackgroundResource(R.drawable.dino);
            setContentView(relativeLayout);
        }
        else
        {
            Toast.makeText(this,"theme error", Toast.LENGTH_LONG).show();
        }

    }

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v){

            intent.putExtra("username", username);
            intent.putExtra("name", name);
            intent.putExtra( "points", Integer.toString(points) );
            intent.putExtra("theme", theme);
            intent.putExtra( "isCoach", Integer.toString(isCoach) );
            intent.putExtra( "userId", Integer.toString(userId) );
            startActivity(intent);
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){

            intent2.putExtra("username", username);
            intent2.putExtra("name", name);
            intent2.putExtra( "points", Integer.toString(points) );
            intent2.putExtra("theme", theme);
            intent2.putExtra( "isCoach", Integer.toString(isCoach) );
            intent2.putExtra( "userId", Integer.toString(userId) );
            startActivity(intent2);
        }
    };

    View.OnClickListener listener3 = new View.OnClickListener(){
        public void onClick(View v){

            intent3.putExtra("username", username);
            intent3.putExtra("name", name);
            intent3.putExtra( "points", Integer.toString(points) );
            intent3.putExtra("theme", theme);
            intent3.putExtra( "isCoach", Integer.toString(isCoach) );
            intent3.putExtra( "userId", Integer.toString(userId) );
            startActivity(intent3);

        }
    };

    //Override the onKeyDown method
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            goBack = new Intent(this, MainActivity.class);
            startActivity(goBack);
        }
        return true;
    }

}
