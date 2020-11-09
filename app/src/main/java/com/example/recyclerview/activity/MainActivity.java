package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Movie;
import com.example.recyclerview.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView moviesRecycler;
    private List<Movie> moviesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesRecycler = findViewById(R.id.moviesRecycler);

        //Movies List
        this.createMovies();

        //config adpter
        Adapter adapter = new Adapter(moviesList);

        //config recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        moviesRecycler.setLayoutManager(layoutManager);
        moviesRecycler.setHasFixedSize(true);
        moviesRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        moviesRecycler.setAdapter(adapter);

        // click event
        moviesRecycler.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    moviesRecycler,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Movie movie = moviesList.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item Pressionado: " + movie.getMovieTitle(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Movie movie = moviesList.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item Pressionado: " + movie.getMovieTitle()+" feito no ano: "+ movie.getYear(),
                                    Toast.LENGTH_LONG
                            ).show();

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }

    public void createMovies(){
        Movie movie = new Movie("The Shawshank Redemption","Drama","1994");
        this.moviesList.add(movie);

        movie = new Movie("The Godfather","Drama/Crime","1972");
        this.moviesList.add(movie);

        movie = new Movie("The Godfather: Part II"," Crime, Drama","1974");
        this.moviesList.add(movie);

        movie = new Movie("The Dark Knight"," Action, Crime, Drama","2008");
        this.moviesList.add(movie);

        movie = new Movie("Schindler's List"," Biography, Drama, History","1993");
        this.moviesList.add(movie);

        movie = new Movie("Pulp Fiction"," Crime, Drama","1994");
        this.moviesList.add(movie);

        movie = new Movie("Fight Club","Drama","1999");
        this.moviesList.add(movie);

        movie = new Movie("Forrest Gump"," Drama, Romance","1994");
        this.moviesList.add(movie);

        movie = new Movie("Inception "," Action, Adventure, Sci-Fi","2010");
        this.moviesList.add(movie);

        movie = new Movie("The Matrix"," Action, Sci-Fi","1999");
        this.moviesList.add(movie);

        movie = new Movie("Se7en","Crime, Drama, Mystery","1995");
        this.moviesList.add(movie);

    }
}