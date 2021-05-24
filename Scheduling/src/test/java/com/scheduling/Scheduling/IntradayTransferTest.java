package com.scheduling.Scheduling;


import com.scheduling.Scheduling.converter.ConverterTranferDtoToTransfer;
import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import com.scheduling.Scheduling.strategy.process.IntradayTransferStrategyImpl;
import com.scheduling.Scheduling.utils.DateUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class IntradayTransferTest {

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
    void testScheduleIntraday() {

        doReturn(buildTransfer()).when(converter).apply(any(TransferDto.class)) ;

        TransferDto transferDto =  buildTransferDto ();
        intradayTransferStrategy.process(transferDto);
        assertEquals(transferDto.getRate(), new BigDecimal(30.00).setScale(2));
    }


    private TransferDto buildTransferDto () {
        return  TransferDto.builder()
                .sourceAccount("666667")
                .destinationAccount("878786")
                .rate(new BigDecimal("30.00"))
                .schedulingDate(LocalDate.now())
                .value(new BigDecimal("1000"))
                .transferDate("2021-05-21").build();
    }

    private Transfer buildTransfer() {

        LocalDate schedulingDate = LocalDate.parse("2021-05-21", DateUtils.formatter);
        LocalDate transferDate = LocalDate.parse("2021-05-21", DateUtils.formatter);

        return  Transfer.builder()
                .sourceAccount("666667")
                .destinationAccount("878786")
                .rate(new BigDecimal("30.00"))
                .schedulingDate(schedulingDate)
                .value(new BigDecimal("1000"))
                .transferDate(transferDate).build();
    }

}
