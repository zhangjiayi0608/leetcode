package com.zhangjiayi.designpatterntraining.decoratormode;

public class Mocha implements CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " and Moka";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
