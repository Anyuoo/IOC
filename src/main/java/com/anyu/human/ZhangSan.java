package com.anyu.human;

import com.anyu.car.Car;

public class ZhangSan extends HumanWithCar {
    public ZhangSan(Car car) {
        super(car);
    }

    public void gohome() {
        car.start();
        car.Stop();
    }
}
