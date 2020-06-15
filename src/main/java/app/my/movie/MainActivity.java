package app.my.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.my.movie.model.Movie;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rec;
    private Context context;
    private MovieAdapter movieAdapter;
    LinearLayoutManager layoutManager;
    List<Movie> mylist = new ArrayList<>();
    RequestQueue requestQueue;
    String popular_url,new_url;
    Utils myUtil = new Utils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        context = this;
        requestQueue = Volley.newRequestQueue(context);
        rec = findViewById(R.id.rec_popular);
        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false);
      //  movieAdapter = new MovieAdapter(mylist,context);
        rec.setLayoutManager(layoutManager);
       // rec.setAdapter(movieAdapter);
        GetPopularMovies();
    }

    public  void GetPopularMovies(){

        popular_url =Utils.Popular_API();
        Toast.makeText(context,popular_url,Toast.LENGTH_LONG).show();
        System.out.println(popular_url);

        JsonObjectRequest jon =new JsonObjectRequest(Request.Method.GET, popular_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jar = response.getJSONArray("results");
                    for(int i=0; i<jar.length(); i++){
                        JSONObject jsonObject = jar.getJSONObject(i);
                        int id = jsonObject.getInt("id");
                        String title = jsonObject.getString("title");
                        String poster = jsonObject.getString("poster_path");
                        String overview = jsonObject.getString("overview");
                        int rate = jsonObject.getInt("vote_average");
                        Movie movie = new Movie(id,title,poster,overview,String.valueOf(rate));
                        mylist.add(movie);
                    }
                    movieAdapter = new MovieAdapter(mylist,context);
                    rec.setAdapter(movieAdapter);
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