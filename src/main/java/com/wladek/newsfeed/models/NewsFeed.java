package com.wladek.newsfeed.models;

import com.wladek.newsfeed.daos.FeedDao;

import javax.persistence.Entity;

/**
 * Created by wladek on 6/17/17.
 */
@Entity
public class NewsFeed extends AbstractModel{
    private String title;
    private String url;
    private Long views = new Long(0);

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

    public FeedDao toDao(){
        FeedDao feedDao = new FeedDao();
        feedDao.setId(getId());
        feedDao.setTitle(title);
        feedDao.setUrl(url);
        feedDao.setViews(views);

        return feedDao;
    }
}
