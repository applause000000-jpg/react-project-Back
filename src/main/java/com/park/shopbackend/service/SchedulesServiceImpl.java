package com.park.shopbackend.service;


import com.park.shopbackend.domain.Schedules;
import com.park.shopbackend.domain.User;
import com.park.shopbackend.dto.SchedulesDTO;
import com.park.shopbackend.repository.SchedulesRepository;
import com.park.shopbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class SchedulesServiceImpl implements SchedulesService {
    private final SchedulesRepository schedulesRepository;
    private final UserRepository userRepository;



    @Override
    public SchedulesDTO saveSchedules(SchedulesDTO schedulesDTO) {
        Schedules schedules = dtoToEntity(schedulesDTO);

        User user = userRepository.findByUsername(schedulesDTO.getUsername());
        schedules.setUser(user);
        schedulesRepository.save(schedules);
        return entityToDto(schedules);
    }

    @Override
    public SchedulesDTO updateSchedule(Long scheduleId, SchedulesDTO dto) {
        Schedules schedule = schedulesRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));

        // DTO 값으로 엔티티 업데이트
        schedule.setTitle(dto.getTitle());
        schedule.setDescription(dto.getDescription());
        schedule.setStartDate(dto.getStartDate());
        schedule.setEndDate(dto.getEndDate());
        schedule.setActive(dto.isActive());

        Schedules updated = schedulesRepository.save(schedule);
        return entityToDto(updated);
    }

    @Override
    public List<SchedulesDTO> findSchedulesUser(String username) {
        List<Schedules> schedules = schedulesRepository.findAllBySchedulesUser(username);
        schedules.forEach(s->s.updateActiveStatus(LocalDateTime.now()));
        List<SchedulesDTO> dtos = new ArrayList<>();
        for (Schedules schedule : schedules) {
            SchedulesDTO  dto = entityToDto(schedule);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<SchedulesDTO> findSchedulesAll() {
        List<Schedules> schedules = schedulesRepository.findAll();
        schedules.forEach(s->s.updateActiveStatus(LocalDateTime.now()));
        List<SchedulesDTO> dtos = new ArrayList<>();
        for (Schedules schedule : schedules) {
            SchedulesDTO  dto = entityToDto(schedule);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void deleteSchedules(Long id) {
        schedulesRepository.deleteById(id);
    }
}
