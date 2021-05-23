package com.scheduling.Scheduling.converter;

import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
public class ConverterTranferDtoToTransfer implements Function<TransferDto, Transfer> {


    @Override
    public Transfer apply(TransferDto _tr) {

        LocalDate transferDate = LocalDate.parse(_tr.getTransferDate(), DateUtils.formatter);

         return Transfer.builder()
                 .transferDate(transferDate)
                 .sourceAccount(_tr.getSourceAccount())
                 .schedulingDate(_tr.getSchedulingDate())
                 .sourceAccount(_tr.getSourceAccount())
                 .destinationAccount(_tr.getDestinationAccount())
                 .value(_tr.getValue())
                 .rate(_tr.getRate().setScale(2)).build();

    }

}
