package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatterdemalione on 2016-03-16.
 */
public class Database extends Activity
{

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
    private static String[] globalNotifications;




    // constructor
    public Database() {}

    /* GETTER Methods */
    public String getUsername()
    {
        return globalUsername;
    }

    public int getIsCoach()
    {
        return isCoachGlobal;
    }

    public int getPoints()
    {
        return points;
    }

    public String getResponse()
    {
        return response;
    }

    public String getGlobalTheme()
    {
        return globalTheme;
    }

    public String getName()
    {
        return globalName;
    }

    public int getId() { return globalID; }

    public String[] getNotificationArray() { return globalNotifications; }


    public void addToDatabase(String username, String password, String name, int isCoach, String theme)
    {
      url_transaction = "http://cse.stfx.ca/~testphp/add_user.php";
      addToDatabase addDb = new addToDatabase(username, password, name, isCoach, theme);
      System.out.println("Username in method addToDatabase method:" + username);
      addDb.execute();
    }

    public String login(String username, String password)
    {
        url_transaction = "http://cse.stfx.ca/~testphp/login.php";
        Login login = new Login(username, password);
        login.execute();
        System.out.println(response);
        return response;

    }

    public String[] getNotifications(int isCoach, int userId)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!" + isCoach + userId);
        url_transaction = "http://cse.stfx.ca/~testphp/getNotifications.php";
        getNotifications getNots = new getNotifications(isCoach, userId);
        getNots.execute();
        return globalNotifications;

    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * addToDatabase class is used to add rows of users to the database                *
     *                                                                                 *
     *                                                                                 *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private class addToDatabase extends AsyncTask<String, String, String>
    {
        private String username;
        private String password;
        private String name;
        private int isCoach;
        private String theme;

        private addToDatabase(String username, String password, String name, int isCoach, String theme)
        {
            this.username = username;
            this.password = password;
            this.name = name;
            this.isCoach = isCoach;
            this.theme = theme;
        }

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute()
        {
            System.out.println("Adding a user to the database");
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
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair( "coach", Integer.toString(isCoach) ) );
            params.add(new BasicNameValuePair( "theme", theme));

            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_transaction, "POST", params);
            // check log cat for response

            Log.d("Create Response", json.toString());

            // check for success tag
            try
            {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1)
                {
                    System.out.println("Successfully Added User to database");

                }
                else
                {
                   System.out.println("Failed");
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url)
        {
            // dismiss the dialog once done
            System.out.println("Added the user to the database");
        }
    }
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
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * getNotifications class is used to retrieve notifications from the database      *
     *                                                                                 *
     *                                                                                 *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private class getNotifications extends AsyncTask<String, String, String>
    {

        private JSONArray notifications;
        private int isCoach;
        private int userId;

        private getNotifications(int isCoach, int userId)
        {
            this.isCoach = isCoach;
            this.userId = userId;

            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + isCoach + userId);
            System.out.println("(((((((((((((((((((((((((((((((( " + isCoach + userId);

        }

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute()
        {
            System.out.println("Retrieving Notifications");
        }

        /**
         * Add User to database in the background
         */
        protected String doInBackground(String... args)
        {

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            System.out.println("^^^^^^^^^^^^^^^^^^^^ " + Integer.toString(isCoach));
            System.out.println("^^^^^^^^^^^^^^^^^^^^^ " + Integer.toString(userId));

            params.add(new BasicNameValuePair("isCoach", Integer.toString(isCoach)));
            params.add(new BasicNameValuePair("userID", Integer.toString(userId)));

            System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuu" + jsonParser.makeHttpRequest(url_transaction, "POST", params).toString());
            JSONObject json = jsonParser.makeHttpRequest(url_transaction, "POST", params);



            // check log cat for response
            Log.d("Create Response", json.toString());

            /* check for success tag */

            try
            {
                notifications = json.getJSONArray("notifications");
                globalNotifications = new String[notifications.length()];

                for (int i = 0; i < notifications.length(); i++)
                {
                    JSONObject c = notifications.getJSONObject(i);
                    globalNotifications[i] = c.toString();
                    System.out.println("****************************************" + globalNotifications[i] + "****************************************");
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
            System.out.println("Get Notifications "+ response);
        }
    }

}

