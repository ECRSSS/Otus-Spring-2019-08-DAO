package nnglebanov.daoexample.dao.jdbc;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.dao.BookDao;
import nnglebanov.daoexample.domain.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao {
    @NonNull
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM BOOK", ImmutableMap.of(), Integer.class);
    }

    @Override
    public void insert(Book book) {
        jdbc.update("INSERT INTO BOOK (TITLE,AUTHOR_ID,GENRE_ID) VALUES (:title, :authorId, :genreId);",
                ImmutableMap.of(
                        "title", book.getTitle(),
                        "authorId", book.getAuthorId(),
                        "genreId", book.getGenreId()
                )
        );
    }

    @Override
    public void update(Book book) {
        jdbc.update("UPDATE BOOK SET TITLE = :title, AUTHOR_ID = :authorId, GENRE_ID = :genreId WHERE ID = :id",
                ImmutableMap.of(
                        "title", book.getTitle(),
                        "authorId", book.getAuthorId(),
                        "genreId", book.getGenreId()
                )
        );
    }

    @Override
    public void deleteById(int id) {
        jdbc.update("DELETE FROM AUTHOR WHERE ID = :id",
                ImmutableMap.of(
                        "id", id
                ));
    }

    @Override
    public Book findById(int id) {
        return jdbc.queryForObject("SELECT * FROM BOOK WHERE ID = :id",
                ImmutableMap.of(
                        "id", id
                ), new BookMapper());
    }

    @Override
    public List<Book> findAll() {
        return jdbc.query("SELECT * FROM BOOK", new BookMapper());
    }

    private static final class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Book(
                    rs.getInt("ID"),
                    rs.getString("TITLE"),
                    rs.getInt("AUTHOR_ID"),
                    rs.getInt("GENRE_ID")
            );
        }
    }
}