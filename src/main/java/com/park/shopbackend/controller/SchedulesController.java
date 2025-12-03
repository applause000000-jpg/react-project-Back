package com.park.shopbackend.controller;

import com.park.shopbackend.dto.SchedulesDTO;
import com.park.shopbackend.security.UserPrincipal;
import com.park.shopbackend.service.SchedulesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Schedules")
@CrossOrigin(origins = "*")
public class SchedulesController {
    private final SchedulesService schedulesService;

    @PostMapping
    public ResponseEntity<Object> savePurchases(@RequestBody SchedulesDTO schedulesDTO){
        return new ResponseEntity<>(schedulesService.saveSchedules(schedulesDTO),
                HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> getAllSchedulesOfUser(@AuthenticationPrincipal
                                                        UserPrincipal userPrinciple){
        return ResponseEntity.ok(schedulesService.findSchedulesUser(
                userPrinciple.getUsername()));
    }

    @DeleteMapping("{scheduleId}")
    public ResponseEntity<Object> deleteSchedules(@PathVariable Long scheduleId){
        schedulesService.deleteSchedules(scheduleId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{scheduleId}")
    public ResponseEntity<SchedulesDTO> updateSchedules(@PathVariable Long scheduleId,
                                                        @RequestBody SchedulesDTO schedulesDTO) {
        SchedulesDTO updated = schedulesService.updateSchedule(scheduleId, schedulesDTO);
        return ResponseEntity.ok(updated);
    }


}
