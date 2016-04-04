package com.example.tatterdemalione.maxapp;

/**
 * Created by Tatterdemalione on 2016-03-26.
 */

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

/**
 * Created by noah on 3/25/16.
 */
public class PlayersMenu extends Activity implements AdapterView.OnItemClickListener {

    ListView listview;
    ArrayAdapter adapter;
    String username;
    int userId;
    int isCoach;

    Intent intent;
    String[] notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players_menu_layout);

        /* Populate the list of notifications */
        listview = (ListView) findViewById(R.id.kidlist);
        ArrayAdapter<String> arrayAdapter;

        Bundle extras = getIntent().getExtras();

        isCoach = Integer.parseInt( extras.getString("isCoach") );
        userId = Integer.parseInt( extras.getString("userId") );


        Database db = new Database();
        notifications = db.getNotifications(isCoach, userId);

        //arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, notifications);
        //listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

        Integer item = position;
        String textItem = item.toString();
        intent = new Intent(this, NotificationsView.class);
        intent.putExtra("username", username); // coach username
        intent.putExtra("position", textItem); //player position on table, could also use their username?
        startActivity(intent);
    }
}