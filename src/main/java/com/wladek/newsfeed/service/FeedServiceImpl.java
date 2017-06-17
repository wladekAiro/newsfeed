package com.wladek.newsfeed.service;

import com.wladek.newsfeed.daos.FeedDao;
import com.wladek.newsfeed.domain.Feed;
import com.wladek.newsfeed.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladek on 6/17/17.
 */
@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    FeedRepository repository;

    @Override
    public List<FeedDao> getFeeds() {
        List<Feed> feeds = repository.findAllOrderByViewsDesc();
        List<FeedDao> feedDaoList = new ArrayList<>();

        for (Feed feed : feeds) {
            feedDaoList.add(feed.toDao());
        }

        return feedDaoList;
    }

    @Override
    public FeedDao addView(FeedDao feedDao) {
        Feed feed = repository.findOne(feedDao.getId());
        feed.setViews(feed.getViews() + new Long(1));
        repository.save(feed);
        return feed.toDao();
    }
}
