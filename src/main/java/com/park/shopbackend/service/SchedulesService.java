package com.park.shopbackend.service;

import com.park.shopbackend.domain.Schedules;
import com.park.shopbackend.dto.SchedulesDTO;

import java.time.LocalDateTime;
import java.util.List;


public interface SchedulesService {


    SchedulesDTO saveSchedules(SchedulesDTO schedulesDTO);
    SchedulesDTO updateSchedule(Long scheduleId,SchedulesDTO schedulesDTO);
    List<SchedulesDTO> findSchedulesUser(String username);
    List<SchedulesDTO> findSchedulesAll();
    void deleteSchedules(Long id);



    default Schedules dtoToEntity(SchedulesDTO dto) {
        Schedules schedules = Schedules.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .active(dto.isActive())
                .build();
        return schedules;
    }

    default SchedulesDTO entityToDto(Schedules schedules) {
        SchedulesDTO dto = new SchedulesDTO();
        dto.setId(schedules.getId());
        dto.setUsername(schedules.getUser() != null ? schedules.getUser().getUsername() : null);
        dto.setTitle(schedules.getTitle());
        dto.setDescription(schedules.getDescription());
        dto.setStartDate(schedules.getStartDate());
        dto.setEndDate(schedules.getEndDate());
        dto.setActive(schedules.isActive());
        return dto;

    }
}
