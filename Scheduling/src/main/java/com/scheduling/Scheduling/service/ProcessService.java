package com.scheduling.Scheduling.service;

import com.scheduling.Scheduling.dto.TransferDto;

public interface ProcessService <T> {

    T process(TransferDto transferDto) ;

}
