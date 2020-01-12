package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@AllArgsConstructor
@Entity
@Table(name = "AUTHORS")
@NamedEntityGraph(name = "author-books",
        attributeNodes = {@NamedAttributeNode("books")})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private Date createdAt;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "AUTHORS_BOOKS",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    Set<Book> books;
}
