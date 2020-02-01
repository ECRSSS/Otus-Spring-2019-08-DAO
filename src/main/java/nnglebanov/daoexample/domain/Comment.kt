package nnglebanov.daoexample.domain

import nnglebanov.daoexample.helpers.Utils
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document
data class Comment(
        @DBRef val book: Book?,
        @Field("message") val message: String,
        @Field("dateTime") val dateTime: Date
) {
    @Id
    var id: String = Utils.generateId()
}
