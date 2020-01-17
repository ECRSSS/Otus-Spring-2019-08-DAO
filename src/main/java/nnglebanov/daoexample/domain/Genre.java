package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GENRES")
@NamedEntityGraph(name = "genre-books",
        attributeNodes = {@NamedAttributeNode("books")})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String genreName;
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "GENRE_ID")
    Set<Book> books;
}
