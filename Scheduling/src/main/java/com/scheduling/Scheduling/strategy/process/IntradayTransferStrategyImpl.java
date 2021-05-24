package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.converter.ConverterTranferDtoToTransfer;
import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service("intradayTransferStrategy")
public class IntradayTransferStrategyImpl extends BaseProcess <Transfer> {

    private static final BigDecimal FIXED_RATE = new BigDecimal(3);

    public IntradayTransferStrategyImpl(TransferRepository transferRepository,
                                        ConverterTranferDtoToTransfer converter) {
        super(transferRepository, converter);
    }

    @Override
    public Transfer process(TransferDto transferDto) {

        BigDecimal percent = FIXED_RATE.divide(new BigDecimal(100));
        transferDto.getValue().multiply(percent);
        transferDto.setRate(transferDto.getValue().multiply(percent));

        Transfer _transfer = (Transfer) converter.apply(transferDto);

        transferRepository.save(_transfer);
        return _transfer;

    }
}
