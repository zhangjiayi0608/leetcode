package com.zhangjiayi.designpatterntraining.observermode;

public interface Subject {

    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
