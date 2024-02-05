package com.occucode.ubti.user;

import com.occucode.ubti.dto.UserDto;
import com.occucode.ubti.service.UserService;
import com.occucode.ubti.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTests {

    @Autowired
    private UserService userService;

    @Test
    void userRegisterTest() {
        UserDto userDto = new UserDto();
        userDto.setNickname("testNickname");

        userService.registerUser(userDto);
    }

    @Test
    void getUserTest() {
        UserVo userVo = userService.getUser("testNickname");

        assertThat(userVo).isNotNull();

    }


}
