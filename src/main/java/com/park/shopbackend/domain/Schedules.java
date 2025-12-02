package com.park.shopbackend.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedules {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private LocalDateTime startDate;
    @Column(nullable = false)
    private LocalDateTime endDate;

    private boolean active;

    public void updateActiveStatus(LocalDateTime now) {
        if (endDate.isBefore(now)) {
            this.active = false; // 자동 비활성화
        }
    }

}
