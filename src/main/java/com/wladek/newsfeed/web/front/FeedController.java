package com.wladek.newsfeed.web.front;

import com.wladek.newsfeed.daos.FeedDao;
import com.wladek.newsfeed.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wladek on 6/17/17.
 */
@RestController
@RequestMapping(value = "/rest")
public class FeedController {
    @Autowired
    FeedService feedService;
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    @ResponseBody
    public List<FeedDao> getFeeds(){
        return feedService.getFeeds();
    }
}