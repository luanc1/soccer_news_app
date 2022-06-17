package me.dio.soccernews.diman;

public class News {
    private String title;
    private String descritption;
    private String image;
    private String link;

    public News(String title, String descritption, String image, String link) {
        this.title = title;
        this.descritption = descritption;
        this.image = image;
        this.link =  link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
