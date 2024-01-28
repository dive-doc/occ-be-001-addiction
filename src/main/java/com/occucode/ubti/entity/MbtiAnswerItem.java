package com.occucode.ubti.entity;

import com.occucode.ubti.enums.MbtiItemEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // getter, setter, toString, equals, hasCode 메소드 제공
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MbtiAnswerItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_num")
    private Long itemNum;

    @Column(name = "description")
    private String description;

    @Column(name = "item")
    private MbtiItemEnum item; // mbti 의 각 항목 (E, I, N, S, T, F, P, J)

    @Column(name = "score")
    private Integer score; // 가중치

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_num")
    private MbtiQuestion question;
}
