package com.scheduling.Scheduling.strategy.process;


import com.scheduling.Scheduling.dto.TransferDto;
import org.springframework.stereotype.Service;

@Service("intradayTransferStrategy")
public class IntradayTransferStrategyImpl  implements ProcessStrategy {

    @Override
    public void process(TransferDto payload) {

    }

}
