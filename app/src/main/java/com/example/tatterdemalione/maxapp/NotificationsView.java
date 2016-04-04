package com.example.tatterdemalione.maxapp;

/**
 * Created by Tatterdemalione on 2016-03-26.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by noah on 3/25/16.
 */
public class NotificationsView extends Activity {

    String username, position;
    TextView Name, Videonumber, Status, Skill;
    Button yes, no;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent myIntent = getIntent();
        username = myIntent.getStringExtra("username"); //remember this is the coach username
        position = myIntent.getStringExtra("position");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_view_layout);

        String[] myArray = {"1","2","3","4"}; //dummy data

        //use position data to get the row of the table containing the notification being checked

        Name = (TextView)findViewById(R.id.name);
        Skill = (TextView)findViewById(R.id.skill);
        Status = (TextView)findViewById(R.id.status);
        Videonumber = (TextView)findViewById(R.id.videonumber); //these 4 fields are based off of charles' xml,idk what we are actually putting in

        Name.setText(myArray[0]);
        Skill.setText(myArray[1]);
        Status.setText(myArray[2]);
        Videonumber.setText(myArray[3]);

        yes = (Button)findViewById(R.id.btnyes);
        no = (Button)findViewById(R.id.btnno);

        intent = new Intent(this, NotificationsView.class);
        intent.putExtra("username", username);

        yes.setOnClickListener(listener1);
        no.setOnClickListener(listener2);

    }

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v){
            //IN DATABASE:
            //update level progress (IF LEVEL < 7)
            //this is because we are storing the "games" with level numbers 7,8,9
            //delete notification
            //give points
            startActivity(intent);
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
            //IN DATABASE:
            //delete notification
            startActivity(intent);
        }
    };

}
