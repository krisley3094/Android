package com.itbank.activity03;

import java.io.Serializable;

/**
 * Created by 연지점204강사 on 2017-06-18.
 */

//상속을 통해 직렬화의 자격을 획득
public class Car implements Serializable{
    private String name;
    private int speed;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
