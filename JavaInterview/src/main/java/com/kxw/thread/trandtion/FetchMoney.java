package com.kxw.thread.trandtion;

/**
 * Created by kangxiongwei on 2015/7/3.
 * 银行取钱案例
 */
public class FetchMoney {

    public static void main(String[] args){

        Bank bank = new Bank();

        Runnable t1 = new MoneyThread(bank); //柜台
        Runnable t2 = new MoneyThread(bank); //ATM

        new Thread(t1).start();
        new Thread(t2).start();
    }

}

class Bank{

    private int money = 1000;

    /**
     * 取钱
     * @param number
     * @return
     */
    public synchronized int getMoney(int number){
        if(number < 0){
            return -1;
        } else if(number > money){
            return -2;
        } else if(money < 0){
            return -3;
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= number;
            return number;
        }
    }
}

class MoneyThread implements Runnable{

    private Bank bank;

    public MoneyThread(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println(bank.getMoney(800));
    }
}
