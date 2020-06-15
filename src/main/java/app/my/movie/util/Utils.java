package app.my.movie.util;

import java.security.Key;

public class Utils {



   static String API_key = "6a2f9c8359403a3d7ea9bd8d9a2a46db";
   static String Popular_Movies = "https://api.themoviedb.org/3/movie/popular?api_key=";
   static String top_rated_Movies = "https://api.themoviedb.org/3/movie/top_rated?api_key=";
   static String Lang = "&language=en-US";
   static String Page = "&page=";
   public static String Image_W500 = "https://image.tmdb.org/t/p/w500";

   /*
   create popular movies list url
    */
   public static String Popular_API(){
    return Popular_Movies+ API_key+Lang+Page+"1";
   }
    /*
      create top rated movies list url
       */
    public static String TopRated_API(){
        return top_rated_Movies+ API_key+Lang+Page+"1";
    }
 }
