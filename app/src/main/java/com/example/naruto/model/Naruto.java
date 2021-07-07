package com.example.naruto.model;

import java.io.Serializable;

public class Naruto implements Serializable {
    private String title;
    private String episodes;
    private String image_url;
    private String synopsis;
    private String type;

    public Naruto(String title, String episodes, String image_url, String synopsis, String type) {
        this.title = title;
        this.episodes = episodes;
        this.image_url = image_url;
        this.synopsis = synopsis;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Naruto{" +
                "title='" + title + '\'' +
                ", episodes='" + episodes + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
