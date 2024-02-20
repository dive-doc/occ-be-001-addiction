package com.occucode.ubti.controller;

import com.occucode.ubti.dto.UserDto;
import com.occucode.ubti.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "User API (nickname)")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


  private final UserService userService;

  @Operation(summary = "User(nickname) 등록", description = "User(nickname)을 등록 합니다.")
  @ApiResponse(description = "userNum (고유값)")
  @PostMapping
  public ResponseEntity<Long> registerUser(@RequestBody UserDto userDto) {
    Long userNum = userService.registerUser(userDto);

    return ResponseEntity.ok(userNum);
  }

}
