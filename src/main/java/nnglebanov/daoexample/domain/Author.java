package nnglebanov.daoexample.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@EqualsAndHashCode(exclude = "books")
@ToString(exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTHORS")
public class Author {
    @ManyToMany(mappedBy = "authors")
    Set<Book> books;
    private String firstName;
    private String lastName;
    @CreationTimestamp
    private Date createdAt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;
}
