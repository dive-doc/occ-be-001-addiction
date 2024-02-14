package com.occucode.ubti.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "note_num")
  private Long noteNum;

  @Column(name = "note_detail")
  private String noteDetail;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_num")
  private User user;

}
