package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Genre
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface GenreRepository : ReactiveMongoRepository<Genre, String> {
    override fun findAll(): Flux<Genre>

    override fun findById(id: String): Mono<Genre>

    fun save(person: Mono<Genre>): Mono<Genre>
}