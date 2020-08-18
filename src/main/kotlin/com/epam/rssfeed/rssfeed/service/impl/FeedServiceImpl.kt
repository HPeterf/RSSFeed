package com.epam.rssfeed.rssfeed.service.impl

import com.epam.rssfeed.rssfeed.DTO.Topic
import com.epam.rssfeed.rssfeed.Entity.TopicEntity
import com.epam.rssfeed.rssfeed.repository.RSSRepository
import com.epam.rssfeed.rssfeed.service.Feedservice
import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.io.IOException
import java.net.URL


@Service
class FeedServiceImpl @Autowired constructor(private var rssRepository: RSSRepository): Feedservice {

     private final val address = "https://index.hu/24ora/rss/"

    init {
        saveTopics()
    }


    override fun readTopics(): MutableIterable<TopicEntity> {
        return rssRepository.findAll()
    }

    override fun postTopics(): Topic {
        return Topic(rssRepository.getTitleList())
    }


    @Scheduled(cron = "\${rss.feed.latest}")
    private fun saveTopics() {
        getEntryList()?.forEach { entry: SyndEntry ->
            run {
                val topicEntity = TopicEntity()
                topicEntity.title = entry.title
                topicEntity.link = entry.link
                topicEntity.description = entry.description.value.toString()
                rssRepository.save(topicEntity)
            }
        }
    }

    @Throws(IOException::class, FeedException::class)
    private fun getEntryList(): List<SyndEntry>? {
        val feedSource = URL(address)
        val input = SyndFeedInput().build(XmlReader(feedSource))
        return input.entries
    }
}

