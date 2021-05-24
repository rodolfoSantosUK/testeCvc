package com.scheduling.Scheduling.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferDto {

    private String transferType;

    private String sourceAccount;

    private String destinationAccount;

    private BigDecimal value;

    private BigDecimal rate;

    private String transferDate;

    private LocalDate schedulingDate;

    private Long daysBetween;

}
