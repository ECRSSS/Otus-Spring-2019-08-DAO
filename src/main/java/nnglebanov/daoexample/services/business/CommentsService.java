package nnglebanov.daoexample.services.business;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import nnglebanov.daoexample.domain.Book;
import nnglebanov.daoexample.domain.Comment;
import nnglebanov.daoexample.repositories.BookRepositoryJpa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentsService {
    @NonNull
    private final BookRepositoryJpa bookRepositoryJpa;

    @Transactional
    public Book addCommentForBookById(int id, String commentMessage) {
        val optionalBook = bookRepositoryJpa.findById(id);
        if (optionalBook.isPresent()) {
            val book = optionalBook.get();
            Comment comment = new Comment();
            comment.setBook(book);
            comment.setCommentText(commentMessage);
            book.addComment(comment);
            return book;
        } else {
            return null;
        }
    }
}
