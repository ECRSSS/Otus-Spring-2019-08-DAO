package nnglebanov.daoexample.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Author {
    @NonNull
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
