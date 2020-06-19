package app.my.movie.util;

import java.security.Key;

public class Utils {



   static String API_key = "6a2f9c8359403a3d7ea9bd8d9a2a46db";
   static String Main_URL = "https://api.themoviedb.org/3/movie/";
   static String Popular_Movies = "popular?api_key=";
   static String top_rated_Movies = "top_rated?api_key=";
   static String Lang = "&language=en-US";
   static String Page = "&page=";
   public static String Image_W500 = "https://image.tmdb.org/t/p/w500";
   public static String credit ="/credits?api_key=";

    /*
    create popular movies list url
     */
    public static String Credit_API(String id){
        return Main_URL+id+ credit+API_key+Lang;
    }
   /*
   create popular movies list url
    */
   public static String Popular_API(){
    return Main_URL+Popular_Movies+ API_key+Lang+Page+"1";
   }
    /*
      create top rated movies list url
       */
    public static String TopRated_API(){
        return Main_URL+top_rated_Movies+ API_key+Lang+Page+"1";
    }
 }
