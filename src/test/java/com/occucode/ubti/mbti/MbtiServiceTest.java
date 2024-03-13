package com.occucode.ubti.mbti;

import com.occucode.ubti.service.MbtiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MbtiServiceTest {

  @Autowired
  private MbtiService mbtiService;

  @Test
  void getMbtiQuestListTest() {
    assertThat(mbtiService.getMbtiQuestList()).isNotNull();
  }

}
