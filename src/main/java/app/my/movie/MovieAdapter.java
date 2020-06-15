package app.my.movie;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import app.my.movie.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {


    private List<Movie> movieList;
    Context con;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView poster;

        public MyViewHolder(View view) {
            super(view);


            title = (TextView) view.findViewById(R.id.title);
            poster = (ImageView) view.findViewById(R.id.poster);


        }




    }


    public MovieAdapter(List<Movie> movieList, Context con) {
        this.movieList = movieList;
        this.con=con;


    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new MovieAdapter.MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {

        final Movie cat= movieList.get(position);

        holder.title.setText(cat.getTitle());

        String img_url = Utils.Image_W500+cat.getPoster();
        Glide.with(con).load(img_url).into(holder.poster);
        Log.d("img",img_url);
        // Picasso.with(con).load(cat.getIcon()).transform(new CircleTransform()).placeholder(R.mipmap.a).into(holder.icon);


        //  setAnimation(holder.itemView, position);



    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
