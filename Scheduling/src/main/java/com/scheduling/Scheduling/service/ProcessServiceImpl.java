package com.scheduling.Scheduling.service;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.strategy.process.ProcessStrategy;
import com.scheduling.Scheduling.strategy.process.ProcessStrategyFactory;
import com.scheduling.Scheduling.strategy.process.StrategyType;
import com.scheduling.Scheduling.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ProcessServiceImpl<Transfer> implements ProcessService {

    @Autowired
    private ProcessStrategyFactory factory;

    @Override
    public Transfer process(TransferDto transferDto) {

        ProcessStrategy strategy =   factory.geStrategy(getStrategyType(transferDto));
      return (Transfer) strategy.process(transferDto);

    }

    private StrategyType getStrategyType(TransferDto transferDto) {

        LocalDate schedulingDate = LocalDate.parse(transferDto.getSchedulingDate(), DateUtils.formatter);
        LocalDate transferDate = LocalDate.parse(transferDto.getTransferDate(), DateUtils.formatter);

        long gapDays = ChronoUnit.DAYS.between(transferDate, schedulingDate);

        if (schedulingDate.isEqual(transferDate)) {
            return StrategyType.INTRADAY;
        } else if(gapDays <= 10 ) {
            return StrategyType.INTERDAY;
        }

        return StrategyType.NONE;
    }


}
