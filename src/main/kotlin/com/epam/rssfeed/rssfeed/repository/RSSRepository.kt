package com.epam.rssfeed.rssfeed.repository

import com.epam.rssfeed.rssfeed.Entity.TopicEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface RSSRepository: CrudRepository<TopicEntity, Long> {

    @Query(value = "SELECT title FROM TopicEntity")
    fun getTitleList(): List<String>

}