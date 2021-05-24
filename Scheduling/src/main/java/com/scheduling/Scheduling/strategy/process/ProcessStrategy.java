package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.dto.TransferDto;

public interface ProcessStrategy<T> {

    T process(TransferDto payload)  ;

}
