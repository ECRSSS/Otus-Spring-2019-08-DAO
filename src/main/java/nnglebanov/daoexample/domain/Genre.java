package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "GENRES")
@NamedEntityGraph(name = "genre-books",
        attributeNodes = {@NamedAttributeNode("books")})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String genreName;
    private Date createdAt;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "GENRES_BOOKS",
            joinColumns = { @JoinColumn(name = "genre_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    Set<Book> books;
}
