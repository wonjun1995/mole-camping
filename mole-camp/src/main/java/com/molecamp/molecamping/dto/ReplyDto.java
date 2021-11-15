package com.molecamp.molecamping.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto {
    private int userId;
    private int postId;
    private String content;

}
