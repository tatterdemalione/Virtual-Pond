package com.example.tatterdemalione.maxapp;

/**
 * Created by Tatterdemalione on 2016-03-26.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noah on 3/25/16.
 */
public class LevelsMain extends Activity {

    Intent intent;
    LinearLayout thisLayout;

    private String theme, username, name, levelInt;
    private int points, isCoach, userId, currentLevel;

    Button b1, b2, b3, b4, b5, b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_main_layout);

        b1 = (Button) findViewById(R.id.level1);
        b2 = (Button) findViewById(R.id.level2);
        b3 = (Button) findViewById(R.id.level3);
        b4 = (Button) findViewById(R.id.level4);
        b5 = (Button) findViewById(R.id.level5);
        b6 = (Button) findViewById(R.id.level6);

        intent = new Intent(this, PreVideo.class);

        Bundle extras = getIntent().getExtras();
        theme = extras.getString("theme");
        username = extras.getString("username");
        name = extras.getString("name");
        userId = Integer.parseInt(extras.getString("userId"));
        points = Integer.parseInt( extras.getString("points"));
        isCoach = Integer.parseInt( extras.getString("isCoach") );

        thisLayout = (LinearLayout) findViewById(R.id.levelMain);
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

        b1.setOnClickListener(listener1);
        b2.setOnClickListener(listener2);
        b3.setOnClickListener(listener3);
        b4.setOnClickListener(listener4);
        b5.setOnClickListener(listener5);
        b6.setOnClickListener(listener6);
    }

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v){
            if(true) { //If the player is qualified to play the level (need to query here)
                levelInt = "1"; //threw these in to save you a query
                intent.putExtra("username", username);
                intent.putExtra("name", name);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", theme);
                intent.putExtra( "isCoach", Integer.toString(isCoach) );
                intent.putExtra( "userId", Integer.toString(userId) );
                intent.putExtra("level", levelInt);
                startActivity(intent);
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Not Qualified", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
            if(true) { //If the player is qualified to play the level (need to query here)

                levelInt = "2";
                intent.putExtra("username", username);
                intent.putExtra("name", name);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", theme);
                intent.putExtra( "isCoach", Integer.toString(isCoach) );
                intent.putExtra( "userId", Integer.toString(userId) );
                intent.putExtra("level", levelInt);
                startActivity(intent);

            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Not Qualified", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    View.OnClickListener listener3 = new View.OnClickListener(){
        public void onClick(View v){
            if(true) { //If the player is qualified to play the level (need to query here)
                levelInt = "3";
                intent.putExtra("username", username);
                intent.putExtra("name", name);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", theme);
                intent.putExtra( "isCoach", Integer.toString(isCoach) );
                intent.putExtra( "userId", Integer.toString(userId) );
                intent.putExtra("level", levelInt);
                startActivity(intent);
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Not Qualified", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    View.OnClickListener listener4 = new View.OnClickListener(){
        public void onClick(View v){
            if(true) { //If the player is qualified to play the level (need to query here)
                levelInt = "4";
                intent.putExtra("username", username);
                intent.putExtra("name", name);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", theme);
                intent.putExtra( "isCoach", Integer.toString(isCoach) );
                intent.putExtra( "userId", Integer.toString(userId) );
                intent.putExtra("level", levelInt);
                startActivity(intent);
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Not Qualified", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    View.OnClickListener listener5 = new View.OnClickListener(){
        public void onClick(View v){
            if(true) { //If the player is qualified to play the level (need to query here)
                levelInt = "5";
                intent.putExtra("username", username);
                intent.putExtra("name", name);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", theme);
                intent.putExtra( "isCoach", Integer.toString(isCoach) );
                intent.putExtra( "userId", Integer.toString(userId) );
                intent.putExtra("level", levelInt);
                startActivity(intent);
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Not Qualified", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    View.OnClickListener listener6 = new View.OnClickListener(){
        public void onClick(View v){
            if(true) { //If the player is qualified to play the level (need to query here)
                levelInt = "6";
                intent.putExtra("username", username);
                intent.putExtra("name", name);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", theme);
                intent.putExtra( "isCoach", Integer.toString(isCoach) );
                intent.putExtra( "userId", Integer.toString(userId) );
                intent.putExtra("level", levelInt);
                startActivity(intent);

            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Not Qualified", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * CheckLevel class is used to check how many levels the player has completed      *
     *                                                                                 *
     *                                                                                 *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private class CheckLevel extends AsyncTask<String, String, String>
    {
        private int userId;
        private String url_transaction = "cse.stfx.ca/~testphp/checkLevel.php";
        JSONParser jsonParser = new JSONParser();
        private String response;


        private CheckLevel(int userId)
        {
            this.userId = userId;
        }

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute()
        {
            System.out.println("Checking Level");
        }

        /**
         * Add User to database in the background
         */
        protected String doInBackground(String... args)
        {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add( new BasicNameValuePair( "userID", Integer.toString(userId) ) );


            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_transaction, "POST", params);

            // check log cat for response
            Log.d("Create Response", json.toString());

            /* check for success tag */
            try
            {
                int success = json.getInt("success");

                if (success == 1)
                {
                    response = "success";

                    /* Set the user information */
                    currentLevel = json.getInt("userId");

                }
                else
                {
                    System.out.println("Failed");
                    response = "fail";
                }

            }
            catch (JSONException e)
            {
                e.printStackTrace();
                response = "fail";
                finish();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url)
        {
            // dismiss the dialog once done
            System.out.println("Login " + response);
        }
    }
}
