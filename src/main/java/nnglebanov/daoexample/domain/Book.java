package nnglebanov.daoexample.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class Book {

    @NonNull
    private Integer id;
    @NonNull
    private String title;
    @NonNull
    private Integer authorId;
    @NonNull
    private Integer genreId;
}
