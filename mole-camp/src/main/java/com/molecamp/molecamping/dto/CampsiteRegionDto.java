package com.molecamp.molecamping.dto;

import lombok.*;

@Getter
@Setter
public class CampsiteRegionDto {
    private String doNm;
    private long count;

    public CampsiteRegionDto(String doNm, long count) {
        this.doNm = doNm;
        this.count = count;
    }
}
