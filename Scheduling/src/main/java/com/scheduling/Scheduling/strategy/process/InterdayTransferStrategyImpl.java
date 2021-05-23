package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.converter.ConverterTranferDtoToTransfer;
import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("interdayTransferStrategy")
public class InterdayTransferStrategyImpl<Transfer> extends BaseProcess <Transfer> {

    private static final Integer FIXED_RATE = 12;

    public InterdayTransferStrategyImpl(TransferRepository transferRepository,
                                        ConverterTranferDtoToTransfer converter) {
        super(transferRepository, converter);
    }

    @Override
    public Transfer process(TransferDto transferDto) {

       transferDto.setRate(new BigDecimal(transferDto.getDaysBetween() *  FIXED_RATE ));
       return (Transfer) transferRepository.save(converter.apply(transferDto));

    }
}