package nnglebanov.daoexample.domain

import nnglebanov.daoexample.helpers.Utils
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.MongoId
import java.util.*

@Document
data class Comment(
        @DBRef val book: Book?,
        @Field("message") val message: String,
        @Field("dateTime") val dateTime: Date
) {
    @MongoId
    var id: String = Utils.generateId()
}
