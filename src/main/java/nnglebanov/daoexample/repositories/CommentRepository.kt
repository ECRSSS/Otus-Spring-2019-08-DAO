package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Comment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : MongoRepository<Comment,String>{
}