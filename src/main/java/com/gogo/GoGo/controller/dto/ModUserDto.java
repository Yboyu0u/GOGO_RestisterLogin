package com.gogo.GoGo.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModUserDto {


    private String nickname;
    private String introduce;

    //TODO: 여행 취향
    //TODO: 프로필 이미지
}