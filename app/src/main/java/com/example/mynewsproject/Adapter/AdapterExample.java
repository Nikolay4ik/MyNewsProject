package com.example.mynewsproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewsproject.Pojo.Kino.Result;
import com.example.mynewsproject.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterExample extends RecyclerView.Adapter<AdapterExample.ResultViewHolder> {
    private List<Result> results;
    private OnClickListner onClickListner;

    public List<Result> getResults() {
        return results;
    }

    public interface OnClickListner {
        void onClick(int position);
    }

    public void setResults(List<Result> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    public void setOnClickListner(OnClickListner onClickListner) {
        this.onClickListner = onClickListner;
    }

    public AdapterExample() {
        results = new ArrayList<>();
        Result result = new Result();
        results.add(result);

    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Result result = results.get(position);
        holder.title.setText(result.getDisplayTitle());
        holder.headline.setText(result.getHeadline());
        holder.publicationDate.setText(result.getPublicationDate());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView headline;
        private TextView publicationDate;

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView_title);
            headline = itemView.findViewById(R.id.textView_headline);
            publicationDate = itemView.findViewById(R.id.textView_publicationDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if( onClickListner!=null){
                       onClickListner.onClick(getAdapterPosition());
                   }
                }
            });


        }
    }
}
