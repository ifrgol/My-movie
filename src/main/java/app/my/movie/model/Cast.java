package app.my.movie.model;

public class Cast {

    private String id;
    private String name;
    private String avatar;
    private String character;

    public Cast(String id, String name, String avatar, String character) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.character = character;
    }

    public Cast() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
