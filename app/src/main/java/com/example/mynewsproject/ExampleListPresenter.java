package com.example.mynewsproject;

import android.renderscript.Sampler;
import android.util.Log;

import com.example.mynewsproject.Api.ApiFactory;
import com.example.mynewsproject.Api.ApiService;
import com.example.mynewsproject.Pojo.Kino.Example;
import com.example.mynewsproject.Pojo.Kino.Result;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ExampleListPresenter {
   private  CompositeDisposable compositeDisposable;
   private ExampleListPresenter exampleListPresenter;
   private ExampleListView exampleListView;

    public ExampleListPresenter(ExampleListView exampleListView) {
        this.exampleListView = exampleListView;
    }

    public void loadData(){
        ApiFactory apiFactory= ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        compositeDisposable=new CompositeDisposable();
        Disposable disposable= apiService.getExample()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Example>() {
                    @Override
                    public void accept(Example example) throws Exception {
                        exampleListView.showData(example.getResults());
                       for (Result s: example.getResults())
                        Log.i("MyRes", s.getByline());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        exampleListView.showError();
                        Log.i("MyRus", throwable.getMessage());
                    }
                });
        compositeDisposable.add(disposable);
    }

    public void disposeDisposable(){
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
