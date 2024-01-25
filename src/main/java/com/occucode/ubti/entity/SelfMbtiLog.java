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

    @Column(name = "self_result", nullable = false)
    private String selfResult;

    @Column(name = "mbti_result", nullable = false)
    private MbtiEnum mbtiResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_num")
    private User user;

}
