package com.occucode.ubti.service;

import com.occucode.ubti.dto.UserDto;
import com.occucode.ubti.vo.UserVo;

public interface UserService {

  void registerUser(UserDto userDto);

  UserVo getUser(String nickName);

}
