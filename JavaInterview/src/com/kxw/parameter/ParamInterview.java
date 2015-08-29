package com.kxw.parameter;

/**
 * Created by kangxiongwei on 2015/6/19.
 */
public class ParamInterview {

    public void changeInt(int a){
        a = 5;
    }

    public void changePoint(Point point){
        point.x = 5;
        point.y = 6;
    }

    public void changeString(String string){
        string = "abc";
    }

    public static void main(String[] args){

        int a = 3;
        ParamInterview pi1 = new ParamInterview();
        pi1.changeInt(a);
        System.out.println(a);
        System.out.println("--------------------------");

        Point point = new Point(4,5);
        ParamInterview pi2 = new ParamInterview();
        pi2.changePoint(point);
        System.out.println(point.x + "--" + point.y);
        System.out.println("--------------------------");

        String string = "xyz";
        ParamInterview pi3 = new ParamInterview();
        pi3.changeString(string);
        System.out.println(string);
    }


}
class Point{

    int x;
    int y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}