package com.example.tatterdemalione.maxapp;

/********************************************/
/* REGISTER ACTIVITY                        */
/* REGISTRATION SCREEN CLASS                */
/* CREATED BY NOAH 03/23/16                 */
/********************************************/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends Activity {

    Intent intent;
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main_layout);

        intent = new Intent(this, PlayerRegisterActivity.class);
        intent2 = new Intent(this, CoachRegisterActivity.class);

        Button mPlayer = (Button) findViewById(R.id.btnPlayer);
        Button mCoach = (Button) findViewById(R.id.btnCoach);
        mPlayer.setOnClickListener(listener1);
        mCoach.setOnClickListener(listener2);
    }

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v){
            startActivity(intent);
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
            startActivity(intent2);
        }
    };
}
