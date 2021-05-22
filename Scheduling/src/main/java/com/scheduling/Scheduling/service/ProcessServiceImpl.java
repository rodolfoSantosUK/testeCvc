package com.scheduling.Scheduling.service;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.strategy.process.ProcessStrategy;
import com.scheduling.Scheduling.strategy.process.ProcessStrategyFactory;
import com.scheduling.Scheduling.strategy.process.StrategyType;
import com.scheduling.Scheduling.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ProcessServiceImpl implements  ProcessService {

    @Autowired
    private ProcessStrategyFactory factory;

    @Override
    public void process(TransferDto transferDto) {

        ProcessStrategy strategy =   factory.geStrategy(getStrategyType(transferDto));
        strategy.process(transferDto);

    }

    private StrategyType getStrategyType(TransferDto transferDto) {

        LocalDate schedulingDate = LocalDate.parse(transferDto.getTransferDate(), DateUtils.formatter);
        LocalDate transferDate = LocalDate.parse(transferDto.getTransferDate(), DateUtils.formatter);

        if (schedulingDate.isEqual(transferDate)) {
            return StrategyType.INTRADAY;
        }

        return StrategyType.NONE;
    }


}
