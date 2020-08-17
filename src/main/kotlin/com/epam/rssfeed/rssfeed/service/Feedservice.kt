package com.epam.rssfeed.rssfeed.service

import com.epam.rssfeed.rssfeed.DTO.Topic
import com.epam.rssfeed.rssfeed.Entity.TopicEntity
import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.io.FeedException
import org.springframework.stereotype.Service
import java.io.IOException


interface Feedservice {

    fun readTopics(): MutableIterable<TopicEntity>
    fun postTopics(): Topic
}