package com.occucode.ubti.entity;

import com.occucode.ubti.enums.MbtiEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // getter, setter, toString, equals, hasCode 메소드 제공
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MbtiResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_num")
    private Long resultNum;

    @Enumerated(EnumType.STRING)
    @Column(name = "mbti")
    private MbtiEnum mbti;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "best_mbti")
    private MbtiEnum bestMbti;

    @Enumerated(EnumType.STRING)
    @Column(name = "worst_mbti")
    private MbtiEnum worstMbti;
}
