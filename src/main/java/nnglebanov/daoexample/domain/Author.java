package nnglebanov.daoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Author {
    private Integer id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

}
