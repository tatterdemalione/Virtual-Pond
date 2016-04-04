package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/***************************************/
/* PRE VIDEO CLASS                     */
/* Created by Noah                     */
/* March 25th, 2016                    */
/*                                     */
/* This class displays a message       */
/* informing the user about the        */
/* skill they are about to learn!      */
/*                                     */
/* Good old fashioned informative fun! */
/***************************************/


public class PreVideo extends Activity {

    private String level, type, explanation;
    private String theme, username, name, levelInt;
    private int points, isCoach, userId, currentLevel;

    LinearLayout thisLayout;
    ImageView imageView;
    Button go;
    Intent intent;
    TextView textView;

    String[] skills= {"This skill is about how to stop yourself while skating. You know, in case you were about to go straight into an asteroid or a planet!",

            "This skill is about how to stop yourself while skating. You know, in case you were about to go straight into an dinosaur or a tree!",

            "This skill is about how to stop yourself while skating. BE DO BEE DO BEE DO!",

            "This skill is about how to skate forward , or stride! You can use it to gain speed to zoom through asteroid belts!",

            "This skill is about how to skate forward , or stride! You can use it to gain speed to run away from T-Rexes!",

            "This skill is about how to skate forward , or stride! You can use it to gain speed if you're hungry, to get a banana! BING!",

            "This skill is how to get up if you fell down! Space is a dangerous place, and recovery is an important skill!",

            "This skill is how to get up if you fell down! Dino World is a dangerous place, and recovery is an important skill!",

            "This skill is how to get up if you fell down! Tutali toooo!!!",

            "This skill is about how do a crossover, which is good for a wide turn! Use it to keep away from black holes at a distance!",

            "This skill is about how do a crossover, which is good for a wide turn! Use it to stay away from big groups of dinosaurs!",

            "This skill is about how do a crossover, which takes you around corners! Woot woot!",

            "This skill teaches you how to go backwards! You can zoom in reverse through the spacetime continuum!",

            "This skill teaches you how to go backwards! You can turn time in reverse and find new species of dinosaurs!",

            "This skill teaches you how to go backwards! Boop boop!",

            "This skill is about how do a turn, which takes you around corners! Use it to turn into the orbit of a planet you wanna visit!",

            "This skill is about how do a turn, which takes you around corners! Use it to turn into a bush to hide from dinoaurs!",

            "This skill is about how do a turn, which takes you around corners! Hee hee!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prevideo_main_layout);

        go = (Button) findViewById(R.id.start4);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        intent = new Intent(this, Video.class);

        //intent = new Intent(this, Video.class);
        // zihao will have this class
        // the plan is to go to the video when the user hits go, and then when the video
        // is done it will pass to PostVideo.java (where the user chooses rewatch, back or notify coach)

        /* Get important user information from previous screen */
        Bundle extras = getIntent().getExtras();
        level = extras.getString("level");
        theme = extras.getString("theme");
        username = extras.getString("username");
        name = extras.getString("name");
        userId = Integer.parseInt(extras.getString("userId"));
        points = Integer.parseInt( extras.getString("points"));
        isCoach = Integer.parseInt( extras.getString("isCoach") );

        /* Set the background based on the theme */
        thisLayout = (LinearLayout) findViewById(R.id.preVideo);
        if (theme.equals("Minions"))
        {
            thisLayout.setBackgroundResource(R.drawable.minion);
            setContentView(thisLayout);
        }
        else if (theme.equals("Space"))
        {
            thisLayout.setBackgroundResource(R.drawable.space);
            setContentView(thisLayout);
        }
        else if (theme.equals("Dinosaurs"))
        {
            thisLayout.setBackgroundResource(R.drawable.dino);
            setContentView(thisLayout);
        }
        else
        {
            Toast.makeText(this,"theme error", Toast.LENGTH_LONG).show();
        }

        /* Set the avatar based on the user's settings */
        //setAvatar(points);


        go.setOnClickListener(listener2);





        switch (level) {
            case "1":
                imageView.setBackgroundResource(R.drawable.stride);
                switch (theme) {
                    case "Space":
                        explanation = skills[0];
                        break;
                    case "Dinosaurs":
                        explanation = skills[1];
                        break;
                    case "Minions":
                        explanation = skills[2];
                        break;
                }
                break;
            case "2":
                imageView.setBackgroundResource(R.drawable.stop);
                switch (theme) {
                    case "Space":
                        explanation = skills[3];
                        break;
                    case "Dinosaurs":
                        explanation = skills[4];
                        break;
                    case "Minions":
                        explanation = skills[5];
                        break;
                }
                break;
            case "3":
                imageView.setBackgroundResource(R.drawable.recover);
                switch (theme) {
                    case "Space":
                        explanation = skills[6];
                        break;
                    case "Dinosaurs":
                        explanation = skills[7];
                        break;
                    case "Minions":
                        explanation = skills[8];
                        break;
                }
                break;
            case "4":
                imageView.setBackgroundResource(R.drawable.crossover);
                switch (theme) {
                    case "Space":
                        explanation = skills[9];
                        break;
                    case "Dinosaurs":
                        explanation = skills[10];
                        break;
                    case "Minions":
                        explanation = skills[11];
                        break;
                }
                break;
            case "5":
                imageView.setBackgroundResource(R.drawable.backward);
                switch (theme) {
                    case "Space":
                        explanation = skills[12];
                        break;
                    case "Dinosaurs":
                        explanation = skills[13];
                        break;
                    case "Minions":
                        explanation = skills[14];
                        break;
                }
                break;
            case "6":
                imageView.setBackgroundResource(R.drawable.turn);
                switch (theme) {
                    case "Space":
                        explanation = skills[15];
                        break;
                    case "Dinosaurs":
                        explanation = skills[16];
                        break;
                    case "Minions":
                        explanation = skills[17];
                        break;
                }
                break;
        }

        textView.setText(explanation);

    }

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
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
                        imageView.setBackgroundResource(R.drawable.spacedude1); //first space avatar
                        break;
                    case "Dinosaurs":
                        imageView.setBackgroundResource(R.drawable.paleontologistdude);
                        break;
                    case "Minions":
                        imageView.setBackgroundResource(R.drawable.minion1);
                        break;
                }
                break;
            case 2:
                switch (type) {
                    case "Space":
                        imageView.setBackgroundResource(R.drawable.spacedude2); //2nd space avatar
                        break;
                    case "Dinosaurs":
                        imageView.setBackgroundResource(R.drawable.paleontologistdude2);
                        break;
                    case "Minions":
                        imageView.setBackgroundResource(R.drawable.minion2);
                        break;
                }
                break;
            case 3:
                switch (type) {
                    case "Space":
                        imageView.setBackgroundResource(R.drawable.spacedude3); //3rd space avatar
                        break;
                    case "Dinosaurs":
                        imageView.setBackgroundResource(R.drawable.paleontologistdude3);
                        break;
                    case "Minions":
                        imageView.setBackgroundResource(R.drawable.minion3);
                        break;
                }
                break;
        }

    }
}
