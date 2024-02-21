package com.occucode.ubti.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MbtiQuestion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "question_num")
  private Long questionNum;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "question")
  private List<MbtiAnswerItem> mbtiAnswerItemList;

  public static MbtiQuestion toEntity(String description) {
    return MbtiQuestion.builder()
      .description(description)
      .build();
  }
}
