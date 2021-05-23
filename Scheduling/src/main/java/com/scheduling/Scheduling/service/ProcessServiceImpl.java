package com.scheduling.Scheduling.service;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.strategy.process.ProcessStrategy;
import com.scheduling.Scheduling.strategy.process.ProcessStrategyFactory;
import com.scheduling.Scheduling.strategy.process.StrategyType;
import com.scheduling.Scheduling.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.temporal.ChronoUnit.DAYS;

import java.math.BigDecimal;
import java.time.LocalDate;

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

        transferDto.setSchedulingDate(LocalDate.now());
        LocalDate transferDate = LocalDate.parse(transferDto.getTransferDate(), DateUtils.formatter);

        Long daysBetween = DAYS.between(transferDto.getSchedulingDate(), transferDate);

        if (transferDto.getSchedulingDate().isEqual(transferDate)) {
            return StrategyType.INTRADAY;
        } else if (null != daysBetween && daysBetween <= 10) {
            transferDto.setDaysBetween(daysBetween);
            return StrategyType.INTERDAY;
        } else if (null != daysBetween && daysBetween > 10) {
            transferDto.setDaysBetween(daysBetween);
            return StrategyType.LONG_TERM;
        }

        return StrategyType.NONE;
    }


}
