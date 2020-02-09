package nnglebanov.daoexample.domain

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "BOOKS")
data class Book(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = 0,
        var bookTitle: String?,
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "AUTHORS_BOOKS", joinColumns = [JoinColumn(name = "author_id")], inverseJoinColumns = [JoinColumn(name = "book_id")])
        var authors: MutableList<Author>? = mutableListOf(),
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "GENRES_BOOKS", joinColumns = [JoinColumn(name = "genre_id")], inverseJoinColumns = [JoinColumn(name = "book_id")])
        var genres: MutableList<Genre>? = mutableListOf(),
        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "book_id")
        var comments: MutableList<Comment>? = mutableListOf(),
        @field:CreationTimestamp var createdAt: Date? = Date()

) {

    fun addComment(comment: Comment) {
        comments?.add(comment)
    }

    @PreRemove
    private fun deleteFromGenresAndAuthors() {
        for (a in this.authors!!) {
            a.books?.remove(this)
        }
        for (g in this.genres!!) {
            g.books?.remove(this)
        }
    }

}
