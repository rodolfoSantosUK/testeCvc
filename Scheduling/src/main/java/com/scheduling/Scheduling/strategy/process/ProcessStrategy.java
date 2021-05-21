package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.dto.TransferDto;

public interface ProcessStrategy {

    void process(TransferDto payload);

}
