package com.example.tatterdemalione.maxapp;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by noah on 3/25/16.
 */
public class ProfileMain extends Activity {

    TextView uiName, uiUsername, uiPoints, uiLevel;
    RelativeLayout relativeLayout;
    ImageView avatar;

    private String theme, username, name;
    private int points, isCoach, userId, currentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main_layout);

        uiName = (TextView)findViewById(R.id.nameView);
        uiUsername = (TextView)findViewById(R.id.nicknameView);
        uiPoints =(TextView)findViewById(R.id.pointsView);
        uiLevel = (TextView)findViewById(R.id.skillView);

        avatar = (ImageView)findViewById(R.id.avatarView);


        Bundle extras = getIntent().getExtras();
        theme = extras.getString("theme");
        username = extras.getString("username");
        name = extras.getString("name");
        userId = Integer.parseInt( extras.getString("userId") );
        points = Integer.parseInt( extras.getString("points"));
        isCoach = Integer.parseInt( extras.getString("isCoach") );

        // now we use the username to determine the chosen theme via the database
        // theme = flag for theme retrieved from database

        relativeLayout = (RelativeLayout) findViewById(R.id.profile);
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

        //use database queries to get user info
        //put into nameString,pointsString,and levelString

        uiName.setText(name);
        uiUsername.setText(username);
        uiLevel.setText( Integer.toString(currentLevel) );
        uiPoints.setText( Integer.toString(points) );

        setAvatar(points);

    }


    public void setAvatar(int points){

        if (points < 100){
            currentLevel = 1;
        } else if (points>99 && points<200){
            currentLevel = 2;
        } else {
            currentLevel = 3;
        }

        String type = theme;

        switch (currentLevel) {
            case 1:
                switch (type) {
                    case "Space":
                        avatar.setBackgroundResource(R.drawable.spacedude1); //first space avatar
                        break;
                    case "Dinosaurs":
                        avatar.setBackgroundResource(R.drawable.paleontologistdude);
                        break;
                    case "Minions":
                        avatar.setBackgroundResource(R.drawable.minion1);
                        break;
                }
                break;
            case 2:
                switch (type) {
                    case "Space":
                        avatar.setBackgroundResource(R.drawable.spacedude2); //2nd space avatar
                        break;
                    case "Dinosaurs":
                        avatar.setBackgroundResource(R.drawable.paleontologistdude2);
                        break;
                    case "Minions":
                        avatar.setBackgroundResource(R.drawable.minion2);
                        break;
                }
                break;
            case 3:
                switch (type) {
                    case "Space":
                        avatar.setBackgroundResource(R.drawable.spacedude3); //3rd space avatar
                        break;
                    case "Dinosaurs":
                        avatar.setBackgroundResource(R.drawable.paleontologistdude3);
                        break;
                    case "Minions":
                        avatar.setBackgroundResource(R.drawable.minion3);
                        break;
                }
                break;
        }

    }
}


