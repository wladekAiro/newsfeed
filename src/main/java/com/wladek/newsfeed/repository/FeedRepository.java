package com.wladek.newsfeed.repository;

import com.wladek.newsfeed.models.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wladek on 6/17/17.
 */
@Repository
public interface FeedRepository extends JpaRepository<NewsFeed, Long>{
    @Query("SELECT n FROM NewsFeed n order by n.views desc")
    public List<NewsFeed> findAll();
}
