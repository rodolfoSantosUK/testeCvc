package com.scheduling.Scheduling.service;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.strategy.process.ProcessStrategy;
import com.scheduling.Scheduling.strategy.process.ProcessStrategyFactory;
import com.scheduling.Scheduling.strategy.process.StrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements  ProcessService {

    @Autowired
    private ProcessStrategyFactory factory;

    @Override
    public void process(TransferDto transferDto) {
        ProcessStrategy strategy = factory.geStrategy(StrategyType.getStrategyType(transferDto.getTransferType()));
        strategy.process(transferDto);
    }
}
