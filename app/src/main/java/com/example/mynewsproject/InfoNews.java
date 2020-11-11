package com.example.mynewsproject;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mynewsproject.Adapter.AdapterWeb;
import com.example.mynewsproject.Pojo.Kino.Result;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


public class InfoNews extends AppCompatActivity {
    private WebView webView;
    private String url;
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_news);
        result = new Result();
        webView = findViewById(R.id.webView_news);
        Intent intent=getIntent();
        url = intent.getStringExtra("id");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new AdapterWeb());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}