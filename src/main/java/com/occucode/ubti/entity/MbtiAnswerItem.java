package com.occucode.ubti.entity;

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
}
