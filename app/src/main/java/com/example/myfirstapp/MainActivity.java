package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_OPTION = "com.example.myfirstapp.OPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        Spinner mySpinner = (Spinner) findViewById(R.id.numberSpinner);
        String option = mySpinner.getSelectedItem().toString();
        if(!message.isEmpty() && !option.isEmpty()){
            intent.putExtra(EXTRA_MESSAGE, message);
            intent.putExtra(EXTRA_OPTION, option);
            startActivity(intent);
        }
    }



}
