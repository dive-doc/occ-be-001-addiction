package com.occucode.ubti.entity;

import com.occucode.ubti.enums.MbtiItemEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data // getter, setter, toString, equals, hasCode 메소드 제공
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MbtiQuestion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "question_num")
  private Long questionNum;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "question")
  private List<MbtiAnswerItem> mbtiAnswerItemList;
}
