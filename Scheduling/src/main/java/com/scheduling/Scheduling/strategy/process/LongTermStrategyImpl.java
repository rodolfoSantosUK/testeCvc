package com.scheduling.Scheduling.strategy.process;


import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import org.springframework.stereotype.Service;

@Service("longTermTransferStrategy")
public class LongTermStrategyImpl  implements ProcessStrategy <Transfer> {

    @Override
    public Transfer process(TransferDto payload) {
        return null;
    }

}
