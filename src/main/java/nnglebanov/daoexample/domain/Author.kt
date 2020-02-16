package nnglebanov.daoexample.domain

import nnglebanov.daoexample.helpers.Utils
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.MongoId
import java.util.*
import java.util.stream.Collectors


@Document
data class Author(
        @Field("firstname") var firstName: String?,
        @Field("lastName") var lastName: String?,
        @DBRef val books: MutableList<Book>?,
        @Field("dateTime") val dateTime: Date
) {
    @MongoId var id: String = Utils.generateId()

    override fun toString(): String {
        return "$firstName $lastName books(${books?.stream()?.map { x -> x.bookTitle }
                ?.collect(Collectors.joining(","))})"
    }
}
