package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by noah on 3/25/16.
 */
public class NotificationsMenu extends Activity implements AdapterView.OnItemClickListener {

    ListView listview;
    ArrayAdapter adapter;
    String username;
    int userId;
    int isCoach;
    private String url_transaction;

    JSONParser jsonParser = new JSONParser();
    JSONArray notifications = null;

    String[] globalNotifications;
    String response;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_menu_layout);

        /* Populate the list of notifications */
        listview = (ListView) findViewById(R.id.notificationslist);
        ArrayAdapter<String> arrayAdapter;

        Bundle extras = getIntent().getExtras();

        isCoach = Integer.parseInt( extras.getString("isCoach") );
        userId = Integer.parseInt( extras.getString("userId") );

        System.out.println("-----------------****** " + isCoach + " ****---------------------");
        System.out.println("-----------------****** " + userId + " ****---------------------");

        url_transaction = "http://cse.stfx.ca/~testphp/getNotifications.php";
        getNotifications getNots = new getNotifications(isCoach, userId);
        getNots.execute();

        /*
        Database db = new Database();
        notifications = db.getNotifications(isCoach, userId);
        */


        //arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, globalNotifications);
        //listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View v, int position, long id)
    {
        Integer item = position;
        String textItem = item.toString();
        intent = new Intent(this, NotificationsView.class);
        intent.putExtra("username", username);
        intent.putExtra("position", textItem);
        startActivity(intent);
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

        private getNotifications(int isCoach, int userId) {
            this.isCoach = isCoach;
            this.userId = userId;

            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + isCoach + userId);
            System.out.println("(((((((((((((((((((((((((((((((( " + isCoach + userId);

        }

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            System.out.println("Retrieving Notifications");
        }

        /**
         * Add User to database in the background
         */
        protected String doInBackground(String... args) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            System.out.println("^^^^^^^^^^^^^^^^^^^^ " + Integer.toString(isCoach));
            System.out.println("^^^^^^^^^^^^^^^^^^^^^ " + Integer.toString(userId));

            params.add(new BasicNameValuePair("isCoach", Integer.toString(isCoach)));
            params.add(new BasicNameValuePair("userID", Integer.toString(userId)));

            JSONObject json2 = jsonParser.makeHttpRequest(url_transaction, "POST", params);
            // check log cat for response
            Log.d("Create Response", json2.toString());

            /* check for success tag */

            try {

                notifications = json2.getJSONArray("notifications");
                globalNotifications = new String[notifications.length()];

                for (int i = 0; i < notifications.length(); i++)
                {
                    JSONObject c = notifications.getJSONObject(i);
                    globalNotifications[i] = c.toString();
                    System.out.println("****************************************" + globalNotifications[i] + "****************************************");
                }

            } catch (JSONException e) {
                e.printStackTrace();
                response = "fail";
                finish();
            }
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            System.out.println("Get Notifications " + response);
        }
    }
}
