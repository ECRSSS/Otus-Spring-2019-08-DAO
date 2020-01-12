package nnglebanov.daoexample.dao.jdbc;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.dao.GenreDao;
import nnglebanov.daoexample.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreDaoJdbc implements GenreDao {
    @NonNull
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM GENRE", ImmutableMap.of(), Integer.class);
    }

    @Override
    public void insert(Genre genre) {
        jdbc.update("INSERT INTO GENRE (TITLE) VALUES (:title);",
                ImmutableMap.of(
                        "title", genre.getTitle()
                )
        );
    }

    @Override
    public void update(Genre genre) {
        jdbc.update("UPDATE GENRE SET TITLE = :title WHERE ID = :id",
                ImmutableMap.of(
                        "title", genre.getTitle(),
                        "id", genre.getId()
                )
        );
    }

    @Override
    public void deleteById(int id) {
        jdbc.update("DELETE FROM GENRE WHERE ID = :id",
                ImmutableMap.of(
                        "id", id
                ));
    }

    @Override
    public Genre findById(int id) {
        return jdbc.queryForObject("SELECT * FROM GENRE WHERE ID = :id",
                ImmutableMap.of(
                        "id", id
                ), new GenreMapper());
    }

    @Override
    public List<Genre> findAll() {
        return jdbc.query("SELECT * FROM GENRE", new GenreMapper());
    }

    private static final class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Genre(
                    rs.getInt("ID"),
                    rs.getString("TITLE")
            );
        }
    }
}