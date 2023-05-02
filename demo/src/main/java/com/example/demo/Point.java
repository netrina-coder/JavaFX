package com.example.demo;

import java.util.Arrays;

public class Point {
double[]x;
double[]y;
Point (int size){
    x = new double[size];
    y = new double[size];

}

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public void setY(double[] y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + Arrays.toString(x) +
                ", y=" + Arrays.toString(y) +
                '}';
    }

}
