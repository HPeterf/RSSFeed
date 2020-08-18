package com.epam.rssfeed.rssfeed

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RssfeedApplication

fun main(args: Array<String>) {
    runApplication<RssfeedApplication>(*args)
}
