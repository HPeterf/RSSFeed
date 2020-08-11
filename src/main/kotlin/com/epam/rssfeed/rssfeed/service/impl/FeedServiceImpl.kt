package com.epam.rssfeed.rssfeed.service.impl

import com.epam.rssfeed.rssfeed.DTO.Topic
import com.epam.rssfeed.rssfeed.service.Feedservice
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.io.IOException
import java.net.URL
import kotlin.streams.toList


@Service
class FeedServiceImpl : Feedservice {

    @Throws(IOException::class, FeedException::class)
    @Scheduled(cron = "\${rss.feed.latest}")
    override fun readfeed(): Topic {
        var feedSource = URL("https://index.hu/24ora/rss/")
        var input = SyndFeedInput().build(XmlReader(feedSource))
        var entryList = input.entries
        var topicList = Topic(entryList.stream().map { t -> t.title }.distinct().toList())

        return topicList

    }
}

