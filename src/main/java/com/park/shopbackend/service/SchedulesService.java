package com.park.shopbackend.service;

import com.park.shopbackend.domain.Schedules;
import com.park.shopbackend.dto.SchedulesDTO;

import java.util.List;

public interface SchedulesService {

    SchedulesDTO saveSchedules(SchedulesDTO schedulesDTO);
    List<SchedulesDTO> findSchedulesUser(String username);
    List<SchedulesDTO> findSchedulesAll();
    void deleteSchedules(Long id);


    default Schedules dtoToEntity(SchedulesDTO schedulesDTO) {
        Schedules schedules = Schedules.builder()
                .id(schedulesDTO.getId())

                .build();
        return schedules;
    }


    default SchedulesDTO entityToDto(Schedules schedules) {
        SchedulesDTO schedulesDTO = SchedulesDTO.builder()
                .id(schedules.getId())

                .build();
        return schedulesDTO;
    }
}
