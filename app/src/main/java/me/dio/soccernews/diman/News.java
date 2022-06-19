package me.dio.soccernews.diman;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {
    @PrimaryKey
    public int id;
    public String title;
    public String descritption;
    public String image;
    public String link;
    public boolean favorites;


   /* public News(String title, String descritption, String image, String link) {
        this.title = title;
        this.descritption = descritption;
        this.image = image;
        this.link =  link;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    }*/
}
