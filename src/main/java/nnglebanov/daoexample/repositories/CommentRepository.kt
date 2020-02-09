package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface CommentRepository : JpaRepository<Comment, Int>
