package com.park.shopbackend.dto;


import com.park.shopbackend.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private  Long id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createTime;
    private Role role;
}
