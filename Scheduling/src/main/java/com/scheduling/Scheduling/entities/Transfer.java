package com.scheduling.Scheduling.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transfer {

    @Id
    private Long id;

    private String sourceAccount;

    private String destinationAccount;

    private BigDecimal value;

    private BigDecimal rate;

    private LocalDateTime transferDate;

    private LocalDateTime schedulingDate;



}
