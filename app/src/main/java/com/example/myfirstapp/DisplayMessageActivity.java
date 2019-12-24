package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String option = intent.getStringExtra(MainActivity.EXTRA_OPTION);
        TextView textView = findViewById(R.id.textView);
        String text = "";
        Integer message_value = 0;
        try {
            switch(option){
                case "Bin":
                    message_value = Integer.parseInt(message, 2);
                    break;
                case "Dec":
                    message_value = Integer.parseInt(message, 10);
                    break;
                case "Hex":
                    message_value = Integer.parseInt(message, 16);
                    break;
                case "Oct":
                    message_value = Integer.parseInt(message, 8);
                    break;
            }
            text += "Binary value: " + Integer.toBinaryString(message_value);
            text += "\nOct value: " + Integer.toOctalString(message_value);
            text += "\nDecimal value: " + message_value;
            text += "\nHex value: " + Integer.toHexString(message_value);
            textView.setText(text);
        } catch(NumberFormatException e){
            textView.setText("Not a number");
        }
    }
}
