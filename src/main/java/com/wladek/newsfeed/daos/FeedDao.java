package com.wladek.newsfeed.daos;

import com.wladek.newsfeed.models.NewsFeed;

import java.io.Serializable;

/**
 * Created by wladek on 6/17/17.
 */
public class FeedDao implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String url;
    private Long views;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NewsFeed toFeed(){
        NewsFeed newsFeed = new NewsFeed();
        newsFeed.setId(id);
        newsFeed.setTitle(title);
        newsFeed.setUrl(url);
        newsFeed.setViews(views);
        newsFeed.setDescription(description);

        return newsFeed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
