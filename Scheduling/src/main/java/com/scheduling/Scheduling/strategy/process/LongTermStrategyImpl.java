package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.converter.ConverterTranferDtoToTransfer;
import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("longTermTransferStrategy")
public class LongTermStrategyImpl extends BaseProcess <Transfer>  {

    private static final BigDecimal ABOVE_10 = new BigDecimal(8);
    private static final BigDecimal ABOVE_20 = new BigDecimal(6);
    private static final BigDecimal ABOVE_30 = new BigDecimal(4);
    private static final BigDecimal ABOVE_40 = new BigDecimal(2);

    public LongTermStrategyImpl(TransferRepository transferRepository,
                                        ConverterTranferDtoToTransfer converter) {
        super(transferRepository, converter);
    }

    @Override
    public Transfer process(TransferDto transferDto) {

        BigDecimal percent =  BigDecimal.ZERO;
        transferDto.setRate(transferDto.getValue().multiply(getPercent(transferDto, percent)));

        Transfer _transfer = (Transfer) converter.apply(transferDto);

        transferRepository.save(_transfer);
        return _transfer;

    }


    private BigDecimal getPercent(TransferDto transferDto, BigDecimal percent) {

        if (transferDto.getDaysBetween() > 10 && transferDto.getDaysBetween() < 20) {
            percent = ABOVE_10.divide(new BigDecimal(100));
        } else if( transferDto.getDaysBetween() >=20 && transferDto.getDaysBetween() < 30) {
            percent = ABOVE_20.divide(new BigDecimal(100));
        } else if ( transferDto.getDaysBetween() >=30 && transferDto.getDaysBetween() < 40) {
            percent = ABOVE_30.divide(new BigDecimal(100));
        } else if (transferDto.getDaysBetween() >=40) {
            percent = ABOVE_40.divide(new BigDecimal(100));
        }

        return percent ;

    }

}
