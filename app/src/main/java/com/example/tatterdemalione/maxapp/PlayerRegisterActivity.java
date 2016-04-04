package com.example.tatterdemalione.maxapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by noah on 3/23/16.
 */
public class PlayerRegisterActivity extends Activity implements AdapterView.OnItemSelectedListener  {

    Spinner spinner;
    String mUsername, mPassword, mName;
    String theme;
    EditText Username, Password, Name;
    Button confirm;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_register_layout);

        i = new Intent(this, LoginActivity.class);

        spinner = (Spinner) findViewById(R.id.Themespinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.theme_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        /*set spinner stuff....need lab source code*/
        /*int choice will be a flag for which theme chosen*/

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
            // set theme to spinner choice
            if ((mUsername!=null)&&(mPassword!=null)&&(theme!=null))
            {
                new Database().addToDatabase(mUsername, mPassword, mName, 0, theme);
                startActivity(i);
            }
            else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Account not added", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };

    @Override
    public void onItemSelected(AdapterView parent, View view, int pos, long id)
    {
            theme = parent.getItemAtPosition(pos).toString();

    }

    @Override
    public void onNothingSelected(AdapterView parent) {
        // Another interface callback
    }
}
