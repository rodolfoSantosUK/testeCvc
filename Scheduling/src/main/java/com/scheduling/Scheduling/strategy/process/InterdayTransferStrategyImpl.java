package com.scheduling.Scheduling.strategy.process;


import com.scheduling.Scheduling.dto.TransferDto;
import org.springframework.stereotype.Service;

@Service("interdayTransferStrategy")
public class InterdayTransferStrategyImpl<Transfer> implements ProcessStrategy {

    @Override
    public Transfer process(TransferDto payload) {

 return  null;

    }
}
