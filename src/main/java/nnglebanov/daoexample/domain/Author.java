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

    @ManyToMany(mappedBy = "authors")
    Set<Book> books = new HashSet<>();
}
