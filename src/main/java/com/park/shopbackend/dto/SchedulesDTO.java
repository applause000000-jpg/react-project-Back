package com.park.shopbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulesDTO {
    private Long id;
    private String username;
    private Long productId;
    private String productName;
    private Integer productPrice;
    private Integer quantity;
    private LocalDateTime purchaseTime;
}
