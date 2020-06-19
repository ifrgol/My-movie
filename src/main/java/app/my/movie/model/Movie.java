package app.my.movie.model;

public class Movie {
    private int ID;
    private String title,poster,overview,rate,date;

    public Movie(int ID, String title, String poster, String overview, String rate) {
        this.ID = ID;
        this.title = title;
        this.poster = poster;
        this.overview = overview;
        this.rate = rate;
    }

    public Movie(int ID, String title, String poster, String overview, String rate, String date) {
        this.ID = ID;
        this.title = title;
        this.poster = poster;
        this.overview = overview;
        this.rate = rate;
        this.date = date;
    }

    public Movie() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
