package com.scheduling.Scheduling.strategy.process;

import com.scheduling.Scheduling.converter.ConverterTranferDtoToTransfer;
import com.scheduling.Scheduling.repository.TransferRepository;

public abstract class BaseProcess<T> implements  ProcessStrategy{

    public final TransferRepository transferRepository;

    public final ConverterTranferDtoToTransfer converter;

    public BaseProcess(TransferRepository transferRepository, ConverterTranferDtoToTransfer converter) {
        this.transferRepository = transferRepository;
        this.converter = converter;
    }
}
