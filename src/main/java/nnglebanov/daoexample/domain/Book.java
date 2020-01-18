package nnglebanov.daoexample.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@EqualsAndHashCode(exclude = "books")
@ToString(exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;
    private String bookTitle;
    @CreationTimestamp
    private Date createdAt;

    @ManyToMany(targetEntity = Author.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "AUTHORS_BOOKS",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private Set<Author> authors;

    @ManyToMany(targetEntity = Genre.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "GENRES_BOOKS",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Genre> genres;

}
