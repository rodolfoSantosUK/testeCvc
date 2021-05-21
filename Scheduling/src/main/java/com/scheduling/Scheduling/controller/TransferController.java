package com.scheduling.Scheduling.controller;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private ProcessService processService;


    @PostMapping
    public ResponseEntity<TransferDto> schedule(@RequestBody TransferDto transferDto ) {

        processService.process(transferDto);

       return null; // ResponseEntity.ok();

    }

}
