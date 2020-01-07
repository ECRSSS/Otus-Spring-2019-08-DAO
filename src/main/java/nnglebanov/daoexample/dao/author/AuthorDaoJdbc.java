package nnglebanov.daoexample.dao.author;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.domain.Author;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorDaoJdbc implements AuthorDao {
    @NonNull
    private final NamedParameterJdbcOperations jdbc;
    //TODO NamedParameterJDBCTemplate

    @Override
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM AUTHOR", ImmutableMap.of(),Integer.class);
    }

    @Override
    public void insert(Author author) {
        jdbc.queryForObject("INSERT INTO AUTHOR (FIRST_NAME,LAST_NAME) VALUES (':firstName', 'lastName');",
                ImmutableMap.of(),
                )
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Author findById(int id) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }
}