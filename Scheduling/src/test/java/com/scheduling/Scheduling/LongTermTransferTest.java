package com.scheduling.Scheduling;


import com.scheduling.Scheduling.converter.ConverterTranferDtoToTransfer;
import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import com.scheduling.Scheduling.strategy.process.IntradayTransferStrategyImpl;
import com.scheduling.Scheduling.utils.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class LongTermTransferTest {

   private IntradayTransferStrategyImpl intradayTransferStrategy;

   @Mock
   private TransferRepository transferRepository;
   @Mock
   private  ConverterTranferDtoToTransfer converter;

    @BeforeEach
    void setUp() {

        intradayTransferStrategy = new IntradayTransferStrategyImpl(transferRepository, converter );

    }

    @Test
    void testScheduleLongTerm() {

        doReturn(buildTransfer()).when(converter).apply(any(TransferDto.class)) ;

        TransferDto transferDto =  buildTransferDto ();
        intradayTransferStrategy.process(transferDto);

    }


    private TransferDto buildTransferDto () {
        return  TransferDto.builder()
                .sourceAccount("666667")
                .destinationAccount("878786")
                .rate(new BigDecimal("3"))
                .schedulingDate(LocalDate.now())
                .value(new BigDecimal("3500.85"))
                .transferDate("2021-06-03").build();
    }

    private Transfer buildTransfer() {

        LocalDate schedulingDate = LocalDate.parse("2021-05-23", DateUtils.formatter);
        LocalDate transferDate = LocalDate.parse("2021-06-03", DateUtils.formatter);

        return  Transfer.builder()
                .sourceAccount("666667")
                .destinationAccount("878786")
                .rate(new BigDecimal("24"))
                .schedulingDate(schedulingDate)
                .value(new BigDecimal("3500.85"))
                .transferDate(transferDate).build();
    }

}
