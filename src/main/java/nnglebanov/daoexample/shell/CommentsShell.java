package nnglebanov.daoexample.shell;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nnglebanov.daoexample.services.IOService;
import nnglebanov.daoexample.services.business.CommentsService;
import nnglebanov.daoexample.services.business.ObjectsPrintService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class CommentsShell {
    @NonNull
    private final CommentsService commentsService;
    @NonNull
    private final ObjectsPrintService objectsPrintService;
    @NonNull
    private final IOService ioService;

    @ShellMethod("add comment to book")
    public String addCommentToBook() {
        objectsPrintService.outAllBooks();
        return "новое состояние книги: \n" + commentsService.addCommentForBookById(
                ioService.readIntWithMessage(
                        "Введите номер книги к которой хотите добавить комментарий"),
                ioService.readLineWithMessage(
                        "Введите комментари к книге")
        );
    }
}
