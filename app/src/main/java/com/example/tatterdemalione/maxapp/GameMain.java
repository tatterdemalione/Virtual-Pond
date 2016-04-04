package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by noah on 3/25/16.
 */
public class GameMain extends Activity {

    Button game1, game2, game3, back;
    String username;
    RelativeLayout relativeLayout;
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main_layout);

        game1 = (Button) findViewById(R.id.game1);
        game2 = (Button) findViewById(R.id.game2);
        game3 = (Button) findViewById(R.id.game3);

        Intent myIntent = getIntent();

        username = myIntent.getStringExtra("username");

        //intent = new Intent(this, Video.class);

        back.setOnClickListener(listener1);
        game1.setOnClickListener(listener2);
        game2.setOnClickListener(listener3);
        game3.setOnClickListener(listener4);

        /*
        if (true){
            relativeLayout = new RelativeLayout(this);
            relativeLayout.setBackgroundResource(R.mipmap.minions_background);
            setContentView(relativeLayout);
        } else if (true){
            relativeLayout = new RelativeLayout(this);
            relativeLayout.setBackgroundResource(R.mipmap.space_background);
            setContentView(relativeLayout);
        } else if (true){
            relativeLayout = new RelativeLayout(this);
            relativeLayout.setBackgroundResource(R.mipmap.dinos_background);
            setContentView(relativeLayout);
        } else {
            Toast.makeText(this, "theme error", Toast.LENGTH_LONG);
        }*/

    }

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v){
            finishActivity(0);
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
            intent.putExtra("username", username);
            intent.putExtra("level","7"); //these values assume 1-6 are the values used for the skill videos.
            startActivity(intent);
        }
    };

    /*Note to self: in the coach notifications, need to make sure the database isn't updated if level > 6 */

    View.OnClickListener listener3 = new View.OnClickListener(){
        public void onClick(View v){
            intent.putExtra("username", username);
            intent.putExtra("level","8");
            startActivity(intent);
        }
    };

    View.OnClickListener listener4 = new View.OnClickListener(){
        public void onClick(View v){
            intent.putExtra("username", username);
            intent.putExtra("level","9");
            startActivity(intent);
        }
    };

}
