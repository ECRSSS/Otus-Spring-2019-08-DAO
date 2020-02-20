package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Comment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface ReactiveCommentRepository : ReactiveMongoRepository<Comment, String> {
    override fun findAll(): Flux<Comment>

    override fun findById(id: String): Mono<Comment>

    fun save(person: Mono<Comment>): Mono<Comment>
}