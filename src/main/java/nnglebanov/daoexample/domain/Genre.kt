package nnglebanov.daoexample.domain

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "GENRES")
class Genre(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = 0,
        @ManyToMany(mappedBy = "genres") var books: MutableList<Book>? = mutableListOf(),
        var genreName: String?,
        @field:CreationTimestamp var createdAt: Date? = Date()
) {

    @PreRemove
    private fun removeGenresFromBooks() {
        this.books!!.forEach { x -> x.genres!!.remove(this) }
    }
}
