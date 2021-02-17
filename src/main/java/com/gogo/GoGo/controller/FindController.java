package com.gogo.GoGo.controller;

import com.gogo.GoGo.controller.dto.FindUserIDRequestDto;
import com.gogo.GoGo.controller.dto.FindUserIdResponseDto;
import com.gogo.GoGo.controller.dto.FindPasswordRequestDto;
import com.gogo.GoGo.controller.dto.FindPasswordResponseDto;
import com.gogo.GoGo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping(value = "/api/find")
@RestController
@Slf4j
public class FindController {
    @Autowired
    private UserService userService;

    //userId 찾기
    @PostMapping("/userid")
    public ResponseEntity<FindUserIdResponseDto> findUserId(@RequestBody FindUserIDRequestDto dto) throws URISyntaxException {
        String userId =  userService.findUserId(dto.getName(), dto.getEmail());

        FindUserIdResponseDto responseDto = FindUserIdResponseDto.builder()
                .userId(userId)
                .build();

        String url ="/api/find/email";
        return ResponseEntity.created(new URI(url))
                .body(responseDto);
    }

    //password 찾기
    @PostMapping("/password")
    public ResponseEntity<FindPasswordResponseDto> findPassword(@RequestBody FindPasswordRequestDto dto) throws URISyntaxException {
        String password = userService.findPassword(dto.getEmail(),dto.getName());

        FindPasswordResponseDto responseDto = FindPasswordResponseDto.builder()
                .password(password)
                .build();

        String url = "/api/find/password";
        return ResponseEntity.created(new URI(url))
                .body(responseDto);

    }
    //TODO: findPassword
}