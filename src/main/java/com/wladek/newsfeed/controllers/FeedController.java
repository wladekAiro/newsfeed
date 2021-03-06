package com.wladek.newsfeed.controllers;

import com.wladek.newsfeed.daos.FeedDao;
import com.wladek.newsfeed.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wladek on 6/17/17.
 */
@RestController
@RequestMapping(value = "/api")
public class FeedController {
    @Autowired
    FeedService feedService;

    @RequestMapping(value = "/newsfeed", method = RequestMethod.GET)
    @ResponseBody
    public List<FeedDao> getFeeds() {
        return feedService.getFeeds();
    }

    @RequestMapping(value = "/ratelink", method = RequestMethod.PUT , consumes = "application/json")
    @ResponseBody
    public String rateLink(@RequestBody FeedDao feedDao) {
        feedService.addView(feedDao);
        return "Ok";
    }
}
