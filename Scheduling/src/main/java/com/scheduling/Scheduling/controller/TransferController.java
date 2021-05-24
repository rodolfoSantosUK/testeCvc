package com.scheduling.Scheduling.controller;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import com.scheduling.Scheduling.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private ProcessService processService;

    @Autowired
    private TransferRepository transferRepository;

    @PostMapping
    public ResponseEntity<Transfer> schedule(@RequestBody TransferDto transferDto )   {
        return new ResponseEntity(processService.process(transferDto) , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transfer>> getSchedule( )   {
        return new ResponseEntity(transferRepository.findAll() , HttpStatus.CREATED);
    }


}
