package nnglebanov.daoexample.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Genre {
    @NonNull
    private int id;
    @NonNull
    private String title;
}
