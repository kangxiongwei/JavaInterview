package com.kxw.pattern.strategy;

/**
 * Created by kangxiongwei on 2015/7/5.
 * 策略的使用环境
 */
public class Environment implements Strategy{

    private Strategy strategy;

    public Environment(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int calculate(int a, int b) {
        return this.strategy.calculate(a,b);
    }
}
