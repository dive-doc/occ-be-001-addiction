package com.occucode.ubti.entity;

import com.occucode.ubti.enums.MbtiEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtherMbtiLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "other_log_num")
  private Long otherLogNum;

  @Column(name = "other_answers_json", nullable = false)
  private String otherAnswersJson;

  @Enumerated(EnumType.STRING)
  @Column(name = "other_result", nullable = false)
  private MbtiEnum otherResult;

  // to (from 은 없어도 되는가?)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_num")
  private User user;

  public static OtherMbtiLog toEntity(
    String otherAnswersJson,
    MbtiEnum otherResult,
    User user
  ) {
    return OtherMbtiLog.builder()
      .otherAnswersJson(otherAnswersJson)
      .otherResult(otherResult)
      .user(user)
      .build();
  }
}
