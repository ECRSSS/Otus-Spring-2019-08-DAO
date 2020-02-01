package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Author
import nnglebanov.daoexample.domain.Book
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : MongoRepository<Author,String> {
}