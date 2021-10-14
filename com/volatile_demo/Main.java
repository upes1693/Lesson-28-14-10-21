package com.volatile_demo;

public class Main {
    public static void main(String[] args) {

    }
}

class Calender{
    private int years;
    private int months;
    private volatile int days;

    public void update(int years, int months, int days){
        this.years=years;
        this.months=months;
        this.days=days;
    }

    public int getTotalDays(){
        int totalDays=this.days;
        totalDays+=months*30;
        totalDays+=years*365;
        return totalDays;
    }
}
