package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service("intradayTransferStrategy")
public class IntradayTransferStrategyImpl  extends  BaseProcess  {


    private static final Integer FIXED_RATE = 3;

    public IntradayTransferStrategyImpl(TransferRepository transferRepository) {
        super(transferRepository);
    }


    @Override
    public void process(TransferDto transferDto) {

        BigDecimal percent = transferDto.getRate().divide(new BigDecimal(100));
        transferDto.getValue().multiply(percent);


        transferRepository.save(new Transfer());

    }
}
