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
    }

    @Override
    public List<SchedulesDTO> findSchedulesUser(String username) {

    }

    @Override
    public List<SchedulesDTO> findSchedulesAll() {

    }

    @Override
    public void deleteSchedules(Long id) {
        schedulesRepository.deleteById(id);
    }
}
