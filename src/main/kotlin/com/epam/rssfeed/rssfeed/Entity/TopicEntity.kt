package com.epam.rssfeed.rssfeed.Entity

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@Table
class TopicEntity: Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column
    @NotBlank
    var title: String = ""

    @Column
    @NotBlank
    var link: String = ""

    @Column(length = 10000)
    @NotBlank
    var description: String = ""

    @Column
    @NotBlank
    var date: LocalDate = LocalDate.now()
}