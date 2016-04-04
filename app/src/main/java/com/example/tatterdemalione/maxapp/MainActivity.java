package com.example.tatterdemalione.maxapp;

/********************************************/
/* MAIN ACTIVITY                            */
/* INITIAL SCREEN CLASS                     */
/* CREATED BY NOAH 03/23/16                 */
/********************************************/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Intent intent;
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, LoginActivity.class);
        intent2 = new Intent(MainActivity.this, RegisterActivity.class);
        Button mLogin = (Button) findViewById(R.id.btnlogin);
        Button mRegister = (Button) findViewById(R.id.btnregister);
        mLogin.setOnClickListener(listener1);
        mRegister.setOnClickListener(listener2);
    }

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v)
        {
            startActivity(intent);
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
            startActivity(intent2);
        }
    };

}





