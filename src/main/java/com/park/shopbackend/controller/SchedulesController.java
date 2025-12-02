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
    public ResponseEntity<Object> savePurchases(@RequestBody SchedulesDTO purchasesDTO){
        log.info("savePurchases"+purchasesDTO);
        return new ResponseEntity<>(schedulesService.saveSchedules(purchasesDTO),
                HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> getAllPurchasesOfUser(@AuthenticationPrincipal
                                                        UserPrincipal userPrinciple){
        return ResponseEntity.ok(schedulesService.findSchedulesUser(
                userPrinciple.getUsername()));
    }

//    @DeleteMapping("{productId}")
//    public ResponseEntity<Object> delteProduct(@PathVariable Long productId){
//        productService.deleteProduct(productId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
