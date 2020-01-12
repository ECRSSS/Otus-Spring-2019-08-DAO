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
@Table(name = "GENRES")
@NamedEntityGraph(name = "genre-books",
        attributeNodes = {@NamedAttributeNode("books")})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String genreName;
    private Date createdAt;
    @ManyToMany(mappedBy = "genres")
    Set<Book> books= new HashSet<>();
}
