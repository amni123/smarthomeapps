package com.example.nur.smarthome;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class lock extends AppCompatActivity {

    EditText txt;
    Button set, open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        txt = (EditText)findViewById(R.id.editText);
        set = (Button)findViewById(R.id.button);
        open = (Button)findViewById(R.id.button2);

        final DatabaseHelper db = new DatabaseHelper(this);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = txt.getText().toString();
                boolean inserted = db.insert(b);

                if (inserted = true)
                {
                    Toast.makeText(getApplicationContext(),"Your password has been set",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Database connection error",Toast.LENGTH_LONG).show();
                }
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass = txt.getText().toString();

                if (pass.equals(txt)) {
                    Toast.makeText(getApplicationContext(), "Data  not found", Toast.LENGTH_LONG).show();
                } else {
                        Toast.makeText(getApplicationContext(), "Your lock has open", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
