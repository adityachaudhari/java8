package com.java8.behaviourparameterization;


public class Apple {

    Integer weight;
    Color color;

    public Apple(Integer weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
