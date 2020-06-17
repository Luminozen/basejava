package com.topjava.basejava.webapp.common;

import java.util.Arrays;
import java.util.List;

public class MainStream {
    public static void main(String[] args) {
        int [] values = {1, 2, 3, 4, 5};
        System.out.println(minValue(values));
    }

    public static int minValue(int[] values) {
        values = Arrays.stream(values).distinct().sorted().toArray();
        int min = 0;
        int length = values.length;
        for (int i = 1; i <= length; i++) {
            min += values[i - 1] * (Math.pow(10, length - i));
        }
        return min;
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        return null;//integers.stream().reduce(0, (x,y)->x+y);
    }


}
