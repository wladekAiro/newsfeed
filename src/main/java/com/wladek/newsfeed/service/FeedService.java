package com.wladek.newsfeed.service;

import com.wladek.newsfeed.daos.FeedDao;

import java.util.List;

/**
 * Created by wladek on 6/17/17.
 */
public interface FeedService {
    public List<FeedDao> getFeeds();
    public FeedDao addView(FeedDao feedDao);
    public boolean refreshFeeds();
}
