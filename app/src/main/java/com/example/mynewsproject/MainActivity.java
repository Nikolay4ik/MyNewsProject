package com.example.mynewsproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewsproject.Adapter.AdapterExample;
import com.example.mynewsproject.Pojo.Kino.Result;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsLogger;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ExampleListView {
    private RecyclerView recyclerView;
    private AdapterExample adapterExample;
    private ExampleListPresenter exampleListPresenter;
private AppEventsLogger logger;
private AccessToken accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exampleListPresenter = new ExampleListPresenter(this);
        recyclerView = findViewById(R.id.recyclerView_news);
        adapterExample = new AdapterExample();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        exampleListPresenter.loadData();

        adapterExample.setOnClickListner(new AdapterExample.OnClickListner() {
            @Override
            public void onClick(int position) {
                Result result = adapterExample.getResults().get(position);
                Intent intent = new Intent(MainActivity.this,InfoNews.class);
                intent.putExtra("id",result.getLink().getUrl());
                startActivity(intent);

            }
        });



        recyclerView.setAdapter(adapterExample);
    }
    @Override
    protected void onDestroy() {
        exampleListPresenter.disposeDisposable();
        super.onDestroy();
    }

    @Override
    public void showData(List<Result> result) {
        adapterExample.setResults(result);
    }

    @Override
    public void showError() {

    }

    public void logSentFriendRequestEvent () {//Сделать когда будет выложенна в гугл плэй
        logger.logEvent("sentFriendRequest");
    }


}
