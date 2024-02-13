package com.occucode.ubti.entity;

import com.occucode.ubti.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num")
    private Long userNum;

    @Column(name = "nickname", unique = true)
    private String nickname;

    public static User toEntity(UserDto userDto) {
        return User.builder()
                .nickname(userDto.getNickname())
                .build();
    }

}
