package nnglebanov.daoexample.domain

import nnglebanov.daoexample.helpers.Utils
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.MongoId
import java.util.*


@Document
data class Book(
        @Field("bookTitle") var bookTitle: String?,
        @Field("authors") val authors: MutableList<Author>?,
        @Field("genres") val genres: MutableList<Genre>?,
        @Field("comments") val comments: MutableList<Comment>?,
        @Field("dateTime")val dateTime: Date
) {
    @MongoId
    var id: String = Utils.generateId()

    fun addComment(comment: Comment) {
        comments?.add(comment)
    }
}
