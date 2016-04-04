package com.example.tatterdemalione.maxapp;

/**
 * Created by Tatterdemalione on 2016-03-25.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by noah on 3/23/16.
 */
public class CoachRegisterActivity extends Activity{

    //Intent intent = new Intent(this, CoachMenu.class);

    String mUsername, mPassword, mName;
    EditText Username, Password, Name;
    Button confirm;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach_register_layout);

        i = new Intent(this, LoginActivity.class);

        Username = (EditText) findViewById(R.id.nicknameedit);
        Password = (EditText) findViewById(R.id.passwordedit);
        Name = (EditText) findViewById(R.id.nameedit);

        confirm = (Button) findViewById(R.id.button2);
        confirm.setOnClickListener(listener2);
    }

    View.OnClickListener listener2 = new View.OnClickListener(){
        public void onClick(View v){
            mUsername = Username.getText().toString();
            mPassword = Password.getText().toString();
            mName = Name.getText().toString();

            if ((mUsername!=null)&&(mPassword!=null)&&(mName!=null))
            {
                new Database().addToDatabase(mUsername, mPassword, mName, 1, "Dinosaur");
                startActivity(i);
            }
            else
            {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Account not added", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };

}
