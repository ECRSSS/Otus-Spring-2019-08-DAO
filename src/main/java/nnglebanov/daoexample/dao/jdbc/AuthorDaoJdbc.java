package nnglebanov.daoexample.dao.jdbc;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.dao.AuthorDao;
import nnglebanov.daoexample.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorDaoJdbc implements AuthorDao {
    @NonNull
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM AUTHOR", ImmutableMap.of(), Integer.class);
    }

    @Override
    public void insert(Author author) {
        jdbc.update("INSERT INTO AUTHOR (FIRST_NAME,LAST_NAME) VALUES (:firstName, :lastName);",
                ImmutableMap.of(
                        "firstName", author.getFirstName(),
                        "lastName", author.getLastName()
                )
        );
    }

    @Override
    public void update(Author author) {
        jdbc.update("UPDATE AUTHOR SET FIRST_NAME = :firstName, LAST_NAME = :lastName WHERE ID = :id",
                ImmutableMap.of(
                        "firstName", author.getFirstName(),
                        "lastName", author.getLastName(),
                        "id", author.getId()
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
    public Author findById(int id) {
        return jdbc.queryForObject("SELECT * FROM AUTHOR WHERE ID = :id",
                ImmutableMap.of(
                        "id", id
                ), new AuthorMapper());
    }

    @Override
    public List<Author> findAll() {
        return jdbc.query("SELECT * FROM AUTHOR", new AuthorMapper());
    }

    private static final class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Author(
                    rs.getInt("ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME")
            );
        }
    }
}