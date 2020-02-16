package nnglebanov.daoexample.rest.dto

import nnglebanov.daoexample.domain.Author
import java.util.*


class AuthorDto {
    private var id: String? = null
    private var firstName: String? = null
    private var lastName: String? = null

    companion object {

        fun toDto(author: Author): AuthorDto {
            return AuthorDto().also {
                it.id = author.id
                it.firstName = author.firstName
                it.lastName = author.lastName
            }
        }

        fun toEntity(authorDto: AuthorDto): Author {
            return Author(
                    firstName = authorDto.firstName,
                    lastName = authorDto.lastName,
                    books = null,
                    dateTime = Date()
            )
        }
    }
}
