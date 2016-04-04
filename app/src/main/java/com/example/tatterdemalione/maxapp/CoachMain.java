package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CoachMain extends Activity
{
    String username, theme, name;
    int userId, isCoach;
    String stringUserId, stringIsCoach;
    Intent intent, intent2, goBack;
    Button notifications, players;
    TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach_main_layout);

        notifications = (Button)findViewById(R.id.btnlist);
        players = (Button)findViewById(R.id.btnview);
        display = (TextView) findViewById(R.id.username);

        intent = new Intent(this, NotificationsMenu.class);
        intent2 = new Intent(this, PlayersMenu.class);

        notifications.setOnClickListener(listener1);
        players.setOnClickListener(listener2);

        /* Retrieve extras from previous activity */

        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        theme = extras.getString("theme");
        name = extras.getString("name");
        stringIsCoach = extras.getString("isCoach");
        stringUserId = extras.getString("userId");

        System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[+++++++++++++++++++ isCoach ======== " + extras.getString("isCoach") + "++++++++++++++++++++]]]]]]]]]]]]]]]]]]");
        System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[+++++++++++++++++++ userId ======== " + extras.getString("userId") + "++++++++++++++++++++]]]]]]]]]]]]]]]]]]" );
        isCoach = Integer.parseInt(extras.getString("isCoach"));
        userId = Integer.parseInt( extras.getString("userId") );


        /* Welcome the user */
        display.setText("Welcome Coach " + extras.getString("name"));
    }

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v){
            intent.putExtra("username", username);
            intent.putExtra("theme", theme);
            intent.putExtra("name", name);
            intent.putExtra( "isCoach", stringIsCoach );
            intent.putExtra( "userId", stringUserId );
            startActivity(intent);
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
            intent.putExtra("username", username);
            intent.putExtra("username", username);
            intent.putExtra("theme", theme);
            intent.putExtra("name", name);
            startActivity(intent2);
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
