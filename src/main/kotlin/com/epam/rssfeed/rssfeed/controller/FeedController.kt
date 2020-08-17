package com.epam.rssfeed.rssfeed.controller

import com.epam.rssfeed.rssfeed.DTO.Topic
import com.epam.rssfeed.rssfeed.Entity.TopicEntity
import com.epam.rssfeed.rssfeed.service.Feedservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class FeedController @Autowired constructor(
        private var feedservice: Feedservice
){

    @GetMapping("/rss")
    fun rss(): MutableIterable<TopicEntity> {
        return feedservice.readTopics()
    }

    @PostMapping("/zoliapp")
    fun postTopicForZoli(): Topic {
        return feedservice.postTopics()
    }
}



