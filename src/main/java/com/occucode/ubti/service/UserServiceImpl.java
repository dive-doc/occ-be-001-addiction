package com.occucode.ubti.service;

import com.occucode.ubti.dto.UserDto;
import com.occucode.ubti.entity.User;
import com.occucode.ubti.repository.UserRepository;
import com.occucode.ubti.utils.exception.CustomException;
import com.occucode.ubti.utils.exception.CustomExceptionCode;
import com.occucode.ubti.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  @Transactional
  public Long registerUser(UserDto userDto) {
    boolean hasUser = userRepository.findByNickname(userDto.getNickname()) != null;

    if(hasUser) {
      throw new CustomException(CustomExceptionCode.USER_EXISTS);
    }

    User user = User.toEntity(userDto);
    userRepository.save(user);

    return user.getUserNum();
  }

  @Override
  @Transactional(readOnly = true)
  public UserVo getUser(Long userNum) {
    User user = userRepository.findByUserNum(userNum);

    return UserVo.toUserVo(user);
  }

}
