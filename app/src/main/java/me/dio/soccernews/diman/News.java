package me.dio.soccernews.diman;

public class News {
    private String title;
    private String descritption;

    public News(String title, String descritption) {
        this.title = title;
        this.descritption = descritption;
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
}
