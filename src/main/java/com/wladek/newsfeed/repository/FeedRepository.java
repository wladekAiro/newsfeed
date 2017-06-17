package com.wladek.newsfeed.repository;

import com.wladek.newsfeed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wladek on 6/17/17.
 */
@Repository
public interface FeedRepository extends JpaRepository<Feed , Long>{
    public List<Feed> findAllOrderByViewsDesc();
}
