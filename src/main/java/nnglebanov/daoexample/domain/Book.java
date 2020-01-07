package nnglebanov.daoexample.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Book {

    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private int authorId;
    @NonNull
    private int genreId;
}
