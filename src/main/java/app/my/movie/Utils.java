package app.my.movie;

import java.security.Key;

public class Utils {



   static String API_key = "6a2f9c8359403a3d7ea9bd8d9a2a46db";
   static String Popular_Movies = "https://api.themoviedb.org/3/movie/popular?api_key=";
   static String Lang = "&language=en-US";
   static String Page = "&page=";
   static String Image_W500 = "https://image.tmdb.org/t/p/w500";
   static String Popular_API(){
    return Popular_Movies+ API_key+Lang+Page+"1";
   }

 }
