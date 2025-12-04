package com.park.shopbackend.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulesDTO {
    private Long id;
    private String username;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean active;
}
