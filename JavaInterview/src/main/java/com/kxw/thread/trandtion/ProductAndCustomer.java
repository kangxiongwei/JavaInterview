package com.kxw.thread.trandtion;

/**
 * Created by kangxiongwei on 2015/7/3.
 */
public class ProductAndCustomer {

    public static void main(String[] args){
        Product product = new Product();
        Thread t1 = new Thread(new ProductThread(product));
        Thread t2 = new Thread(new CustomerThread(product));
        Thread t3 = new Thread(new ProductThread(product));
        Thread t4 = new Thread(new CustomerThread(product));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
class Product{

    private int number;

    public synchronized void increase(){
        while(number != 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("Number:"+number);
        notify();
    }

    public synchronized void decrease(){
        while(number == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println("Number:"+number);
        notify();
    }

}

class ProductThread implements Runnable{

    private Product product;

    public ProductThread(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++){
            try {
                Thread.sleep((long)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.product.increase();
        }
    }
}

class CustomerThread implements Runnable{

    private Product product;

    public CustomerThread(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++){
            try {
                Thread.sleep((long)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.product.decrease();
        }
    }
}
