package app.my.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.my.movie.model.Cast;
import app.my.movie.model.Movie;
import app.my.movie.util.Utils;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie_Page extends AppCompatActivity {

    TextView summary,rate,date,title;
    ImageView poster;
    RecyclerView rec;

    private Context context;
    private CastAdapter castAdapter;
    LinearLayoutManager layoutManager;
    List<Cast> mylist = new ArrayList<>();
    RequestQueue requestQueue;
    String cast_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__page);
        context=this;
        requestQueue = Volley.newRequestQueue(context);
        initView();

        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false);
        rec.setLayoutManager(layoutManager);
        GetCast(String.valueOf(getIntent().getIntExtra("id",0)));
    }

    void initView(){
        summary = findViewById(R.id.summary);
        date = findViewById(R.id.date);
        rate = findViewById(R.id.rate);
        title = findViewById(R.id.title);
        rec = findViewById(R.id.rec);
        poster = findViewById(R.id.poster);
        title.setText(getIntent().getStringExtra("title"));
        rate.setText(getIntent().getStringExtra("rate"));
        summary.setText(getIntent().getStringExtra("over"));
        date.setText(getIntent().getStringExtra("date"));
        Glide.with(this).load(getIntent().getStringExtra("poster")).into(poster);

    }

     /*
    get Top rated movies list
     */

    public  void GetCast(String id){

        cast_url = Utils.Credit_API(id);
       System.out.println(cast_url);
       // Toast.makeText(context,id,Toast.LENGTH_LONG).show();

        JsonObjectRequest jon =new JsonObjectRequest(Request.Method.GET, cast_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jar = response.getJSONArray("cast");
                    JSONArray crew = response.getJSONArray("crew");

                    for(int i=0;i<crew.length();i++){
                        JSONObject jsonObject = crew.getJSONObject(i);

                        String job= jsonObject.getString("job");
                        if(job.equals("Director")){
                           // int id = Integer.parseInt(jsonObject.getString("credit_id"));
                            String character = jsonObject.getString("job");
                            String name = jsonObject.getString("name");
                            String avatr = jsonObject.getString("profile_path");
                            Cast cast = new Cast("1",name,avatr,character);
                            mylist.add(cast);
                            // break;



                        }
                    }
                    for(int i=0; i<4; i++){
                        JSONObject jsonObject = jar.getJSONObject(i);


                            int id = jsonObject.getInt("cast_id");
                            String character = jsonObject.getString("character");
                            String name = jsonObject.getString("name");
                            String avatr = jsonObject.getString("profile_path");

                            Cast cast = new Cast(String.valueOf(id),name,avatr,character);
                            mylist.add(cast);

                    }

                    castAdapter = new CastAdapter(mylist,context);
                    rec.setAdapter(castAdapter);
                }catch (Exception e){
                    Toast.makeText(context,"1 "+e.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"2 "+error.getMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(jon);
    }
}