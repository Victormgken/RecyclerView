package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Movie;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Movie> movieList;
    public Adapter(List<Movie> list) {
        this.movieList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Movie movie = movieList.get(position);
        holder.title.setText(movie.getMovieTitle());
        holder.year.setText(movie.getYear());
        holder.genre.setText(movie.getGenre());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView year;
        TextView genre;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            year = itemView.findViewById(R.id.yearText);
            genre = itemView.findViewById(R.id.genreText);


        }
    }
}
