package nnglebanov.daoexample.rest.dto;

import lombok.Data;
import nnglebanov.daoexample.domain.Author;

@Data
public class AuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;

    public static AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        return authorDto;
    }

    public static Author toEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setFirstName(authorDto.firstName);
        author.setLastName(authorDto.lastName);
        return author;
    }
}
