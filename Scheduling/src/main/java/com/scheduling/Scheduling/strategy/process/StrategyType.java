package com.scheduling.Scheduling.strategy.process;

import java.util.HashMap;
import java.util.Map;

public enum StrategyType {

    INTRADAY("INTRADAY"), INTERDAY("INTERDAY"), LONG_TERM("LONG_TERM");

    private String strategyType;

    public String getStrategyType() {
        return strategyType;
    }

    private static Map<String, StrategyType> map = new HashMap<>();

    StrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    static {
        for ( StrategyType strategyType : values() ) {
            map.put(strategyType.getStrategyType(), strategyType);
        }
    }

    public static StrategyType  getStrategyType(String strategyType) {
        return map.get(strategyType);
    }


}
