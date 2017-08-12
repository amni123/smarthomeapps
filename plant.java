package com.example.nur.smarthome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class plant extends AppCompatActivity {


    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        String url = "https://thingspeak.com/channels/312465/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Soil+Moisture&type=line";
        WebView view = (WebView) findViewById(R.id.soil);

        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }
}