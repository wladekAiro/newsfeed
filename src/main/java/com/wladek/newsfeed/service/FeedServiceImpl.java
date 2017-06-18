package com.wladek.newsfeed.service;

import com.wladek.newsfeed.daos.FeedDao;
import com.wladek.newsfeed.models.NewsFeed;
import com.wladek.newsfeed.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladek on 6/17/17.
 */
@Service
public class FeedServiceImpl implements FeedService {
    private static final String FEED_URL = "http://rss.cnn.com/rss/edition.rss";

    @Autowired
    FeedRepository repository;

    @Override
    public List<FeedDao> getFeeds() {

        if (repository.findAll().isEmpty()){
            refreshFeeds();
        }

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

    @Override
    public boolean refreshFeeds() {
        boolean result = false;
        try {
            repository.save(downloadFeeds());
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private List<NewsFeed> downloadFeeds() throws IOException {
        URL url = new URL(FEED_URL);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        List<NewsFeed> newsFeeds = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("<item>")) {
                line = line.replace("</item>", System.lineSeparator());
                String[] lines = line.split(System.lineSeparator());

                for (String li : lines) {
                    String title = getRequiredString(li, "<title><![CDATA[", "]]></title>");
                    String feedUrl = getRequiredString(li, "<link>", "</link>");
                    String description = getRequiredString(li, "<description><![CDATA[", "]]></description>");

                    if (title != null && feedUrl != null) {
                        NewsFeed newsFeed = new NewsFeed();
                        newsFeed.setTitle(title);
                        newsFeed.setUrl(feedUrl);
                        newsFeed.setDescription(description);

                        newsFeeds.add(newsFeed);
                    }
                }
            }

        }

        reader.close();
        return newsFeeds;
    }

    private String getRequiredString(String line, String openingTag, String closingtag) {
        String result = null;
        if (line.contains("<item>")) {
            if (line.contains(openingTag)) {
                int idx1 = line.indexOf(openingTag);
                String substr = line.substring(idx1);
                substr = substr.replace(openingTag, "");
                int lastidx = substr.indexOf(closingtag);
                result = substr.substring(0, lastidx);
            }
        }


        return result;
    }
}
