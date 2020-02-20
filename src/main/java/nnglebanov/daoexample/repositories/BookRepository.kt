package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Book
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono



@Repository
interface BookRepository : ReactiveMongoRepository<Book, String> {
    override fun findAll(): Flux<Book>

    override fun findById(id: String): Mono<Book>

    fun save(person: Mono<Book>): Mono<Book>
}