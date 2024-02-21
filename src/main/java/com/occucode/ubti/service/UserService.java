package com.occucode.ubti.service;

import com.occucode.ubti.dto.UserDto;
import com.occucode.ubti.vo.UserVo;

public interface UserService {

  Long registerUser(UserDto userDto);

  UserVo getUser(Long userNum);

}
