package com.occucode.ubti.vo;

import com.occucode.ubti.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserVo {
    private Long userNum;
    private String nickname;

    public static UserVo toUserVo(User user) {
        return UserVo.builder()
                .userNum(user.getUserNum())
                .nickname(user.getNickname())
                .build();
    }

}
