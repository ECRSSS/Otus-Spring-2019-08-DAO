package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Book {

    private Integer id;
    @NonNull
    private String title;
    @NonNull
    private Integer authorId;
    @NonNull
    private Integer genreId;
}
