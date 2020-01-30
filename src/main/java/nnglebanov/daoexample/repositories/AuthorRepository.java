package nnglebanov.daoexample.repositories;

import nnglebanov.daoexample.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
