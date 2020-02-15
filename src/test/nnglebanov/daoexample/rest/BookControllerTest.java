package nnglebanov.daoexample.rest;

import nnglebanov.daoexample.domain.Book;
import nnglebanov.daoexample.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deleteTest() throws Exception {
        given(bookRepository.findById(any()))
                .willReturn(java.util.Optional.of(
                        new Book(1, "example", new Date(), null, null, null)
                ));
        bookRepository.deleteById(1);
        assertEquals(bookRepository.findById(1).get(), null);
        mockMvc.perform(delete("/api/books/1")).andExpect(status().isOk());
        assertEquals(null,bookRepository.findById(1));
    }

}
