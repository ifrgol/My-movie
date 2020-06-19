package app.my.movie;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import app.my.movie.model.Cast;
import app.my.movie.model.Movie;
import app.my.movie.util.Utils;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.MyViewHolder> {


    private List<Cast> castList;
    Context con;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView character,name;
        public ImageView avatar;

        public MyViewHolder(View view) {
            super(view);


            character = (TextView) view.findViewById(R.id.character);
            name = (TextView) view.findViewById(R.id.name);
            avatar = (ImageView) view.findViewById(R.id.avatar);


        }




    }


    public CastAdapter(List<Cast> castList, Context con) {
        this.castList = castList;
        this.con=con;


    }

    @Override
    public CastAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cast_item, parent, false);

        return new CastAdapter.MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(CastAdapter.MyViewHolder holder, int position) {

        final Cast cat= castList.get(position);

        holder.name.setText(cat.getName());
        holder.character.setText(cat.getCharacter());

        String img_url = Utils.Image_W500+cat.getAvatar();
        Glide.with(con).load(img_url).into(holder.avatar);
        Log.d("img",img_url);





    }

    @Override
    public int getItemCount() {
        return castList.size();
    }
}

