package com.scheduling.Scheduling.strategy.process;

public interface ProcessStrategyFactory {

    public ProcessStrategy geStrategy(StrategyType strategyType);

}
