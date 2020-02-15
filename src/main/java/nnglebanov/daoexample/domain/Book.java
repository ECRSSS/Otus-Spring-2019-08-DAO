package nnglebanov.daoexample.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@EqualsAndHashCode(exclude = {"genres", "authors"})
@ToString(exclude = {"genres", "authors"})
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

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "AUTHORS_BOOKS",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "GENRES_BOOKS",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Genre> genres;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @PreRemove
    private void deleteFromGenresAndAuthors() {
        for (Author a : authors) {
            a.getBooks().remove(this);
        }
        for (Genre g : genres) {
            g.getBooks().remove(this);
        }
    }

}
