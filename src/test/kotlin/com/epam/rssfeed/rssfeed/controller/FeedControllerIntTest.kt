package com.epam.rssfeed.rssfeed.controller

import com.epam.rssfeed.rssfeed.DTO.Topic
import com.epam.rssfeed.rssfeed.service.Feedservice
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FeedControllerIntTest {

    @Autowired
    lateinit var feedservice: Feedservice

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun testFeedController() {

        var request: HttpEntity<Topic> = HttpEntity(Topic(feedservice.readfeed().topicList))
        val result = testRestTemplate.postForEntity("/rss",request, String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
    }
}