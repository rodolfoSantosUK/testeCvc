package com.scheduling.Scheduling;


import com.scheduling.Scheduling.converter.ConverterTranferDtoToTransfer;
import com.scheduling.Scheduling.dto.TransferDto;
import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import com.scheduling.Scheduling.strategy.process.IntradayTransferStrategyImpl;
import com.scheduling.Scheduling.strategy.process.LongTermStrategyImpl;
import com.scheduling.Scheduling.utils.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class LongTermTransferTest {

   private LongTermStrategyImpl longTermStrategy;

   @Mock
   private TransferRepository transferRepository;
   @Mock
   private  ConverterTranferDtoToTransfer converter;

    @BeforeEach
    void setUp() {

        longTermStrategy = new LongTermStrategyImpl(transferRepository, converter );

    }

    @Test
    void testScheduleAbove10Days() {
        doReturn(buildTransfer()).when(converter).apply(any(TransferDto.class)) ;
        TransferDto transferDto =  buildTransferDto ();
        longTermStrategy.process(transferDto);
        assertEquals(transferDto.getRate(), new BigDecimal(80.00).setScale(2));
    }

    @Test
    void testScheduleAbove20Days() {
        doReturn(buildTransfer()).when(converter).apply(any(TransferDto.class)) ;
        TransferDto transferDto =  buildTransferDto ();
        transferDto.setDaysBetween(21L);
        longTermStrategy.process(transferDto);
        assertEquals(transferDto.getRate(), new BigDecimal(60.00).setScale(2));
    }

    @Test
    void testScheduleAbove30Days() {
        doReturn(buildTransfer()).when(converter).apply(any(TransferDto.class)) ;
        TransferDto transferDto =  buildTransferDto ();
        transferDto.setDaysBetween(31L);
        longTermStrategy.process(transferDto);
        assertEquals(transferDto.getRate(), new BigDecimal(40.00).setScale(2));
    }

    @Test
    void testScheduleAbove40Days() {
        doReturn(buildTransfer()).when(converter).apply(any(TransferDto.class)) ;
        TransferDto transferDto =  buildTransferDto ();
        transferDto.setDaysBetween(41L);
        transferDto.setValue(new BigDecimal("100000"));
        longTermStrategy.process(transferDto);
        assertEquals(transferDto.getRate(), new BigDecimal(2000.00).setScale(2));
    }

    private TransferDto buildTransferDto () {
        return  TransferDto.builder()
                .sourceAccount("666667")
                .destinationAccount("878786")
                .rate(new BigDecimal("80"))
                .daysBetween(11L)
                .schedulingDate(LocalDate.now())
                .value(new BigDecimal("1000"))
                .transferDate("2021-06-03").build();
    }

    private Transfer buildTransfer() {

        LocalDate schedulingDate = LocalDate.parse("2021-05-23", DateUtils.formatter);
        LocalDate transferDate = LocalDate.parse("2021-06-03", DateUtils.formatter);

        return  Transfer.builder()
                .sourceAccount("666667")
                .destinationAccount("878786")
                .rate(new BigDecimal("80"))
                .schedulingDate(schedulingDate)
                .value(new BigDecimal("1000"))
                .transferDate(transferDate).build();
    }

}
