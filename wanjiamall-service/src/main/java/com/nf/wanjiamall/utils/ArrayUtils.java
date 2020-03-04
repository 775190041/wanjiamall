package com.nf.wanjiamall.utils;

import java.util.Arrays;

public class ArrayUtils {
    public static String addDouble(String[] arr){
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] ="\""+arr[i] + "\"";
        }
      return   Arrays.toString(arr);
    }
}
