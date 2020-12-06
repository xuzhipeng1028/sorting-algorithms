package com.xzp.util;

import java.util.Arrays;
import java.util.Random;

/**
 * 工具类
 * @author xzp
 * @date 2020.11.19 23:17
 */
public final class Util {
    private Util(){}

    /**
     * 生成指定范围的随机整数
     * @param min 最小值（inclusive）
     * @param max 最大值（inclusive）
     * @return
     */
    public static int generateRandom(int min,int max){
        return new Random().nextInt(max) % (max - min + 1) + min;
    }
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
        System.out.println();
    }

    /**
     * 正确排序
     * @param arr
     */
    public static void rightSort(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 生成随机数组
     * @param maxSize 数组最大size
     * @param maxValue 数组元素最大值,生成[0,maxValue]范围的整数
     * @return
     */
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)(maxSize * Math.random() + 1)];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }

    /**
     * 拷贝原数组，生成新数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        return Arrays.copyOf(arr,arr.length);
    }

    /**
     * 判断两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2){
        // 如果都为null
        if(arr1 == null && arr2 == null) return true;
        // 如果有且仅有一个为null
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) return false;
        // 如果都不为null,判断长度是否相等
        if(arr1.length != arr2.length) return false;
        //长度相等，挨个比较
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
