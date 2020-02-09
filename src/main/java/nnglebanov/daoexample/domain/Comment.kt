package nnglebanov.daoexample.domain

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "COMMENTS")
data class Comment(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = 0,
        @ManyToOne var book: Book?,
        var commentText: String?,
        @field:CreationTimestamp var createdAt: Date? = Date()
)
