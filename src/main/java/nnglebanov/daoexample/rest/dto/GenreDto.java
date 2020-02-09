package nnglebanov.daoexample.rest.dto;

import lombok.Data;
import nnglebanov.daoexample.domain.Genre;

import java.util.Date;

@Data
public class GenreDto {
    private Integer id;
    private String genreName;
    private Date createdAt;

    public static GenreDto toDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setGenreName(genre.getGenreName());
        genreDto.setCreatedAt(genre.getCreatedAt());
        return genreDto;
    }
}
