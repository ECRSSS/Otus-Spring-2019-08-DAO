package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@AllArgsConstructor
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
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
    @ManyToMany(mappedBy = "books")
    private Set<Genre> genres;

}
