package com.xzp.util;

/**
 * 工具类
 * @author xzp
 * @date 2020.11.19 23:17
 */
public final class Util {
    private Util(){}

    /**
     * 交换数组中两个位置的值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
