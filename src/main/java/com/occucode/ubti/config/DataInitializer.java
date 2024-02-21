package com.occucode.ubti.config;

import com.occucode.ubti.entity.MbtiAnswerItem;
import com.occucode.ubti.entity.MbtiQuestion;
import com.occucode.ubti.entity.MbtiResult;
import com.occucode.ubti.entity.User;
import com.occucode.ubti.enums.MbtiEnum;
import com.occucode.ubti.enums.MbtiItemEnum;
import com.occucode.ubti.repository.MbtiAnswerItemRepository;
import com.occucode.ubti.repository.MbtiQuestionRepository;
import com.occucode.ubti.repository.MbtiResultRepository;
import com.occucode.ubti.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

  @Bean
  // mbti result data
  public CommandLineRunner initMbtiResultData(MbtiResultRepository repository) {
    return args -> {
      int id = 0;
      // 더미 데이터 생성 및 저장 로직
      for (MbtiEnum mbti : MbtiEnum.values()) {
        MbtiResult result = new MbtiResult(
          (long) id, mbti, mbti.getValue() + " description", mbti, mbti
        );
        id++;
        // result 속성 설정
        repository.save(result);
      }
    };
  }

  @Bean
  // mbti answer, itmem data
  public CommandLineRunner initMbtiQuestionData(
    MbtiQuestionRepository mbtiQuestionRepository,
    MbtiAnswerItemRepository mbtiAnswerItemRepository
  ) {
    return args -> {
      int id = 0;
      // 더미 데이터 생성 및 저장 로직
      while (id < 5) {
        MbtiQuestion mbtiQuestion = MbtiQuestion.toEntity("description " + id);
        mbtiQuestionRepository.save(mbtiQuestion);

        int answerItemId = 0;
        while (answerItemId < 5) {
          MbtiAnswerItem mbtiAnswerItem = MbtiAnswerItem.toEntity(
            "question " + id + ": Item " + answerItemId, MbtiItemEnum.E, 10, mbtiQuestion
          );
          mbtiAnswerItemRepository.save(mbtiAnswerItem);
          answerItemId++;
        }
        id++;
      }
    };
  }

  @Bean
  // user data
  public CommandLineRunner initUser(UserRepository repository) {
    return args -> {
      repository.save(new User(
        1L, "skim : D"
      ));
    };
  }
}
