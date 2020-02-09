package nnglebanov.daoexample.rest.dto;


import lombok.Data;
import nnglebanov.daoexample.domain.Comment;

import java.util.Date;

@Data
public class CommentDto {
    private Integer id;
    private String commentText;
    private Date createdAt;

    public static CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setCommentText(comment.getCommentText());
        commentDto.setCreatedAt(comment.getCreatedAt());
        return commentDto;
    }
}
