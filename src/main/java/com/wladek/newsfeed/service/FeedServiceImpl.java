package com.wladek.newsfeed.service;

import com.wladek.newsfeed.daos.FeedDao;
import com.wladek.newsfeed.models.NewsFeed;
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
        List<NewsFeed> newsFeeds = repository.findAll();
        List<FeedDao> feedDaoList = new ArrayList<>();

        for (NewsFeed newsFeed : newsFeeds) {
            feedDaoList.add(newsFeed.toDao());
        }

        return feedDaoList;
    }

    @Override
    public FeedDao addView(FeedDao feedDao) {
        NewsFeed newsFeed = repository.findOne(feedDao.getId());
        newsFeed.setViews(newsFeed.getViews() + new Long(1));
        repository.save(newsFeed);
        return newsFeed.toDao();
    }
}
