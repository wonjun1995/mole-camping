package com.molecamp.molecamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampingSpotReplyDto {
    private int writer_id;
    private int camping_spot_id;
    private String content;
}
