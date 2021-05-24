package com.scheduling.Scheduling;

import com.scheduling.Scheduling.entities.Transfer;
import com.scheduling.Scheduling.repository.TransferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
class BootStrapData implements CommandLineRunner {


    private final TransferRepository transferRepository;


    public BootStrapData(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        transferRepository.save(Transfer.builder()
                .sourceAccount("666667")
                .destinationAccount("878786")
                .rate(new BigDecimal("60"))
                .schedulingDate(LocalDate.now().plusMonths(4))
                .value(new BigDecimal("2000"))
                .transferDate(LocalDate.now()).build());

        transferRepository.save(Transfer.builder()
                .sourceAccount("333444")
                .destinationAccount("444333")
                .rate(new BigDecimal("30.00"))
                .schedulingDate(LocalDate.now().plusMonths(4))
                .value(new BigDecimal("1000"))
                .transferDate(LocalDate.now()).build());

    }

}
