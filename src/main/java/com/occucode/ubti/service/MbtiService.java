package com.occucode.ubti.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.occucode.ubti.dto.MbtiQuestionResponseDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitFriendRequestDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitResponseDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitSelfRequestDto;

import java.util.List;

public interface MbtiService {

  List<MbtiQuestionResponseDto> getMbtiQuestList();

  MbtiQuestionSubmitResponseDto submitQuestionSelf(
    MbtiQuestionSubmitSelfRequestDto mbtiQuestionSubmitSelfRequestDto) throws JsonProcessingException;

  MbtiQuestionSubmitResponseDto submitQuestionFriend(
    MbtiQuestionSubmitFriendRequestDto mbtiQuestionSubmitFriendRequestDto) throws JsonProcessingException;
}
