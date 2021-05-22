package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.repository.TransferRepository;

public abstract class BaseProcess implements  ProcessStrategy{

    public final TransferRepository transferRepository;

    public BaseProcess(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }



}
