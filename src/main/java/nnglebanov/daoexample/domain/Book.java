package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookTitle;
    private Date createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;
}
