package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKS")
@NamedEntityGraph(name = "book-authors",
        attributeNodes = {@NamedAttributeNode("authors")})
@NamedEntityGraph(name = "book-genres",
        attributeNodes = {@NamedAttributeNode("genres")})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String bookTitle;
    private Date createdAt;
    @ManyToMany
    @JoinTable(
            name = "AUTHORS_BOOKS",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private Set<Author> authors = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "GENRES_BOOKS",
            joinColumns = { @JoinColumn(name = "genre_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private Set<Genre> genres = new HashSet<>();

}
