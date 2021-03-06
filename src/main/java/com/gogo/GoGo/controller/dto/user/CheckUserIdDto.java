package com.gogo.GoGo.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckUserIdDto {

    @NotBlank(message = "아이디를 입력해 주세요")
    private String userId;
}
