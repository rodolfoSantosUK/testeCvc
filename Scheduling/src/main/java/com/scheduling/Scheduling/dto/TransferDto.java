package com.scheduling.Scheduling.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {

    private String transferType;

    private String sourceAccount;

    private String destinationAccount;

    private BigDecimal value;

    private BigDecimal rate;

    private String transferDate;

    private String schedulingDate;


}
