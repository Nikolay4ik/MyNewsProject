package com.example.mynewsproject;

import com.example.mynewsproject.Pojo.Kino.Example;
import com.example.mynewsproject.Pojo.Kino.Link;
import com.example.mynewsproject.Pojo.Kino.Result;

import java.util.List;

public interface ExampleListView {
   void showData( List<Result>result);
   void showError();
}
