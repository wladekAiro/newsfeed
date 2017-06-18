package com.wladek.newsfeed.models;

import com.wladek.newsfeed.daos.FeedDao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * Created by wladek on 6/17/17.
 */
@Entity
public class NewsFeed extends AbstractModel{
    @Lob
    @Column( length = 100000 )
    private String title;
    @Lob
    @Column( length = 100000 )
    private String url;
    @Lob
    @Column( length = 100000 )
    private String description;
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
        feedDao.setDescription(description);

        return feedDao;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
