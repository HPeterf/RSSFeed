package com.epam.rssfeed.rssfeed.service

import com.epam.rssfeed.rssfeed.DTO.Topic
import com.rometools.rome.io.FeedException
import org.springframework.stereotype.Service
import java.io.IOException

@Service
interface Feedservice {

    @Throws(IOException::class, FeedException::class)
    fun readfeed(): Topic
}