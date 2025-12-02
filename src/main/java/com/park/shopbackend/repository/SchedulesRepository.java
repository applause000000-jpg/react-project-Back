package com.park.shopbackend.repository;

import com.park.shopbackend.domain.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
    @Query("select pur from Schedules pur where pur.user.username=:username")
    List<Schedules> findAllByPurchaseUSer(String username);
}
