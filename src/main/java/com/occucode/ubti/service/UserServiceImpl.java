package com.occucode.ubti.service;

import com.occucode.ubti.dto.UserDto;
import com.occucode.ubti.entity.User;
import com.occucode.ubti.repository.UserRepository;
import com.occucode.ubti.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public void registerUser(UserDto userDto) {
    User user = User.toEntity(userDto);

    userRepository.save(user);
  }

  @Override
  public UserVo getUser(String nickName) {
    User user = userRepository.findByNickname(nickName);

    return UserVo.toUserVo(user);
  }
}
