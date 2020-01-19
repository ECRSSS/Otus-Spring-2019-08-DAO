package nnglebanov.daoexample.services.business;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import nnglebanov.daoexample.domain.Book;
import nnglebanov.daoexample.domain.Comment;
import nnglebanov.daoexample.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsService {
    @NonNull
    private final BookRepository bookRepository;

    public Book addCommentForBookById(int id, String commentMessage) {
        val optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            val book = optionalBook.get();
            Comment comment = new Comment();
            comment.setBook(book);
            comment.setCommentText(commentMessage);
            book.addComment(comment);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }
}
