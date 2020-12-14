package com.zhangjiayi;


import com.zhangjiayi.treadtraining.ThreadTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {


    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        Integer j1 = 128;
        Integer j2 = 128;
        System.out.println(j1 == j2);
    }
}
