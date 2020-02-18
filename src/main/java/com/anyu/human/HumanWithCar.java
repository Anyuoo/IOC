package com.anyu.human;

import com.anyu.car.Car;

public abstract  class HumanWithCar implements Human {
    public Car car;
    public  HumanWithCar(Car car){
        this.car=car;
    }
    public abstract void gohome() ;
}
