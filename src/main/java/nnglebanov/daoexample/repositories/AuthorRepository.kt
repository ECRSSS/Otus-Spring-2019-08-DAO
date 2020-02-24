package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Author
import nnglebanov.daoexample.domain.Book
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface AuthorRepository : ReactiveMongoRepository<Author, String> {
    override fun findAll(): Flux<Author>

    override fun findById(id: String): Mono<Author>

    fun save(person: Mono<Book>): Mono<Author>
}