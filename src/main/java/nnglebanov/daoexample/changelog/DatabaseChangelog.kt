package nnglebanov.daoexample.changelog


import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import com.mongodb.client.MongoDatabase
import nnglebanov.daoexample.domain.Author
import nnglebanov.daoexample.domain.Book
import nnglebanov.daoexample.domain.Comment
import nnglebanov.daoexample.domain.Genre
import org.springframework.data.mongodb.core.MongoTemplate
import java.util.*
import kotlin.collections.ArrayList

@ChangeLog(order = "001")
class DatabaseChangelog {

    private val comments = ArrayList<Comment>()
    private val books = ArrayList<Book>()

    @ChangeSet(order = "001", id = "dropDataBase",author = "ecrsss", runAlways = true)
    fun dropDb(mongoDatabase: MongoDatabase) {
        mongoDatabase.drop()
    }

    @ChangeSet(order = "002", id = "initCommentsCollection",author = "ecrsss", runAlways = true)
    fun initComments(template: MongoTemplate) {
        val comment1 = template.save(Comment(null,"Text#1", Date()))
        val comment2 = template.save(Comment(null,"Text#2", Date()))
        val comment3 = template.save(Comment(null,"Text#3", Date()))
        val comment4 = template.save(Comment(null,"Text#4", Date()))

        val genre1 = template.save(Genre("1first",null,Date()))
        val genre2 = template.save(Genre("2first",null,Date()))
        val genre3 = template.save(Genre("3first",null,Date()))

        val author1 = template.save(Author("1first","1last",null,Date()))
        val author2= template.save(Author("2first","2last",null,Date()))
        val author3 = template.save(Author("3first","3last",null,Date()))

        val book1 = template.save(Book("Book1", arrayListOf(author1,author2)
                , arrayListOf(genre1,genre3), arrayListOf(comment1,comment2),Date()))
        val book2 = template.save(Book("Book2", arrayListOf(author3)
                , arrayListOf(genre2), arrayListOf(comment3,comment4),Date()))
    }


}