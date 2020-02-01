package nnglebanov.daoexample.shell

import nnglebanov.daoexample.services.IOService
import nnglebanov.daoexample.services.business.CommentsService
import nnglebanov.daoexample.services.business.ObjectsPrintService
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class CommentsShell(private val commentsService: CommentsService,
                    private val objectsPrintService: ObjectsPrintService,
                    private val ioService: IOService) {


    @ShellMethod("add comment to book")
    fun addCommentToBook(): String {
        objectsPrintService!!.outAllBooks()
        return "новое состояние книги: \n" + commentsService.addCommentForBookById(
                ioService.readLineWithMessage(
                        "Введите номер книги к которой хотите добавить комментарий"),
                ioService.readLineWithMessage(
                        "Введите комментари к книге")
        )!!
    }
}
