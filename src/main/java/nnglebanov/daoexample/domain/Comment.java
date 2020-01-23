package nnglebanov.daoexample.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@EqualsAndHashCode(exclude = "book")
@ToString(exclude = "book")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @ManyToOne
    Book book;
    @NonNull
    private String commentText;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;
    @CreationTimestamp
    private Date createdAt;

    @PreRemove
    private void removeComment() {
        book.getComments().remove(this);
    }
}
