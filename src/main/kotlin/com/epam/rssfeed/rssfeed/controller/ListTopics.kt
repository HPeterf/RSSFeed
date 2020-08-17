package com.epam.rssfeed.rssfeed.controller

import com.epam.rssfeed.rssfeed.service.Feedservice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ListTopics @Autowired constructor(
        private var feedservice: Feedservice) {

    @GetMapping("/home")
    fun getTopics(model: Model): String {

        if (feedservice.readTopics().toList().isEmpty()) {
            return "no-topics"
        }
        val topicList = feedservice.readTopics().toList()

        model.addAttribute("topicList", topicList)

        return "homepage"
    }
}