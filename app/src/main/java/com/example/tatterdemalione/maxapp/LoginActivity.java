package com.example.tatterdemalione.maxapp;


/********************************************/
/* LOGIN ACTIVITY                           */
/* LOGIN SCREEN CLASS                       */
/* CREATED BY NOAH 03/23/16                 */
/********************************************/

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/********************************************/

public class LoginActivity extends Activity {

    private static String url_transaction;
    JSONParser jsonParser = new JSONParser();

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static String response;
    private static String globalUsername;
    private static int isCoachGlobal;
    private static int points;
    private static String globalName;
    private static String globalTheme;
    private static int globalID;

    Intent intent;
    Intent intent2;
    EditText mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        mUsername = (EditText)(findViewById(R.id.nameedit));
        mPassword = (EditText)(findViewById(R.id.passwordedit));

        /* Make intents for the activities that will be called next */
        intent = new Intent(this, CoachMain.class);
        intent2 = new Intent(this, PlayerMain.class);

        Button connect = (Button)(findViewById(R.id.button3));

        connect.setOnClickListener(goListener);
    }

    View.OnClickListener goListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {

            String usr = mUsername.getText().toString();
            String pss = mPassword.getText().toString();

            url_transaction = "http://cse.stfx.ca/~testphp/login.php";
            Login login = new Login(usr, pss);
            login.execute();

            while(response == null)
            {
                System.out.println("Spam");
            }

            if ( response.equals("success") && isCoachGlobal == 1 ){

                //Add important variables to a bundle to be used by the next activity
                intent.putExtra("username", usr);
                intent.putExtra("name", globalName);
                intent.putExtra( "points", Integer.toString(points) );
                intent.putExtra("theme", globalTheme);
                intent.putExtra( "isCoach", Integer.toString(isCoachGlobal) );
                intent.putExtra( "userId", Integer.toString(globalID) );

                startActivity(intent);

            } else if (response.equals("success") && isCoachGlobal == 0  ){

                //Add important variables to a bundle to be used by the next activity
                intent2.putExtra("username", usr);
                intent2.putExtra("name", globalName);
                intent2.putExtra( "points", Integer.toString(points) );
                intent2.putExtra("theme", globalTheme);
                intent2.putExtra( "isCoach", Integer.toString(isCoachGlobal) );
                intent2.putExtra( "userId", Integer.toString(globalID) );

            /*
            String usr = "Aaron";
            String pss = "1337";
            String globalName = "Jacob";
            String globalTheme = "Dinosaurs";
            int points = 0;
            int isCoachGlobal = 1;
            int globalID = 46;

            intent.putExtra("username", usr);
            intent.putExtra("password", pss);
            intent.putExtra("name", globalName);
            intent.putExtra("points", points);
            intent.putExtra("theme", globalTheme);
            intent.putExtra( "isCoach", Integer.toString(isCoachGlobal) );
            intent.putExtra( "userId", Integer.toString(globalID) );
            */
                startActivity(intent2);

            } else { // on login fail
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Info not correct", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * login class is used to check the username and password                          *
     *                                                                                 *
     *                                                                                 *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private class Login extends AsyncTask<String, String, String>
    {
        private String username;
        private String password;


        private Login(String username, String password)
        {
            this.username = username;
            this.password = password;
        }

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute()
        {
            System.out.println("Checking username and password");
        }

        /**
         * Add User to database in the background
         */
        protected String doInBackground(String... args)
        {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", username));
            params.add(new BasicNameValuePair("password", password));

            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_transaction, "POST", params);
            // check log cat for response
            Log.d("Create Response", json.toString());

            /* check for success tag */
            try
            {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1)
                {
                    System.out.println("Success");
                    response = "success";

                    /* Set the user information */
                    globalUsername = json.getString("Username");
                    points = json.getInt("Points");
                    isCoachGlobal = json.getInt("isCoach");
                    globalName = json.getString("Name");
                    globalTheme = json.getString("Theme");
                    globalID = json.getInt("ID");

                    System.out.println("+=========+======+======" + isCoachGlobal);

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

