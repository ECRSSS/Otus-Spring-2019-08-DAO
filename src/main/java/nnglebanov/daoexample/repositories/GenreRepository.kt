package nnglebanov.daoexample.repositories

import nnglebanov.daoexample.domain.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface GenreRepository : JpaRepository<Genre, Int>
