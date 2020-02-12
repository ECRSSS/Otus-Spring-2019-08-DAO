package nnglebanov.daoexample.rest.dto;

import lombok.Data;
import nnglebanov.daoexample.domain.Author;

import java.util.Date;

@Data
public class AuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date createdAt;

    public static AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setCreatedAt(author.getCreatedAt());
        return authorDto;
    }

    public static Author toEntity(AuthorDto authorDto){
        Author dto
    }
}
