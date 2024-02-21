package com.occucode.ubti.entity;

import com.occucode.ubti.enums.MbtiEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SelfMbtiLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "self_log_num")
  private Long selfLogNum;

  @Column(name = "self_answers_json", nullable = false)
  private String selfAnswersJson;

  @Enumerated(EnumType.STRING)
  @Column(name = "self_result", nullable = false)
  private MbtiEnum selfResult;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_num")
  private User user;

  public static SelfMbtiLog toEntity(String selfAnswersJson, MbtiEnum selfResult, User user) {
    return SelfMbtiLog.builder()
      .selfAnswersJson(selfAnswersJson)
      .selfResult(selfResult)
      .user(user)
      .build();
  }
}
