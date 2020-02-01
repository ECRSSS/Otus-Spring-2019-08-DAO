package nnglebanov.daoexample.shell


import nnglebanov.daoexample.domain.Author
import nnglebanov.daoexample.repositories.AuthorRepository
import nnglebanov.daoexample.services.IOService
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import java.util.*
import java.util.stream.Collectors


@ShellComponent
class AuthorCrudShell(private val authorRepository: AuthorRepository,
                      private val ioService: IOService) {


    @ShellMethod("insert author")
    fun authorInsert(): String {
        var newAuthor = Author(
                firstName = ioService.readLineWithMessage("input first name of new Author:"),
                lastName = ioService.readLineWithMessage("input last name of new Author"),
                books = null,
                dateTime = Date()
        )
        authorRepository.save(newAuthor)
        return "new Author correctly added"
    }

    @ShellMethod("update author")
    fun authorUpdate(): String {
        val id: String = ioService.readLineWithMessage("input id of Author which you want to update")
        val authorToUpdate = authorRepository.findById(id).get()
        authorToUpdate.firstName = ioService.readLineWithMessage("input first name of new Author:")
        authorToUpdate.lastName = ioService.readLineWithMessage("input last name of new Author")
        authorRepository.save(authorToUpdate)
        return authorToUpdate.toString()
    }

    @ShellMethod("get author by id")
    fun authorGet(): String {
        return authorRepository.findById(ioService.readLineWithMessage("input id of Author")).toString()
    }

    @ShellMethod("get all authors")
    fun authorGetAll(): String {
        return authorRepository.findAll().stream().map {
            x->x.toString()
        }.collect(Collectors.joining(","))
    }

    @ShellMethod("delete Author by id")
    fun authorDelete(): String {
        authorRepository.deleteById(ioService.readLineWithMessage("input id of Author you want to delete"))
        return "author succesfully deleted"
    }
}
