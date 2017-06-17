package com.wladek.newsfeed.daos;

import com.wladek.newsfeed.domain.Feed;

import java.io.Serializable;

/**
 * Created by wladek on 6/17/17.
 */
public class FeedDao implements Serializable {
    private Long id;
    private String title;
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

    public Feed toFeed(){
        Feed feed = new Feed();
        feed.setId(id);
        feed.setTitle(title);
        feed.setUrl(url);
        feed.setViews(views);

        return feed;
    }
}
