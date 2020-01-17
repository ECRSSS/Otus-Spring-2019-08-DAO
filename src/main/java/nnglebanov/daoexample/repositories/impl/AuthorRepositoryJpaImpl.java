package nnglebanov.daoexample.repositories.impl;

import nnglebanov.daoexample.domain.Author;
import nnglebanov.daoexample.repositories.AuthorRepositoryJpa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class AuthorRepositoryJpaImpl implements AuthorRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Author save(Author author) {
        if (author.getId() <= 0) {
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    @Override
    public void deleteById(int id) {
        Query query = em.createQuery("delete " +
                "from Author a " +
                "where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Optional<Author> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);//  join fetch a.books
        return query.getResultList();
    }
}
