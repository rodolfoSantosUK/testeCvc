package com.scheduling.Scheduling.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferDto {

    private String transferType;

    private String sourceAccount;

    private String destinationAccount;

    private BigDecimal value;

    private BigDecimal rate;

    private String transferDate;

    private String schedulingDate;


}
