package com.scheduling.Scheduling.strategy.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProcessStrategyFactoryImpl implements ProcessStrategyFactory  {

    @Autowired
    @Qualifier("intradayTransferStrategy")
    private ProcessStrategy intradayTransferStrategy;

    @Autowired
    @Qualifier("interdayTransferStrategy")
    private ProcessStrategy interdayTransferStrategy;

    @Autowired
    @Qualifier("longTermTransferStrategy")
    private ProcessStrategy longTermTransferStrategy;


    private Map<StrategyType, ProcessStrategy> map;

    @PostConstruct
    public void postConstruct() {
        map = new HashMap<>();
        map.put(StrategyType.INTRADAY, intradayTransferStrategy);
        map.put(StrategyType.INTERDAY, interdayTransferStrategy);
        map.put(StrategyType.LONG_TERM, longTermTransferStrategy);
    }

    @Override
    public ProcessStrategy geStrategy(StrategyType strategyType) {
        return map.get(strategyType);
    }


}
