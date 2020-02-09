package nnglebanov.daoexample.domain

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "AUTHORS")
data class Author(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = 0,
        @ManyToMany(mappedBy = "authors", cascade = [CascadeType.ALL])
        var books: MutableList<Book>? = mutableListOf(),
        var firstName: String?,
        var lastName: String?,
        @field:CreationTimestamp var createdAt: Date? = Date()
) {


    @PreRemove
    private fun removeAuthorsFromBooks() {
        books?.forEach { x -> x.authors!!.remove(this) }
    }

}
