package com.kxw.designpattern.strategy;

/**
 * Created by kangxiongwei on 2015/7/5.
 * 抽象角色
 */
public interface Strategy {

    /**
     * 对a和b进行计算
     * @param a
     * @param b
     * @return
     */
    public int calculate(int a,int b);

}
