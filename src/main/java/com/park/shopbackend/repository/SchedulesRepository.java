package com.park.shopbackend.repository;

import com.park.shopbackend.domain.Schedules;
import com.park.shopbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
    @Query("select s from Schedules s where s.user.username=:username")
    List<Schedules> findAllBySchedulesUser(String username);

    List<Schedules> findByUser(User user);

}
